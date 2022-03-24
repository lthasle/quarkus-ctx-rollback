package q;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import io.quarkus.arc.Unremovable;
import io.reactiverse.contextual.logging.ContextualData;
import io.smallrye.common.vertx.ContextLocals;

@Unremovable
@ApplicationScoped
public class QMsgHandler implements MessageListener {

	@Override
	public void onMessage(Message message) {

		try {
			System.out.println("Msg from Q received: " + ((TextMessage)message).getText());
			System.out.println("ContextualData: " +  ContextualData.getAll()); // -> null
			  /*
			  System.out.println("ContextLocals: " + ContextLocals.get(QProducer.CTX_KEY));
			  ERROR UnsupportedOperationException: 
			  Access to Context Locals are forbidden from a 'root' context  as it can leak data between unrelated processing. 
			  Make sure the method runs on a 'duplicated' (local) Context*/
		} catch (JMSException e) {
			System.out.println("Not able to read from Q: " + e);
		}
	}

}
