package ch.heg.ig.sda.caspratique.sma.business;

import java.time.LocalDate;

public class Solution extends Document{
    private Exercice exercice;

    public Solution() {
    }


    public Solution(Exercice exercice) {
        this.exercice = exercice;
    }

    public Solution(Integer id, Unit unit, LocalDate dateOfCreation, Format format, Exercice exercice ) {
        super(id,unit,dateOfCreation,format);
        this.exercice = exercice;
    }

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("\nExercice : ");

        if (this.exercice != null) {
            sb.append(this.exercice.getNumber());
        }else {
            sb.append(" - ");
        }

        return sb.toString();
    }



}
