package Projet;

public class Coordoner implements Comparable<Coordoner> {

    int x;
    int y;

    /**
     * @author Pierre-Francois Hau
     * @param x
     * Coordonner x
     * @param y
     * Coordonner y
     */
    public  Coordoner (int x,int y){
        this.x=x;
        this.y=y;
    }

    /**
     * @author Pierre-Francois Hau
     * @param i
     * l'entier i que l'on souhaite augmenter a x
     */

    public void augmenterX(int i) {
        this.x=x+i;
    }

    /**
     * @author Pierre-Francois Hau
     * @param i
     * l'entier i que l'on souhaite augmenter a y
     */
    public void augmenterY(int i){
        this.y=y+i;
    }

    /**
     * @author Pierre-Francois Hau
     * @param c
     * Coordonner c a laquel on souhaite comparer la coordonner choisi
     * @return -1 si la Coordoner souhaiter est inferieur
     */
    public int compareTo(Coordoner c){

     if(c==null){
         return 0;
     }
            if(this.getX()<c.getX()){
                return 1;
            }else{
                if (this.getX()>c.getX()){
                    return -1;
                }else{
                    if (this.getY()<c.getY()){
                        return 1;
                    }else{
                        if(this.getY()>c.getY()){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
            }


    }

    /**
     * @author Pierre-Francois Hau
     * @return l'entier x
     */
    public int getX() {
        return x;
    }

    /**
     * @author Pierre-Francois Hau
     * @param x
     * l'entier x que l'on souhaite mettre en Coordonner x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @author Pierre-Francois Hau
     * @return l'entier y
     */
    public int getY() {
        return y;
    }

    /**
     * @author Pierre-Francois Hau
     * @param y
     * l'entier y que l'on souhaite mettrz zn Coordonner y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @author Pierre-Francois Hau
     * @return la coordoner souhaiter sous forme de String
     */
    public String toString(){
        String str =x+" "+y;
        return str;
    }
}

