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
	
	public void Validate_AdditionalInformation(String SubscriptionDetails_Name1,String SubscriptionDetails_Value1,String SubscriptionDetails_Name2,String SubscriptionDetails_Value2,
			String SubscriptionDetails_Name3,String SubscriptionDetails_Value3,String SubscriptionDetails_Name4, String SubscriptionDetails_Value4,
			String SubscriptionDetails_Name5,String SubscriptionDetails_Value5)
	{
		for(int i=0;i<responseData.getAdditionalInformation().size();i++)
		{
			System.out.println(" Additional Info : i = "+i+" :"+responseData.getAdditionalInformation().get(i).getName());
			System.out.println(" Additional Info : i = "+i+" :"+responseData.getAdditionalInformation().get(i).getValue());
			
			if(i==0)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), SubscriptionDetails_Name1,"Verification of Additional Information Name at Position : "+i);
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getValue(),SubscriptionDetails_Value1,"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==1)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), SubscriptionDetails_Name2,"Verification of Additional Information Name at Position : "+i);
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getValue(),SubscriptionDetails_Value2,"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==2)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), SubscriptionDetails_Name3,"Verification of Additional Information Name at Position : "+i);
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getValue(),SubscriptionDetails_Value3,"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==3)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), SubscriptionDetails_Name4,"Verification of Additional Information Name at Position : "+i);
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getValue(),SubscriptionDetails_Value4,"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==4)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), SubscriptionDetails_Name5,"Verification of Additional Information Name at Position : "+i);
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getValue(),SubscriptionDetails_Value5,"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==5)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), "BillNumber","Verification of Additional Information Name at Position : "+i);
				Assert.assertNotNull(responseData.getAdditionalInformation().get(i).getValue(),"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==6)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), "BillPeriod","Verification of Additional Information Name at Position : "+i);
				Assert.assertNotNull(responseData.getAdditionalInformation().get(i).getValue(),"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==7)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), "DueDate","Verification of Additional Information Name at Position : "+i);
				Assert.assertNotNull(responseData.getAdditionalInformation().get(i).getValue(),"Verification of Additional Information Value at Position : "+i);	
			}
			if(i==8)
			{
				Assert.assertEquals(responseData.getAdditionalInformation().get(i).getName(), "BillDate","Verification of Additional Information Name at Position : "+i);
				Assert.assertNotNull(responseData.getAdditionalInformation().get(i).getValue(),"Verification of Additional Information Value at Position : "+i);	
			}
		
		}
	}
	
	public void Validate_BillerID(String BillerId)
	{
		Assert.assertTrue(responseData.getBillerID().equals(BillerId),"Verify Biller Id");
		
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
