//Javier Gonzalez
//Sql driver takes care of fetching and updating SQL DB

package westernracelogger.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLDriver {
	private static Connection conn;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/runner_project?user=root&password=obliviux");
			System.out.println("Connection success");
			
			PrintTable();
			UpdateTable("A344", 5,67);
			PrintTable();
			
			
			
	        conn.close();
		}
		catch (Exception e){
			
			//handle exceptions and shit
			System.err.print(e);
		}
		
		
		

	}
	
	
	
	public static void UpdateTable(String id, int placein, int placeout){
		
		String query = "UPDATE runners"
				+ " SET r_placein="+placein + ", r_placeout=" + placeout 
				+ " WHERE r_id=" + "'"+id+"'" +";" ;
		try {
			
			Statement stmt = conn.createStatement();
			int ret = stmt.executeUpdate(query);
			
			
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public static void UpdateTable(String id, int placein){
		String query = "UPDATE runners"
				+ " SET r_placein="+placein
				+ " WHERE r_id=" + "'"+id+"'" +";" ;
		try {
			
			Statement stmt = conn.createStatement();
			int ret= stmt.executeUpdate(query);
			
			
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void PrintTable(){
		String query = "SELECT * FROM runners;";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()){
				System.out.println("ID: "+ rs.getString("r_id") +"| Name: " + rs.getString("r_name") + "| PlaceIn: " + rs.getString("r_placein") + "| PlaceOut: " + rs.getString("r_placeout"));
				
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

