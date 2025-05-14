
package com.election.service.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.election.dao.DbConnection;
import com.election.service.Election;

public class ElectionImple implements Election
{
	int id;
	String pass;
	Scanner s1 = new Scanner(System.in);

	@Override
	public void election() throws SQLException
	{
		try 
		{
			System.out.println(" ");
			System.out.println("!.....Welcome To The Election Both.....!");
			System.out.println(" ");
			System.out.print("Enter Voter Id : ");
			id = s1.nextInt();
			System.out.print("Enter Voter Password :");
			pass = s1.next();

			Statement stat = DbConnection.dbms().createStatement();
			ResultSet rSet = stat.executeQuery("select * from Voter1");

			while(rSet.next())
			{
				if (rSet.next()) 
				{
					System.out.println(" ");
					System.out.println("!.....Validation Successfull.....!");
					System.out.println("-------------------------------------");
					System.out.println(" ");
					System.out.println("!.....Avaialable Candidate Nominees.....!");

					ResultSet canSet = stat.executeQuery("select Id , Name from Candidate1");

					while(canSet.next())
					{
						System.out.println(" ");
						System.out.println("Candidate Id : "+canSet.getInt("Id"));
						System.out.println("Candidate Name : "+canSet.getString("Name"));
						System.out.println(" ");
					}
					
					try 
					{
						System.out.println("-------------------------------------");
						System.out.println(" ");
						System.out.println("!.....Select Candidate For Vote.....!");
						System.out.println(" ");
						System.out.print("Enter Candidate Id : ");
						int c_id = s1.nextInt();
						
						System.out.println(" ");
						System.out.println("!.....Thank You For Voting.....!");
						System.out.println("-------------------------------------");

						PreparedStatement cStat , vStat;

						cStat = DbConnection.dbms().prepareStatement("update Candidate1 set Votes = votes+1 where Id = ?");
						cStat.setInt(1, c_id);
						cStat.executeUpdate();

						vStat = DbConnection.dbms().prepareStatement("update Voter1 set Status = 1 where Id = ?");
						vStat.setInt(1, id);
						vStat.executeUpdate();
					} 

					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
				}
			}

		} 

		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

		finally 
		{
			DbConnection.dbms().close();
		}
	}

}
