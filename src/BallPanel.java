import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by michael_hopps on 10/26/17.
 */
public class BallPanel extends JPanel {

    private Ball[] theBalls;
    private int counter;

    public BallPanel(int w, int h){
        setSize(w, h);

        //initialize theBalls array.
        //first, create the array
        //second, make new Ball objects and put them in the array
        theBalls = new Ball[500];
        for (int i = 0; i < theBalls.length; i++) {
            int x = (int)(Math.random()*getWidth());
            int y = (int)(Math.random()*getHeight());
            int vx = (int)(Math.random()*17-8);
            int vy = (int)(Math.random()*17-8);
            theBalls[i] = new Ball(getWidth()/2-25,getHeight()/2-25, vx, vy);
        }


        Timer timer = new Timer(1000/60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //anything in here happens 60 times per sec.
                counter++;
                for(Ball b: theBalls) {
                    b.move(getWidth(), getHeight());
                }

//                //every 120 frames, every ball gets a new color
//                if(counter % 120 == 0){
//                    for(Ball b: theBalls)
//                        b.randomColor();
//                }

                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);  //needed if you have the streak.
        Graphics2D g2 = (Graphics2D)g;

        g2.setStroke(new BasicStroke(3));
        for(Ball b: theBalls) {
            b.draw(g2);
        }
    }
}
