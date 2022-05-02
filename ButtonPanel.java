import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    Button stepButton, runButton, stopButton;
    MyPanel gridPanel;

    ButtonPanel(JFrame frame, MyPanel gridPanel){

        this.gridPanel = gridPanel;

        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");

        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);

        stepButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);

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


    }
}
