package demineurkk;

import java.util.Scanner;

public class jouer 
{
	public static void tester() {
		jeu game = new jeu();
		game.placermines(25);
		game.actualiser();
		Scanner saisir = new Scanner(System.in);
		int x, y;
		System.out.println("Entrez X");
		x = saisir.nextInt();
		System.out.println("Entrez Y");
		y = saisir.nextInt();
		
		if(game.getcellule(x,y).equals(" * ") == true)
		{
			game.placermines(1);
			game.table[x][y] = " ? ";
		}
		game.propag(x, y);
		game.affichecellulev();
		game.actualiser();
		
		while(true){
		      if(game.fini() == true && game.gagner() == true){    //If the player wins.
		        System.out.println("t as gangné");
		        game.afficheGrill();
		        break;
		      }else if(game.fini() == true){                       //If the player loses.
		        game.afficheGrill();
		        break;
		      }else if(game.fini() == false){                      //While the player hasn't lost or won.
		        x = -1;
		        y = -1;     //Resets values.
		        System.out.println("Entrez X");
		        y = saisir.nextInt();
		        System.out.println("Entrez Y");
		        x = saisir.nextInt();
		        game.jouer(x,y);
		        game.gagne();
		        game.affichecellulev();
		        game.actualiser();
		      }
		      
		    }   
		  }
	
	

	
}
