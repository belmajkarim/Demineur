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
	private int n;
	private int casevidee;
	
	public jeu()
	{
		int x = 0;
		int y = 0;
		
		for ( x = 0; x < 12; x++) {
			for(y = 0; y < 12 ; y++) 
			{
				 
					table[x][y] = inco;
					grille[x][y] = inco;
				
			}
		}
	}

	
	public static void afficheJeu(String[][] str) 
	{
		for (int x = 0; x < 12; x++) 
		{
			for(int y = 0; y < 12; y++)
			{
			
				if( y > 0  && y < 12) 
				
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
	public String getcellule(int x, int y) 
	{
		return table[x][y];
	}
	
	public void affichecellulev() 
	{
		n = 0;
			for(int x = 1 ; x <= 12; x++)
			{
				for(int y = 1 ; y <= 12; y++) 
					{
						if(table[x][y].equals(vide)==true) 
						{
							n = 0;
							for(int i = (x - 1); i <= (x + 1); i++)
							{
					            for(int j = (y - 1); j <= (y + 1); j++)
					            {
					            	if(table[i][j].equals(mine) == true)
					            		n++;
					            }
							}
							grille[x][y]="" + n + "";
						}	
					}
			}
	}
	public void jouer(int x, int y) {
		if(table[x][y].equals(inco) == true)
		{           
		      fini = false;
		      grille[x][y] = vide;
		      table[x][y] = vide;
		}else if (table[x][y].equals(mine)==true) {
			fini = true;
			gagne = false;
			System.out.println("t as perdu !!! :(");
		}else if (table[x][y].equals(vide) && grille[x][y].equals(vide)) {
			fini = false;
			System.out.println("cette case est vide");
		}
	}
	
	public void gagne() {
		casevidee = 0;
	    for(int i = 0; i < 12; i++)
	    {
	    	for(int j = 0; j < 12; j++)
	    	{
		        if(table[i][j].equals(inco) == true)
		        	casevidee++;                  
	    	}
	    }
	     if (casevidee != 0) 
	     {
	    	 gagne = false;
	     }else
	     { 
	    		 gagne = true;
	    		 fini = true;
	    }
	    	 
	     }
	
	public Boolean fini(){
	    return fini;
	  }
	  
	  
	  public Boolean gagner(){
	    return gagne;
	  }
	  
	 
}
	
	
	
	

