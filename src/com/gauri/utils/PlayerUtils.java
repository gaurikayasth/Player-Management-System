package com.gauri.utils;

import java.util.Arrays;
import java.util.Scanner;

import com.gauri.models.Player;

public class PlayerUtils {
	//initial phase of player array=size 0
	private static Player[] parr=new Player[0];
	private static Scanner sc=new Scanner(System.in);
	public static Player createPlayer()
	{
		System.out.println("Enter the player id=");
		int playerId=sc.nextInt();
		System.out.println("Enter the player name=");
		sc.nextLine();
		String playerName=sc.nextLine();
		System.out.println("Enter the player team=");
		String team=sc.nextLine();
		System.out.println("Enter the player jersey number=");
		String jerseyNum=sc.nextLine();
		System.out.println("Enter the player runs=");
		int runs=sc.nextInt();
		System.out.println("Enter the player wickets=");
		int wickets=sc.nextInt();
		System.out.println("Enter the player match played=");
		int matchPlayed=sc.nextInt();
		
		Player p=new Player(playerId,playerName,team,jerseyNum,runs,wickets,matchPlayed);
		System.out.println("New player with name:"+playerName+" has been created successfully");
		return p;
	}
	public static void addPlayer(Player newPlayer)
	{
		parr=Arrays.copyOf(parr,parr.length+1);
//		parr[0]=newPlayer;
		parr[parr.length-1]=newPlayer;
		System.out.println("player added successfully!");
	}
	public static void display(Player p)
	{
		System.out.println("*******************************************");
		System.out.println("PLAYER ID:"+p.getPlayerId());
		System.out.println("PLAYER NAME:"+p.getPlayerName());
		System.out.println("PLAYER TEAM:"+p.getTeam());
		System.out.println("PLAYER JERSEYNUMBER:"+p.getJerseyNum());
		System.out.println("PLAYER RUNS:"+p.getRuns());
		System.out.println("PLAYER WICKETS:"+p.getWickets());
		System.out.println("PLAYER MATCHPLAYED:"+p.getMatchPlayed());
		System.out.println("*******************************************");
	}
	
	
	public static int getUserChoice() {
		System.out.println("Enter your choice:");
		return sc.nextInt();
	}
	public static void searchPlayer() {
		System.out.println("1.Search by Jersey Number");
		System.out.println("2.Search by Player Name");
		int searchChoice=getUserChoice();
		
		switch(searchChoice) {
		case 1:
			System.out.println("Enter Jersey Number to Search");
			sc.nextLine();//consume new line
			String Jerseynum=sc.nextLine();
			searchAndDisplayPlayer(parr,Jerseynum);
			break;
		case 2:
			System.out.println("Enter Player Name to Search");
			sc.nextLine();//consume new line
			String name=sc.nextLine();
			searchAndDisplayPlayer(parr,name);
			break;
		default:
			System.out.println("Invalid Choice!");
			break;
		}
	}

	private static int searchAndDisplayPlayer(Player[] parr,String searchKey) {
		for(int i=0;i<parr.length;i++)
		{
			if(parr[i].getJerseyNum().equals(searchKey) || parr[i].getPlayerName().equals(searchKey)) {
				display(parr[i]);
				return i;
			}
		}
		System.out.println("Player not found");
		return -1;
	}

	public static void displayAllPlayer() {
		if(parr.length==0)
		{
			System.out.println("no player in the system");
			return;
		}
		for(int i=0;i<parr.length;i++)
		{
			display(parr[i]);
		}
	}

	public static void displaySortedPlayer() {
		System.out.println("1.sorting based on minimum runs");
		System.out.println("2.sorting based on maximum runs");
		System.out.println("3.sorting based on minimum wickets");
		System.out.println("4.sorting based on maximum wickets");
		
		int sortChoice=getUserChoice();
	    switch (sortChoice) {
		case 1:
			sortByRunsAsc(parr);
			break;
		case 2:
			sortByRunsDesc(parr);
			break;
		case 3:
			sortByWicketAsc(parr);
			break;
		case 4:
			sortByWicketDesc(parr);
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
	    System.out.println("Sorted Players");
	    displayAllPlayer();
	}

	private static void sortByWicketDesc(Player[] parr) {
		for(int i=0;i<parr.length-1;i++)
		{
			for(int j=i+1;j<parr.length;j++)
			{
				if(parr[i].getWickets()<parr[j].getWickets())
				{
					Player temp=parr[i];
					parr[i]=parr[j];
					parr[j]=temp;
				}
			}
		}
	}

	private static void sortByWicketAsc(Player[] parr) {
		for(int i=0;i<parr.length-1;i++)
		{
			for(int j=i+1;j<parr.length;j++)
			{
				if(parr[i].getWickets()>parr[j].getWickets())
				{
					Player temp=parr[i];
					parr[i]=parr[j];
					parr[j]=temp;
				}
			}
		}
	}

	private static void sortByRunsDesc(Player[] parr) {
		for(int i=0;i<parr.length-1;i++)
		{
			for(int j=i+1;j<parr.length;j++)
			{
				if(parr[i].getRuns()<parr[j].getRuns())
				{
					Player temp=parr[i];
					parr[i]=parr[j];
					parr[j]=temp;
				}
			}
		}
	}

	private static void sortByRunsAsc(Player[] parr) {
		for(int i=0;i<parr.length-1;i++)
		{
			for(int j=i+1;j<parr.length;j++)
			{
				if(parr[i].getRuns()>parr[j].getRuns())
				{
					Player temp=parr[i];
					parr[i]=parr[j];
					parr[j]=temp;
				}
			}
		}
	}

	public static void removePlayer() {
		System.out.println("Enter Player jersey number to remove");
		sc.nextLine();//consume new line
		String Jerseynum=sc.nextLine();
		int index=searchAndDisplayPlayer(parr,Jerseynum);
		if(index==-1)
		{
			System.out.println("\nPlayer to be deleted not present OR Array is empty.");
			return;
		}
		else
		{
			while(index<parr.length-1)
			{
				parr[index]=parr[index+1];
				index++;
			}
			parr=Arrays.copyOf(parr,parr.length-1);
			System.out.println("Player removed successfully!");
			return;
		}
	}

	public static void updatePlayer() {
		System.out.println("Enter Player jersey number to update");
		sc.nextLine();//consume new line
		String Jerseynum=sc.nextLine();
		int index=searchAndDisplayPlayer(parr,Jerseynum);
		if(index==-1)
		{
//			System.out.println("\nPlayer to be updated not present OR Array is empty.");
			return;
		}
		else
		{
			System.out.println("\nenter what you want to update:\n1:runs\n2:wickets\n3:matches played\n");
			int updateChoice=getUserChoice();
			if(updateChoice==1)
			{
				System.out.println("enter updated runs of player=");
				int runs=sc.nextInt();
				parr[index].setRuns(runs);
				System.out.println("Player updated successfully!");
				return;
			}
			else if(updateChoice==2)
			{
				System.out.println("enter updated wickets of player=");
				int wickets=sc.nextInt();
				parr[index].setWickets(wickets);
				System.out.println("Player updated successfully!");
				return;
			}
			else if(updateChoice==3)
			{
				System.out.println("enter updated matches played of player=");
				int matches=sc.nextInt();
				parr[index].setMatchPlayed(matches);
				System.out.println("Player updated successfully!");
				return;
			}
			else
			{
				System.out.println("\nInvalid choice");
			}
//			return;
		}
	}
	public static void scannerClosed()
	{
		sc.close();
	}
}
