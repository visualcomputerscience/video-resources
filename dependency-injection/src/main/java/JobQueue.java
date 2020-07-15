import com.google.inject.Inject;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobQueue {
    Queue<Job> queue = new PriorityQueue<>();
    private Notifier notifier;

    @Inject
    public JobQueue(Notifier notifier) {
        this.notifier = notifier;
    }

    public void add(Job job) {
        queue.add(job);
        notifier.notify("New job added!");
    }

    public Job remove() {
        notifier.notify("New job removed!");
        return queue.poll();
    }
}
