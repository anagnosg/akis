package gr.akis.handsapp.config;

import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Settings {
	String basePath;
	String port;
	String protocol;
	String host;
	
	String datasourceName;
	
	ResourceBundle config ;
	
	public Settings() {
		config = ResourceBundle.getBundle("config");
		load();
	}
	
	public void load(){
		this.basePath = config.getString("basePath");
		this.port = config.getString("port");
		this.protocol = config.getString("protocol");
		this.host = config.getString("host");
		this.datasourceName = config.getString("datasourceName");
		
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public ResourceBundle getConfig() {
		return config;
	}

	public void setConfig(ResourceBundle config) {
		this.config = config;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}
}
