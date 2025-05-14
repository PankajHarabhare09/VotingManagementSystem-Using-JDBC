package com.election.service.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.election.dao.DbConnection;
import com.election.service.Result;

public class ResultImple implements Result
{
	@Override
	public void resultDay() throws SQLException 
	{
		try
		{
			Statement stat = DbConnection.dbms().createStatement();
			ResultSet r1 = stat.executeQuery("select Id , Name , City , Votes from Candidate1 order by Votes desc");

			ResultSet r = stat.executeQuery("SELECT ID, Name, City , Votes FROM Candidate1 ORDER BY Votes DESC");
			while(r.next())
			{
			System.out.println("Candidate ID: "+r.getInt("ID") +"   " + "Candidate Name: "+r.getString("Name") + " " +r.getString("City")+ " " + "Candidate Votes: "+r.getInt("Votes") );	
			System.out.println(" ");	
			}
			r = stat.executeQuery("SELECT ID, Name, City , Votes FROM Candidate1 ORDER BY Votes DESC");
			r.next();
			System.out.println("******************** WINNER ********************");
			System.out.println();
			System.out.println("Candidate ID: "+r.getInt("ID") +"---" + "Candidate Name: "+r.getString("Name") + "---" +r.getString("City") + "---" + "Candidate Votes: "+r.getInt("Votes"));
			System.out.println();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}


}
