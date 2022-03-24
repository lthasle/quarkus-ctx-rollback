package q;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ApplicationLifeCycle {

	@Inject QConsumer consumer; 
    
    void onStart(@Observes StartupEvent ev) throws IOException { /* to start QConsumer */ }
}
