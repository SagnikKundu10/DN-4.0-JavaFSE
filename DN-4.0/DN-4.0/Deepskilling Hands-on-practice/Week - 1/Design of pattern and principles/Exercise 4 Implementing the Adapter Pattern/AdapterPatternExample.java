public class AdapterPatternExample {
    
    interface PaymentProcessor {
        void processPayment(double amount);
    }


    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " via PayPal.");
        }
    }

    static class StripeGateway {
        public void sendPayment(double value) {
            System.out.println("Processing payment of $" + value + " via Stripe.");
        }
    }

    static class RazorpayGateway {
        public void pay(double money) {
            System.out.println("Processing payment of $" + money + " via Razorpay.");
        }
    }


    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.sendPayment(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpay;

        public RazorpayAdapter(RazorpayGateway razorpay) {
            this.razorpay = razorpay;
        }

        public void processPayment(double amount) {
            razorpay.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(250.0);

        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());
        razorpayProcessor.processPayment(500.0);
    }
}
