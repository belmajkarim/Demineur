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
		int rep ;
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
		
		
		if(game.fini() == true && game.gagner() == true)
		      {   
		        System.out.println("t as gangné");
		        game.afficheGrill();
		        
		      }
			if(game.fini() == true)
		      {                       
		        game.afficheGrill();
		        
		      }
			if(game.fini() == false)
		      {                      
		    	  x = -1;
		    	  y = -1;
		    	 
		    while(true) {	 
		   
		    
		    	  System.out.println("saisissez 1 pour mettre un drapeau, 2 pour decouvrir la case ");
		    	  
		    	  rep = saisir.nextInt();
		    	  		
		    	  if(rep == 1) 
		    	  	{
		    	  		System.out.println("Entrez X");
			    	  	x = saisir.nextInt();
			    	  	System.out.println("Entrez Y");
			    	  	y = saisir.nextInt();
		    	  		game.placerflag(x, y);
		    	  		game.jouer(x,y);
		    	  		game.gagne();
			    	  	game.actualiser();
		    	  		}
		    	  else if (rep == 2) {
		    		  	System.out.println("Entrez X");
			    	  	x = saisir.nextInt();
			    	  	System.out.println("Entrez Y");
			    	  	y = saisir.nextInt();
		    	  		game.jouer(x,y);
		    	  		game.gagne();
			    	  	game.affichecellulev();
			    	  	game.actualiser();
		    	  }
		      }
			
		      
		    }   
		  }
}
	

	

