package gr.akis.handsapp;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import gr.akis.handsapp.api.RegionResource;
import gr.akis.handsapp.api.ServicesResource;
import gr.akis.handsapp.api.UserResource;
import gr.akis.handsapp.api.VathmologiaResource;
import gr.akis.handsapp.api.VenueCategoriesResource;
import gr.akis.handsapp.config.Settings;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
@ApplicationScoped
public class HandsappServicesApplication extends Application {
	private static final Logger LOG = Logger.getLogger(HandsappServicesApplication.class.getName());
	@Inject
	Settings settings;

	public HandsappServicesApplication() {

	}

	@PostConstruct
	public void init() {
		try {
			BeanConfig beanConfig = new BeanConfig();
			beanConfig.setVersion("1.0");
			beanConfig.setSchemes(new String[] { settings.getProtocol() });
			beanConfig.setHost(settings.getHost() + ":" + settings.getPort());
			beanConfig.setBasePath(settings.getBasePath());
			beanConfig.setSchemes(new String[] { settings.getProtocol() });
			beanConfig.setHost(settings.getHost() + ":" + settings.getPort());

			beanConfig.setResourcePackage("gr.akis.handsapp.api");
			beanConfig.setScan(true);
			LOG.info("handsapp started!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();

		resources.add(VathmologiaResource.class);
		resources.add(UserResource.class);
		resources.add(ServicesResource.class);
		resources.add(RegionResource.class);
		resources.add(VenueCategoriesResource.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;

	}
}