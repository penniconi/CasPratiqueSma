package ch.heg.ig.sda.caspratique.business;

import java.time.LocalDate;

public class Exercise extends Document{
    private final int number;
    private final Presentation presentation;

    public Exercise(Unit unit, LocalDate dateOfCreation, Format format, int number, Presentation presentation) {
        super(unit, dateOfCreation, format);
        this.id = idCount++;
        this.number = number;
        this.presentation = presentation;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("\nID: ").append("EX0").append(this.getId());

        sb.append("\nNumber: ");
        sb.append(getNumber());

        sb.append("\nTopic: ");

        if (this.presentation != null) {
            sb.append(this.presentation.getTopic());
        }else {
            sb.append(" - ");
        }

        return sb.toString();
    }







}
