package salaus;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.Pizza;

public class test {
	
	
	public static void main (String [] args)	{
		  
		
		Hash hash= new Hash();
		Salt salting= new Salt();
		
		String input="sana"+salting.generateSalt();
		String suojattu=hash.getmd5(input);
			

		System.out.println(suojattu);
	
		

	
		}
			
	

}
