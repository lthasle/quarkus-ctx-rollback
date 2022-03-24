package q;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

@ApplicationScoped
public class QConsumer {

	public QConsumer() throws JMSException {

		QConnectionFactory cf = Common.getInstance(QConnectionFactory.class);
		MessageConsumer consumer = cf.getSession().createConsumer(cf.getQueue());
        QMsgHandler msgHandler = Common.getInstance(QMsgHandler.class);
		consumer.setMessageListener(msgHandler::onMessage);
	}
}
