package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
	public static void main(String[] args) {
	//	createTable();
	//createProduct();
	//createProduct(101,"Power of now");
//insertRecordsUsingPreparedStatement();
	selectAllProduct();
//	selectProduct(101);
	//	updateAllProducts();
//		updateProduct(100,"CANT HURT ME");
//		updateProduct(101,"Power of now");
//		updateProduct(102,"The Alchemist");
//		updateProduct(103,"The monk who sold his Ferrari");
//		deleteProduct(103);
//	 deleteAllProduct();
	// dropTable();
//		
	}

	public static void createTable()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String createTableQuery = "CREATE TABLE PRODUCTS (PRODUCT_ID NUMBER, PRODUCT_NAME VARCHAR(50))";
			System.out.println(createTableQuery);
			statement.execute(createTableQuery);
			System.out.println("Successfully created table ");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	public static void createProduct() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			//Hard coded values
			String insertQuery = "insert into products values (100,'CANT HURT ME')";
			int noOfRowsAffected = statement.executeUpdate(insertQuery);
			System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void createProduct(int productId, String productName) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("Driver loaded successfully!");
		//Get the connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
		//System.out.println("Connection Established!");
		//Create the statement
		Statement statement = connection.createStatement();
		//Execute the query
		String insertQuery = "insert into products values (" + productId + ",'" + productName + "')";
		//System.out.println(insertQuery);
		int noOfRowsAffected = statement.executeUpdate(insertQuery);
		System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
	} 
	catch (ClassNotFoundException e) {
		System.out.println(e);
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
	public static void selectAllProduct() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			ResultSet resultSet = statement.executeQuery("select * from products");
			while(resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String productName = resultSet.getString("product_name"); 
				System.out.println("Product Id " + " > " + productId +  " Product Name  " + " > " + productName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void selectProduct(int productid) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String query="select product_id, product_name from products where product_id = " + productid ;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String productName = resultSet.getString("product_name"); 
				System.out.println("Product Id " + " > " + productId +  " Product Name  " + " > " + productName);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
}
	public static void updateAllProducts() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String updateQuery = "UPDATE  products SET PRODUCT_NAME = 'THE POWER OF POSITIVE THINKING' ";
			//System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void updateProduct(int productId, String productName) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String updateQuery = "UPDATE  products SET PRODUCT_NAME = '" + productName + "' where product_id = " + productId;
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void deleteAllProduct() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String updateQuery = "delete from products";
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully deleted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void deleteProduct(int productId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String updateQuery = "delete from products where product_id =" + productId;
			System.out.println(updateQuery);
			int noOfRowsAffected = statement.executeUpdate(updateQuery);
			System.out.println("Successfully deleted " + noOfRowsAffected + "record(s)!");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void dropTable() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver loaded successfully!");
			//Get the connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			//System.out.println("Connection Established!");
			//Create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			String dropTableQuery = "DROP TABLE PRODUCTS";
			System.out.println(dropTableQuery);
			statement.execute(dropTableQuery);
			System.out.println("Successfully DROPPED table ");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
public static void insertRecordsUsingPreparedStatement() {
	// Get ojdbc14.jar
	// Load the driver
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("Driver loaded successfully!");
		//Get the connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
		//System.out.println("Connection Established!");
		
		String insertQuery = "insert into products values (?,?)";
		//Create the statement
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		//Execute the query
		preparedStatement.setInt(1,102);
		preparedStatement.setString(2, "The Alchemist");
		int noOfRowsAffected = preparedStatement.executeUpdate();
		System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
		preparedStatement.setInt(1,103);
		preparedStatement.setString(2, "The Monk Who Sold His Ferrari!");
		noOfRowsAffected = preparedStatement.executeUpdate();
		System.out.println("Successfully inserted " + noOfRowsAffected + "record(s)!");
	} catch (ClassNotFoundException e) {
		System.out.println(e);
	} catch (SQLException e) {
		System.out.println(e);
	}
}
}
