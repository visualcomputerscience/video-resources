package observer.pull;

import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected final Subject subject;

    abstract void update();

    public Observer(Subject subject) {
        this.subject = subject;
    }
}

class Subject {
    protected String data;

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    protected void updateObservers() {
        observers.forEach(Observer::update);
    }
}

class Database extends Subject {
    public void setData(String data) {
        this.data = data;
        updateObservers();
    }

    public String getData() {
        return this.data;
    }
}

class DiskDispatcher extends Observer {

    public DiskDispatcher(Subject subject) {
        super(subject);
    }

    @Override
    void update() {
        // Working with subject.data
    }
}

class EmailDispatcher extends Observer {
    public EmailDispatcher(Subject subject) {
        super(subject);
    }
    @Override
    void update() {
        System.out.println("Sent data on email: " + subject.data);
    }
}

class SlackDispatcher extends Observer {
    public SlackDispatcher(Subject subject) {
        super(subject);
    }

    @Override
    void update() {
        System.out.println("Sent data on slack: " + subject.data);
    }
}

class Main {
    public static void main(String[] args) {
        Database database = new Database();

        Observer diskDispatcher = new DiskDispatcher(database);
        Observer emailDispatcher = new EmailDispatcher(database);
        Observer slackDispatcher = new SlackDispatcher(database);

        database.attach(diskDispatcher);
        database.attach(emailDispatcher);
        database.attach(slackDispatcher);

        database.setData("New Record");

        database.detach(diskDispatcher);

        database.setData("New Record2");
    }
}
