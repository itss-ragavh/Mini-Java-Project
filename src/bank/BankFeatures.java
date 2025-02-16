package bank;

import java.sql.*;
import java.util.Scanner;

public class BankFeatures extends bankk {
	static Scanner sc=new Scanner(System.in);
	static Connection c;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankk","root","root");
//			Statement s=c.createStatement();
	 
			System.out.println("\t\tCompleted");
			
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    }
	
			// 1.Method to withdraw money from the account
			public void withdraw(int accNo,double amount) {
				PreparedStatement ps;
				try {
					ps = c.prepareStatement("select pin,balance from bankk where acc_no=?");
						ps.setInt(1, accNo);
						ResultSet rs=ps.executeQuery();
						if (rs.next()) {
							int correctPin=rs.getInt("pin");
							double currentBalance=rs.getDouble("balance");
							
							System.out.print("Enter the Pin :");
							int enteredPin=sc.nextInt();
								if (enteredPin==correctPin) {
									if (amount>0 && amount<=currentBalance) {
										double newBalance=currentBalance-amount;
										PreparedStatement pss=c.prepareStatement("update bankk set balance=? where acc_no=?");
										pss.setDouble(1, newBalance);
										pss.setInt(2, accNo);
										pss.executeUpdate();
										  System.out.println("Successfully withdrawn ₹" + amount);
						                    System.out.println("Remaining balance: ₹" + newBalance);
									}
								 else if (amount > currentBalance) {
				                    System.out.println("Insufficient funds. Unable to withdraw ₹" + amount);
				                }
									else {
										System.out.println("Withdrawal amount must be greater than zero");
									}
								} else {
										System.out.println("The Enterd PIN is Wrong");
								}
						} else {
							System.out.println("The account Does not Exist");
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			
			
		 	// 2.Method to deposit money into the account
		    public   void deposit(int accNo,double amount) {
		    	try {
					PreparedStatement ps=c.prepareStatement("Select pin,balance from bankk where acc_no=?");
					ps.setInt(1, accNo);
					ResultSet rs=ps.executeQuery();
					if (rs.next()) {
						int correctPin= rs.getInt("pin");
						double currentBalance=rs.getDouble("balance");
						
						System.out.print("\n\tEnter the PIN :");
						int enteredPin=sc.nextInt();
						if (correctPin==enteredPin) {
							if (amount>0) {
								double newBalance=currentBalance+amount;
								PreparedStatement pss=c.prepareStatement("update bankk set balance=? where acc_no=?");
								pss.setDouble(1, newBalance);
								pss.setInt(2, accNo);
								pss.executeUpdate();
								  System.out.println("\t----Successfully Deposited ₹" + amount+"---");
								  
				                    System.out.println("\t\tRemaining balance: ₹" + newBalance);
				                    System.out.println("-----------------------------------\n");
							} else {
								System.out.println("\t\tDeposit must be greater than Zero!!\n");
							}
						} else {
							System.out.println("\n-----------------------------------");
							System.out.println("\tWrong PIN Entered Seeya!!");
							System.out.println("-----------------------------------\n");
						}
					} else {
						System.out.println("\n-----------------------------------");
						System.out.println("\tThe acoount Doesn't exists!!");
						System.out.println("-----------------------------------\n");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		    }
		    
		    
		  
		    
		 // 3.Method to Check the Balance in the account
		    public   void checkBalance(int accno) {
		        try {
		        	 System.out.print("\n\tEnter PIN: ");
		             int enteredPin = sc.nextInt();
		             
		            PreparedStatement ps = c.prepareStatement("SELECT pin,acc_name,balance FROM bankk WHERE acc_no = ?");
		            ps.setInt(1, accno);
		            ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		            	 int correctPin = rs.getInt("pin");
		            	 if (correctPin==enteredPin) {
		            		  String name = rs.getString("acc_name");
				                double balance = rs.getDouble("balance");
				                System.out.println("Hey, " + name + "!! Your current balance is: ₹" + balance);	
						 }
		            	 else {
		            		 System.out.println("\n-----------------------------------");
		            		 System.out.println("\tInCorrect pin wrong.");
		            		 System.out.println("-----------------------------------\n");
		            	 }
		            }
		              
		            else {
		            	System.out.println("\n-----------------------------------");
		                System.out.println("\tEntered Account number does not exist!!");
		                System.out.println("-----------------------------------\n");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    //4.Method to view Account Details
		    public  void viewAccountDetails(int accno) {
				
		    	try {
		    		System.out.print("\n\tEnter the Pin :");
		    		int enteredPin=sc.nextInt();
					PreparedStatement ps=c.prepareStatement("select *from bankk");
					ResultSet rs=ps.executeQuery();
					if (rs.next()) {
						int correctPin=rs.getInt("pin");
						if (correctPin==enteredPin) {
							System.out.println("\n\t--------------------------------------");
							System.out.println("\t\tAccount Details:\n");
		                    System.out.println("\t\tAccount Number: " + rs.getInt("acc_no"));
		                    System.out.println("\t\tName: " + rs.getString("acc_name"));
		                    System.out.println("\t\tPhone: " + rs.getLong("phone_no"));
		                    System.out.println("\t\tEmail: " + rs.getString("email"));
		                    System.out.println("\t\tBalance: ₹" + rs.getDouble("balance"));
		                    System.out.println("\t\tBank Name :"+rs.getString("bank_name"));
		                    System.out.println("\t---------------------------------------\n");
						} else {
							System.out.println("\n-----------------------------------");
							System.out.println("\tEntered Pin was Wrong -Start over Again");
							System.out.println("-----------------------------------\n");
						}
					} else {
						System.out.println("\n-----------------------------------");
						System.out.println("\tEnterd Account number DoesNot Exist!!");
						System.out.println("-----------------------------------\n");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					
				
				
			}
	    
//		    1.New User\n2.Login\n3.AccountManagement\n4.Deposit\n5.withdraw
		    
		    //1.Method to create new user
		    public static void NewUser() {
		    	System.out.print("Enter Account number :");
		    	int accNo=sc.nextInt();


		    	System.out.print("Enter Account holder name :");
		    	String accName=sc.next();

		    	System.out.print("Enter PhoneNumber :");
		    	Long phone=sc.nextLong();	
		    	
		    	System.out.print("Enter Account Balance :");
		    	double balance=sc.nextDouble();

		    	System.out.print("Enter email :");
		    	String email=sc.next();	
		    	
		    	System.out.print("Enter Your pin(4-digits) :");
		    	int pin=sc.nextInt();	

		    	System.out.print("Enter Bank Name :");
		    	String bName=sc.next();	
		    	
//		    	acc_no,acc_nam,Phone_no,balance,Email,pin,bankName
		    	 try {
					PreparedStatement ps=c.prepareStatement("Insert into bankk(acc_no,acc_name,phone_no,balance,email,pin,bank_name)values(?,?,?,?,?,?,?)");
					ps.setInt(1, accNo);
					ps.setString(2, accName);
					ps.setLong(3,phone);
					ps.setDouble(4, balance);
					ps.setString(5, email);
					ps.setInt(6, pin);
					ps.setString(7, bName);
					ps.executeUpdate();
					
					System.out.println("Account Created Successfully!");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		 

		    //2.Method for AccoutManagemnet 
		    public  void accountManagement() {
		    	System.out.println("\n\t1.withdraw amount\n\t2.deposit Amount\n\t3.Check Balance\n\t4.view Account Details\n");
		    	System.out.print("\t\tEnter your choice :");
		    	switch(sc.nextInt()) {
		    	
		    	case 1:{
		    		//To Withdraw Money
		    		System.out.print("\n\tEnter the Account Number :");
		    		int accNo=sc.nextInt();
		    		System.out.print("\tEnter the Amount you wanna Withdraw :");
		    		double amount =sc.nextDouble();
		    		withdraw(accNo, amount);
		    		break;
		    	}
		    	case 2:{
		    		//To Deposit Money
		    		System.out.print("\n\tEnter the Account Number :");
		    		int accNo=sc.nextInt();
		    		System.out.print("\tEnter the Amount you wanna Deposit :");
		    		double amount =sc.nextDouble();
		    		deposit(accNo, amount);
		    		break;
		    	}
		    	case 3:{
		    		//To check the Balance
		    		System.out.print("\n\tEnter the Account Number :");
		    		int accNo=sc.nextInt();
		    		checkBalance(accNo);
		    	}
		    	case 4:{
		    		//To view the Account details
		    		System.out.print("\n\tEnter the Account Number :");
		    		int accNo=sc.nextInt();
		    		viewAccountDetails(accNo);
		    		break;
		    	}
		    	
		    	default:{
		    		System.out.println("\n-----------------------------------");
		    		System.out.println("\tEntered Option is wrong");
		    		System.out.println("-----------------------------------\n");
		    		break;
		    	}
		    	}
		    
		    }
}

