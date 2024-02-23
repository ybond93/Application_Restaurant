package miun.dt170g.application_restaurant.entities;

import java.sql.Time;
import java.util.Date;

public class Event {


    private int eventId;

    private String name;

    private Integer price;

    private String descr;

    private Date eventDate;

    private Time startTime;

    public Event(int eventId, String name, Integer price, String descr, Date eventDate, Time startTime) {
        this.eventId = eventId;
        this.name = name;
        this.price = price;
        this.descr = descr;
        this.eventDate = eventDate;
        this.startTime = startTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}
