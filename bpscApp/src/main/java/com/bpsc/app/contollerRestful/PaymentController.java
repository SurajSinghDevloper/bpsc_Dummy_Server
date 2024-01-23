package com.bpsc.app.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpsc.app.util.RazorpayService;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	@Autowired
    private RazorpayService razorpayService;
	
	
	@PostMapping("/order")
    public String generateOrder(@RequestParam int amount) throws RazorpayException {
        return razorpayService.generateOrderId(amount);
    }

    @PostMapping("/verify")
    public String verifyPayment(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String razorpaySignature) {
        String generatedSignature = razorpayService.generatePaymentSignature(orderId, paymentId, razorpaySignature);
        // Compare the generatedSignature with the received razorpaySignature
        if (generatedSignature.equals(razorpaySignature)) {
            return "Payment verified successfully";
        } else {
            return "Payment verification failed";
        }
    }
}
