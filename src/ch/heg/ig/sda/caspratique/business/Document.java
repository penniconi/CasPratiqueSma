package ch.heg.ig.sda.caspratique.business;

import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author SMA
 */

public abstract class Document {

    public enum Format {P, O}// Format enumeration: PDF, Other

    protected static int idCount = 1;

    int id;


    private final Unit unit;
    private final LocalDate dateOfCreation;

    private final Format format;

    protected Document(Unit unit, LocalDate dateOfCreation, Format format) {
        this.unit = unit;
        this.dateOfCreation = dateOfCreation;
        this.format = format;
    }


    public Integer getId() {
        return id;
    }

    public Format getFormat() {
        return format;
    }

    public int getCreated() {
        LocalDate now = LocalDate.now();
        return Period.between(this.dateOfCreation, now).getDays();
    }


    // Redéfinition de la méthode toString();
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nDocument: ");
        sb.append(this.getClass().getSimpleName());


        sb.append("\nCreated: ");
        sb.append(this.getCreated()).append(" days ago");


        sb.append("\nFormat: ");

        // Variant format en enum
        if (this.format != null) {
            switch (this.format) {
                case P:
                    sb.append("PDF");
                    break;
                case O:
                    sb.append("Other");
                    break;
                default:
                    sb.append(" - ");
                    break;
            }
        }

        return sb.toString();
    }

    public static class InvalidFormatException extends IllegalStateException {
        public InvalidFormatException(String message) {
            super(message);
        }
    }

    public void checkFormat() throws InvalidFormatException {
        if (this.getFormat() != Format.P) {
            throw new InvalidFormatException("Presentations and Readings must be in PDF format");
        }
    }

}

