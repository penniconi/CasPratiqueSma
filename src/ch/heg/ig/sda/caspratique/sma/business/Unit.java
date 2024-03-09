package ch.heg.ig.sda.caspratique.sma.business;

import ch.heg.ig.sda.caspratique.sma.datastructure.ArrayList;


public class Unit {
    private String title;
    private ArrayList<Document> documents;

    public Unit() {
    }

    public Unit(String title, ArrayList<Document> documents) {
        this.title = title;
        this.documents = documents;
    }


    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nUnit title: ");
        sb.append(title);

        return sb.toString();
    }

}
