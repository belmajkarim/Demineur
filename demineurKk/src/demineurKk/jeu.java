package demineurKk;

import java.util.Random;

public class jeu {
	
	public String[][] table = new String[12][12];
	public String[][] grille = new String[12][12];
	public boolean fini = false;
	public boolean gagne = false;
	
	
	public String inco = "?";
	public String mine = "*";
	public String vide = "";
	
	Random rand = new Random();
	
	public jeu()
	{
		int x = 0;
		int y = 0;
		
		for ( x = 0; x < 12; x++) {
			for(y = 0; y < 12 ; y++) 
			{
				if((x == 0 || x == 11 )||(x == 0 || x == 11)) {
					table[x][y] = vide;
					grille[x][y] = vide;
				}
				else 
				{
					table[x][y] = inco;
					grille[x][y] = inco;
				}
			}
		}
	}

	
	public static void afficheJeu(String[][] str) 
	{
		for (int x = 0; x < str.length; x++) 
		{
			for(int y = 0; y < str[0].length; y++)
			{
			
				if( y > 0  && y < str[0].length) 
				
					System.out.println("|");
				else 
					System.out.println("");
				System.out.println(str[x][y]);		
			}
			
		}
	}
	public void actualiser()
	{
		afficheJeu(table);
		System.out.println("");
	}
	public void placermines(int nbm) 
	{
		for(int m=0 ; m <= nbm; m++)
		{
			while(true) 
			{
			int x, y = 0;
			x = (int)(10*Math.random());
			y = (int)(10*Math.random());
			
			 if(x >= 1 && x <= 12){
		          if(y >= 1 && y <= 12)
		          {
		        	  if(!table[x][y].equals(mine)) {
		        		  table[x][y] = mine;  
		        	  break;		        	  
		        	  }        
		          }			
			   }
			}
		}
	}
}
