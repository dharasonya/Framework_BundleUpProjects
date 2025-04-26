package com.RestAssured.Collection.pojo;

import java.util.List;

public class PaymentInformation {

	public PaymentInformation() {
		super();
	}
	
	
	
	
	public String getPaymentMode() {
		return PaymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}
	public List<paymentParams> getPaymentParams() {
		return paymentParams;
	}
	public void setPaymentParams(List<paymentParams> paymentParams) {
		this.paymentParams = paymentParams;
	}
	private String PaymentMode;
	private List<paymentParams> paymentParams;
	
	
	
}

