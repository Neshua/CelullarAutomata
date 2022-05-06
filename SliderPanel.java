import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPanel extends JPanel implements ChangeListener {

    MyPanel gridPanel;
    JSlider probSlider;
    JLabel sliderLabel;
    JTextField valueInput;

    private static int probMin = 0, probMax = 100, probDefault = 45;

    SliderPanel(JFrame frame, MyPanel gridPanel, ButtonPanel buttonPanel){
        this.gridPanel = gridPanel;
        probSlider = new JSlider(JSlider.HORIZONTAL, probMin, probMax, probDefault);
        sliderLabel = new JLabel();
        valueInput = new JTextField();

        this.add(probSlider);
        this.add(sliderLabel);
        this.add(valueInput);

        probSlider.addChangeListener(this);

        this.setBounds(gridPanel.getPreferredSize().width, buttonPanel.getHeight(), buttonPanel.getWidth(), 50);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        sliderLabel.setText("Probability a Cell with Initialize Alive = " + probSlider.getValue());
    }
}
