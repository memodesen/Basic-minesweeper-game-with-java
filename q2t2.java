package githubb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class q2t2 {
public static void main (String []args) throws ClassNotFoundException {
	Scanner scanner = new Scanner( System.in );
	Playerr2 player = new Playerr2();
	System.out.println("You have a game that is saved. Do you want to load?");
	String kaydet = scanner.nextLine();
	ObjectInputStream oku;
	if (kaydet.contains("yes")) {
		
		try {
			oku = new ObjectInputStream(new FileInputStream ("kaydetmee.bin"));
			Playerr2 playerr = (Playerr2)oku.readObject();
			System.out.println(playerr.score);
			System.out.println(playerr.dead);
			System.out.println(playerr.positionx);
			System.out.println(playerr.positiony);
			player.dead=playerr.dead;
			player.score=playerr.score;
			player.positionx=playerr.positionx;
			player.positiony=playerr.positiony;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		//okumaþeysi.okumaa(playerr);
		
		
		
	}
	else  {
		
		System.out.println("Starting from beginning.");
	}
	
	
		
			

	
		
		
		
		
	
	/*else if (kaydet.contains("hayýr")) {
		System.out.println("Sýfýr oyundan baþlanýyor.");
	}*/
	
			
			
	
	
	System.out.println( "Which direction to move? You can say right,left,up,down. If you want, you can type quit." );
	
	while( !player.dead ) {
	
		String seçim = scanner.nextLine();
		if (seçim.equalsIgnoreCase("quit")) {
			break;
		}
		 player.move(seçim);
		 if (player.positionx==2 && player.positiony==2 || player.positionx==4 && player.positiony==3 || player.positionx==1 && player.positiony==5) {
			 player.score= player.score +100;
			 System.out.println("You found a star!");
		 }
		 if (player.positionx==0 || player.positionx ==6 || player.positiony==0 || player.positiony==6) {
			 System.out.println("You died");
			 return;
		 }
		 if (player.positionx==2 &&  player.positiony==3 || player.positionx==5 && player.positiony==4 || player.positionx==2 && player.positiony==5) {
			 System.out.println("You stepped on  a bomb!");
			 System.out.println("You died");
		 }
		 System.out.println("You are on [" + player.positionx + "," + player.positiony + "]");
		 if (player.positionx==5 && player.positiony==5) {
			 System.out.println("You finished the game with " + player.score + " points");
		 }
		 
	}
	
		 
		 
		 System.out.println("Do you want to save this game? You can write yes or no. ");
		 String seçim2 = scanner.nextLine();
		 if (seçim2.equalsIgnoreCase("yes")) {
			 try {
				ObjectOutputStream yaz = new ObjectOutputStream(new FileOutputStream("kaydetmee.bin"));
				yaz.writeObject(player);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else if (seçim2.equalsIgnoreCase("no")) {
			 System.out.println("Exiting the game. ");
		 }
		 
		
		
		
		
		

	
}
}
