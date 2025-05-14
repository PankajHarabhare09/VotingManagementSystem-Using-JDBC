package com.election.service.implementation;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.election.dao.DbConnection;
import com.election.service.Candidate;

public class CandidateImple implements Candidate
{

	private int id;
	private String name;
	private String city;
	private int votes;
	Scanner s1 = new Scanner(System.in);

	@Override
	public void addcandidateDetails() throws SQLException 
	{
		try 
		{
			System.out.println("!.....Add Candidate Details.....!");
			
			System.out.print("Enter Candidate Id : ");
			id = s1.nextInt();
			System.out.print("Enter Candidate Name : ");
			name = s1.next();
			System.out.print("Enter Candidate City : ");
			city = s1.next();
			
			System.out.println("!.....Thank You.....!");

			Statement stat = DbConnection.dbms().createStatement();
			stat.execute("insert into Candidate1 (Id , Name , City , Votes) values ('"+id+"' , '"+name+"' , '"+city+"' , '"+0+"') ");

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
