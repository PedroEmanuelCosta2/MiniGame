package minigame;

public class Asteroides{
    private int x;
    private int y;
    private int width;
    private int height;
    private int vitesse;

    public Asteroides(int x, int y, int width, int height, int vitesse) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vitesse = vitesse;
    }
    
    public void move(){
        x-=vitesse;
    }
    
    public boolean dead(){
        if (x<0-width){
            return true;
        }else{
            return false;
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
