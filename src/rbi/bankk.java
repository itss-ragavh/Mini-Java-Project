package rbi;
 class bankk {
	private int accNo;
	private String acName;
	private double balance;
	private int pin;
	private long phNo;
	private String email;
	private String bName;
	
	public bankk() {}
	
	public bankk(int accNo, String acName, double balance, int pin, long phNo, String email, String bName) {
		super();
		this.accNo = accNo;
		this.acName = acName;
		this.balance = balance;
		this.pin = pin;
		this.phNo = phNo;
		this.email = email;
		this.bName = bName;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	

	    
}
