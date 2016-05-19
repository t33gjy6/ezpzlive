package com.gcproject.ezpz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EZPZDao {


	public static Connection readDataBase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezpz", "root", "sesame");
		
		return connect;
	}
	
	public static Statement getStatement() throws Exception, SQLException {
		Connection connect = readDataBase();
		Statement statement = connect.createStatement();

		return statement;
	}

	public static String[] getData(String query) throws Exception {
		Statement statement = getStatement();
		ResultSet resultSet = statement.executeQuery("select * from ezpz.recipes where Meal = '" + query + "'");
		
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
		ResultSet resultSet = statement.executeQuery("select * from ezpz.nutrition where Meat = '" + query + "'");

		String[] recipes = new String[5];
		while(resultSet.next()){
			
			recipes[0] =resultSet.getString("Name");
			recipes[1] =resultSet.getString("Protein");
			recipes[2] =resultSet.getString("Carbs");
			recipes[3] =resultSet.getString("Fiber");
			recipes[4] =resultSet.getString("Calories");
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

