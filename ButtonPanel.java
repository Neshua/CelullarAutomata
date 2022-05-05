import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {

    Button stepButton, runButton, stopButton, switchModeButton, resetButton;
    MyPanel gridPanel;

    ButtonPanel(JFrame frame, MyPanel gridPanel){

        this.gridPanel = gridPanel;

        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");
        resetButton = new Button("Reset");
        switchModeButton = new Button("Switch");


        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);
        this.add(resetButton);
        this.add(switchModeButton);

        stepButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        switchModeButton.addActionListener(this);

        this.setBounds(gridPanel.getPreferredSize().width, 10, 100, 150);


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

        else if(buttonClicked.equals(stopButton)){

            if(!gridPanel.cave){
                gridPanel.cave = true;
            }
        }

        else if(buttonClicked.equals(switchModeButton)){

            if(gridPanel.cave){
                gridPanel.cave = false;
            }
            else{
                gridPanel.cave = true;
            }
        }


    }
}
