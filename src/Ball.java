import java.awt.*;

/**
 * Created by michael_hopps on 10/17/16.
 */
public class Ball {

    private int x, y, vx, vy, diameter;
    private Color color;

    public Ball(int x, int y, int vx, int vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        diameter = 50;
        randomColor();
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fillOval(x, y, diameter, diameter);
    }

    public void move(int w, int h){


        x += vx;
        y += vy;
    }

    public void randomColor(){
        int r = (int)(Math.random()*256); //[0,255]
        int g = (int)(Math.random()*256); //[0,255]
        int b = (int)(Math.random()*256); //[0,255]

        Color rColor = new Color(r, g, b);
        color = rColor; //rather than return, assign to instance fields
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setVX(int newVX){
        vx = newVX;
    }

    public void setVY(int newVY){
        vy = newVY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }
}
