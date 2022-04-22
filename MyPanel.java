import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.MouseListener;


public class MyPanel extends JPanel {

    gol canvaGol;
    int height=50, width=50; //set dimensions here
    boolean auto = false;
    private Timer t;

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screensize.height;
    int screenWidth = screensize.width;

    MyPanel(){

        this.setPreferredSize(new Dimension(width*25,height*25));
        this.canvaGol = new gol(height, width);
//        this.canvaGol = new gol("test", false);

        t = new Timer(300, new MoveListener());
    }


    public void paint(Graphics g) {
  
        Graphics2D g2D = (Graphics2D) g;
        // gol canvaGol = new gol(200, 200);

        for(int i = 0; i< canvaGol.getNumRow(); i++){
            for( int j = 0; j<canvaGol.getNumColumn();j++){
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

        t.start();

        //

        // addMouseListener(new MouseInputAdapter(){
        //     public void mousePressed(MouseEvent e){
        //         g2D.fillOval(30, 30, 30, 70);
                

        //     }
        // });
        

        
     
    }

      private class MoveListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
//                while (!canvaGol.isStable()){
                    canvaGol.iterate();
                    repaint();
            }
        }
}
