package westernracelogger.model;

import java.util.List;

public class Race {

	List<Runner> runner_list;
	User user;
	int num_finished;
	
	public void inc_finished(int i){ num_finished+= i; }
	public void set_finished(int i){ num_finished = i; }
	public int get_finished(){ return num_finished; }
	
}
