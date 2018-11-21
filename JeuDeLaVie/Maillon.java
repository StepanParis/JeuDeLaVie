package Projet;
import java.util.*;

public class Maillon <T extends Comparable<T>> implements Comparable<Maillon<T>> {
   private T o;
   private Maillon suivant;

    /**
     * @author Pierre-Francois Hau
     * @param o
     * le type T du Maillon
     * @param suivant
     * le Maillon lier au Maillon par le mot suivant indiquant qu'il est placer apres dans une liste
     */
    public Maillon(T o, Maillon suivant) {
        this.o = o;
        this.suivant = suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @return o
     */
    public T getO() {
        return o;
    }

    /**
     * @author Pierre-Francois Hau
     * @param o
     * le type T que l'on souhaite placer dans le Maillon souhaiter
     */
    public void setO(T o) {
        this.o = o;
    }

    /**
     * @author Pierre-Francois Hau
     * @return le maillon suivant du maillon souhaiter
     */
    public Maillon<T> getSuivant() {
        return suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @param suivant
     * le Maillon que l'on souhaite lier au Maillon souhaiter
     */
    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @param l
     * Maillon l avec lequel l'on souhaite verifier l'egualiter avec le Maillon souhaiter
     * @return true si le parametre est egale au maillon souhaiter et false sinon
     */
    public boolean equals(Maillon l) {
        return l.getO() == this.getO();
    }

    /**
     * @author Pierre-Francois Hau
     * @param obj
     * Maillon que l'on souhaiter comparer avec le Maillon souhaiter
     * @return -1 si le maillon est inferieur au parametre m, 0 si ils sont egaux et 1 si le parametre m est inferieur au maillon
     */
    public int compareTo(Maillon<T> obj) {

        return this.o.compareTo(obj.o);

   }

    /**
     * @author Pierre-Francois Hau
     * @return le Maillon souhaiter sous forme de String
     */
    public String toString(){
        String str =new String();
        return str = o.toString();
    }

}





