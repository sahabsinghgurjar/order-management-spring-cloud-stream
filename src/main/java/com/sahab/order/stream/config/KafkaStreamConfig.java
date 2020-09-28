package com.sahab.order.stream.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.sahab.order.common.model.OrderDetails;
import com.sahab.order.stream.processors.PolledProcessors;

@Configuration
@EnableBinding(PolledProcessors.class)
@EnableScheduling
public class KafkaStreamConfig {

	@Autowired
	private PolledProcessors polledProcessors;


	@SuppressWarnings("unchecked")
	@Scheduled(fixedDelay = 10)
	public void poll() {
		polledProcessors.destIn().poll(message -> {
			OrderDetails payload = ( OrderDetails) message.getPayload();
	        System.out.println("Received: " + payload);
	        polledProcessors.destOut().send(MessageBuilder.withPayload(payload)
	                .copyHeaders(message.getHeaders())
	                .build());
	    }, new ParameterizedTypeReference<OrderDetails>() {});
	}

}
