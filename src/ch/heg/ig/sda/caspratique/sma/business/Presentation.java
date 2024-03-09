package ch.heg.ig.sda.caspratique.sma.business;

import java.time.LocalDate;

public class Presentation extends Document{
    private String title;
    private String topic;
    private int pages;

    public Presentation(Integer id, Unit unit, LocalDate dateOfCreation, Format format, String title, String topic, int pages) {
        super(id,unit, dateOfCreation, format);
        this.title = title;
        this.topic = topic;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("\nTitle: ");
        sb.append(this.getTitle());
        sb.append("\nTopic: ");
        sb.append(this.getTopic());
        sb.append("\nPages: ");
        sb.append(this.getPages());


        return sb.toString();

    }
}
