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

    int nrOfBricks = 3;
    int blackBrickStartPosition = nrOfBricks * nrOfBricks;
    int blackBrickCurrentPosition;
    final int PLAYAREASIZE = 400;
    JPanel femtonPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JButton startKnapp = new JButton("Nytt spel");
    private String sizesMeny[] = {"3x3", "4x4", "5x5", "6x6"};
    private JComboBox chooseSizeMeny = new JComboBox(sizesMeny);
    GridLayout gameAreaLayout = new GridLayout(nrOfBricks, nrOfBricks, 1, 1);
    Border gameAreaBorder = new LineBorder(Color.black, 1);
    FemtonSetup fs = new FemtonSetup(nrOfBricks, 0);

    public FemtonGraphics() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(PLAYAREASIZE + 200, PLAYAREASIZE + 200));

        femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE, PLAYAREASIZE));
        femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
        femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());
        femtonPanel.setBorder(gameAreaBorder);
        femtonPanel.setLayout(gameAreaLayout);

        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(startKnapp);
        inputPanel.add(chooseSizeMeny);

        chooseSizeMeny.addActionListener(this);
        chooseSizeMeny.setSelectedItem(-1);
        startKnapp.addActionListener(this);
        //startKnapp.addActionListener(new Drivers(bricksList, inputPanel));

        add(femtonPanel);
        add(inputPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bricksList = fs.createBricksObjectsAndList(femtonPanel);
        setListeners();
        newGame();

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

        String selectedSize = (String) chooseSizeMeny.getSelectedItem();

        if (selectedSize != null) {
            // Clear the old bricks and reset the panel
            femtonPanel.removeAll();

            if (selectedSize.equalsIgnoreCase("3x3")) {
                nrOfBricks = 3;
            } else if (selectedSize.equalsIgnoreCase("4x4")) {
                nrOfBricks = 4;
            } else if (selectedSize.equalsIgnoreCase("5x5")) {
                nrOfBricks = 5;
            } else if (selectedSize.equalsIgnoreCase("6x6")) {
                nrOfBricks = 6;
            }

            // Update the game area layout
            gameAreaLayout = new GridLayout(nrOfBricks, nrOfBricks, 1, 1);

            // Update the game area border with a fixed thickness of 1
            gameAreaBorder = new LineBorder(Color.black, 1);

            // Create new Bricks objects and add listeners
            bricksList = fs.createBricksObjectsAndList(femtonPanel);
            setListeners();

            // Add the updated panel to the frame and refresh
            femtonPanel.setLayout(gameAreaLayout);
            add(femtonPanel);
            revalidate();
            repaint();
            newGame();
        }

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
