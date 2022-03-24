
package q;

import java.net.URI;
import java.util.Map;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class MyBrokerResource implements QuarkusTestResourceLifecycleManager {

	static BrokerService broker;

	@Override
	public Map<String, String> start() {
		
		broker = new BrokerService();
		broker.setPersistent(false);
		TransportConnector connector = new TransportConnector();
		try {
			connector.setUri(new URI("tcp://localhost:61616"));
			broker.addConnector(connector);
			broker.start();
			broker.waitUntilStarted();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void stop() {
		
		try {
			broker.stop();
			broker.waitUntilStopped();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
