package com.sahab.order.stream.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;

import com.sahab.order.common.model.OrderDetails;
import com.sahab.order.stream.processor.TwoOutProcessor;

@Configuration
@EnableBinding(TwoOutProcessor.class)
public class KafkaStreamConfig {
	  @Autowired
	    private MessageChannel electronicsOutput;
	
	@StreamListener(TwoOutProcessor.INPUT)
    @SendTo(TwoOutProcessor.GROCESSORY_OUTPUT)
	
	public OrderDetails process(OrderDetails input) {
		if(input.getOrderName().endsWith("ELECTRONICS")) {
			electronicsOutput.send(MessageBuilder.withPayload(input).build());
			return null;
		}
		return input;
	}
}
