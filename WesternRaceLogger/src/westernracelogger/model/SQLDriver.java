//Javier Gonzalez
//Sql driver takes care of fetching and updating SQL DB

package westernracelogger.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class SQLDriver {
	private static Connection conn;
	static LinkedList<Runner> runners= new LinkedList<Runner>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* make sure IP address is correct when switching to a new network */
			conn = DriverManager.getConnection("jdbc:mysql://134.154.62.169/runner_project?user=$station&password=$station");
			System.out.println("Connection success");
			
			PrintTable();
			
			java.util.Date date = new java.util.Date(); // Right now
			java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			Runner runner= new Runner();
			runner.set_age(13); runner.set_first_name("Adolf"); runner.set_last_name("Loaf");
			runner.set_gender("F"); runner.set_in_time(date);
			//runner.set_runner_id("A344");
			
			runners.add(runner);
			UpdateTableIn(runner);
			PrintTable();
			
			
			
	        conn.close();
		}
		catch (Exception e){
			
			//handle exceptions and shit
			System.err.print(e);
		}
		

	}
	
	/*
	 * Read rows form SQL database and put into linked list
	 */
	public static LinkedList<Runner> RetrieveTableData(){  
		
		String query= "Select * from runners;";
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			//retrieve row by row
			while(rs.next()){
				Runner runner = new Runner();
				runner.set_age(rs.getInt("r_age"));
				runner.set_first_name(rs.getString("r_name"));
				runner.set_gender(rs.getString("r_gender"));
				//runner.set_runner_id(rs.getString("r_ID"));
				runner.set_in_place(rs.getInt("r_placein"));
				runner.set_out_place(rs.getInt("r_placeout"));
				runner.set_out_time(rs.getDate("r_timeout"));
				runner.set_in_time(rs.getDate("r_timein"));
				runners.add(runner);	//add runner to list, for retunr at end of function
			}
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return runners;
		
		
	}
	
	/*
	 * Updates check-in station columns
	 */
	public static void UpdateTableIn(Runner runner){
		
		String query = "UPDATE runners"
				+ " SET r_placein= "+runner.in_place
				+ ", r_timein= '" + runner.in_time +"'"
				
				+ " WHERE r_id=" + "'"+runner.runner_id+"'" +";" ;
		try {
			
			Statement stmt = conn.createStatement();
			int ret = stmt.executeUpdate(query);
			
			
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	/*
	 * Updates check-out station columns
	 */
	public static void UpdateTableOut(Runner runner){
		
		String query = "UPDATE runners"
				+ " SET r_placeout= "+runner.out_place
				+ ", r_timeout= '" + runner.out_time +"'"
				+ " WHERE r_id=" + "'"+runner.runner_id+"'" +";" ;
		try {
			
			Statement stmt = conn.createStatement();
			int ret = stmt.executeUpdate(query);
			
			
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	/*
	 * prints runner list row by row from sqldb, for debugging purposes
	 */
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

