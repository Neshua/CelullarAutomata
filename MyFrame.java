import javax.swing.JFrame;
import java.awt.*;


public class MyFrame extends JFrame {
    MyPanel panel;
    ButtonPanel buttonPanel;
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

    // gol mygol;
 
    MyFrame(){

        this.setSize(new Dimension((int) (screensize.width * .5), (int) (screensize.height *.005)));

        panel = new MyPanel();
        buttonPanel = new ButtonPanel(this);

        // mygol = new gol(500,500);
        // mygol.generate();

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         this.add(buttonPanel);
         this.add(panel);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);

  
    }

    
    MyFrame(String title){
        super(title);
    }
}
