package ch.heg.ig.sda.caspratique.service;


import ch.heg.ig.sda.caspratique.business.*;
import ch.heg.ig.sda.caspratique.datastructure.ArrayList;
import ch.heg.ig.sda.caspratique.datastructure.List;

import java.time.LocalDate;

public class DocumentService implements IDocumentService {


    private Unit currentUnit;
    private final List<Unit> units;

    public DocumentService() {
        units = new ArrayList<>();
        currentUnit = null;
    }

    public Unit getCurrentUnit() {
        return currentUnit;
    }


    @Override
    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(String title) {
        System.out.println("\n----------------------> Add");
        currentUnit = new Unit(title);
        units.add(currentUnit);
        System.out.println("\nadding... \nsuccess!\nUnit content: " + currentUnit.getDocuments().size() + " documents at the moment");

    }

    public void unitsCount() {
        System.out.println("\nnumber of units in the system " + units.size());
    }

    /**
     * User ne peut ajouter à l'unité currente que des documents de type "Presentation" ou "Reading";
     * etant donné que les Excercices et les Solutions son gerés par le systéme.
     *
     * @param type   = determine la forme que la classe document prendra
     * @param format = n'ayant pas accés à la couche business, la main ne peut que passer un char en parametre, le body de la methode s'en chargera de faire la liasion
     * @param info   = cela peut prendre la forme d'un titre de presentation ou de nom d'auteur de reading
     */

    public void addPrintableDocument(String type, char format, String title, String info, int pages) {
        System.out.println("\n----------------------> Add Printable");
        Document myDocument;
        if (format != 'P') {
            System.out.println("\nOh no! Printable insert has failed... Error: Presentations and Readings must be in PDF format");
        } else {
            try {
                switch (type) {
                    case "Presentation" -> {
                        myDocument = new Presentation(currentUnit, LocalDate.now(), Document.Format.P, title, info, pages);
                        currentUnit.getDocuments().add(myDocument);
                    }

                    case "Reading" -> {
                        myDocument = new Reading(currentUnit, LocalDate.now(), Document.Format.O, title, info, pages);//c'est la faute au dev car l'user n'a pas acces au body de la methode.
                        currentUnit.getDocuments().add(myDocument);
                    }

                    default -> throw new IllegalStateException("Unexpected value: " + type);
                }
                System.out.println("\nPrintable insert success!");
            } catch (IllegalStateException ise) {
                System.out.println("Error : " + ise.getMessage());
            }
        }
    }


    /**
     * ensemble de documents = les données du cours SDA à présent
     */

    @Override
    public void unitInitialize() {
        System.out.println("\n----------------------> Initialize");


        currentUnit = new Unit("63-31 .1  Advanced Data Structure");

        try {
            Document document0 = new Presentation(currentUnit, LocalDate.of(2024, 2, 20), Document.Format.P, "GES-63-31.1-SDA_C1.2_POO-SDA", "Object Oriented Programming and Advanced Data Structures Basis", 25);
            currentUnit.getDocuments().add(0, document0);

            Document document1 = new Exercise(currentUnit, LocalDate.of(2024, 2, 20), Document.Format.P, 1, (Presentation) document0);
            currentUnit.getDocuments().add(1, document1);

            Document document2 = new Reading(currentUnit, LocalDate.of(2024, 2, 20), Document.Format.P, "Programmer en Java (Dellanoy, 2008 chap.1)", "Dellanoy Claude", 25);
            currentUnit.getDocuments().add(2, document2);

            Document document3 = new Solution(currentUnit, LocalDate.of(2024, 2, 26), Document.Format.O, (Exercise) document1);
            currentUnit.getDocuments().add(3, document3);

            Document document4 = new Presentation(currentUnit, LocalDate.of(2024, 2, 27), Document.Format.P, "GES-63-31.1-SDA_C2.1_StructureDeDonnees_List", "List", 21);
            currentUnit.getDocuments().add(4, document4);

            Document document5 = new Presentation(currentUnit, LocalDate.of(2024, 2, 27), Document.Format.P, "GES-63-31.1-SDA_C2.2_Exceptions", "Exceptions", 8);
            currentUnit.getDocuments().add(5, document5);

            Document document6 = new Exercise(currentUnit, LocalDate.of(2024, 2, 27), Document.Format.P, 2, (Presentation) document4);
            currentUnit.getDocuments().add(6, document6);

            Document document7 = new Solution(currentUnit, LocalDate.of(2024, 3, 4), Document.Format.O, (Exercise) document6);
            currentUnit.getDocuments().add(7, document7);

            Document document8 = new Presentation(currentUnit, LocalDate.of(2024, 3, 5), Document.Format.P, "GES-63-31.1-SDA_C3.1_Genericité", "Generics", 8);
            currentUnit.getDocuments().add(8, document8);

            Document document9 = new Exercise(currentUnit, LocalDate.of(2024, 3, 5), Document.Format.P, 2, (Presentation) document8);
            currentUnit.getDocuments().add(9, document9);

            Document document10 = new Solution(currentUnit, LocalDate.of(2024, 3, 5), Document.Format.O, (Exercise) document9);
            currentUnit.getDocuments().add(10, document10);

        } catch (Document.InvalidFormatException ife) {
            System.out.println("\nOh no! some document init has failed, because: " + ife.getMessage());
        }

        System.out.println("\ninitializing... \nsuccess!\nUnit content: " + currentUnit.getDocuments().size() + " documents at the moment");
        units.add(currentUnit);
        unitsCount();
        System.out.println(currentUnit);

    }

