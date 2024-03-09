package ch.heg.ig.sda.caspratique.sma.business;

import ch.heg.ig.sda.caspratique.sma.service.DocumentService;

import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author SMA
 */

public abstract class Document {

    public enum Format {P, O}// Format enumeration: PDF, Other

    private static Integer id;
    private Unit unit;
    private LocalDate dateOfCreation;

    private Format format;

    protected Document() {
    }

    protected Document(Integer id, Unit unit) {
        this.id = id;
        this.unit = unit;
    }

    protected Document(Integer id, Unit unit, LocalDate dateOfCreation, Format format) {
        this(id, unit);
        this.dateOfCreation = dateOfCreation;
        this.format = format;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
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
        sb.append(this.getCreated() + " days ago");


        sb.append("\nFormat: ");

        // Variante format en enum
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

    /*public void checkDocumentValidity() throws DocumentService.CustomBusinessException {
        if this.
        throw new DocumentService.CustomBusinessException("Invalid document");
    }*/




}

