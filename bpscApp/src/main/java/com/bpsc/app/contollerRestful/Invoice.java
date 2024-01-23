//package com.bpsc.app.contollerRestful;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//
//@RestController
//public class Invoice {
//	
//	@Value("${rzp_key_id}")
//    private String keyId;
//	
//	@Value("${rzp_key_secret}")
//	private String secretKey;
//
//	
//	@PostMapping("/api/new-invoice")
//	public String generateNewInvoice(
//			@RequestParam("name") String name,
//			@RequestParam("contact") String contact,
//			@RequestParam("email") String email,
//			@RequestParam("line1") String line1,
//			@RequestParam("line2") String line2,
//			@RequestParam("pincode") String pincode,
//			@RequestParam("City") String City,
//			@RequestParam("State") String State,
//			@RequestParam("amount") String amount
//			) throws RazorpayException {
//		
//		RazorpayClient razorpay = new RazorpayClient(keyId, secretKey);
//		JSONObject invoiceRequest = new JSONObject();
//		invoiceRequest.put("type", "invoice");
//		invoiceRequest.put("description", "Invoice For The Month of January");
//		invoiceRequest.put("partial_payment", true);
//		JSONObject customer = new JSONObject();
//		customer.put("name", name);
//		customer.put("contact", contact);
//		customer.put("email", email);
//		JSONObject billingAddress = new JSONObject();
//		billingAddress.put("line1", line1);
//		billingAddress.put("line2", line2);
//		billingAddress.put("pincode", pincode);
//		billingAddress.put("City", City);
//		billingAddress.put("State", State);
//		billingAddress.put("country", "India");
//		customer.put("billing_address", billingAddress);
//		
//		JSONObject shipingAddress = new JSONObject();
//		shipingAddress.put("line1", "sarowar enclave raja bagan");
//		shipingAddress.put("line2", "panchwati gali");
//		shipingAddress.put("pincode", "834008");
//		shipingAddress.put("City", "ranchi");
//		shipingAddress.put("State", "ranchi");
//		shipingAddress.put("country", "India");
//		customer.put("shipingAddress", shipingAddress);
//		
//		invoiceRequest.put("customer", customer);
//		List<Object> lines=new ArrayList<>();
//		JSONObject linesItems = new JSONObject();
//		linesItems.put("name","Master Cloud Computing in 30 Days");
//		linesItems.put("description","Book by Suraj Singh");
//		linesItems.put("amount",amount);
//		linesItems.put("currecncy","INR");
//		linesItems.put("quantity",1);
//		lines.add(linesItems);
//		
//		invoiceRequest.put("line_item", lines);
//		invoiceRequest.put("email_notify",1);
//		invoiceRequest.put("sms_notify", 1);
//		invoiceRequest.put("currency", "INR");
//		invoiceRequest.put("expire_by", 1580479824);
//		
//		try {
//			com.razorpay.Invoice invoice = razorpay.invoices.create(invoiceRequest);
//		} catch (RazorpayException e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//			e.printStackTrace();
//		}
//		
//		
//		return "work Done";
//	}
//}
