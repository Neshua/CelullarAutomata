import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ButtonPanel extends JPanel implements ActionListener {

    Button stepButton, runButton, stopButton, switchModeButton, resetButton, saveButton, loadButton;
    MyPanel gridPanel;
//    JSlider probSlider;

//    private static int probMin = 0, probMax = 100, probDefault = 45;


    ButtonPanel(JFrame frame, MyPanel gridPanel){

        this.gridPanel = gridPanel;

        stepButton = new Button("Step");
        runButton = new Button("Run");
        stopButton = new Button("Stop");
        resetButton = new Button("Reset");
        switchModeButton = new Button("Switch");
        saveButton = new Button("Save");
//        loadButton = new Button("Load");
//        probSlider = new JSlider(JSlider.HORIZONTAL, probMin, probMax, probDefault);



        //this.setLayout(new FlowLayout());

        this.add(stepButton);
        this.add(runButton);
        this.add(stopButton);
        this.add(resetButton);
        this.add(switchModeButton);
        this.add(saveButton);
//        this.add(loadButton);

        stepButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        switchModeButton.addActionListener(this);
        saveButton.addActionListener(this);
//        loadButton.addActionListener(this);


        this.setBounds(gridPanel.getPreferredSize().width, 10, 100, 250);


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

        else if (buttonClicked.equals(resetButton)){
            gridPanel.reset();
        }

        else if (buttonClicked.equals(saveButton)){
            gridPanel.canvaGol.saveMatrix();
        }

//        else if (buttonClicked.equals(loadButton)){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Type filename of save:\n");
//            gridPanel.canvaGol.testBoard(scanner.nextLine());
//        }

    }

//    public void slideChange(ChangeEvent e){
//        if (!probSlider.getValueIsAdjusting()){
//            gridPanel.canvaGol.setProbability(probSlider.getValue());
//        }
//    }

}
