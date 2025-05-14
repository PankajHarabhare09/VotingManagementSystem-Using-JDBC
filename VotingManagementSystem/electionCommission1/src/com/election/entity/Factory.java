package com.election.entity;

import java.sql.SQLException;

import com.election.service.implementation.CandidateImple;
import com.election.service.implementation.ElectionImple;
import com.election.service.implementation.ResultImple;
import com.election.service.implementation.VoterImple;

public class Factory 
{
	public void voter() throws SQLException
	{
		VoterImple v1 = new VoterImple();
		v1.addVoterDetails();
	}
	
	public void candidate() throws SQLException
	{
		CandidateImple c1 = new CandidateImple();
		c1.addcandidateDetails();
	}
	
	public void election() throws SQLException
	{
		ElectionImple e1 = new ElectionImple();
		e1.election();
	}
	
	public void result() throws SQLException
	{
		ResultImple r1 = new ResultImple();
		r1.resultDay();
	}
}
