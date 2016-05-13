package email;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @Timo Jarmala
 */
public class SahkoPosti {
	

	public void lahetaSahkoposti(String lahettajanGoogleEmail, String lahettajanGoogleSalasana, String vastaanottajanEmail, String otsikko, String emailinSisalto ) {
		// Asetetaan Stringeihin l�hett�j�n kredentiaalit
		String from = lahettajanGoogleEmail;
		String pass = lahettajanGoogleSalasana;
		// S�hk�postipalvelin
		String host = "smtp.gmail.com";

		// Haetaan j�rjestelm�n ominaisuudet
		Properties properties = System.getProperties();
		// Asetetaan s�hk�postipalvelin
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Haetaan oletus session olio
		Session session = Session.getDefaultInstance(properties);

		try {
			// Luo oletus MimeMessage olio
			MimeMessage message = new MimeMessage(session);

			// Viestin l�hett�j�n asettaminen (t�ytyy olla gmail-osoite)
			message.setFrom(new InternetAddress(from));

			// Viestin vastaanottajan asettaminen
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					vastaanottajanEmail));

			// Viestin otsikko eli subject
			message.setSubject(otsikko);

			// Asetetaan itse viestin sis�lt�
			message.setText(emailinSisalto);

			// L�hetet��n viesti
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}	
	

}
