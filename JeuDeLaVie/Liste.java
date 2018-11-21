package Projet;
import java.io.*;

public class Liste <T extends Maillon> {

    private T first;

    /**
     * @author Pierre-Francois Hau
     */
    public Liste (){
        first=null;

    }

    /**
     * @author Pierre-Francois Hau
     * @param m
     * element m de type T que l'on souhaite placer en premiere element de la liste
     */
    public Liste (T m){
        first=m;
    }

    /**
     * @author Pierre-Francois Hau
     * @return true si la liste est vide, false sinon
     */
    public boolean vide(){
        return first == null;
    }

    /**
     * @author Pierre-Francois Hau
     * @return le premier element de la liste
     */
    public  T getFirst() {
        return first;
    }

    /**
     * @author Pierre-Francois Hau
     * @param first
     * element de type T que l'on souhaite placer a l'element first
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * @author Pierre-Francois Hau
     * @param addition
     * element de type T que l'on souhaite ajouter  la Liste souhaiter
     */
    public void add(T addition)
    {
        if(first == null || first.compareTo (addition)== -1)
        {
            T temp = first;
            first = addition;
            first.setSuivant (temp);
        }

        else
        {
            T temp = first;
            while ( temp != null)
            {
                if( temp.getSuivant () != null)
                {
                    if(temp.compareTo (addition) > -1 &&  temp.getSuivant ().compareTo (addition) < 1)
                    {
                        T conteneur = (T)temp.getSuivant ();
                        temp.setSuivant( addition);
                        addition.setSuivant(conteneur);
                        break;
                    }
                }
                else
                {
                    temp.setSuivant( addition);
                    break;
                }
                temp = (T) temp.getSuivant ();
            }
        }
    }


    /**
     * @author Pierre-Francois Hau
     * @param m
     * element de type T que l'on souhaite retirer de la Liste souhaiter
     */
    public void remove (T m)
    {
        if (first.getO ().compareTo (m.getO ()) == 0)
        {
            first = (T) first.getSuivant ();
        }
        else
        {
            //tmp-dexièm élément de la liste
            T tmp = (T) first.getSuivant ();
            //tmpPrevious-premier élément
            T précédent = first;

            while (tmp != null)
            {
                if (tmp.getO ().compareTo (m.getO ()) == 0)
                {
                    précédent.setSuivant (tmp.getSuivant ());
                    break;
                }
                précédent = (T) précédent.getSuivant ();
                tmp = (T) tmp.getSuivant ();

            }
        }
    }

    /**
     * @author Pierre-Francois Hau
     * @param m
     * element de type T que dont l'on souhaite verifier la presence dans la liste souhaiter
     * @return un boolean
     */
    public boolean estDans(T m) {
        Maillon tmp = this.getFirst();
        while (tmp.getSuivant()!=null) {
            if (tmp.compareTo(m) == 0) {
                return true;
            }
            tmp = tmp.getSuivant();
        }
        return false;
    }

    /**
     * @author Khomenko Stepan
     * @return un clone de la liste
     */
    public Liste clone()
    {
        Liste listeClone = new Liste ();
        T temp = first;
        while(temp!=null)
        {
            T temporaire = (T)(new Maillon<> (temp.getO (),null));
            listeClone.add (temporaire);
            temp= (T)temp.getSuivant ();
        }
        return listeClone;
    }

    /**
     * @author Khomenko Stepan
     * @return Le String de la liste que l'on souhaite obtenire
     */
    public String toString(){

       String string="";
        T temp=first;
        while (temp!=null){
            string=string+temp.toString()+ "\n";
            temp=(T)temp.getSuivant();

        }
        return string;
    }

    @Override
    public int compareTo(Coordoner o) {
        return 0;
    }
}
