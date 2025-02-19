package playerPerformance;

import java.util.Scanner;

public class Main extends PlayerFeautresAndDataBaseConnect{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	
		
		System.out.println("\n\n\t ----------------------------------");
		System.out.println("\t|Cricket Player Performance Tracker|");
		System.out.println("\t ----------------------------------\n");
		System.out.println("\t---------------------------------");
		System.out.println("\t|   1.add new player\t\t|"
				+ "\n\t|   2.Update Player Stats\t|"
				+ "\n\t|   3.Delete Player\t\t|"
				+ "\n\t|   4. View Player Details\t|"
				+ "\n\t|   5. Compare Two Players\t|"
				+ "\n\t|   6.Exit\t\t\t|");
		System.out.println("\t---------------------------------");
		System.out.print("\n\nEnter your option :");
		switch (sc.nextInt())	
		{
			
		case 1:{
			//To Add New Player
			addPlayer();
			break;}
		case 2:{
			//To update the Player Details
			System.out.print("\n\tEnter the player Id :");
			int pId=sc.nextInt();
			new PlayerFeautresAndDataBaseConnect().updatePlayerStats(pId);
			break;}
		case 3:{
			//To [Remove or Delete] the Player
			System.out.print("\n\tEnter the Player Id :");
			int pId=sc.nextInt();
			new PlayerFeautresAndDataBaseConnect().deletePlayer(pId);
			break;
		}
		case 4:{
			//To view Player Details
			System.out.print("\n\tEnter the Player Id :");
			int pId=sc.nextInt();
			new PlayerFeautresAndDataBaseConnect().viewPlayerDetails(pId);
			break;}
		
		case 5:
		{
			//Compare two player based on either batting or bowling
			System.out.print("\n\tEnter the Player 1 Id :");
			int pId1=sc.nextInt();
			System.out.print("\n\tEnter the Player 2 Id :");
			int pId2=sc.nextInt();
			System.out.println("\n\t\tIn which basis you wanna compare these two Players");
			System.out.println("\t\t\t1.Batting\n\t\t\t2.Bowling");
			System.out.print("\t\tEnter the option :");
				switch (sc.nextInt())		
				{
					case 1:{//based on batting
							new PlayerFeautresAndDataBaseConnect().ComparePlayers(pId1, pId2, 1);
							break;}
					case 2:{//based on bowling
							new PlayerFeautresAndDataBaseConnect().ComparePlayers(pId1, pId2, 2);
							break;}
					default:{
							System.out.println("\t\t\tInvalid Input");
					}
				}//Inner switch closes
			break;
		}
		case 6:{
			//TO Exit;
			sc.close();
			System.out.println("\n\t\t\t-----------------------------");
			System.out.println("\t\t\t\tSeeya Soon!!");
			System.out.println("\t\t\t-----------------------------");
			return;
			}
		
		default:{
			System.out.println("\n\t---Invalid option Selected.---");
		}
		}//Outer switch closes
		
	
	
}
}
