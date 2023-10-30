package FemtonSpel_v_2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class FemtonGraphics extends JFrame implements ActionListener, MouseListener {

    ArrayList<Bricks> bricksList = new ArrayList<>();

    int nrOfBricks = 6;
    int blackBrickStartPosition = nrOfBricks * nrOfBricks;
    int blackBrickCurrentPosition;
    final int PLAYAREASIZE = 400;
    JPanel femtonPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JButton startKnapp = new JButton("Nytt spel");
    GridLayout gameAreaLayout = new GridLayout(nrOfBricks, nrOfBricks, 1, 1);
    Border gameAreaBorder = new LineBorder(Color.black, 3);

    public FemtonGraphics() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(PLAYAREASIZE + 200, PLAYAREASIZE + 200));

        femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE, PLAYAREASIZE));
        femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
        femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());
        femtonPanel.setBorder(gameAreaBorder);
        femtonPanel.setLayout(gameAreaLayout);
        inputPanel.add(startKnapp);
        startKnapp.addActionListener(this);
        //startKnapp.addActionListener(new Drivers(bricksList, inputPanel));
        inputPanel.setLayout(new FlowLayout());

        add(femtonPanel);
        add(inputPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        FemtonSetup fs = new FemtonSetup(nrOfBricks, 0);
        bricksList = fs.createBricksObjectsAndList(femtonPanel);
        setListeners();
        moveBricks();

    }

    public void newGame() {
        Collections.shuffle(bricksList);
        moveBricks();
        setBlackBrickPosition();
    }

    public void setListeners(){
        for (Bricks br : bricksList) {
            br.getBrick().addMouseListener(this);
        }
    }

    public void setBlackBrickPosition() {
        int counter = 0;
        for (Bricks br : bricksList) {
            if (br.getStartPosition() == blackBrickStartPosition) {
                blackBrickCurrentPosition = counter;
                break;
            }
            counter++;
        }
    }


    public void moveBricks() {
        try {
            femtonPanel.removeAll();
            for (Bricks br : bricksList) {
                femtonPanel.add(br.getBrick());
            }
            femtonPanel.revalidate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        setBlackBrickPosition();
        checkIfGameWon();
    }

   /* public void gameWon(){
        boolean arraySorted = true;

        for (int i = 0; i < bricksList.size() - 1; i++) {
            String currentText = bricksList.get(i).getText();
            String nextText = bricksList.get(i + 1).getText();

            if (!currentText.isEmpty() && !nextText.isEmpty()) {
                int currentValue = Integer.parseInt(currentText);
                int nextValue = Integer.parseInt(nextText);

                if (currentValue > nextValue) {
                    arraySorted = false;
                    break;
                }
            }
        }
        if (arraySorted) {
            JOptionPane.showMessageDialog(this, "Grattis, du vann spelet!");
            //createGame();
        }
    }*/

    public void checkIfGameWon() {
        boolean arraySorted = true;

        for (int i = 0; i < bricksList.size() - 1; i++) {

            int currentValue = bricksList.get(i).getStartPosition();
            int nextValue = bricksList.get(i + 1).getStartPosition();

            if (currentValue > nextValue) {
                arraySorted = false;
                break;
            }
        }
        if (arraySorted) {
            JOptionPane.showMessageDialog(this, "Grattis, du vann spelet!");
            //createGame();
        }
    }

    public void moveIfMovable(Bricks br) {
        //int indexOf16 = bricksList.indexOf(ruta16);
        int indexOf16 = blackBrickCurrentPosition;
        int indexOfThis = bricksList.indexOf(br);
        System.out.println("Nr: " + br.getStartPosition() + " is at: " + indexOfThis);
        System.out.println("Nr16 is at: " + indexOf16);

        //if((indexOfThis+1 == indexOf16 && (indexOfThis+1)%4 != 0) || indexOfThis-1 == indexOf16) {
        if ((indexOfThis + 1 == indexOf16 && (indexOfThis + 1) % nrOfBricks != 0) || (indexOfThis - 1 == indexOf16 && (indexOf16 + 1) % nrOfBricks != 0)) {
            Collections.swap(bricksList, indexOf16, indexOfThis);
            moveBricks();
        }

        if ((indexOfThis + nrOfBricks == indexOf16) || indexOfThis - nrOfBricks == indexOf16) {
            Collections.swap(bricksList, indexOf16, indexOfThis);
            moveBricks();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startKnapp) {
            newGame();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Klicked");
        for(Bricks br: bricksList){
            if(e.getSource().equals(br.getBrick())){
                System.out.println("Nr: " + br.getStartPosition());
                moveIfMovable(br);
                break;
            }
        }
        //moveIfMovable(e.getClass());
        checkIfGameWon();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
