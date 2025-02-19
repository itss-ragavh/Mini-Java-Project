package playerPerformance;

public class Player {
	
	private int pId;
	private String name;
	private String team;
	private int matches;
	private int runs;
	private int wickets;
	private double avgBat;
	private double avgBow;
	
	
	public Player() {}
	
	public Player(int pId, String name, String team, int matches, int runs, int wickets, double avgBat, double avgBow) {
		super();
		this.pId = pId;
		this.name = name;
		this.team = team;
		this.matches = matches;
		this.runs = runs;
		this.wickets = wickets;
		this.avgBat = avgBat;
		this.avgBow = avgBow;
	}
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public double getAvgBat() {
		return avgBat;
	}
	public void setAvgBat(double avgBat) {
		this.avgBat = avgBat;
	}
	public double getAvgBow() {
		return avgBow;
	}
	public void setAvgBow(double avgBow) {
		this.avgBow = avgBow;
	}
	
	
	
}
