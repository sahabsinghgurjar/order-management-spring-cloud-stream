package com.sahab.order.stream.sink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import com.sahab.order.common.model.OrderDetails;

@EnableBinding(Sink.class)
public class OrderSink {

	@StreamListener(target = Sink.INPUT)
	public void consume(@Payload OrderDetails message) {
		System.out.println("recieved a string message : " + message);
	}

}
