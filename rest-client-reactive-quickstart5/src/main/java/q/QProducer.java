package q;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import io.reactiverse.contextual.logging.ContextualData;
import io.smallrye.common.vertx.ContextLocals;

@ApplicationScoped
public class QProducer {

	static final String CTX_KEY = "CTX_KEY";

	public void send() throws JMSException {

		ContextualData.put(CTX_KEY, "CTX_VALUE");
		System.out.println("CTX is set: " + ContextualData.getAll()); // -> {CTX_KEY=CTX_VALUE}
		ContextLocals.put(CTX_KEY, "some data");
		System.out.println("ContextLocals is set: " + ContextLocals.get(CTX_KEY).get()); // -> some data
		
		sendMsg2Q();
	}
	
	private void sendMsg2Q() throws JMSException {
		
		QConnectionFactory cf = Common.getInstance(QConnectionFactory.class);
		Session session = cf.getSession();
		MessageProducer producer = session.createProducer(cf.getQueue());
		System.out.println("Sending Hi!....");
		producer.send(session.createTextMessage("Hi!"));
	}

}
