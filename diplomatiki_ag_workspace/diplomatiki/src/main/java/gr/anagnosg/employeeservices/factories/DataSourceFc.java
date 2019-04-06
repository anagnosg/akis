package gr.anagnosg.employeeservices.factories;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import gr.anagnosg.employeeservices.config.Settings;

@ApplicationScoped
public class DataSourceFc {

	DataSource ds;
	
	
	@Inject
	Settings settings;
	
	public DataSourceFc(){
		
	}
	
	@Produces
	public DataSource getDatasource(){
		
		if(this.ds==null){
			String dsName = this.settings.getDatasourceName();
			
			try {
				InitialContext context;
				context = new InitialContext();
				ds = (DataSource) context.lookup(dsName);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return this.ds;
	}
}
