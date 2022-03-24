package q;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import io.quarkus.arc.Unremovable;

@Unremovable
@ApplicationScoped
public class QConnectionFactory {
	
	private Session session;
	private Queue queue;
	
	public QConnectionFactory() throws JMSException {
			
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = session.createQueue("Q");
	}

	public Session getSession() {
		return session;
	}

	public Queue getQueue() {
		return queue;
	}
}
