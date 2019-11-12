package com.bluewind.configuratonproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * @Configuration //@Configuration annotation doesn't work here, 
 * probably because classes with @Configuration annotation are not considered as a normal Bean by Spring.
 * Maybe also related to spring boot version. This project is using 2.2.1, but the tutorial is using 2.1.3.
*/
@Component
@ConfigurationProperties(prefix="mail")

public class ConfigProperties {
	public String hostName;
	public int port;
	public String from;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	@Override
	public String toString() {
		return "ConfigProperties [hostName=" + hostName + ", port=" + port + ", from=" + from + "]";
	}
	
	

}
