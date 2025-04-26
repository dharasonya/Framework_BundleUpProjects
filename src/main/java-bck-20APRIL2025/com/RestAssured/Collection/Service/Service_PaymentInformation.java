package com.RestAssured.Collection.Service;

import java.util.ArrayList;
import java.util.List;

import com.RestAssured.Collection.pojo.PaymentInformation;
import com.RestAssured.Collection.pojo.paymentParams;

public class Service_PaymentInformation {

	public PaymentInformation getPaymentInformation()
	{
		PaymentInformation objPaymentInformationdet=new PaymentInformation();
		
		List<paymentParams> paymentParamsList=new ArrayList<>();
		paymentParamsList.add(new paymentParams("WalletName|MobileNo","2kNWfZfGuTHZSHTb92+QhXc1Lg5RqJ3GnTovfruYSEk="));
		
		objPaymentInformationdet.setPaymentMode("Wallet");
		objPaymentInformationdet.setPaymentParams(paymentParamsList);
		

		return objPaymentInformationdet;
		
	}
}
