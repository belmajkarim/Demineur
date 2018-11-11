package demineurkk;
public class jeu {
	public String[][] table = new String[12][12];
	public String[][] grille = new String[12][12];
	public boolean fini = false;
	public boolean gagne = false;
	
	
	private String inco = "?";
	private String mine = "*";
	private String vide = " ";
	public String flag = "$";
	
	
	
	
	
	public jeu()
	{
		
		int x = 0;
		int y = 0;
		
		
		for ( x = 0; x < table.length; x++) {
			for(y = 0; y < table[0].length; y++) 
			{
				 	if ((x == 0 || x == table.length -1)||(y == 0 || y == table[0].length -1)) {
					table[x][y] = vide;
					grille[x][y] = vide;
				 	}else {
						table[x][y] = inco;
						grille[x][y] = inco;
					}
			}
			
		}
	}

	
	public static void afficheJeu(String[][] str) 
	{
		for (int x = 1; x < str.length -1 ; x++) 
		{
			for(int y = 0; y < str[0].length; y++)
			{
			
				if( y > 0  && y < str[0].length) 
				
					System.out.print("|");
				else 
					System.out.println("");
				System.out.print(str[x][y]);		
			}
			
		}
	}
	public void actualiser()
	{
		afficheJeu(grille);
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
			
			 if(x >= 1 && x <= 10){
		          if(y >= 1 && y <= 10)
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
		
		for(int x = 1; x < grille.length - 2; x++)
		{     
		      for(int y = 1; y < grille.length - 2; y++)
		      {
		        if(table[x][y].equals(vide) == true)
		        {
		          int nums = 0;                              
		          for(int i = (x - 1); i <= (x + 1); i++)
		          {
		            for(int j = (y - 1); j <= (y + 1); j++)
		            {
		              if(table[i][j].equals(mine) == true)
		                nums++;                              
		            }
		          }
		          grille[x][y] = " " + nums + " ";
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
		}else if (table[x][y].equals(flag) && grille[x][y].equals(flag) ) {
			fini = false;
			System.out.println("cette case est marqué");
		}
	}
	
	public void gagne() 
	{
		int casevidee = 0;
	    for(int i = 0; i < table.length; i++)
	    {
	    	for(int j = 0; j < table[0].length; j++)
	    	{
		        if(table[i][j].equals(inco) == true)
		        	casevidee++;                  
	    	}
	    }
	     if (casevidee != 0) 
	     
	    	 gagne = false;
	     else
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
	  public void propag(int x, int y) 
	  {
		  for(int i = (x - 1); i <= (x + 1); i++)
			{
	            for(int j = (y - 1); j <= (y + 1); j++)
	            {
	            	if(table[i][j].equals(inco) == true)
	            		table[i][j] = vide;
	            		grille[i][j]=vide;
	            		
	            }

			}
	  }
	  public void afficheGrill()
	  {
		  afficheJeu(table);
	  }


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void placerflag(int x, int y) 
	{
		grille[x][y] = " $ ";
	    table[x][y] = " $ " ;
	}
	 
}
