public class DecoratorPatternExample {
    
    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }


    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack message: " + message);
        }
    }


    public static void main(String[] args) {

        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Welcome to our platform!");

        System.out.println();

        Notifier emailSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailSmsNotifier.send("Your OTP is 123456");

        System.out.println();

        Notifier fullNotifier = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()));
        fullNotifier.send("System alert: High CPU usage detected!");
    }
}
