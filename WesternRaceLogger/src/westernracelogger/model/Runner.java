package westernracelogger.model;


import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Runner {
	
	IntegerProperty in_place;
	IntegerProperty out_place;
	IntegerProperty runner_id;
	Date in_time;
	Date out_time;
	StringProperty first_name;
	StringProperty last_name;
	StringProperty gender;
	IntegerProperty age;
	
	//setters
	public void set_in_place(IntegerProperty i){ in_place = i; }
	public void set_out_place(IntegerProperty i){ out_place = i; }
	public void set_runner_id(IntegerProperty i){ runner_id = i; }
	public void set_in_time(Date d){ in_time = d; }
	public void set_out_time(Date d){ out_time = d; }
	public void set_first_name(StringProperty s){ first_name = s; }
	public void set_last_name(StringProperty s){ last_name = s; }
	public void set_gender(StringProperty s){ gender = s; }
	public void set_age(IntegerProperty i){ age = i; }
	
	//getters
	public IntegerProperty get_in_place(){ return in_place; }
	public IntegerProperty get_out_place(){ return out_place; }
	public IntegerProperty get_runner_id(){ return runner_id; }
	public Date get_in_time(){ return in_time; }
	public Date get_out_time(){ return out_time; }
	public StringProperty get_first_name(){ return first_name; }
	public StringProperty get_last_name(){ return last_name; }
	public StringProperty get_gender(){ return gender; }
	public IntegerProperty get_age(){ return age; };
	
	public Runner(){
		this.runner_id = new SimpleIntegerProperty(0);
		this.first_name = new SimpleStringProperty("") ;
		this.last_name = new SimpleStringProperty("");
		this.gender = new SimpleStringProperty("");
		this.age = new SimpleIntegerProperty(0);
	}
	
	public Runner(int runner_id, String first_name, String last_name, String gender, int age ) {
		
		
		this.runner_id = new SimpleIntegerProperty(runner_id);
		this.first_name = new SimpleStringProperty(first_name) ;
		this.last_name = new SimpleStringProperty(last_name);
		this.gender = new SimpleStringProperty(gender);
		this.age = new SimpleIntegerProperty(age);
    }
	
}
