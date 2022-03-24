package q;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path(MyController.DOMAIN)
public class MyController {

	public static final String DOMAIN = "my";
	public static final String PATH = "q";
	
	@Inject QProducer producer;
	
	@GET
	@Path(PATH)
	public Response simple() throws JMSException {
		
		producer.send();
		return Response.ok().build();
	}
}
