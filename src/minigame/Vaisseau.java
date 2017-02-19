package minigame;

import java.awt.event.KeyEvent;
import specifications.Spec;

/**
 *
 * @author pedro.costa
 */
public class Vaisseau implements Spec {

    //ATTRIBUTS 
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int vitesse;
    private int vie = 5;

    //CONSTRUCTEUR
    public Vaisseau(int x, int y, int width, int height, int vitesse) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vitesse = vitesse;
    }

    //FONCTIONS PLUBIQUES               
    public void move() {
        x += dx;
        y += dy;

        if (x <= 0) {
            x = 0;
        }
        if (x + width >= GAME_WIDTH) {
            x = GAME_WIDTH - width;
        }

        if (y <= 0) {
            y = 0;
        }
        if (y + height >= GAME_HEIGHT) {
            y = GAME_HEIGHT - height;
        }
    }

    public boolean dead() {
        if (vie <= 0) {
            return true;
        } else {
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
            vie--;
            return true;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = -vitesse;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = vitesse;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = -vitesse;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = vitesse;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = 0;
        }
    }

    //GETTERS
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

    public String getVie() {
        return new String(""+vie);
    }
}
