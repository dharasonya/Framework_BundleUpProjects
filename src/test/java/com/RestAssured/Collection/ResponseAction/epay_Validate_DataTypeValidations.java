package com.RestAssured.Collection.ResponseAction;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;

import com.RestAssured.Collection.response.AdditionalInformation;
import com.RestAssured.Collection.response.epay_ResponseData;
public class epay_Validate_DataTypeValidations {
   
	
	epay_ResponseData responseData;
	public epay_Validate_DataTypeValidations(epay_ResponseData responseData) {
		// TODO Auto-generated constructor stub
		this.responseData=responseData;
	}
	
	public void Validate_DataType()
	{
        assertThat("EuronetRefNo is not a string!", responseData.getEuronetRefNo(), CoreMatchers.instanceOf(String.class));
        assertThat("MerchantRefNo is not a string!", responseData.getMerchantRefNo(), CoreMatchers.instanceOf(String.class));
        assertThat("PaymentRefNo is not a string!", responseData.getPaymentRefNo(), CoreMatchers.instanceOf(String.class));
        assertThat("ApprovalRefNo is not a String!", responseData.getApprovalRefNo(), CoreMatchers.instanceOf(String.class));
        assertThat("ResponseCode is not a String!", responseData.getApprovalRefNo(), CoreMatchers.instanceOf(String.class));
        assertThat("ResponseDescription is not a String!", responseData.getResponseDescription(), CoreMatchers.instanceOf(String.class));
        assertThat("BillerID is not a String!", responseData.getBillerID(), CoreMatchers.instanceOf(String.class));
        assertThat("StateCode is not a String!", responseData.getStateCode(), CoreMatchers.nullValue());
        assertThat("BBPSRefId is not a String!", responseData.getBBPSRefId(), CoreMatchers.instanceOf(String.class));
        assertThat("ResponseCode is not a String!", responseData.getResponseCode(), CoreMatchers.instanceOf(String.class));
        assertThat("OperatorRefId is not a String!", responseData.getOperatorRefId(), CoreMatchers.instanceOf(String.class));
        assertThat("BBPSONUSRefId is not a String!", responseData.getBBPSONUSRefId(), CoreMatchers.nullValue());
        assertThat("NetworkMode is not a String!", responseData.getNetworkMode(), CoreMatchers.instanceOf(String.class));
        assertThat("AdditionalInformation is not a List!", responseData.getAdditionalInformation(), CoreMatchers.instanceOf(List.class));
        
        for (AdditionalInformation info : responseData.getAdditionalInformation()) {
			 assertThat("AdditionalInformation-Name is not a String!", info.getName(), CoreMatchers.instanceOf(String.class));
			 assertThat("AdditionalInformation-Value is not a String!", info.getValue(), CoreMatchers.instanceOf(String.class));
		}
	}
}
