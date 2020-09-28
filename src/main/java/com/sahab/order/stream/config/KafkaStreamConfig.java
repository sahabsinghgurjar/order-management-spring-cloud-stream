package com.sahab.order.stream.config;

import java.util.Arrays;
import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sahab.order.common.model.OrderDetails;

@Configuration
public class KafkaStreamConfig {
	
	

	@SuppressWarnings("unchecked")
	@Bean
	public Function<KStream<Object, OrderDetails>, KStream<?, OrderDetails>[]> processOrder() {

	    Predicate<Object, OrderDetails> isElectronics = (k, v) -> v.getOrderName().endsWith("ELECTRONICS");
	    Predicate<Object, OrderDetails> isGrocerry = (k, v) -> !v.getOrderName().endsWith("ELECTRONICS");
	    return (KStream<Object, OrderDetails> input)->
	    {
	    	return input.mapValues(new ValueMapper<OrderDetails, OrderDetails>() {

				@Override
				public OrderDetails apply(OrderDetails value) {
					System.out.println(value);
					return value;
				}
			})
	            .flatMapValues(value ->{ 
	            	return Arrays.asList(value);
	            	
	            })
	            .branch(isElectronics, isGrocerry);
	    };
	}
	


}
