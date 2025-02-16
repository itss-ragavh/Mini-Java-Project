package bank;

import java.util.Scanner;

public class BankingApplication extends BankFeatures {
		static Scanner sc=new Scanner(System.in);
		public static void main(String[] args) {
			System.out.println("\n\n\tWelcome to BankApplication!!\n");
			System.out.println("\n\t1.New User\n\t2.AccountManagement\n\t3.Exit");
			System.out.print("\nEnter the Option :");
			switch(sc.nextInt()) {
			
			case 1:{
				NewUser();
				break;
			}
			case 2:{
				new BankFeatures().accountManagement();
				break;
			}
			case 3:{
				sc.close();
				System.out.println("\n-----------------------------------");
				System.out.println("\tHope you see me soon!!");
				System.out.println("-----------------------------------\n");
				return;
			}
			default:{
				System.out.println("\n-----------------------------------");
				System.out.println("\tInvalid Input");
				System.out.println("-----------------------------------\n");
				break;
			}
			}
			
			
		}
		
	
}
