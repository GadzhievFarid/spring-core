package epam.spring.core;

import epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

public class App {
    Client client;
    EventLogger eventLogger;

    App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = new Event(new Date(), DateFormat.getDateTimeInstance());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");

        app.logEvent("Some event for user 1");
        Thread.sleep(1000);
        app.logEvent("Some event for user 2");
        context.close();
    }
}
