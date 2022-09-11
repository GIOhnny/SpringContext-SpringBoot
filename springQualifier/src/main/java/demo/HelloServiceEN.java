package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("en")
//@Primary
public class HelloServiceEN implements HelloService{

    @Override
    public String sayHello(String name) {
        return "Hello, "+name+"!" ;
    }
}
