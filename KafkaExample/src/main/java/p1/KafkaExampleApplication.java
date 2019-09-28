package p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding(ProducerMessage.class)
public class KafkaExampleApplication {
	
	@Autowired
	ProducerMessage producerMessage;
	@GetMapping("/check3")
	@StreamListener("messagein")
    
	//@StreamListener(target=Sink.INPUT)
	public void getMessage( String msg)
	{
		//producerMessage.inboundGreetings().s
		System.out.println("The Message is"+ msg);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}
	
	@GetMapping("justcheck")
	public String check()
	{
		return "Working fine";
	}
	
	@GetMapping("justcheck1")
	public String check1()
	{
		producerMessage.msg().send(MessageBuilder.withPayload("Hello").build());
		return "Working fineuououo";
		
	}
}
