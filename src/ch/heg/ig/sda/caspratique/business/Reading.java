package ch.heg.ig.sda.caspratique.business;

import java.time.LocalDate;

public class Reading extends Document {
    private final String title;
    private final String author;
    private final int pages;

    public Reading(Unit unit, LocalDate dateOfCreation, Format format, String title, String author, int pages) throws IllegalStateException {
        super(unit, dateOfCreation, format);
        this.id = idCount++;
        this.title = title;
        this.author = author;
        this.pages = pages;
        checkFormat();
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getPages() {
        return pages;
    }


    @Override
    public String toString() {


        return super.toString() +
                "\nID: " + "RE0" + this.getId() +
                "\nTitle: " +
                this.getTitle() +
                "\nAuthor: " +
                this.getAuthor() +
                "\nPages: " +
                this.getPages();

    }
}



