package com.luv2code.ecommerce.server;

import org.hsqldb.Server;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements InitializingBean, DisposableBean {
	
	private  Server server;
	@Override
	public void afterPropertiesSet() throws Exception {
		// Create a new HSQLDB server
        server = new Server();

        // Set the server properties
        server.setDatabaseName(0, "ecommerceapp");
        server.setDatabasePath(0, "file:hsqldb/db/ecommerceapp");
        server.setPort(9001);

        // Start the server
        server.start();
		System.out.println("server running");
	}
	
	
	@Override
	public void destroy() throws Exception {
		// Stop the server when the application shuts down
        if (server != null) {
            server.stop();
            System.out.println("server Stopping");
        }
		
	}

	
	

}
