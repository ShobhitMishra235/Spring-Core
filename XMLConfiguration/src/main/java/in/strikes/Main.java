package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /* Get bean by id/name

         OrderService orderService = (OrderService) context.getBean("orderService");

         When using context.getBean("beanName"), Spring returns an Object, so we type-cast it to the required bean class (e.g., OrderService)
         to assign it to an OrderService reference.


         */

        /* Get bean by type

        OrderService orderService = context.getBean(OrderService.class);

        This method does not work when multiple beans are created from the
        same Java class (for example, multiple OrderService beans), because
        Spring cannot determine which bean to return.

         */

        // Best way
        OrderService orderService = context.getBean("orderService2", OrderService.class);

       /*

       PaymentService paymentService = context.getBean("paymentService", PaymentService.class);

        */

        orderService.placeOrder();
    }
}
