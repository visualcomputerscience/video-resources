package observer.push;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String data);
}

class Subject {
    private List<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();;
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    protected void updateObservers(String data) {
        observers.forEach(observer ->
                observer.update(data));
    }
}

class Database extends Subject {
    private String data;

    public void setData(String data) {
        this.data = data;
        updateObservers(data);
    }

    public String getData() {
        return this.data;
    }
}

class DiskDispatcher implements Observer {
    @Override
    public void update(String data) {
        // Specific implementation
    }
}

class EmailDispatcher implements Observer {
    @Override
    public void update(String data) {
        System.out.println("Sent data on email: " + data);
    }
}

class SlackDispatcher implements Observer {
    @Override
    public void update(String data) {
        System.out.println("Sent data on slack: " + data);
    }
}

class Main {
    public static void main(String[] args) {
        Database database = new Database();

        Observer diskDispatcher = new DiskDispatcher();
        Observer emailDispatcher = new EmailDispatcher();
        Observer slackDispatcher = new SlackDispatcher();

        database.attach(diskDispatcher);
        database.attach(emailDispatcher);
        database.attach(slackDispatcher);

        database.setData("New Record");

        database.detach(diskDispatcher);

        database.setData("New Record2");
    }
}
