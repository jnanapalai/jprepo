package p1;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerMessage {
	@Input("messagein")
    SubscribableChannel inboundGreetings();
}
