package westernracelogger.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Runner {

	
    
    private final IntegerProperty in_place;
    private final IntegerProperty out_place;
    private final StringProperty runner_id;
    private final ObjectProperty<Timestamp> in_time;
    private final ObjectProperty<Timestamp> out_time;
    private final StringProperty name;
    private final StringProperty gender;
    private final IntegerProperty age;
    /**
     * Default constructor.
     */
    public Runner() {
        this("","","",0);
    }

    public Runner(String id, String name, String gender, int age) {
        this.runner_id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleIntegerProperty(age);
        this.in_time = new SimpleObjectProperty<Timestamp>();
        this.out_time = new SimpleObjectProperty<Timestamp>();
        this.in_place = new SimpleIntegerProperty();
        this.out_place = new SimpleIntegerProperty();
    }

    public String get_runner_id() { return runner_id.get(); }
    public void set_runner_id(String id) { this.runner_id.set(id); }   
    public StringProperty runnerIDProperty(){ return runner_id; }  
    
    public String get_name() { return name.get(); }
    public void set_name(String name) { this.name.set(name); }    
    public StringProperty nameProperty(){ return name; }  
    
    public String get_gender() { return gender.get(); }
    public void set_gender(String gender) { this.gender.set(gender); }  
    public StringProperty genderProperty(){ return gender; } 
    
    public int get_age() { return age.get(); }
    public void set_age(int age) { this.age.set(age); }
    public IntegerProperty ageProperty(){ return age; }
    
    public Timestamp get_in_time() { return in_time.get(); }
    public void set_in_time(Timestamp d) { this.in_time.set(d); }
    public ObjectProperty<Timestamp> inTimeProperty(){ return in_time; }
    
    public Timestamp get_out_time() { return out_time.get(); }
    public void set_out_time(Timestamp d) { this.out_time.set(d); }
    public ObjectProperty<Timestamp> outTimeProperty(){ return out_time; }
    
    public int get_in_place() { return in_place.get(); }
    public void set_in_place(int i) { this.in_place.set(i); }
    public IntegerProperty inPlaceProperty(){ return in_place; }
    
    public int get_out_place() { return out_place.get(); }
    public void set_out_place(int o) { this.in_place.set(o); }
    public IntegerProperty outPlaceProperty(){ return out_place; }
    
    
    
}