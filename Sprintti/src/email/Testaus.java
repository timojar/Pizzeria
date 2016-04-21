package email;

public class Testaus {

public static void main (String [] args) {
	
SahkoPosti email=new SahkoPosti();

String lahettajanGoogleEmail= "hepuli88432@gmail.com";

String lahettajanGoogleSalasana="Huippuhemmo";

String vastaanottajanEmail="jepulisjee88@outlook.com";

String otsikko="Moro";

String emailinSisalto="Tämä on vaan testi";
  email.lahetaSahkoposti(lahettajanGoogleEmail, lahettajanGoogleSalasana, vastaanottajanEmail, 
		otsikko, emailinSisalto);
	
	
	
	
	
}
	
	
}
