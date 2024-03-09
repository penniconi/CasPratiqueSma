package ch.heg.ig.sda.caspratique.sma.service;

import ch.heg.ig.sda.caspratique.sma.business.Document;
import ch.heg.ig.sda.caspratique.sma.datastructure.ArrayList;

/**
 *
 * @author SMA
 */


public interface IDocumentService {

    /**
     * F0 = unitInitialize : Initialize notre unité
     */

    void unitInitialize() throws Exception;



    /**
     * F1 = listAllDocuments : Affiche tous les documents triés par date de création.
     */

    void listAllDocuments(ArrayList<Document> documentList);




    /**
     * F1.1 = listPrintableDocs : Affiche tous les documents en format digital triés par date de création.
     */

    void listPrintableDocuments(ArrayList<Document> documentList);




    /**
     * F2 = unitOverview : Affiche une liste des listes pour chaque type de document stocké dans la liste.
     *
     * @param documentsList = unité
     */

    void unitOverview(ArrayList <Document> documentsList);

    /**
     * F3 = testInsertReading : ajout un document "reading" en format "O" pour catcher l'exception "Invalid Format"
     */

    void testInsertReading();


}




