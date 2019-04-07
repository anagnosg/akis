package gr.akis.handsapp.business;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import gr.akis.handsapp.db.ServicesDb;
import gr.akis.handsapp.models.Service.Responses.*;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class ServicesBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	ServicesDb serviceDB;

	public List<Service> selectAll() throws SQLException {
		List<Service> service;
		service = serviceDB.selectAll();
		return service;
	}

	public Service insert(Service service) throws SQLException {
		List<Service> Service;
		Service = serviceDB.selectAll();
		return serviceDB.insert(service);
	}

	public Service update(Service service) throws SQLException {

		return serviceDB.update(service);
	}

	public Service delete(Integer serviceId) throws SQLException {
		Service service = new Service();
		service.setId(serviceId);
		return serviceDB.delete(service);
	}

	public ServicesBs() {
	}
}
