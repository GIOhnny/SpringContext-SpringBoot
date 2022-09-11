package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")
public class HelloServiceES implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hola, "+name+"!" ;
    }
}
