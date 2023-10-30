package FemtonSpel_v_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FemtonGraphics extends JFrame implements ActionListener {

    ArrayList<Bricks> bricksList = new ArrayList<>();


    final int PLAYAREASIZE = 400;
    JPanel femtonPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JButton startKnapp = new JButton("Nytt spel");
    GridLayout gameAreaLayout = new GridLayout(4, 4, 0, 0);

    public FemtonGraphics() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(PLAYAREASIZE + 200, PLAYAREASIZE + 200));

        femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE, PLAYAREASIZE));
        femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
        femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());

        femtonPanel.setLayout(gameAreaLayout);
        inputPanel.add(startKnapp);
        //startKnapp.addActionListener(this);
        startKnapp.addActionListener(new Drivers(bricksList, femtonPanel));
        inputPanel.setLayout(new FlowLayout());

        add(femtonPanel);
        add(inputPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        FemtonSetup fs = new FemtonSetup(4,0);
        bricksList = fs.createBricksObjectsAndList();
        moveBricks();

    }

    public void moveBricks(){
        try {
            femtonPanel.removeAll();
            for (Bricks br : bricksList) {
                femtonPanel.add(br.getBrick());
            }
            femtonPanel.revalidate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startKnapp){
            moveBricks();
        }
    }
}
