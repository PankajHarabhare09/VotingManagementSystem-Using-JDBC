package com.election.service.implementation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.election.dao.DbConnection;
import com.election.service.Voter;

public class VoterImple implements Voter
{
	private int id;
	private String name;
	private String city;
	private int status;
	private String pass;
	Scanner s1 = new Scanner(System.in);

	@Override
	public void addVoterDetails() throws SQLException
	{
		try 
		{
			System.out.println("!.....Add Voter Details....!");
			
			System.out.print("Enter Voter id : ");
			id = s1.nextInt();
			System.out.print("Enter Voter Name : ");
			name = s1.next();
			System.out.print("Enter Voter City : ");
			city = s1.next();
			System.out.print("Enter Voter Password : ");
			pass = s1.next();
			
			System.out.println("!.....Thank You.....!");

			Statement stat = DbConnection.dbms().createStatement();
			stat.execute("insert into Voter1(Id , Name , City , Status , Password) values ('"+id+"' , '"+name+"' , '"+city+"' , '"+0+"' , '"+pass+"')");
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
