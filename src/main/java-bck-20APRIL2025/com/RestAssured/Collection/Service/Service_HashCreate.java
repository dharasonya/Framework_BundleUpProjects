package com.RestAssured.Collection.Service;

import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;

import java.util.*;

import java.util.Base64;


public class Service_HashCreate {

	public String CreateHashValue( String merchantRefNo,String merchantCode,String agentId,String billerId,String amount) throws Exception {

		// Set input values

		String saltKey = "Os3dcl82"; // Set your salt key value
		String merchantEncKey = "abcd12345678901*"; // Encryption key
		// Define the subscription details

		List<Map<String, String>> subscriptionDetails = Arrays.asList(

				createSubscriptionEntry("a", "10"),

				createSubscriptionEntry("a b", "20"),

				createSubscriptionEntry("a b c", "30"),

				createSubscriptionEntry("a b c d", "40"),

				createSubscriptionEntry("a b c d e", "50")

				);


		// Concatenate all "Value" fields from subscriptionDetails

		StringBuilder subValues = new StringBuilder();

		for (Map<String, String> entry : subscriptionDetails) {

			subValues.append(entry.get("Value"));

		}


		// Sort the concatenated string

		char[] sortedSubValues = subValues.toString().toCharArray();

		Arrays.sort(sortedSubValues);

		String sortedSubValuesStr = new String(sortedSubValues);


		// Step 1: Concatenate the hash value

		String hashValue = merchantRefNo + "|" + merchantCode + "|" + agentId + "|" + billerId + "|" + amount + "|" + sortedSubValuesStr;

		System.out.println("Hash Value: " + hashValue);


		// Step 2: Encrypt the hash value using AES-CBC with the given encryption key

		String encryptedValue = aesEncrypt(hashValue, merchantEncKey);

		System.out.println("Encrypted Hash: " + encryptedValue);


		// Step 3: Create a final hash with the encrypted value and saltKey using SHA-256

		String finalHashValue = sha256(encryptedValue + "|" + saltKey);

		System.out.println("Final Encrypted with Salt: " + finalHashValue);

		return finalHashValue;

	}


	// Helper method to create subscription entries

	private static Map<String, String> createSubscriptionEntry(String name, String value) {

		Map<String, String> entry = new HashMap<String, String>();

		entry.put("Name", name);

		entry.put("Value", value);

		return entry;

	}


	// AES Encryption (AES-CBC mode)

	private static String aesEncrypt(String data, String key) throws Exception {

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

		IvParameterSpec iv = new IvParameterSpec(key.getBytes(StandardCharsets.UTF_8), 0, 16); // IV using the key's first 16 bytes

		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

		return Base64.getEncoder().encodeToString(encrypted);

	}


	// SHA-256 hashing method

	private static String sha256(String data) throws Exception {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");

		byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

		StringBuilder hexString = new StringBuilder();

		for (byte b : hash) {

			hexString.append(String.format("%02x", b));

		}

		return hexString.toString().toUpperCase();

	}

}