package com.gcproject.ezpz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EZPZDao {


	public static Connection readDataBase() throws Exception {
		String pass = System.getenv("DATABASE_PASSWORD");
		String url = System.getenv("DATABASE_URL_PARAMS");
		String user = System.getenv("DATABASE_USERNAME");
		
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezpz", "root", "sesame");
		Class.forName("org.postgresql.Driver");
		//Connection connect = DriverManager.getConnection("jdbc:postgresql://ec2-54-235-221-102.compute-1.amazonaws.com:5432/de3h0jbprur7d8?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "bctthbkxfsapcr", "vAik0XnXrICB1SMxcCZOUQTF1L");
		Connection connect = DriverManager.getConnection(url, user, pass);
		
		return connect;
	}
	
	public static Statement getStatement() throws Exception, SQLException {
		Connection connect = readDataBase();
		Statement statement = connect.createStatement();

		return statement;
	}

	public static String[] getData(String query) throws Exception {
		Statement statement = getStatement();
		ResultSet resultSet = statement.executeQuery("select * from recipes where \"Meal\" = '" + query + "'");
		
		String[] info = new String[4];
		while(resultSet.next()){
			
			info[0] = resultSet.getString("Replacement");
			info[1] = resultSet.getString("Url");
			info[2] = resultSet.getString("Veggie");
			info[3] = resultSet.getString("Meat");
		}
		return info;
	}


	public static String[] getNutrition(String query) throws Exception{
		Statement statement = getStatement();
		ResultSet resultSet = statement.executeQuery("select * from nutrition where \"Veggie\" = '" + query + "'");

		String[] recipes = new String[6];
		while(resultSet.next()){
			
			recipes[0] =resultSet.getString("Name");
			recipes[1] =resultSet.getString("Protein");
			recipes[2] =resultSet.getString("Carbs");
			recipes[3] =resultSet.getString("Fiber");
			recipes[4] =resultSet.getString("Calories");
			recipes[5] =resultSet.getString("Veggie");
		}
		return recipes;
	}
	
	

//	public static void insertInfo(String[] array) throws Exception {
//		connect = readDataBase();
//		String preparedQuery = "Insert Into ezpz.easypeasy (Meal, Meat)" + "Values(?,?)";
//		
//		try {
//			for(String a: array){
//				preparedStatement = connect.prepareStatement(preparedQuery);
//				preparedStatement.setString(1,a);
//				preparedStatement.setString(2,"");
//				preparedStatement.executeUpdate();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//	}
}

