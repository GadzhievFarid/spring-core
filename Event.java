package epam.spring.core;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    int id;
    String msg;
    Date date;
    DateFormat df;

    public Event(Date date, DateFormat df) {
        Random random = new Random();
        this.id = random.nextInt();
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
