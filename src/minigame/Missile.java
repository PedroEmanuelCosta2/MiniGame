
package minigame;

import specifications.Spec;

public class Missile implements Spec{
    private int x;
    private int y;
    private int width;
    private int height;
    private int vitesse = 4;

    public Missile(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void move(){
        x += vitesse;
    }
    
     public boolean dead(){
        if (x>GAME_WIDTH){
            return true;
        }else{
            return false;
        }
    }
     
    public boolean collision(Asteroides a) {
        if ((x >= a.getX() + a.getWidth()) // trop à droite
                || (x + width <= a.getX()) // trop à gauche
                || (y >= a.getY() + a.getHeight()) // trop en bas
                || (y + height <= a.getY())) // trop en haut
        {
            return false;
        } else {
            return true;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
