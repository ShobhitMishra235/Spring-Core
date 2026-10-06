package org.example;

import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    private final PaymentService paymentService;
    /*

    @Autowired
    private PaymentService paymentService;

    */

    // Constructor injection
   @Autowired
    public OrderService(@Qualifier("cardPayment") PaymentService paymentService) {

       this.paymentService = paymentService;
    }


    /*

    Setter injection
    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    */


    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
