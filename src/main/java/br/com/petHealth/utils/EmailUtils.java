package br.com.petHealth.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	
	public static void enviarHotmail(String emailDestino, String nome, String senha){
		
		 try {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        
        Properties propertiesFile = new Properties();
		FileInputStream file = new FileInputStream("C:/Pet/pet.properties");
		propertiesFile.load(file);
		String loginRem = propertiesFile.getProperty("props.email");
		String senhaRem = propertiesFile.getProperty("props.senha");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication(loginRem, senhaRem);
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);
        
        
        /** props.email = pethealth@outlook.com.br
			props.senha = 15187853Pet */

       

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("pethealth@outlook.com.br")); //Remetente

              message.setRecipients(Message.RecipientType.TO, 
                                InternetAddress.parse(emailDestino)); //Destinatário(s)
              message.setSubject("Bem-Vindo ao PetHealth");//Assunto
              message.setText("Bem Vindo ao PetHeath, "+nome+" \n Login: " + emailDestino + " \n Senha: " + senha);
              Transport.send(message);

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

}
