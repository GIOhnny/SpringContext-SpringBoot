package ro.giohnnysoftware.spingbootlesson16.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthIndicator  implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down()
                .withDetail("ABC","aaabbccc")
                .build();
    }
}
