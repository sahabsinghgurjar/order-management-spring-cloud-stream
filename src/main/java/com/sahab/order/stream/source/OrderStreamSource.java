package com.sahab.order.stream.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
public class OrderStreamSource {
	private Source mySource;
	public OrderStreamSource(Source mySource) {
	super();
	this.mySource = mySource;
	}
	public Source getMysource() {
	return mySource;
	}
	public void setMysource(Source mySource) {
	this.mySource = mySource;
	}

}
	