import com.google.inject.AbstractModule;

public class JobQueueModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Notifier.class).to(EmailNotifier.class);
    }
}
