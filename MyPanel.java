import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Random;


public class MyPanel extends JPanel {

    gol canvaGol;
    int height=150, width=150; //set dimensions here
    boolean auto = false;
    public Timer t;
    int cellSize = 25;
    boolean cave = true;

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screensize.height;
    int screenWidth = screensize.width;

    MyPanel() {


        this.cellSize = (625/Math.max(width, height));
        this.setPreferredSize(new Dimension(cellSize*width,cellSize*height));
        this.canvaGol = new gol(height, width);

        animate();
    }

    public void animate(){
        t = new Timer(300, new MoveListener());
    }


    public void paint(Graphics g) {
        Color beach = new Color(254, 255, 188);
        Color grass2 = new Color(0,141,5);
        Color brown = new Color(138, 93, 15);

        Graphics2D g2D = (Graphics2D) g;
        // gol canvaGol = new gol(200, 200);

        if (cave) {
            for (int i = 0; i < canvaGol.getNumRow(); i++) {
                for (int j = 0; j < canvaGol.getNumColumn(); j++) {
                    if (canvaGol.getBoard()[i][j] == 1) {
                        g2D.setPaint(brown);
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    } else if (canvaGol.getBoard()[i][j] == 2) {
                        g2D.setPaint(brown);
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    } else {
                        g2D.setPaint(Color.black);
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    }
                    g2D.setColor(Color.gray);
                    g2D.setStroke(new BasicStroke(1));
//                g2D.drawRect(i*25, j*25, 25, 25);
                    g2D.drawRect(i*cellSize, j*cellSize, cellSize, cellSize);
                }
            }
        }
        else {
            for (int i = 0; i < canvaGol.getNumRow(); i++) {
                for (int j = 0; j < canvaGol.getNumColumn(); j++) {
                    if (canvaGol.getBoard()[i][j] == 1) {
                        Random r = new Random();
                        int a = r.nextInt(2);
                        if (a == 1) {
                            g2D.setPaint(Color.green);
                        } else {
                            g2D.setPaint(grass2);
                        }
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);

                    } else if (canvaGol.getBoard()[i][j] == 2) {
                        g2D.setPaint(beach);
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                    } else {
                        g2D.setPaint(Color.blue);
//                    g2D.fillRect(i*25, j*25, 25, 25);
                        g2D.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);

                    }
                    g2D.setColor(Color.gray);
                    g2D.setStroke(new BasicStroke(1));
//                g2D.drawRect(i*25, j*25, 25, 25);
                    g2D.drawRect(i*cellSize, j*cellSize, cellSize, cellSize);
                }
            }

        }





        //t.start();

        //

        // addMouseListener(new MouseInputAdapter(){
        //     public void mousePressed(MouseEvent e){
        //         g2D.fillOval(30, 30, 30, 70);
                

        //     }
        // });



    }

      private class MoveListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canvaGol.isStable()) {
                    canvaGol.iterate();
                    repaint();
                }
            }
        }
}
