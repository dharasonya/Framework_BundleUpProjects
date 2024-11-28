package com.RestAssured.Collection.response;

import java.util.List;

public class epay_ResponseData {

	 private String EuronetRefNo;
	    private String MerchantRefNo;
	    private String PaymentRefNo;
	    private String ApprovalRefNo;
	    private String ResponseCode;
	    private String ResponseMessage;
	    private String ResponseDescription;
	    private List<AdditionalInformation> AdditionalInformation;
	    private String BillerID;
	    private String StateCode;
	    private String BBPSRefId;
	    private String OperatorRefId;
	    private String BBPSONUSRefId;
	    private String NetworkMode;
	    
	 // Getters and Setters for all fields
	    public String getEuronetRefNo() {
	        return EuronetRefNo;
	    }

	    public void setEuronetRefNo(String euronetRefNo) {
	        EuronetRefNo = euronetRefNo;
	    }

	    public String getMerchantRefNo() {
	        return MerchantRefNo;
	    }

	    public void setMerchantRefNo(String merchantRefNo) {
	        MerchantRefNo = merchantRefNo;
	    }

	    public String getPaymentRefNo() {
	        return PaymentRefNo;
	    }

	    public void setPaymentRefNo(String paymentRefNo) {
	        PaymentRefNo = paymentRefNo;
	    }

	    public String getApprovalRefNo() {
	        return ApprovalRefNo;
	    }

	    public void setApprovalRefNo(String approvalRefNo) {
	        ApprovalRefNo = approvalRefNo;
	    }

	    public String getResponseCode() {
	        return ResponseCode;
	    }

	    public void setResponseCode(String responseCode) {
	        ResponseCode = responseCode;
	    }

	    public String getResponseMessage() {
	        return ResponseMessage;
	    }

	    public void setResponseMessage(String responseMessage) {
	        ResponseMessage = responseMessage;
	    }

	    public String getResponseDescription() {
	        return ResponseDescription;
	    }

	    public void setResponseDescription(String responseDescription) {
	        ResponseDescription = responseDescription;
	    }

	    public List<AdditionalInformation> getAdditionalInformation() {
	        return AdditionalInformation;
	    }

	    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
	        AdditionalInformation = additionalInformation;
	    }

	    public String getBillerID() {
	        return BillerID;
	    }

	    public void setBillerID(String billerID) {
	        BillerID = billerID;
	    }

	    public String getStateCode() {
	        return StateCode;
	    }

	    public void setStateCode(String stateCode) {
	        StateCode = stateCode;
	    }

	    public String getBBPSRefId() {
	        return BBPSRefId;
	    }

	    public void setBBPSRefId(String BBPSRefId) {
	        this.BBPSRefId = BBPSRefId;
	    }

	    public String getOperatorRefId() {
	        return OperatorRefId;
	    }

	    public void setOperatorRefId(String operatorRefId) {
	        OperatorRefId = operatorRefId;
	    }

	    public String getBBPSONUSRefId() {
	        return BBPSONUSRefId;
	    }

	    public void setBBPSONUSRefId(String BBPSONUSRefId) {
	        this.BBPSONUSRefId = BBPSONUSRefId;
	    }

	    public String getNetworkMode() {
	        return NetworkMode;
	    }

	    public void setNetworkMode(String networkMode) {
	        NetworkMode = networkMode;
	    }
}
