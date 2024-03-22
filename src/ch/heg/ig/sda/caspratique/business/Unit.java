package ch.heg.ig.sda.caspratique.business;

import ch.heg.ig.sda.caspratique.datastructure.ArrayList;
import ch.heg.ig.sda.caspratique.datastructure.List;


public class Unit {

    private String title;
    private List<Document> documents;


    public Unit(String title) {
        this.title = title;
        this.documents = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {

        return "\nUnit title: " +
                title;
    }

}
