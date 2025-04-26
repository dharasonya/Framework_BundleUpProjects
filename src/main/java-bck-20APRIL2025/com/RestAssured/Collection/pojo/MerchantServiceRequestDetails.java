package com.RestAssured.Collection.pojo;

import java.util.List;

public class MerchantServiceRequestDetails {

	public MerchantServiceRequestDetails() {
		super();
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getRequesterIP() {
		return RequesterIP;
	}
	public void setRequesterIP(String requesterIP) {
		RequesterIP = requesterIP;
	}
	public String getMerchantRefNo() {
		return MerchantRefNo;
	}
	public void setMerchantRefNo(String merchantRefNo) {
		MerchantRefNo = merchantRefNo;
	}
	public String getMerchantCode() {
		return MerchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		MerchantCode = merchantCode;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPass() {
		return UserPass;
	}
	public void setUserPass(String userPass) {
		UserPass = userPass;
	}
	public String getStoreCode() {
		return StoreCode;
	}
	public void setStoreCode(String storeCode) {
		StoreCode = storeCode;
	}
	public String getAgentId() {
		return AgentId;
	}
	public void setAgentId(String agentId) {
		AgentId = agentId;
	}
	public String getBillerId() {
		return BillerId;
	}
	public void setBillerId(String billerId) {
		BillerId = billerId;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getCCF1() {
		return CCF1;
	}
	public void setCCF1(String cCF1) {
		CCF1 = cCF1;
	}
	public ChannelDetails getChannelDetails() {
		return channelDetails; 
	}
	public void setChannelDetails(ChannelDetails channelDetails) {
		this.channelDetails = channelDetails;
	}
	public String getSplitPay() {
		return SplitPay;
	}
	public void setSplitPay(String splitPay) {
		SplitPay = splitPay;
	}
	public List<customerProfile> getCustomerProfile() {
		return CustomerProfile;
	}
	public void setCustomerProfile(List<customerProfile> customerProfile) {
		CustomerProfile = customerProfile;
	}
	public List<SubscriptionDetails> getSubscriptionDetails() {
		return subscriptionDetails;
	}
	public void setSubscriptionDetails(List<SubscriptionDetails> subscriptionDetails) {
		this.subscriptionDetails = subscriptionDetails;
	}
	public PaymentInformation getPaymentInformation() {
		return paymentInformation;
	}
	public void setPaymentInformation(PaymentInformation paymentInformation) {
		this.paymentInformation = paymentInformation;
	}
	public String getAdditionalInformation() {
		return AdditionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		AdditionalInformation = additionalInformation;
	}
	public String getHash() {
		return Hash;
	}
	public void setHash(String hash) {
		Hash = hash;
	}
	private String RequestType;
	private String RequesterIP;
	private String MerchantRefNo;
	private String MerchantCode;
	private String UserName;
	private String UserPass;
	private String StoreCode;
	private String AgentId;
	private String BillerId;
	private String Amount;
	private String CCF1;
	private ChannelDetails channelDetails;
	private String SplitPay;
	private List<customerProfile> CustomerProfile;
	private List<SubscriptionDetails> subscriptionDetails;
	private PaymentInformation paymentInformation; 
	private String AdditionalInformation;
	private String Hash;
	
	
}
