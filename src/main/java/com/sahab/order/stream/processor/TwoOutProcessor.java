package com.sahab.order.stream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TwoOutProcessor {
	String ELECTRONOCIS_OUTPUT = "electronicsOutput";
	
	String GROCESSORY_OUTPUT = "grocessoryOutput";

	
	@Output(GROCESSORY_OUTPUT)
	MessageChannel grocessoryOutput();
	
	@Output(ELECTRONOCIS_OUTPUT)
	MessageChannel electronicsOutput();
	
	String INPUT = "input";
	@Input(INPUT)
	SubscribableChannel input();

}
