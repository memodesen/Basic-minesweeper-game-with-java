package githubb;

import java.io.Serializable;

public class Playerr2 implements Serializable {
	public int score = 0;
	public int positionx = 1;
	public int positiony = 1;
	public boolean dead = false;
	
	
	public void move( String direction ) {
		if (direction.equals("left")) {
			positionx--;
			
		}
		else if (direction.equals("right")) {
			positionx = positionx +1;
		
		}
        else if (direction.equals("up")) {
			positiony = positiony -1 ;
			
		}
        else if (direction.equals("down")) {
        	positiony = positiony +1;
        	
        	
		}
		
		
		
		}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return score + " " + positionx + " " + positiony + " " + dead + " .";
	}
	
	
	
}

