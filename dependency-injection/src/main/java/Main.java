import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
            new JobQueueModule()
        );

        JobQueue queue = injector.getInstance(JobQueue.class);

        queue.add(new Job(10));
        Job job = queue.remove();

        System.out.println("Retrieved job with id = " + job.getId());
    }
}
