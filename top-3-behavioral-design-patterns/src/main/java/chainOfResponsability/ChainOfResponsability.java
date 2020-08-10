package chainOfResponsability;

import java.util.Arrays;
import java.util.List;

interface Request {
    String getContent();
}

class ConcreteRequest implements Request {
    private String content;

    public ConcreteRequest(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

interface Handler {
    void process(Request request);
    boolean canProcess(Request request);
}

class ProcessingChain {
    private List<Handler> handlers;

    public ProcessingChain(Handler... handlers) {
        this.handlers = Arrays.asList(handlers);
    }

    public void execute(Request request) {
        for (Handler handler : handlers) {
            if (handler.canProcess(request)) {
                handler.process(request);
                break;
            }
        }
    }
}

class Handler1 implements Handler {

    @Override
    public void process(Request request) {
        // Process the request.getContent()
    }

    @Override
    public boolean canProcess(Request request) {
        return !request.getContent().isEmpty();
    }

}

class Handler2 implements Handler {

    @Override
    public void process(Request request) {
        System.out.println(
                "Request processed:" + request.getContent()
        );
    }

    @Override
    public boolean canProcess(Request request) {
        return !request.getContent().isEmpty();
    }
}

public class ChainOfResponsability {

    public static void main(String[] args) {

        ProcessingChain chain = new ProcessingChain(
                new Handler1(),
                new Handler2()
        );

        chain.execute(new ConcreteRequest("Payload 1"));
        chain.execute(new ConcreteRequest("Payload 2"));
    }
}
