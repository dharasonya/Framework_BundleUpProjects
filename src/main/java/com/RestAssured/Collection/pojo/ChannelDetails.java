package com.RestAssured.Collection.pojo;

import java.util.List;

public class ChannelDetails {

	public ChannelDetails() {
		super();
	}
	private String ChannelCode;
	public String getChannelCode() {
		return ChannelCode;
	}
	public void setChannelCode(String channelCode) {
		ChannelCode = channelCode;
	}
	public List<ChannelParams> getChannelParams() {
		return channelParams;
	}
	public void setChannelParams(List<ChannelParams> channelParams) {
		this.channelParams = channelParams;
	}
	private List<ChannelParams> channelParams;
	
}
