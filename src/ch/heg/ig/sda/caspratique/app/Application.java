package ch.heg.ig.sda.caspratique.app;

import ch.heg.ig.sda.caspratique.service.DocumentService;
import ch.heg.ig.sda.caspratique.service.IDocumentService;

public class Application {
    public static void main(String[] args) throws IllegalStateException {
        System.out.println("Hello! ");

        IDocumentService yourService = new DocumentService();

        yourService.unitInitialize();
        yourService.listAllDocuments(yourService.getCurrentUnit().getDocuments());
        yourService.listPrintableDocuments(yourService.getCurrentUnit().getDocuments());
        yourService.unitOverview(yourService.getCurrentUnit().getDocuments());
        yourService.unitsCount();


        yourService.addUnit("63-31 .2 Patterns et librairies");
        yourService.unitsCount();
        System.out.println(yourService.getCurrentUnit());
        yourService.listAllDocuments(yourService.getCurrentUnit().getDocuments());



        try {
            yourService.testInsert();
        } catch (IllegalStateException ise) {
            System.out.println("\nOh no! Test insert has failed... Error: " + ise.getMessage());
        }

        yourService.unitOverview(yourService.getCurrentUnit().getDocuments());

        // scenario1 -> l'user est interpellé via un scanner et fait tout juste:
        yourService.addPrintableDocument("Presentation",'P',"00_Theorie_Intro_Patterns_Librairies","Intro",1);

        // scenario2 -> l'user est interpellé via un scanner et essaye d'inserer un document autre que presentation ou reading:
        yourService.addPrintableDocument("Solution",'P',"the solution of all problems","magic",1);

        // scenario3 -> l'user est interpellé via un scanner et fait une faute d'insertion de format:
        yourService.addPrintableDocument("Presentation",'O',"00_Theorie_Patterns_Librairies","Patterns and Libraries",1);

        // scenario4 -> l'user est interpellé via un scanner et fait tout juste, mais c'est le body de la methode qui est mal codée:
        yourService.addPrintableDocument("Reading",'P',"Patterns of Enterprise Application Architecture","M.Fowler",389);

        // oui, on a fait abstraction du scanner :)



        yourService.unitOverview(yourService.getCurrentUnit().getDocuments());
        yourService.listPrintableDocuments(yourService.getCurrentUnit().getDocuments());//juste pour checker le tests




        System.out.println("\n----------------------> Terminate");
        System.out.println("\nGoodbye!");
    }
}
