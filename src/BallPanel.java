import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by michael_hopps on 10/26/17.
 */
public class BallPanel extends JPanel {

    private Ball theBall;

    public BallPanel(int w, int h) {
        setSize(w, h);
        theBall = new Ball(400, 400, 5, 7);

        Timer timer = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //called 60x per second!

                theBall.move(getWidth(), getHeight());
                repaint();
            }
        });
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);  //needed if you have the streak.
        Graphics2D g2 = (Graphics2D)g;

        theBall.draw(g2);

    }
}
