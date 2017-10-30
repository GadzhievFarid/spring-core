package epam.spring.core.loggers;

import epam.spring.core.Event;

public interface EventLogger {
    void logEvent(Event event);
}
