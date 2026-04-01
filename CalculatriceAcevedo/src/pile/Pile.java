package pile;

public class Pile<E> {
    private int maxElements = 1000;
    private E elements[];
    private int sommet;

    public Pile() {
        this.elements = (E[]) new Object[maxElements];
        this.sommet = -1;
    }

    public void empiler(E nouvElem) {
        if (this.sommet == (this.maxElements - 1)) {
            System.out.println("Desole, la pile est pleine!");
        } else {
            this.sommet = this.sommet + 1;
            this.elements[this.sommet] = nouvElem;
        }
    }

    public E depiler() {
        if (this.sommet < 0) {
            System.out.println("Errreur: la pile est vide, on ne peut pas depiler!");
            return null;
        } else {
            E elemDuHaut = this.elements[sommet];
            this.sommet = this.sommet - 1;
            return elemDuHaut;
        }
    }

    public boolean estVide() {
        return this.sommet < 0;
    }

    public E getSommet() {
        return this.elements[this.sommet];
    }

    public static void main(String[] args) {
        Pile<Integer> p = new Pile<>();
        p.empiler(6);
        p.empiler(2);
        p.empiler(5);
        p.depiler();
        System.out.println(p.getSommet());
    }
}
