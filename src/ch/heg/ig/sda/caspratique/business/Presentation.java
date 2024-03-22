package ch.heg.ig.sda.caspratique.business;

import java.time.LocalDate;

public class Presentation extends Document{
    private final String title;
    private final String topic;
    private final int pages;

    public Presentation(Unit unit, LocalDate dateOfCreation, Format format, String title, String topic, int pages) {
        super(unit, dateOfCreation, format);
        this.id = idCount++;
        this.title = title;
        this.topic = topic;
        this.pages = pages;
        checkFormat();
    }

    public String getTitle() {
        return title;
    }



    public String getTopic() {
        return topic;
    }



    public int getPages() {
        return pages;
    }



    @Override
    public String toString() {


        return super.toString() + "\nID: " + "PR0" + this.getId() + "\nTitle: " + this.getTitle() + "\nTopic: " + this.getTopic() + "\nPages: " + this.getPages();

    }
}
