
 package com.election.test;

import java.util.Scanner;

import com.election.entity.Factory;

public class Choice
{
	public static void main(String[] args) 
	{
		while(true)
		{
			try 
			{
				Factory f1 = new Factory();
				Scanner s1 = new Scanner(System.in);
				System.out.println("-------------------------------------");
				System.out.println("1.Add Candiate Details");
				System.out.println("2.Add Voter Details");
				System.out.println("3.Voting");
				System.out.println("4.Result of the Election");
				System.out.print("Enter Your Choice : ");
				int x = s1.nextInt();
				System.out.println("-------------------------------------");

				switch(x)
				{
				case 1:
				{
					f1.candidate();
					break;
				}
				case 2:
				{
					f1.voter();
					break;
				}
				case 3:
				{
					f1.election();
					break;
				}
				case 4:
				{
					f1.result();
					break;
				}
				default:
					System.out.println("!.....Please Enter Valid Input.....!");
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}

		}
	}
}
