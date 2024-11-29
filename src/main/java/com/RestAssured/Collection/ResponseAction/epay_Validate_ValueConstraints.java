package com.RestAssured.Collection.ResponseAction;

import org.testng.Assert;

import com.RestAssured.Collection.response.epay_ResponseData;

public class epay_Validate_ValueConstraints {

	//public void 
	epay_ResponseData responseData;
	public epay_Validate_ValueConstraints(epay_ResponseData responseData) {
		// TODO Auto-generated constructor stub
		this.responseData=responseData;
	}
 
	public void Validate_EuronetRefNo()
	{
		Assert.assertNotNull(responseData.getEuronetRefNo(),"Verify Euronet Ref No. is not Null");
		Assert.assertEquals(responseData.getEuronetRefNo().length(), 10,"Verify Length of Euronet Ref No. is of 10 digit");
	}
	
	public void Validate_MerchantRefNo()
	{
		Assert.assertNotNull(responseData.getMerchantRefNo(),"Verify MerchantRefNo. is not Null");
		Assert.assertEquals(responseData.getMerchantRefNo().length(), 12,"Verify Length of MerchantRefNo. is of 12 digit");
	}
	
	public void Validate_PaymentRefNo()
	{
		Assert.assertNotNull(responseData.getPaymentRefNo(),"Verify PaymentRefNo. is not Null");
		Assert.assertEquals(responseData.getPaymentRefNo().length(), 20,"Verify Length of PaymentRefNo. is of 20 digit");
	}
	public void Validate_ApprovalRefNo()
	{
		Assert.assertNotNull(responseData.getApprovalRefNo(),"Verify ApprovalRefNo. is not Null");
		Assert.assertEquals(responseData.getApprovalRefNo().length(), 8,"Verify Length of ApprovalRefNo. is of 8 digit");
	}
	public void Validate_ResponseCode()
	{
		switch(responseData.getResponseCode())
		{
			case "00":
			{
				Assert.assertEquals(responseData.getResponseMessage(), "Successful","Verify Response Message");
				Assert.assertEquals(responseData.getResponseDescription(), "Successful","Verify Response Description");
				break;
			}
		}
	}
	
	public void Validate_BillerID()
	{
		Assert.assertTrue(responseData.getBillerID().equals("OCNS00000TMN02"),"Verify Biller Id");
		
	}
	public void Validate_StateCode()
	{
		Assert.assertNull(responseData.getStateCode(),"Verify StateCode Not Null");	
	}
	public void Validate_BBPSRefId()
	{
		Assert.assertEquals(responseData.getBBPSRefId(),responseData.getPaymentRefNo(),"Verify BBPSRefId is Equal to Payment RefNo.");
	}
	public void Validate_OperatorRefId()
	{
		Assert.assertEquals(responseData.getOperatorRefId(),responseData.getApprovalRefNo(),"Verify OperatorRefId is Equal to ApprovalRefNo.");
	}
	public void Validate_BBPSONUSRefId()
	{
		Assert.assertNull(responseData.getBBPSONUSRefId(),"Verify BBPSONUSRefId Not Null");	
	}
	public void Validate_NetworkMode()
	{
		Assert.assertEquals(responseData.getNetworkMode(), "BBPSOFFUS","Verify Network Mode");
	}
	 
	
}
