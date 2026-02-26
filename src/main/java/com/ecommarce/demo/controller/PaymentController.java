package com.ecommarce.demo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class PaymentController {

    @PostMapping("/razorpay")
    public String createOrder() throws RazorpayException {
            RazorpayClient client = new RazorpayClient("YOUR_KEY_ID", "YOUR_SECRET");
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", 50000); // amount in paise (500.00 INR)
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "txn_123456");
            orderRequest.put("payment_capture", 1);

            Order order = client.orders.create(orderRequest);
            return order.toString();
    }

}
