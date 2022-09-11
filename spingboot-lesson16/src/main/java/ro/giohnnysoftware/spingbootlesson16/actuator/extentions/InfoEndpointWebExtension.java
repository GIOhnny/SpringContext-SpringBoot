package ro.giohnnysoftware.spingbootlesson16.actuator.extentions;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoEndpointWebExtension {
    @ReadOperation
    public WebEndpointResponse info() {
        //return "{Bau : Bauuuuu}";
        return new WebEndpointResponse<>("INFO" , 204);
    }
}
