package gr.akis.paraga;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import gr.akis.paraga.api.Login_logResource;
import gr.akis.paraga.api.PersonResource;
import gr.akis.paraga.api.TeamResource;
import gr.akis.paraga.api.UserResource;
import gr.akis.paraga.api.VathmologiaResource;

import gr.anagnosg.employeeservices.config.Settings;

 
import io.swagger.jaxrs.config.BeanConfig;

 

@ApplicationPath("/api")
@ApplicationScoped
public class ParagaServicesApplication extends Application {
	private static final Logger LOG = Logger.getLogger(ParagaServicesApplication.class.getName());
	@Inject
	Settings settings;

	public ParagaServicesApplication() {

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
			beanConfig.setResourcePackage("gr.akis.paraga.api");
			beanConfig.setScan(true);
			LOG.info("Paraga started!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();

		resources.add(PersonResource.class);
		resources.add(TeamResource.class);
		resources.add(VathmologiaResource.class);
		resources.add(Login_logResource.class);
		resources.add(UserResource.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;

	}
}