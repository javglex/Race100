package westernracelogger.model;

import java.util.Date;

public class Runner {
	
	int in_place;
	int out_place;
	int runner_id;
	Date in_time;
	Date out_time;
	String first_name;
	String last_name;
	String gender;
	int age;
	
	//setters
	public void set_in_place(int i){ in_place = i; }
	public void set_out_place(int i){ out_place = i; }
	public void set_runner_id(int i){ runner_id = i; }
	public void set_in_time(Date d){ in_time = d; }
	public void set_out_time(Date d){ out_time = d; }
	public void set_first_name(String s){ first_name = s; }
	public void set_last_name(String s){ last_name = s; }
	public void set_gender(String s){ gender = s; }
	public void set_age(int i){ age = i; }
	
	//getters
	public int get_in_place(){ return in_place; }
	public int get_out_place(){ return out_place; }
	public int get_runner_id(){ return runner_id; }
	public Date get_in_time(){ return in_time; }
	public Date get_out_time(){ return out_time; }
	public String get_first_name(){ return first_name; }
	public String get_last_name(){ return last_name; }
	public String get_gender(){ return gender; }
	public int get_age(){ return age; };
	
}
