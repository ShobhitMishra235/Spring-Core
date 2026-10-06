package in.strikes;

import in.strikes.payment.PaymentService1;

public class OrderService {

    private PaymentService1 paymentService;

    public OrderService(PaymentService1 paymentService) {
        this.paymentService = paymentService;
    }

    /* Injection Of Dependencies Using Setter in XML

    public void setPaymentServiceBean(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    */
    public void placeOrder() {

        paymentService.pay();
        System.out.println("Order Placed");
    }
}
