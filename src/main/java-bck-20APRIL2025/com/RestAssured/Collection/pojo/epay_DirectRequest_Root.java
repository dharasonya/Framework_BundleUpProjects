package com.RestAssured.Collection.pojo;

import java.util.List;

public class epay_DirectRequest_Root {

	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public List<MerchantServiceRequestDetails> getMerchantServiceRequestDetails() {
		return MerchantServiceRequestDetails;
	}
	public void setMerchantServiceRequestDetails(List<MerchantServiceRequestDetails> merchantServiceRequestDetails) {
		MerchantServiceRequestDetails = merchantServiceRequestDetails;
	}
	private String RequestType;
	List<MerchantServiceRequestDetails> MerchantServiceRequestDetails;
}
