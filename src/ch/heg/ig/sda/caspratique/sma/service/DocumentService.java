package ch.heg.ig.sda.caspratique.sma.service;


import ch.heg.ig.sda.caspratique.sma.business.*;
import ch.heg.ig.sda.caspratique.sma.datastructure.ArrayList;


import java.time.LocalDate;

public class DocumentService implements IDocumentService {




    private Unit myUnit; //encapsulation
    public Unit getMyUnit() {
        return myUnit;
    }


    @Override
    public void unitInitialize() throws Exception {
        System.out.println("\n----------------------> Initialize");

        ArrayList<Document> myFakeDatabase = new ArrayList<>();

        Unit myUnit = new Unit("Advanced Data Structures", myFakeDatabase);

        Document document0 = new Presentation(1, myUnit, LocalDate.of(2024, 02, 20), Document.Format.P, "GES-63-31.1-SDA_C1.2_POO-SDA", "Object Oriented Programmation and Advanced Data Structures Basis", 25);
        myFakeDatabase.add(0, document0);

        Document document1 = new Exercice(101, myUnit, LocalDate.of(2024, 2, 20), Document.Format.P, 1, (Presentation) document0);
        myFakeDatabase.add(1, document1);

        Document document2 = new Reading(201, myUnit, LocalDate.of(2024, 2, 20), Document.Format.P, "Programmer en Java (Dellanoy, 2008 chap.1)", "Dellanoy Claude", 25);
        myFakeDatabase.add(2, document2);

        Document document3 = new Solution(301, myUnit, LocalDate.of(2024, 2, 26), Document.Format.O, (Exercice) document1);
        myFakeDatabase.add(3, document3);

        Document document4 = new Presentation(2, myUnit, LocalDate.of(2024, 2, 27), Document.Format.P, "GES-63-31.1-SDA_C2.1_StructureDeDonnees_List", "List", 21);
        myFakeDatabase.add(4, document4);

        Document document5 = new Presentation(3, myUnit, LocalDate.of(2024, 2, 27), Document.Format.P, "GES-63-31.1-SDA_C2.2_Exceptions", "Exceptions", 8);
        myFakeDatabase.add(5, document5);

        Document document6 = new Exercice(102, myUnit, LocalDate.of(2024, 2, 27), Document.Format.P, 2, (Presentation) document4);
        myFakeDatabase.add(6, document6);

        Document document7 = new Solution(302, myUnit, LocalDate.of(2024, 3, 4), Document.Format.O, (Exercice) document6);
        myFakeDatabase.add(7, document7);

        Document document8 = new Presentation(4, myUnit, LocalDate.of(2024, 3, 5), Document.Format.P, "GES-63-31.1-SDA_C3.1_Genericité", "Generics", 8);
        myFakeDatabase.add(8, document8);

        Document document9 = new Exercice(102, myUnit, LocalDate.of(2024, 3, 5), Document.Format.P, 2, (Presentation) document8);
        myFakeDatabase.add(9, document9);

        Document document10 = new Solution(303, myUnit, LocalDate.of(2024, 3, 5), Document.Format.O, (Exercice) document9);
        myFakeDatabase.add(10, document10);

        myUnit.setDocuments(myFakeDatabase);

        this.myUnit = myUnit;

        System.out.println("\ninitializing... \nsuccess!\nUnit content: " + myUnit.getDocuments().size() + " documents at the moment");
        System.out.println(myUnit);
    }

    @Override
    public void listAllDocuments(ArrayList<Document> documentList) {
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
    public void listPrintableDocuments(ArrayList<Document> documentList) {
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
    public void unitOverview(ArrayList<Document> documentsList) {
        System.out.println("\n----------------------> Unit overview");


        int presentations = 0, readings = 0, exercices = 0, solutions = 0;

        for (int i = 0; i < documentsList.size(); i++) {
            String className = documentsList.get(i).getClass().getSimpleName();

            switch (className) {
                case "Presentation" -> presentations++;
                case "Reading" -> readings++;
                case "Exercice" -> exercices++;
                case "Solution" -> solutions++;
            }
        }


        System.out.println("Presentations = " + presentations);
        System.out.println("Readings = " + readings);
        System.out.println("Exercices = " + exercices);
        System.out.println("Solutions = " + solutions);


        System.out.println("Total documents = " + documentsList.size());
    }

    @Override
    public void testInsertReading() {
        System.out.println("\n----------------------> Test insert");
        try {
            Reading testReading = new Reading(101,getMyUnit(), LocalDate.now(), Document.Format.O,"How to throw an exception","saverio martini",0);
            getMyUnit().getDocuments().add(testReading);
        }
        catch (Exception exception) {
            System.out.println("\nDocument creation failed: Reading documents must be in PDF!\n");
        }
    }
}

