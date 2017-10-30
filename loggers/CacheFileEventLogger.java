package epam.spring.core.loggers;

import epam.spring.core.Event;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void init() throws IOException {
        this.file = new File(filename);
        if (!this.file.canWrite()) {
            throw new IOException();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }
}
