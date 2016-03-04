//last update 3/3 8:51
package westernracelogger.model;


import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Runner {
	
	IntegerProperty in_place;
	IntegerProperty out_place;
	StringProperty runner_id;
	Timestamp in_time;
	Timestamp out_time;
	StringProperty name;
	StringProperty gender;
	IntegerProperty age;
	
	//setters
	public void set_in_place(int i){ in_place.setValue(i);}
	public void set_out_place(int i){ out_place.setValue(i);}
	public void set_runner_id(String i){ runner_id.setValue(i);}
	public void set_in_time(Timestamp d){ in_time = d; }
	public void set_out_time(Timestamp d){ out_time = d; }
	public void set_name(String s){ name.setValue(s);}
	public void set_gender(String s){ gender.setValue(s); }
	public void set_age(int i){ age.setValue(i);}
	
	//getters
	public IntegerProperty get_in_place(){ return in_place; }
	public IntegerProperty get_out_place(){ return out_place; }
	public StringProperty get_runner_id(){ return runner_id; }
	public Timestamp get_in_time(){ return in_time; }
	public Timestamp get_out_time(){ return out_time; }
	public StringProperty get_name(){ return name; }
	public StringProperty get_gender(){ return gender; }
	public IntegerProperty get_age(){ return age; };
	
	public Runner(){
		this.runner_id = new SimpleStringProperty("");
		this.name = new SimpleStringProperty("") ;
		this.gender = new SimpleStringProperty("");
		this.age = new SimpleIntegerProperty(0);
		this.in_place = new SimpleIntegerProperty(0);
		this.in_place = new SimpleIntegerProperty(0);

	}
	
	public Runner(String runner_id, String name, String gender, int age ) {
		
		
		this.runner_id = new SimpleStringProperty(runner_id);
		this.name = new SimpleStringProperty(name);
		this.gender = new SimpleStringProperty(gender);
		this.age = new SimpleIntegerProperty(age);
    }
	
}
