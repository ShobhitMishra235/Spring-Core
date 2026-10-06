package org.example;

import in.strikes.CartService;
import org.example.payment.CardPayment;
import org.example.payment.PaymentService;
import org.example.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Shobhit", 20);
    }

    @Bean
    public CartService createCartService() {
        return new CartService();
    }

    @Bean
    public PaymentService createCardPayment() {
        return new CardPayment();
    }

    @Bean
    public PaymentService createUpiPayment() {
        return new UpiPayment();
    }

    @Bean
    public OrderService createOrderService(@Qualifier("createUpiPayment") PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
