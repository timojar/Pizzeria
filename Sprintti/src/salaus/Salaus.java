package salaus;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;


public class Salaus {

	// ERILAISIA VAIHTOEHTOJA SALAUSALGORITMIKSI
	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA-1";
	public static final String SHA256 = "SHA-256";
	public static final String SHA384 = "SHA-384";
	public static final String SHA512 = "SHA-512";

	/**
	 * Salaa tekstin jollain salausalgoritmilla ja suolalla n kertaa.
	 * 
	 * @param salattavaTeksti tekstinpätkä (esim. salasana), joka halutaan salata (UTF-8)
	 * @param suola teksti (UTF-8), jolla salausalgoritmia muutetaan uniikiksi
	 * @param salausalgoritmi Jokin tarjolla olevista salausalgoritmeista, kuten SHA-512. Kts. Salaaja.SHA512
	 * @param montakoKertaa Montako kertaa salausalgoritmi pyöräytetään ympäri
	 * @return salatun salasanan base64-enkoodattuna Stringinä. 
	 * @throws NoSuchAlgorithmException Mikäli valittua salausalgoritmia ei löydy
	 * @throws UnsupportedEncodingException Mikäli suolaa tai salattavaa tekstiä ei pystytä kääntämän UTF-8:sta bittijonoksi.
	 */
	public String salaa(String salattavaTeksti, String suola,
			 int montakoKertaa)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
String salausalgoritmi=MD5;
		MessageDigest md = MessageDigest.getInstance(salausalgoritmi);
		md.reset();
		md.update(suola.getBytes("UTF-8"));
		byte[] input = md.digest(salattavaTeksti.getBytes("UTF-8"));
		for (int i = 0; i < montakoKertaa; i++) {
			md.reset();
			input = md.digest(input);
		}
		String salattuTeksti = DatatypeConverter.printBase64Binary(input);
		return salattuTeksti;
	}
	

	/**
	 * Generoi SHA1PRNG-algoritmilla kahdeksan tavun mittaisen suolan, joka
	 * enkoodataan base64-algoritmilla
	 * 
	 * @return generoidun suolan, jonka pituus on 8 merkkiä
	 * @throws NoSuchAlgorithmException Mikäli SHA1PRNG-algoritmi ei ole käytettävissä
	 */
	public  String generoiSuola() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] suolaBin = new byte[8];
		random.nextBytes(suolaBin);
		String suolaStr = DatatypeConverter.printBase64Binary(suolaBin);

		return suolaStr;
	}
}
