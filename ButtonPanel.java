import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    Button stepButton, runButton, stopButton, resetButton;
    MyPanel gridPanel;

    ButtonPanel(JFrame frame, MyPanel gridPanel){

        this.gridPanel = gridPanel;

        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");
        resetButton = new Button("Reset");


        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);
        this.add(resetButton);

        stepButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        this.setBounds(gridPanel.getPreferredSize().width, 10, 100, 100);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent){

        Button buttonClicked = (Button) actionEvent.getSource();

        if(buttonClicked.equals(stepButton)){
            if (!gridPanel.canvaGol.isStable()) {
                gridPanel.canvaGol.iterate();
                gridPanel.repaint();
            }

        }
        else if(buttonClicked.equals(runButton)){
            gridPanel.t.start();
        }
        else if(buttonClicked.equals(stopButton)){

            gridPanel.t.stop();
        }
//        else if(buttonClicked.equals(resetButton)){
//            gridPanel.
//        }


    }
}
