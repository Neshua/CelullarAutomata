import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyPanel panel;
    // gol mygol;
 
    MyFrame(){
    panel = new MyPanel();
    // mygol = new gol(500,500);
    // mygol.generate();
     
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     this.add(panel);
     this.pack();
     this.setLocationRelativeTo(null);
     this.setVisible(true);
    }  
}
