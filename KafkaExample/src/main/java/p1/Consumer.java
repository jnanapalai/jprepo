package p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@EnableBinding(ConsumerMessage.class)

public class Consumer {
	
	@Autowired
	ProducerMessage producerMessage;
	
@StreamListener("messagein")
public void getMessage( String msg)
	{
		//producerMessage.inboundGreetings().s
		System.out.println( "Another is"+msg);
		
	}

}
