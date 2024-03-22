package ch.heg.ig.sda.caspratique.service;

import ch.heg.ig.sda.caspratique.business.Unit;
import ch.heg.ig.sda.caspratique.business.Document;
import ch.heg.ig.sda.caspratique.datastructure.List;

/**
 *
 * @author SMA
 */


public interface IDocumentService {

    List<Unit> getUnits();
    Unit getCurrentUnit();

    /**
     * F0 = unitInitialize : Initialize notre unité
     */

    void unitInitialize() throws IllegalStateException;

    void addUnit(String title);
    void unitsCount();
    void addPrintableDocument(String type, char format, String title, String specification, int pages);

    /**
     * F1 = listAllDocuments : Affiche tous les documents
     */

    void listAllDocuments(List<Document> documentList);




    /**
     * F1.1 = listPrintableDocs : Affiche tous les documents en format PDF
     */

    void listPrintableDocuments(List<Document> documentList);




    /**
     * F2 = unitOverview : Affiche une liste des listes pour chaque type de document stocké dans la liste.
     *
     * @param documentsList = unité
     */

    void unitOverview(List<Document> documentsList);

    /**
     * F3 = testInsert : ajout un document "reading"  en format "O" pour catcher l'exception "Invalid Format"et relancer l'exception "Ilegal State"
     */

    void testInsert();

}




