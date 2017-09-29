package gr.anagnosg.schoolservices;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import gr.anagnosg.employeeservices.config.Settings;
import gr.anagnosg.schoolservices.api.ClassResource;

import gr.anagnosg.schoolservices.api.StudentResource;
import gr.anagnosg.schoolservices.api.TeacherResource;
import io.swagger.jaxrs.config.BeanConfig;

 
public class SchoolServicesApplication  {
	private static final Logger LOG = Logger.getLogger(SchoolServicesApplication.class.getName());
	@Inject
	Settings settings;

	public SchoolServicesApplication() {

	}

	@PostConstruct
	public void init() {
		try {
			BeanConfig beanConfig = new BeanConfig();
			beanConfig.setVersion("1.0");
			beanConfig.setSchemes(new String[] { settings.getProtocol() });
			beanConfig.setHost(settings.getHost()+":"+settings.getPort());
			beanConfig.setBasePath(settings.getBasePath());
			beanConfig.setSchemes(new String[]{settings.getProtocol()});
            beanConfig.setHost(settings.getHost()+":"+settings.getPort());
			
			/*beanConfig.setBasePath(settings.getProtocol() + "://" + settings.getHost() + ":" + settings.getPort() + "/"
					+ settings.getBasePath());
			*/
			beanConfig.setResourcePackage("gr.anagnosg.schoolservices.api");
			beanConfig.setScan(true);
			LOG.info("SchoolServicesApplication started!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
