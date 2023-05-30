package org.ass.hospital.util;

import java.util.Properties;

public class ConnectionUtil 
{
	public static Properties getDbProperties()
	{
		Properties properties = new Properties();
		
		properties.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/user_db");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

}
