package com.gauri.test;

import com.gauri.models.Player;
import com.gauri.utils.PlayerUtils;

public class PlayerManagmentSystem {

	public static void main(String[] args) {
		int choice = 0;
		while(choice!=7)
		{
			System.out.println("==========================================");
			System.out.println("Player Managment System Menu::");
			System.out.println("1.Add Player");
			System.out.println("2.remove Player");
			System.out.println("3.Search Player");
			System.out.println("4.Update Player");
			System.out.println("5.Display sorted Player");
			System.out.println("6.Display All Player");
			System.out.println("7.Exit");
			System.out.println("==========================================");
			
			choice=PlayerUtils.getUserChoice();
			switch (choice) {
			case 1:
				Player newPlayer=PlayerUtils.createPlayer();
				PlayerUtils.addPlayer(newPlayer);
				break;
			case 2:
				PlayerUtils.removePlayer();
				break;
			case 3:
				PlayerUtils.searchPlayer();
				break;
			case 4:
				PlayerUtils.updatePlayer();
				break;
			case 5:
				PlayerUtils.displaySortedPlayer();
				break;
			case 6:
				PlayerUtils.displayAllPlayer();
				break;
			case 7:
				System.out.println("Thank You!");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}
}
