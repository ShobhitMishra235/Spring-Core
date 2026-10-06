package in.strikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    /*

    Correct Way Using field injection to resolve circular dependencies.
    @Autowired
    private PaymentService paymentService;

     */

    /*

    Wrong cause Error because of Circular dependencies.
    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

     */
    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
    public void getOrderDetails() {
        System.out.println("Order Details");
    }
}

/*

Spring automatically invokes methods marked with @Autowired when performing dependency injection.
Other normal methods are not automatically executed;
they must be called explicitly (unless another Spring annotation/mechanism specifically tells Spring to invoke them).

Also, the constructor is automatically invoked because Java object creation requires a constructor, even without @Autowired.

 */


/*

In setter/field injection, Spring can instantiate a bean first and then inject its dependencies afterward.
During the period between instantiation and dependency injection, the bean is often described as a "partially initialized" or "partially created" bean.
After all required injection and initialization steps are completed, the bean is ready for use.

 */