package com.sahab.order.stream.processors;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.MessageChannel;

public interface PolledProcessors {
	@Input
	PollableMessageSource destIn();

	@Output
	MessageChannel destOut();
}
