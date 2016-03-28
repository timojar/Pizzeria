package salaus;

import java.security.SecureRandom;
import java.util.Random;

public class Salt {

public static void main (String[] args){

	Random r= new SecureRandom();	
	
	byte[] salt=new byte[32];
	r.nextBytes(salt);
	


	
	
}	
	

}
