package com.sahab.order.stream.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahab.order.common.model.OrderDetails;

@Configuration
public class KafkaStreamConfig {
	
	@Bean
	public Function<OrderDetails,OrderDetails> processOrder(){
		return (input)->{
			System.out.println("Message received in transformer0 "+input);
			input.setOrderName("transformed");
			return input;
		};
	}

	@Bean
	public Function<OrderDetails,OrderDetails> processOrder1(){
		return (input)->{
			System.out.println("Message received in transformer1 "+input);
			input.setOrderName("transformed");
			return input;
		};
	}


}
