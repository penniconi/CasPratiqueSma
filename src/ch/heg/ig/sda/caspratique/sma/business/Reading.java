package ch.heg.ig.sda.caspratique.sma.business;

import java.time.LocalDate;

public class Reading extends Document {
    private String title;
    private String author;
    private int pages;

    public Reading(Integer id, Unit unit, LocalDate dateOfCreation, Format format, String title, String author, int pages) throws Exception {
        super(id, unit, dateOfCreation, format);
        this.title = title;
        this.author = author;
        this.pages = pages;
        checkFormat();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        sb.append("\nAuthor: ");
        sb.append(this.getAuthor());
        sb.append("\nPages: ");
        sb.append(this.getPages());


        return sb.toString();

    }

    public void checkFormat() throws Exception {
        if (this.getFormat() == Format.O) {
            throw new Exception("Reading must be in PDF format");
        }
    }


}
