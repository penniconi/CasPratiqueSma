package ch.heg.ig.sda.caspratique.business;

import java.time.LocalDate;

public class Solution extends Document{
    private final Exercise exercise;


    public Solution(Unit unit, LocalDate dateOfCreation, Format format, Exercise exercise) {
        super(unit,dateOfCreation,format);
        this.id = idCount++;
        this.exercise = exercise;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("\nID: ").append("SO0").append(this.getId());
        sb.append("\nExercise : ");

        if (this.exercise != null) {
            sb.append(this.exercise.getNumber());
        }else {
            sb.append(" - ");
        }

        return sb.toString();
    }



}
