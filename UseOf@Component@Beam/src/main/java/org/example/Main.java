package org.example;

import in.strikes.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main() {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       OrderService order = context.getBean(OrderService.class);
       order.placeOrder();

       /*

       PaymentService payment = context.getBean(PaymentService.class);
       payment.pay();

        */

       User user = context.getBean(User.class);
       System.out.println(user.getName());

       CartService cart = context.getBean(CartService.class);
       cart.addToCart();
    }


}
