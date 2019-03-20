package diplomatiki;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;


import gr.anagnosg.employeeservices.config.Settings;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
@ApplicationScoped
public class HandsAppApplication {
    private static final Logger LOG = Logger.getLogger(HandsAppApplication.class.getName());
	@Inject
	Settings settings;

	public HandsAppApplication() {

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
			beanConfig.setResourcePackage("diplomatiki");
			beanConfig.setScan(true);
			LOG.info("Paraga started!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();

		resources.add(RegionResource.class);
		resources.add(ServicesResource.class);
		resources.add(VenuesResource.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;

	}


	}


