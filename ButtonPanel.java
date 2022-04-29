import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    Button stepButton, runButton, stopButton;

    ButtonPanel(JFrame frame, JPanel gridPanel){


        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");

        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);

        //System.out.println(gridPanel.getPreferredSize().width );
        this.setBounds(gridPanel.getPreferredSize().width, 10, 100, 100);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent){

        JButton buttonClicked = (JButton) actionEvent.getSource();

        if(buttonClicked.equals(stepButton)){
            //Step once through iteration

            System.out.println("LEFT FOOT TWO STEPS ... SLIDED TO THE RIGHT!!!... CRIS CROSS!! ... CHA CHA REAL SMOOTH ");
        }
        else if(buttonClicked.equals(runButton)){
            // run through entire iteration
            // run through entire iteration
            System.out.println("RUN RUN .. RUN RUN ... CAN'T KEEP RUNNING AWAAAAY ");
        }
        else if(buttonClicked.equals(stopButton)){
            // run through entire iteration
            System.out.println("STOP ... WAIT A MINUTE!!! ");
        }


    }
}
