package es.uc3m.tiw.wallapop.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.uc3m.tiw.wallapop.dominios.Mensaje;

/**
 * @author David Palomar
 *
 */
public class EscribeEnCola {

	//FIXME: Codigo legado  de acceso  tradicional via JNDI
public void enviar(Mensaje mensaje){

	  
   MessageProducer messageProducer;
   ObjectMessage messge;
   
   try
   {
       ConnectionFactory connectionFactory = null;
       
      // Get the JNDI Context
 
           Context jndiContext = new InitialContext();
            
      //   Create the Connection Factory
           connectionFactory = (ConnectionFactory) jndiContext.lookup("jms_tiwConnectionFactory");
           Queue queue = (Queue) jndiContext.lookup("jms_mensajes"); 

     Connection connection = connectionFactory.createConnection();
     Session session = connection.createSession(false,
       Session.AUTO_ACKNOWLEDGE);
     

     messageProducer = session.createProducer(queue);
     messge = session.createObjectMessage();
     messge.setObject(mensaje);

     
     messageProducer.send(messge);
     connection.start();
     messageProducer.close();
     session.close();
     connection.close();
   
   }
   catch (JMSException | NamingException e)
   {
     e.printStackTrace();
   }
}
}