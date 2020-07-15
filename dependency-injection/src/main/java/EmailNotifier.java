public class EmailNotifier implements Notifier {
    private final EmailService service;

    public EmailNotifier() {
        this.service = new EmailService();
    }

    @Override
    public void notify(String message) {
        service.sendEmail(message);
    }
}
