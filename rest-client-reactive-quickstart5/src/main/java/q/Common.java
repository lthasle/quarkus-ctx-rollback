package q;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.arc.Arc;

@ApplicationScoped
public class Common {

    public static <U> U getInstance(Class<U> clazz) {

        return Arc.container().instance(clazz).get();
    }
}
