package com.devops.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SonarqubeMysqlDemoApplication {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(SonarqubeMysqlDemoApplication.class);
	  public Environment getEnv() {
		return env;
	}

    @Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}


	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(SonarqubeMysqlDemoApplication.class, args);
	}

	
	public Connection createConnection() {
		
		Connection con = null;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", env.getProperty("mysql.password"));
		}
		catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		return con;
	}
}
