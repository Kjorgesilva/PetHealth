package br.com.petHealth.utils;

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
		
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("josecarlos.nascimento@hotmail.com.br", "P@ssw0rd1994");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("josecarlos.nascimento@hotmail.com.br")); //Remetente

              message.setRecipients(Message.RecipientType.TO, 
                                InternetAddress.parse(emailDestino)); //Destinatário(s)
              message.setSubject("Bem-Vindo ao PetHealth");//Assunto
              message.setText("Bem Vindo ao PetHeath, "+nome+" \n Login: " + emailDestino + " \n Senha: " + senha);
              Transport.send(message);

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
  }

}
