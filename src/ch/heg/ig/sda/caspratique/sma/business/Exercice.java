package ch.heg.ig.sda.caspratique.sma.business;

import java.time.LocalDate;

public class Exercice extends Document{
    private int number;
    private Presentation presentation;

    public Exercice(Integer id, Unit unit, LocalDate dateOfCreation, Format format, int number, Presentation presentation) {
        super(id, unit, dateOfCreation, format);
        this.number = number;
        this.presentation = presentation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

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
