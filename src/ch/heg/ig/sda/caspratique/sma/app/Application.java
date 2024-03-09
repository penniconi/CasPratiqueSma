package ch.heg.ig.sda.caspratique.sma.app;

import ch.heg.ig.sda.caspratique.sma.service.DocumentService;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello! ");
        DocumentService yourService = new DocumentService();

        yourService.unitInitialize();
        yourService.listAllDocuments(yourService.getMyUnit().getDocuments());
        yourService.listPrintableDocuments(yourService.getMyUnit().getDocuments());
        yourService.testInsertReading();
        yourService.unitOverview(yourService.getMyUnit().getDocuments());

        System.out.println("\n----------------------> Terminate");
        System.out.println("\nGoodbye!");
    }
}
