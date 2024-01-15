package com.bpsc.app.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class Base64Decoder {
	public String decodeBase64String(String encodedString) {

		try {
	        if (encodedString != null) {
	            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
	            return decodedString;
	        } else {
	            return "Input is null";
	        }
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        return "Error decoding Base64: " + e.getMessage();
	    }
	}
}
