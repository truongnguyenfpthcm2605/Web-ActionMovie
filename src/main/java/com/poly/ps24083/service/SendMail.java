package com.poly.ps24083.service;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class SendMail {
	public static void sendmail(String link, String emailClident) {
		try {
			String username = "truongnguenlqm@gmail.com";
			String pass = "jsopvjrpqrfacjny";

			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, pass);
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailClident));
//			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(infor.getCc()));
//			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(infor.getBcc()));

			message.setSubject("Nội Dung Chia Sẻ Từ Action Movie");
			message.setText("https://youtu.be/"+link);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