    @Override
    public void listAllDocuments(List<Document> documentList) {
        System.out.println("\n----------------------> All documents");
        int j = 0;

        for (int i = 0; i < documentList.size(); i++) {
            System.out.println("\n" + documentList.get(i));
            System.out.println("\n----------------------\n");
            j++;
        }

        System.out.println("\n----------------------\n" + j + "/" + documentList.size() + " displayed");
    }


    @Override
    public void listPrintableDocuments(List<Document> documentList) {
        System.out.println("\n----------------------> Printable documents");
        int printableCount = 0;

        for (int i = 0; i < documentList.size(); i++) {
            if (documentList.get(i).getFormat() == Document.Format.P) {
                System.out.println(documentList.get(i));
                System.out.println("\n----------------------\n");
                printableCount++;
            }
        }

        System.out.println("\n----------------------\n" + printableCount + "/" + documentList.size() + " displayed");
    }

    @Override
    public void unitOverview(List<Document> documentsList) {
        System.out.println("\n----------------------> Unit overview");


        int presentations = 0, readings = 0, exercises = 0, solutions = 0;

        for (int i = 0; i < documentsList.size(); i++) {
            String unitOverViewed = documentsList.get(i).getClass().getSimpleName();

            switch (unitOverViewed) {
                case "Presentation" -> presentations++;
                case "Reading" -> readings++;
                case "Exercise" -> exercises++;
                case "Solution" -> solutions++;
                default -> throw new IllegalStateException("Unexpected value: " + unitOverViewed);
            }
        }


        System.out.println("Presentations = " + presentations);
        System.out.println("Readings = " + readings);
        System.out.println("Exercises = " + exercises);
        System.out.println("Solutions = " + solutions);


        System.out.println("Total documents = " + documentsList.size());
    }

    @Override
    public void testInsert() throws IllegalStateException {
        System.out.println("\n----------------------> Test insert");
        try {
            int i = 1;
            Document testReading = new Reading(getCurrentUnit(), LocalDate.now(), Document.Format.P, "How to throw an exception", "saverio martini", 0);
            getCurrentUnit().getDocuments().add(testReading);
            System.out.println("Test insert n " + i + " success!");
            i++;
            System.out.println("\n---------------------- Test insert n " + i);
            Document testPresentation = new Presentation(getCurrentUnit(), LocalDate.now(), Document.Format.P, "GES-63-31.1-SDA_C2.2_Try and Catch em all", "Exceptions", 0);
            getCurrentUnit().getDocuments().add(testPresentation);
            System.out.println("Test insert n " + i + " success!");
            i++;
            System.out.println("\n---------------------- Test insert n " + i);
            Document testPresentation2 = new Presentation(getCurrentUnit(), LocalDate.now(), Document.Format.O, "GES-63-31.1-SDA_C2.2_Try and Catch em all", "Exceptions", 0);
            getCurrentUnit().getDocuments().add(testPresentation2);
            System.out.println("Test insert n " + i + " success!");
            //i++;


            // feel free to add as many test as you want -> do not forget to fix the format in the last test!

        } catch (Document.InvalidFormatException e) {
            throw new IllegalStateException(e.getMessage());
        }


    }
}

