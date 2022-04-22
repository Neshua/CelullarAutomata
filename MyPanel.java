import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel {

    gol canvaGol;

    MyPanel(){
        this.setPreferredSize(new Dimension(50,50));
        this.canvaGol = new gol(200, 200);



    }


    public void paint(Graphics g) {
  
        Graphics2D g2D = (Graphics2D) g;
        // gol canvaGol = new gol(200, 200);

        for(int i = 0; i< 25; i++){
            for( int j = 0; j<25;j++){
                if (canvaGol.getBoard()[i][j] == 1){
                    g2D.setPaint(Color.green);
                    g2D.fillRect(i*25, j*25, 25, 25);
                    
                }
                else{
                    g2D.setPaint(Color.blue);
                    g2D.fillRect(i*25, j*25, 25, 25);
                    
                }
                g2D.setColor(Color.gray);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawRect(i*25, j*25, 25, 25);

            }
        } 


        // addMouseListener(new MouseInputAdapter(){
        //     public void mousePressed(MouseEvent e){
        //         g2D.fillOval(30, 30, 30, 70);
                

        //     }
        // });

        
     
    }
}
