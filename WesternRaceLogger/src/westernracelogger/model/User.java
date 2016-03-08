package westernracelogger.model;

public class User {
	
	public enum Rank{ IN, OUT, ADMIN};
	
	Rank user_rank;
	
	public void set_rank(Rank r){ user_rank = r; }
	
	public Rank get_rank(){ return user_rank; }
	
}