package com.example.edward.inventstoryreformat;

/**
 * Created by Andrew on 5/2/2016.
 */
public class inventorymanag {
    int id;
    String event_name, event_date;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setEvent_name(String eventame)  {this.event_name = eventame;}
   // public String getEvent_name() {return this.event_name;}

    public void setEvent_date(String eventdate) {this.event_date = eventdate;}
  //  public String getEvent_date() {return this.event_date;}

    public String getEventname() {
        return event_name;
    }

    public String getEventdate() {
        return event_date;
    }
}
