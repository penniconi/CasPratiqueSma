package ch.heg.ig.sda.caspratique.sma.app;

import ch.heg.ig.sda.caspratique.sma.business.*;
import ch.heg.ig.sda.caspratique.sma.service.DocumentService;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Document Manager 1 ");




        DocumentService yourService = new DocumentService();


        yourService.unitInitialize();
        yourService.listAllDocuments(yourService.getMyUnit().getDocuments());
        yourService.listPrintableDocuments(yourService.getMyUnit().getDocuments());

        try {
            Reading testReading = new Reading(101,yourService.getMyUnit(), LocalDate.now(), Document.Format.P,"How to throw an exception","saverio martini",-1);
            yourService.getMyUnit().getDocuments().add(testReading);
        }
        catch (Exception exception) {
            System.out.println("\nDocument creation failed: Reading must be in PDF\n");
        }

        yourService.unitOverview(yourService.getMyUnit().getDocuments());




        System.out.println("\nGoodbye!\n---------------------------------------------------");
    }
}
