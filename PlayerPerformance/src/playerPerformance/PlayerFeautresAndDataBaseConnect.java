package playerPerformance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class PlayerFeautresAndDataBaseConnect extends Player {

    static Scanner sc = new Scanner(System.in);

    // Declare the connection
    static Connection c;

    // Static block to initialize the database connection
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/player", "root", "root");
            System.out.println("DataBase Connected Successfully ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a player
    public static void addPlayer() {

    	System.out.println("\n\t\tHey Entres the Deatils for Add new Player \n");
    	System.out.print("\tEnter the Player ID :");
    	int playId=sc.nextInt();
    	
    	System.out.print("\tEnter thr Player Name :");
    	String Pname=sc.next();
    	
    	System.out.print("\tEnter the Team name :");
    	String team=sc.next();
    	
    	System.out.print("\tNumber of Matches the palyer Played :");
    	int match=sc.nextInt();
    	
    	System.out.print("\tNumber of Runs the Player Scored Till now :");
    	int run=sc.nextInt();
    	
    	System.out.print("\tThe Total number of Wickets Taken by the Player :");
    	int wicket=sc.nextInt();
    	
    	System.out.print("\tThe Average Score of the Player For batting :");
    	double avgbat=sc.nextDouble();
    	
    	System.out.print("\tThe Average Score of the Player for bowling :");
    	double avgbow=sc.nextDouble();
    	
//    	player_id  name  team  matches  runs  wickets  avg_batting  avg_bowling
    	
    	try {
			PreparedStatement ps=c.prepareStatement("insert into player(player_id,name,team,matches,runs,wickets,avg_batting,avg_bowling)values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, playId);
			ps.setString(2, Pname);
			ps.setString(3, team);
			ps.setInt(4, match);
			ps.setInt(5, run);
			ps.setInt(6, wicket);
			ps.setDouble(7, avgbat);
			ps.setDouble(8, avgbow);
			 int rowsInserted = ps.executeUpdate();
			
			 if (rowsInserted > 0) {
		            System.out.println("\n\t\tPlayer added successfully!");
		            System.out.println("\t\t-------------------------\n");
		        } else {
		            System.out.println("\n\t\tError: Player not added.");
		        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Method to update player stats
    public  void updatePlayerStats(int pId) {
    	try {
       PreparedStatement ps=c.prepareStatement("Select*from player where player_id=?");
       ps.setInt(1, pId);
       ResultSet rs=ps.executeQuery();
       if (rs.next()) {
    	   System.out.print("\n\t1.Player Name.\n\t2.Player's Team name \n\t3.Matches Played");
    	   System.out.println("\n\t4.Runs\n\t5.Number of Wickets\n\t6.Average Score in batting\n\t7.Average SCore in Bowling\n");
    	   System.out.print("Enter the option you wanna update: ");
    	   	switch (sc.nextInt())
    	   	{
    	   			case 1:{
    	   				System.out.print("\n\t\tEnter the updated Player's New Name :");
    	   				String newName=sc.next();
    	   				PreparedStatement psn=c.prepareStatement("update player set name=? where player_id=?");
    	   				psn.setString(1, newName);
    	   				psn.setInt(2, pId);
    	   				psn.executeUpdate();
    	   				System.out.println("\n\t\tThe Player Name Updated Succesfully");
    	   				System.out.println("\t\t-----------------------------------\n");
    	   				break;
    	   			}
    	   			case 2:{
    	   				System.out.print("\n\t\tEnter the updated Player's new Team Name :");
    	   				String newTName=sc.next();
    	   				PreparedStatement pstn=c.prepareStatement("update player set team=? where player_id=?");
    	   				pstn.setString(1, newTName);
    	   				pstn.setInt(2, pId);
    	   				pstn.executeUpdate();
    	   				System.out.println("\n\t\tThe Player's Team Name Updated Succesfully");
    	   				System.out.println("\t\t-------------------------------------------\n");
    	   				break;
    	   			}
    	   			case 3:{
    	   				System.out.print("\n\t\tEnter the updated Total Matches played by the Player:");
    	   				int newMatches=sc.nextInt();
    	   				PreparedStatement psm=c.prepareStatement("update player set matches=? where player_id=?");
    	   				psm.setInt(1, newMatches);
    	   				psm.setInt(2, pId);
    	   				psm.executeUpdate();
    	   				System.out.println("\n\t\tNumber Matches Player played is updated Sucessfully");
    	   				System.out.println("\t\t---------------------------------------------------\n");
    	   				
    	   				break;
    	   			}
    	   			case 4:{
    	   				System.out.print("\n\t\tEnter the updated Run Scored by the Player:");
    	   				int newRun=sc.nextInt();
    	   				PreparedStatement psr=c.prepareStatement("update player set runs=? where player_id=?");
    	   				psr.setInt(1, newRun);
    	   				psr.setInt(2, pId);
    	   				psr.executeUpdate();
    	   				System.out.println("\n\t\tRun Scored by Player is updated Successfully");
    	   				System.out.println("\t\t--------------------------------------------\n");
    	   				break;
    	   			}
    	   			case 5:{
    	   				System.out.print("\n\t\tEnter the updated Number of wickets taken by the Player :");
    	   				int newWickets=sc.nextInt();
    	   				PreparedStatement psr=c.prepareStatement("update player set wickets=? where player_id=?");
    	   				psr.setInt(1, newWickets);
    	   				psr.setInt(2, pId);
    	   				psr.executeUpdate();
    	   				System.out.println("\n\t\tWickets taken by Player is updated Successfully");
    	   				System.out.println("\t\t-----------------------------------------------\n");
    	   				break;
    	   			}
    	   			case 6:{
    	   				System.out.print("\n\t\tEnter the updated Player's Batting Average :");
    	   				double newAvgBat=sc.nextDouble();
    	   				PreparedStatement psr=c.prepareStatement("update player set avg_batting=? where player_id=?");
    	   				psr.setDouble(1,newAvgBat);
    	   				psr.setInt(2, pId);
    	   				psr.executeUpdate();
    	   				System.out.println("\n\t\tPlayer's Average in batting  is updated Successfully");
    	   				System.out.println("\t\t----------------------------------------------------\n");
    	   				break;
    	   			}
    	   			case 7:{
    	   				System.out.print("\n\t\tEnter the updated Player's Bowling Average :");
    	   				double newAvgBow=sc.nextDouble();
    	   				PreparedStatement psr=c.prepareStatement("update player set avg_batting=? where player_id=?");
    	   				psr.setDouble(1,newAvgBow);
    	   				psr.setInt(2, pId);
    	   				psr.executeUpdate();
    	   				System.out.println("\n\t\tPlayer's Average in bowling  is updated Successfully");
    	   				System.out.println("\t\t----------------------------------------------------\n");
    	   				break;
    	   			}
			
			default:{
				System.out.println("\n\t---------------");
				System.out.println("\t Invalid option");
				System.out.println("\t---------------\n");
				break;}
			}
	} else {
		System.out.println("\t\t-----------------------------------\n");
		System.out.println("\t\tThe player Doesnot Exists to update ");
		System.out.println("\t\t-----------------------------------\n");
	}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Method to delete a player
    public  void deletePlayer(int pId) {
        // Add your code to delete player from the database
    	try {
			PreparedStatement ps=c.prepareStatement("Select*from player where player_id=?");
			ps.setInt(1, pId);
			System.out.println("\n\n\tPlayer Details:\n");			
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				System.out.println("\t\tPlayer ID :"+rs.getInt("player_id"));
				System.out.println("\t\tName :"+rs.getString("name"));
				System.out.println("\t\tTeam :"+rs.getString("team"));
				System.out.print("\n\t\tAre you sure? Wanna Delete this Player Details(non-reveserble) (Y or n) :");
				switch (sc.next().charAt(0)){
					case 'y','Y':{
						PreparedStatement pd=c.prepareStatement("delete from player where player_id=?");
						pd.setInt(1, pId);
						pd.executeUpdate();
						System.out.println("\n\t\tPlayer deleted successfully");
						break;}
					case 'n','N':{
						System.out.println("\n\t\tPlayer deletetion Process aborted!!");
						break;}
				default:{
					System.out.println("\n\t---------------");
					System.out.println("Invalid Input");
					System.out.println("\t---------------\n");
				break;}
				}
				
			} else {
				System.out.println("\n\t\t-----------------------------------");
				System.out.println("\t\t\tPlayer Does not Exist");
				System.out.println("\t\t-----------------------------------\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    // Method to view player details
    public  void viewPlayerDetails(int pId) {
        // Add your code to view player detail
    	try {
			PreparedStatement ps=c.prepareStatement("Select*from player where player_id=?");
			ps.setInt(1,pId);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				
				System.out.println("\n\t\tThe Player Details:");
				System.out.println("\t\t---------------------");
				System.out.println("\n\t\t-   Player ID :"+ rs.getInt("player_id"));
				System.out.println("\t\t-   Player's name :"+rs.getString("name"));
				System.out.println("\t\t-   Player Team's name :"+rs.getString("team"));
				System.out.println("\t\t-   Total matches Played :"+rs.getInt("matches"));
				System.out.println("\t\t-   Total Run Scored :"+rs.getInt("runs"));
				System.out.println("\t\t-   Total Wickets Taken :"+rs.getString("wickets"));
				System.out.println("\t\t-   The Batting Average :"+rs.getDouble("avg_batting"));
				System.out.println("\t\t-   The Bowling Average ::"+rs.getDouble("avg_bowling")+"\n");
				
				
			} else {
				System.out.println("\n\t\t-----------------------------------");
				System.out.println("\t\t\tPlayer doesn't exist!!");
				System.out.println("\t\t-----------------------------------\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

//    5. Compare Two Players
    public void ComparePlayers(int pId1, int pId2, int based) {
        try {
            // Check if both player IDs are the same
            if (pId1 == pId2) {
            	System.out.println("\n\t\t--------------------------------");
                System.out.println("\t\tError: Player IDs must be different.");
                System.out.println("\n\t\t--------------------------------");
                return;
            }

            // Prepare the query to check if both player IDs exist in the database
            PreparedStatement psCheck = c.prepareStatement("SELECT COUNT(*) FROM player WHERE player_id IN (?, ?)");
            psCheck.setInt(1, pId1);
            psCheck.setInt(2, pId2);
            ResultSet rsCheck = psCheck.executeQuery();
            
            if (rsCheck.next()) {
                int count = rsCheck.getInt(1);
                if (count != 2) {
                	System.out.println("\t\t---------------------------------------------------------");
                    System.out.println("\t\tError: One or both player IDs do not exist in the database.");
                    System.out.println("\t\t---------------------------------------------------------");
                    return;
                }
            }

            // Proceed to fetch player data
            PreparedStatement ps1 = c.prepareStatement("SELECT * FROM player WHERE player_id IN (?, ?)");
            ps1.setInt(1, pId1);
            ps1.setInt(2, pId2);
            ResultSet rs = ps1.executeQuery();

            // Variables to hold player stats
            int matches1 = 0, totalRuns1 = 0, battingAvg1 = 0, wickets1 = 0;
            int matches2 = 0, totalRuns2 = 0, battingAvg2 = 0, wickets2 = 0;

            // Fetch data for Player 1 and Player 2
            while (rs.next()) {
                if (rs.getInt("player_id") == pId1) {
                    matches1 = rs.getInt("matches");
                    totalRuns1 = rs.getInt("runs");
                    battingAvg1 = rs.getInt("avg_batting");
                    wickets1 = rs.getInt("wickets");
                } else if (rs.getInt("player_id") == pId2) {
                    matches2 = rs.getInt("matches");
                    totalRuns2 = rs.getInt("runs");
                    battingAvg2 = rs.getInt("avg_batting");
                    wickets2 = rs.getInt("wickets");
                }
            }

            // Compare based on batting or bowling
            if (based == 1) { // Batting Comparison
                System.out.println("\n\tTwo Player's are compared by their batting:");

                // Compare Batting Average
                if (battingAvg1 > battingAvg2) {
                    System.out.println("\n\t\tPlayer 1 \n\t\t\t-has a higher batting average (Player 1 Avg[" + battingAvg1 + "] vs Player 2 Avg[" + battingAvg2 + "])");
                } else if (battingAvg1 < battingAvg2) {
                    System.out.println("\n\t\tPlayer 2 \n\t\t\t-has a higher batting average (Player 2 " + battingAvg2 + " vs Player 1 " + battingAvg1 + ")");
                } else {
                    System.out.println("\n\t\tBoth players have the same batting average (" + battingAvg1 + ")");
                }

                // Compare Runs per Match (optional for more detail)
                double runsPerMatch1 = (double) totalRuns1 / matches1;
                double runsPerMatch2 = (double) totalRuns2 / matches2;
                if (runsPerMatch1 > runsPerMatch2) {
                	System.out.println(String.format("\n\t\tPlayer 1 \n\t\t\t-scores more runs per match (Player 1 [%.2f] vs Player 2 [%.2f])", runsPerMatch1, runsPerMatch2));

                } else if (runsPerMatch1 < runsPerMatch2) {
                    System.out.println(String.format("\n\t\tPlayer 2 \n\t\t\t-scores more runs per match (Player [1 %.2f] vs Player 2 [%.2f])", runsPerMatch2, runsPerMatch1));
                } else {
                    System.out.println("\n\t\tBoth players score the same runs per match (" + runsPerMatch1 + ")");
                }

            } else { // Bowling Comparison
                System.out.println("\n\tTwo Player's are compared by their bowling:");

                // Compare Wickets Taken
                if (wickets1 > wickets2) {
                	System.out.println(String.format("\n\t\tPlayer 1 has taken more wickets (%d vs %d)", wickets1, wickets2));

                } else if (wickets1 < wickets2) {
                    System.out.println(String.format("\n\t\tPlayer 2 has taken more wickets (%d vs %d)", wickets2, wickets1));
                } else {
                    System.out.println("\n\t\tBoth players have taken the same number of wickets (" + wickets1 + ")");
                }

                // You could also add a comparison for bowling average if you have total runs conceded
                // For now, assume you only compare the wickets taken for simplicity.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
