package in.strikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private OrderService orderService;


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /*

        Correct Way Using field injection.
        @Autowired
       private OrderService orderService;

   */

   /*

   Wrong cause Error because of Circular dependencies.
   public PaymentService(OrderService orderService) {
        this.orderService = orderService;
    }

    */
    public void pay(){
        System.out.println("Payment done");
        orderService.getOrderDetails();
    }
}

/*

Component Scanning
       ↓
Find @Component
       ↓
OrderService found
PaymentService found
       ↓
Create bean definitions
       ↓
Start creating objects
       ↓
To create OrderService
       ↓
Spring sees constructor needs PaymentService
       ↓
"Okay, I need PaymentService first"
       ↓
To create PaymentService
       ↓
Spring sees constructor needs OrderService
       ↓
"Okay, I need OrderService first"
       ↓
But OrderService is currently being created
       ↓
❌ Circular dependency


Spring does not automatically execute all methods of a bean. During bean creation, Spring performs dependency injection according to the injection point:

Constructor injection: Spring provides the dependency through the constructor while creating the object.
Setter injection: Spring creates the object first and then automatically calls the @Autowired setter to inject the dependency.
Field injection: Spring creates the object first and then directly injects the dependency into the @Autowired field.
Normal methods: Spring does not call them just because they exist; you normally call them yourself.

 */