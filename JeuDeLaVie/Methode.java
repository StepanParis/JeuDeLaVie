package Projet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Methode {
    /**
     * @author Khomenko Stepan
     */
    //supprimer des doublons
    public static void supprimerDoublons() {
        Maillon<Coordoner> tempMaillon = Data.stockage.getFirst();
        while (tempMaillon != null) {
            Maillon<Coordoner> tempMaillon1 = Data.stockage.getFirst();
            int count = 0;
            while (tempMaillon1 != null) {
                if (tempMaillon.compareTo(tempMaillon1) == 0) {
                    count++;
                }
                if (count > 1) {
                    count--;
                    Data.stockage.remove(tempMaillon);
                }
                tempMaillon1 = tempMaillon1.getSuivant();
            }
            tempMaillon = tempMaillon.getSuivant();
        }
    }

    /**
     * @param liste Liste dont l'on souhaite afficher les cellules
     * @author Khomenko Stepan
     */
    public static void affichage(Liste<Maillon> liste) {
        final int FRAME_SIZE = 10;
        for (int x = 1; x <= FRAME_SIZE; x++) {
            for (int y = 1; y <= FRAME_SIZE; y++) {
                Maillon<Coordoner> temp = liste.getFirst();
                boolean marque = false;
                while (temp != null) {
                    if (x == temp.getO().getX() && y == temp.getO().getY()) {
                        marque = true;
                        break;
                    }
                    temp = temp.getSuivant();
                }
                if (marque) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();

        }
        System.out.println();

    }

    /**
     * @param liste liste qui devient une liste adapter pour le monde circulaire
     * @author Khomenko Stepan
     */
    public static void mondeCirculaire(Liste<Maillon> liste) {
        //размеры поля
        int xWidth = ((Coordoner) (liste.getFirst().getO())).getX();
        int yHigh = ((Coordoner) (liste.getFirst().getO())).getY();
        Maillon<Coordoner> temp = liste.getFirst();
        while (temp.getSuivant() != null) {
            temp = temp.getSuivant();
        }
        xWidth = ((Coordoner) (temp.getO())).getX() - xWidth;
        yHigh = ((Coordoner) (temp.getO())).getY() - yHigh;
        //
    }

    /**
     * @author Khomenko Stepan
     */
    public static void mondeAvecFrontieres() {
        int sizePlace = 10;
        int xStart = ((Coordoner) (Data.stockage.getFirst().getO())).getX();
        int yStart = ((Coordoner) (Data.stockage.getFirst().getO())).getY();

        Maillon<Coordoner> tempMaillon = Data.stockage.getFirst();
        while (tempMaillon != null) {
            int x = tempMaillon.getO().getX();
            int y = tempMaillon.getO().getY();
            if (x < xStart || y < yStart || x > xStart + sizePlace || y > yStart + sizePlace) {
                Data.stockage.remove(tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant();
        }
        affichage(Data.stockage);
        evolution();
        affichage(Data.stockage);

        tempMaillon = Data.stockage.getFirst();
        while (tempMaillon != null) {
            int x = tempMaillon.getO().getX();
            int y = tempMaillon.getO().getY();
            if (x < xStart || y < yStart || x > xStart + sizePlace || y > yStart + sizePlace) {
                Data.stockage.remove(tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant();
        }
        affichage(Data.stockage);
    }


    /**
     * @author Khomenko Stepan
     */
    public static void evolution() {
        Liste<Maillon> tempListe = Data.stockage.clone();
        Maillon<Coordoner> tempMaillon = Data.stockage.getFirst();

        //definir ce qu'il faut supprimer
        while (tempMaillon != null) {
            int count = 0;
            int x = tempMaillon.getO().getX();
            int y = tempMaillon.getO().getY();

            Maillon<Coordoner> tempRecherche = Data.stockage.getFirst();
            while (tempRecherche != null) {
                if (tempRecherche.getO().getX() <= (x + 1) && tempRecherche.getO().getX() >= (x - 1)
                        && tempRecherche.getO().getY() <= (y + 1) && tempRecherche.getO().getY() >= (y - 1)) {
                    count++;
                }
                tempRecherche = tempRecherche.getSuivant();
            }
            //on supprime le maillon pour lequel on a cherché les voisins car on l'a aussi calculé comme un voisin
            count--;

            if (!(count == 2 || count == 3)) {
                tempListe.remove(tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant();
        }

        Liste<Maillon> tempListeAdd = new Liste();
        tempMaillon = Data.stockage.getFirst();
        while (tempMaillon != null) {
            int x = tempMaillon.getO().getX() - 1;
            int y = tempMaillon.getO().getY() - 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int xNear = x + j;
                    int yNear = y + i;
                    if (!Data.stockage.estDans(new Maillon<>(new Coordoner(xNear, yNear), null))) {
                        int count = 0;

                        Maillon<Coordoner> tempRecherche = Data.stockage.getFirst();
                        while (tempRecherche != null) {
                            if (tempRecherche.getO().getX() <= (xNear + 1) && tempRecherche.getO().getX() >= (xNear - 1)
                                    && tempRecherche.getO().getY() <= (yNear + 1) && tempRecherche.getO().getY() >= (yNear - 1)) {
                                count++;
                            }
                            tempRecherche = tempRecherche.getSuivant();
                        }
                        if (count == 3) {
                            tempListeAdd.add(new Maillon(new Coordoner(xNear, yNear), null));
                        }
                    }
                }
            }
            tempMaillon = tempMaillon.getSuivant();
        }


        Data.stockage = tempListe;
        Maillon<Coordoner> tempMaillonAdd = tempListeAdd.getFirst();
        while (tempMaillonAdd != null) {
            Data.stockage.add(new Maillon(new Coordoner(tempMaillonAdd.getO().getX(), tempMaillonAdd.getO().getY()), null));
            tempMaillonAdd = tempMaillonAdd.getSuivant();
        }


        //supprimer les doublons
        tempMaillon = Data.stockage.getFirst();
        while (tempMaillon != null) {
            Maillon<Coordoner> tempMaillon1 = Data.stockage.getFirst();
            int count = 0;
            while (tempMaillon1 != null) {
                if (tempMaillon.compareTo(tempMaillon1) == 0) {
                    count++;
                }
                if (count > 1) {
                    count--;
                    Data.stockage.remove(tempMaillon);
                }
                tempMaillon1 = tempMaillon1.getSuivant();
            }
            tempMaillon = tempMaillon.getSuivant();
        }


    }

    /**
     * @param chemin chemain ou ce trouve le fichier
     * @throws IOException exeption input/output car nous lisons les données (readAllLines)
     * @author Khomenko Stepan
     */
    public static void lireFichier(String chemin) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(chemin), StandardCharsets.UTF_8);
        int x = 0;
        int y = 0;
        for (String line : lines) {
            if (line.compareTo("") != 0 && line.compareTo(".") != 0 && (line.substring(0, 2)).compareTo("#P") == 0) {
                String[] xy = line.split(" ");
                x = Integer.parseInt(xy[1]);
                y = Integer.parseInt(xy[2]);
            } else if (line.compareTo("") != 0 &&
                    ((line.substring(0, 1)).compareTo("*") == 0 || ((line.substring(0, 1)).compareTo(".") == 0))) {
                int temp = line.lastIndexOf('*');

                while (temp != -1) {
                    Data.stockage.add(new Maillon<Coordoner>(new Coordoner(x, y + temp), null));
                    line = line.substring(0, temp);
                    temp = line.lastIndexOf('*');
                }
                x++;
            }

        }

        supprimerDoublons();
    }

}
