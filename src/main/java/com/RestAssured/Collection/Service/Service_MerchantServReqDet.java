package com.RestAssured.Collection.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.RestAssured.Collection.pojo.ChannelDetails;
import com.RestAssured.Collection.pojo.MerchantServiceRequestDetails;
import com.RestAssured.Collection.pojo.PaymentInformation;
import com.RestAssured.Collection.pojo.SubscriptionDetails;
import com.RestAssured.Collection.pojo.customerProfile;

import ePay_CRM.Reusable_Utils.ReferenceNumberGenerator;

public class Service_MerchantServReqDet {

	public LinkedHashMap<String,Object>  getMerchantServiceRequestDetails(String requestType, String requesterIP, String merchantCode, String userName, 
			String userPass, String storeCode, String agentId, String billerId, String amount, String cCF1, String channelCode, String channelParams_Name1, 
			String channelParams_Value1, String channelParams_Name2, String channelParams_Value2, String channelParams_Name3,String channelParams_Value3, 
			String channelParams_Name4, String channelParams_Value4, String channelParams_Name5, String channelParams_Value5, String splitPay,
			String customerProfile_Name1, String customerProfile_Value1, String customerProfile_Name2, String customerProfile_Value2, 
			String subscriptionDetails_Name1, String subscriptionDetails_Value1, String subscriptionDetails_Name2, String subscriptionDetails_Value2, 
			String subscriptionDetails_Name3, String subscriptionDetails_Value3, String subscriptionDetails_Name4, String subscriptionDetails_Value4, 
			String subscriptionDetails_Name5, String subscriptionDetails_Value5, String paymentMode, String paymentParams_Name1, String paymentParams_Value1, 
			String additionalInformation) throws Exception
	{
		MerchantServiceRequestDetails merchantServiceRequestDetails=new MerchantServiceRequestDetails();
		Service_HashCreate hash=new Service_HashCreate();
		merchantServiceRequestDetails.setRequestType(requestType);
		merchantServiceRequestDetails.setRequesterIP(requesterIP);
		merchantServiceRequestDetails.setMerchantRefNo(new ReferenceNumberGenerator().generateReferenceNumber());
		merchantServiceRequestDetails.setMerchantCode(merchantCode);
		merchantServiceRequestDetails.setUserName(userName);
		merchantServiceRequestDetails.setUserPass(userPass);
		merchantServiceRequestDetails.setStoreCode(storeCode);
		merchantServiceRequestDetails.setAgentId(agentId);
		merchantServiceRequestDetails.setBillerId(billerId);
		merchantServiceRequestDetails.setAmount(amount);
		merchantServiceRequestDetails.setCCF1(cCF1);
	
		Service_ChannelDetails profile_ChannelDetail=new Service_ChannelDetails();
		ChannelDetails channelDetails=profile_ChannelDetail.getChannelDetails(channelCode,channelParams_Name1,channelParams_Value1,channelParams_Name2,
				channelParams_Value2,channelParams_Name3,channelParams_Value3,channelParams_Name4,channelParams_Value4,channelParams_Name5,channelParams_Value5);
		
		Service_CustomerProfile profile_Service_CustomerProfile=new Service_CustomerProfile();
		List<customerProfile> customerProfile=profile_Service_CustomerProfile.getCustomerProfile();
		
		Service_SubscriptionDetails profile_ServiceSubscription=new Service_SubscriptionDetails();
		List<SubscriptionDetails> subscriptionDetailsProfile=profile_ServiceSubscription.getSubscriptionDetails(subscriptionDetails_Name1,subscriptionDetails_Value1
				,subscriptionDetails_Name2, subscriptionDetails_Value2, 
				subscriptionDetails_Name3,subscriptionDetails_Value3, subscriptionDetails_Name4, subscriptionDetails_Value4, 
				subscriptionDetails_Name5,subscriptionDetails_Value5);

		Service_PaymentInformation profile_PaymentInformation=new Service_PaymentInformation();
		PaymentInformation paymentInformation=profile_PaymentInformation.getPaymentInformation();
		
		merchantServiceRequestDetails.setChannelDetails(channelDetails);
		merchantServiceRequestDetails.setSplitPay(splitPay);
		merchantServiceRequestDetails.setCustomerProfile(customerProfile);
		merchantServiceRequestDetails.setSubscriptionDetails(subscriptionDetailsProfile);
		merchantServiceRequestDetails.setPaymentInformation(paymentInformation);
		merchantServiceRequestDetails.setAdditionalInformation(null);
		
		String hashValue = hash.CreateHashValue(merchantServiceRequestDetails.getMerchantRefNo(), merchantServiceRequestDetails.getMerchantCode(), merchantServiceRequestDetails.getAgentId(), merchantServiceRequestDetails.getBillerId(), merchantServiceRequestDetails.getAmount());
        merchantServiceRequestDetails.setHash(hashValue);

		LinkedHashMap<String,Object> requestDetails=new LinkedHashMap<String,Object>();
		requestDetails.put("RequestType",merchantServiceRequestDetails.getRequestType());
		requestDetails.put("RequesterIP",merchantServiceRequestDetails.getRequesterIP());
		requestDetails.put("MerchantRefNo",merchantServiceRequestDetails.getMerchantRefNo());
		requestDetails.put("MerchantCode",merchantServiceRequestDetails.getMerchantCode());
		requestDetails.put("UserName",merchantServiceRequestDetails.getUserName());
		requestDetails.put("UserPass",merchantServiceRequestDetails.getUserPass());
		requestDetails.put("StoreCode",merchantServiceRequestDetails.getStoreCode());
		requestDetails.put("AgentId",merchantServiceRequestDetails.getAgentId());
		requestDetails.put("BillerId",merchantServiceRequestDetails.getBillerId());
		requestDetails.put("Amount",merchantServiceRequestDetails.getAmount());
		requestDetails.put("CCF1",merchantServiceRequestDetails.getCCF1());
		requestDetails.put("ChannelDetails",merchantServiceRequestDetails.getChannelDetails());
		requestDetails.put("SplitPay",merchantServiceRequestDetails.getSplitPay());
		requestDetails.put("CustomerProfile",merchantServiceRequestDetails.getCustomerProfile());
		requestDetails.put("SubscriptionDetails",merchantServiceRequestDetails.getSubscriptionDetails());
		requestDetails.put("PaymentInformation",merchantServiceRequestDetails.getPaymentInformation());
		requestDetails.put("AdditionalInformation",merchantServiceRequestDetails.getAdditionalInformation());
		requestDetails.put("Hash",merchantServiceRequestDetails.getHash());
		
		return requestDetails;
	
		
	}
}
