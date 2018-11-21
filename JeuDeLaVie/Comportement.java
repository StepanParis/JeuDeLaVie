package Projet;
import java.util.Iterator;
public class Comportement {

    /**
     * @author Hau Pierre-Francois & Sow  Elhadji
     * liste de chaque étape de l'evolution du jeu.
     * @return
     * la periode
     */
      public static int calculePeriode(/* Data.a*/) {
          Liste<Maillon> liste = new Liste();//liste des generation
          liste.add(new Maillon(new Coordoner(9, 6), null));
          liste.add(new Maillon(new Coordoner(8, 6), null));
          Liste<Maillon> b = new Liste ();//liste qui contien toute les génération
          b.add (new Maillon(liste, null));
          Maillon periodeX=new Maillon(b.getFirst(),null);
          Maillon periodeY=new Maillon(b.getFirst(),null);
          int periode = 1;

            while (periodeX!=periodeY) {
                if (periodeY.getSuivant()!= null && periodeY.getSuivant().getSuivant()!=null) {
                    periodeX = periodeX.getSuivant();
                    periode++;
                    periodeY = periodeY.getSuivant().getSuivant();
                }
            }
            return periode;
        }
    /**
     * @author Hau Pierre-Francois & Sow  Elhadji
     * liste de chaque étape de l'evolution du jeu.
     * @return
     * les cellules de la génération souhaiter
     */

       public Liste calculeGeneration() {// pareille que calcule periode mais pas le même retour
           Liste<Maillon> liste = new Liste();//liste des generation
           liste.add(new Maillon(new Coordoner(9, 6), null));
           liste.add(new Maillon(new Coordoner(8, 6), null));
           Liste<Maillon> b = new Liste ();//liste qui contien toute les génération
           b.add (new Maillon(liste, null));
           Maillon periodeX=new Maillon(b.getFirst(),null);
           Maillon periodeY=new Maillon(b.getFirst(),null);

           while (periodeX!=periodeY) {
               if (periodeY.getSuivant() != null && periodeY.getSuivant().getSuivant() != null) {
                   periodeX = periodeX.getSuivant();
                   periode++;
                   periodeY = periodeY.getSuivant().getSuivant();
               }
           }
        return periodeX.getO();
    }
       /* public int taillequeue() {

            int taille_queue = 0;

            while (periode > 1) {
                genX = genX.generationX;
                genY = genY.generationY;


                taille_queue++;
            }
            return taille_queue;
        }


        //sarreter car les deux generations sont egales
        //
        public boolean Siidentique(Liste<Maillon> z) {
            boolean identique;
            int GoX = Liste.suivant().getCoorX;
            int GoY = Liste.suivant().getCoorY;
            identique = true;

            while (suivant() && identique) {
                Methodes.evolution();
            }
            return identique;

        }*/


}
