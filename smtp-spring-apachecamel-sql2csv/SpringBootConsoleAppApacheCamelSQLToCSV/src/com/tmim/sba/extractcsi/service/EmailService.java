package com.tmim.sba.extractcsi.service;

//import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Properties;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service

public class EmailService {

	@Value("${APP.CAMEL_CONTEXT.ROUTE2_SQL_TO}")
	private String sql1;
	@Value("${APP.CAMEL_CONTEXT.ROUTE2_SQL_CC}")
	private String sql2;

	@Value("${APP.JDBC.DRIVER_CLASS_NAME}")
	private String driver;	
	@Value("${APP.JDBC.CONNECTION_STR}")
	private String URL;
	@Value("${APP.JDBC.USERNAME}")
	private String Username;
	@Value("${APP.JDBC.PASSWORD}")
	private String Password;

	public EmailService() throws SQLException {}

	public String getEmail() throws SQLException, ClassNotFoundException {
		// initialize Spring's Application context
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-appcontext-dir/appcontext-devserver.xml");
		// get bean declared with email "dataSource" in the configuration file
		//DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");
		// get connection
		//Connection connection = dataSource.getConnection();
        Class.forName(driver); 
        Connection connection = DriverManager.getConnection( 
        		URL, Username, Password); 
		
		// get the email
		PreparedStatement preparedStatement = connection.prepareStatement(sql1);
		ResultSet resultSet = preparedStatement.executeQuery();
		String email = "";
		List<String> tests = new ArrayList<String>();
		while (resultSet.next()) {
			email = resultSet.getString("email_to");
			tests.add(email);
		}
		String[] strarray = tests.toArray(new String[0]);
		String emails = Arrays.toString(strarray).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
		// context.close();
		//((ConfigurableApplicationContext) context).close();
		resultSet.close();
		connection.close();
		return emails;
	}

	// CC email
	public String getCCEmail() throws SQLException, ClassNotFoundException {
		// initialize Spring's Application context
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-appcontext-dir/appcontext-devserver.xml");
		// get bean declared with email "dataSource" in the configuration file
		//DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");
		// get connection
		//Connection connection = dataSource.getConnection();
		Class.forName(driver); 
        Connection connection = DriverManager.getConnection( 
        		URL, Username, Password); 
        
		// get the email
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		ResultSet resultSet2 = preparedStatement2.executeQuery();
		String cc_email = "";
		List<String> tests2 = new ArrayList<String>();
		while (resultSet2.next()) {
			cc_email = resultSet2.getString("email_to");
			tests2.add(cc_email);
		}
		String[] strarray2 = tests2.toArray(new String[0]);
		String emailsCC = Arrays.toString(strarray2).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
		//((ConfigurableApplicationContext) context).close();
		resultSet2.close();
		connection.close();
		return emailsCC;
	}
}