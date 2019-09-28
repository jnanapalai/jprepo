package p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProducerMessage {
	
	
	
	@Output("messgedelivery")
	MessageChannel msg();
	
	
	

}
