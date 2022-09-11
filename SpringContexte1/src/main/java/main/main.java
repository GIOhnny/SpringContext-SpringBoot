package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    /**
     * XML
     * Annotations
    */
    public static void main(String[] args) {
        //contextul se configureaza cu o clasa de configurare pusa cu @Configutation
        try (var context =
                     new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            //Cat x = context.getBean(Cat.class);
            Owner o = context.getBean(Owner.class);

//            x.setName("Leo");
//            System.out.println(x);
            System.out.println(o);
        }
    }
}
