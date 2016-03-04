//Javier Gonzalez
//Sql driver takes care of fetching and updating SQL DB
//last update 3/3 8:51

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
			
			//PrintTable();
			
			java.util.Date date = new java.util.Date(); // Right now
			java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			Runner runner= new Runner();
			
			runner.set_age(13); 
	        runner.set_name("Adolf Loaf");
			runner.set_gender("F");
			runner.set_in_time(timestamp);
		    runner.set_in_place(11);
			runner.set_out_place(12);
			runner.set_out_time(timestamp);
			runner.set_runner_id("A374");
			
			//runners.add(runner);
			
			UpdateTableIn(runner);
			
			UploadIntoTable(runner);
			PrintTable();
			
			
			
	        conn.close();
		}
		catch (Exception e){
			
			//handle exceptions and shit
			System.err.print(e);
		}
		

	}
	
	/*Open file and read into linked list
	 * 
	 */
	public static void FileIntoList(/*file here*/){
		
		//open file here
		//for runners...
		//uploadintotable (runners)
	}
	
	/*
	 *  Upload runner to SQLDB (admin only)
	 */
	public static void UploadIntoTable(Runner runner){
		
		//Runner runner;
		
		String query = "INSERT INTO runners(r_id, r_name, r_placein, r_placeout, r_timein, r_timeout, r_age, r_gender)"
				+ " VALUES ('" + runner.get_runner_id().getValue() + "','" + runner.get_name().getValue() + "' ," +
				runner.get_in_place().getValue() + "," + runner.get_out_place().getValue() + ",'" +
				runner.get_in_time() + "','" + runner.get_out_time() + "'," + runner.get_age().getValue() + 
				",'" + runner.get_gender().getValue()
				+"');";
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
	 * Read rows form SQL database and put into linked list
	 */
	public static LinkedList<Runner> RetrieveTableData(){  
		
		LinkedList<Runner> retrieved = new LinkedList<Runner>();
		
		String query= "Select * from runners;";
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			//retrieve row by row
			while(rs.next()){
				Runner runner = new Runner();
				runner.set_age(rs.getInt("r_age"));
				runner.set_name(rs.getString("r_name"));
				runner.set_gender(rs.getString("r_gender"));
				runner.set_runner_id(rs.getString("r_ID"));
				runner.set_in_place(rs.getInt("r_placein"));
				runner.set_out_place(rs.getInt("r_placeout"));
				runner.set_out_time(rs.getTimestamp("r_timeout"));
				runner.set_in_time(rs.getTimestamp("r_timein"));
				runners.add(runner);	//add runner to list, for retunr at end of function
			}
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return retrieved;
		
		
	}
	
	/*
	 * Updates check-in station columns
	 */
	public static void UpdateTableIn(Runner runner){
		
		System.out.println(runner.get_in_time());
		System.out.println(runner.get_runner_id().getValue());
		String query = "UPDATE runners"
				+ " SET r_placein= "+runner.get_in_place().getValue()
				+ ", r_timein= '" + runner.get_in_time() +"'"
				
				+ " WHERE r_id=" + "'"+runner.get_runner_id().getValue()+"';" ;
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
				+ " SET r_placeout= "+runner.get_out_place().intValue()
				+ ", r_timeout= '" + runner.get_out_time()+"'"
				+ " WHERE r_id=" + "'"+runner.get_runner_id().getValue()+"'" +";" ;
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
				System.out.println("ID: "+ rs.getString("r_id") +"| Name: " + rs.getString("r_name") 
				+ "| PlaceIn: " + rs.getString("r_placein") + "| PlaceOut: " 
				+ rs.getString("r_placeout") + "| TimeIn: " +rs.getTimestamp("r_timein")
				+ "| TimeOut: " +rs.getTimestamp("r_timeout"));
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

