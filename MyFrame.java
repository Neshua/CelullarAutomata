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

         System.out.println(panel.getHeight());
         this.setSize(new Dimension(buttonPanel.getX() + buttonPanel.getWidth(),panel.getPreferredSize().height));
         this.setLocationRelativeTo(null);
         this.setVisible(true);

  
    }

    
    MyFrame(String title){
        super(title);
    }
}
