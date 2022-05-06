import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ButtonPanel extends JPanel implements ActionListener {

    Button stepButton, runButton, stopButton, switchModeButton, resetButton, saveButton, loadButton, ruleButton;
    MyPanel gridPanel;


    ButtonPanel(JFrame frame, MyPanel gridPanel){

        this.gridPanel = gridPanel;

        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");
        resetButton = new Button("Reset");
        switchModeButton = new Button("Mode: " + modeLabel());
        ruleButton = new Button("Change to: " + ruleLabel());
        saveButton = new Button("Save");
        loadButton = new Button("Load");

        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);
        this.add(resetButton);
        this.add(switchModeButton);
        this.add(ruleButton);
        this.add(saveButton);
        this.add(loadButton);

        stepButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        switchModeButton.addActionListener(this);
        ruleButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

        this.setBounds(gridPanel.getPreferredSize().width, 10, 150, 350);
    }

    private String modeLabel(){
        if (gridPanel.getMode()){
            return "Cave";
        } else {
            return "Surface";
        }
    }

    private String ruleLabel(){
        if (gridPanel.canvaGol.getRule().equals("Simple")){
            return "Conway";
        } else {
            return "Simple";
        }
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

        else if(buttonClicked.equals(switchModeButton)){
            gridPanel.setMode();
            switchModeButton.setLabel("Mode: "+ modeLabel());
            if (gridPanel.canvaGol.isStable()){
                gridPanel.repaint();
            }
        }

        else if(buttonClicked.equals(ruleButton)){
            if (gridPanel.canvaGol.getRule().equals("Simple")){
                gridPanel.canvaGol.setRule("Conway");
            } else {
                gridPanel.canvaGol.setRule("Simple");
            }
            ruleButton.setLabel("Change to: " + ruleLabel());
        }

        else if (buttonClicked.equals(resetButton)){
            gridPanel.reset();
            gridPanel.t.stop();
        }

        else if (buttonClicked.equals(saveButton)){
            gridPanel.canvaGol.saveMatrix();
        }

        else if (buttonClicked.equals(loadButton)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type filename of save:\n");
            gridPanel.loadData(scanner.nextLine());
        }

    }

}
