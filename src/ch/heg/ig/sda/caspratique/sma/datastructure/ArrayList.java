package ch.heg.ig.sda.caspratique.sma.datastructure;



/**
 *
 * @author maximili.jeannere
 * ArrayList contenant des intances de type Document de taille fixe.
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY=16;

    private E[] elements; // Tableau pour stocker des Person
    private int size = 0; // Nombre d'éléments

    // Constructeurs

    public ArrayList( ) {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructeur de capacité donnée.
     * @param capacity Capactité du tableau
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return elements[i];
    }

    @Override
    public E set(int i, E E) {
        checkIndex(i, size);
        E temp = elements[i];
        elements[i] = E;
        return temp;
    }

    @Override
    public void add(int i, E Element) {

        // Vérifie la validité de l'index
        // Une arraylist stocke des éléments contigus, cette méthode permet d'éliminer une insertion à un index trop lointain
        this.checkIndex(i, this.size + 1);

        // Vérifie si le tableau à encore de la place
        this.checkCapacity();

        for(int j = this.size-1; j >= i; j--){ // Déplacement des éléments vers la droite, le plus à droite en 1er.
            this.elements[j+1] = this.elements[j];
        }

        this.elements[i] = Element; // Place libre pour le nouvel élément

        this.size++;

    }

    @Override
    public void add(E E) {
        this.add(size, E);
    }

    @Override
    public E remove(int i) {
        checkIndex(i, size);

        E temp = elements[i];

        for(int j=i; j < size-1;j++){ // Décale les éléments vers la gauche pour remplir le trou
            elements[j] = elements[j+1];
        }

        elements[this.size-1] = null; // candidat au garbage collector
        this.size--;

        return temp;
    }

    // Utilitaires

    /** Vérifie si l'indice donné est dans la plage [0, n].
     IndexOutOfBoundsException pour signaler un indice non valide en argument. */
    public void checkIndex(int i, int n) {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    /** Vérifie si le tableau à de la place disponible.
     IllegalStateException signale qu'une méthode a été invoquée à un moment illégal ou inapproprié.*/
    public void checkCapacity(){
        if (this.size() == elements.length)
            throw new IllegalStateException("Array is full");
    }






}
