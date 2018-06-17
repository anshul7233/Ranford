package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Library {

	public static void screenshot(String screenshotname) {

		try {
			Robot r = new Robot();

			// Taking screenshots of alert pop-ups and the failed scripts and
			// storing it
			// into the temporary place
			// called BufferedImage (bi)

			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

			// Moving the screenshots from source to destination of png format

			ImageIO.write(bi, "png", new File(".\\screenshots\\" + screenshotname + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void attachment(String screenshotname) {

		screenshot(screenshotname);
		
		EmailAttachment email = new EmailAttachment();
		email.setPath(".\\screenshots\\" + screenshotname + ".png");
		email.setDisposition(EmailAttachment.ATTACHMENT);
		email.setDescription("Failed screenshot of branch creation");
		email.setName("screenshot");

		MultiPartEmail memail = new MultiPartEmail();
		

		try {
			memail.setAuthenticator(new DefaultAuthenticator("anshulkgupta7233@gmail.com", "Orange@123"));
			memail.setHostName("smtp.gmail.com");
			memail.setSmtpPort(465);
			memail.setSSLOnConnect(true);
			memail.setFrom("anshulkgupta7233@gmail.com");
			memail.setSubject(screenshotname);
			memail.setMsg("attachment of failure case");
			memail.addTo("anshulkgupta7233@gmail.com");
			memail.attach(email);
			memail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

}
