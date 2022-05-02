import javax.swing.JFrame;
import java.awt.*;


public class MyFrame extends JFrame {
    MyPanel panel;
    ButtonPanel buttonPanel;

    MyFrame(){

        panel = new MyPanel();
        buttonPanel = new ButtonPanel(this, panel);


         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         this.add(buttonPanel);
         this.add(panel);


         int screenX = buttonPanel.getX() + buttonPanel.getWidth();
         int screenY = (int) (panel.getPreferredSize().height + (panel.getPreferredSize().height * .05));

         System.out.println(screenY);

         this.setSize(new Dimension(screenX, screenY));
         this.setLocationRelativeTo(null);
         this.setVisible(true);

  
    }

    
    MyFrame(String title){
        super(title);
    }
}
