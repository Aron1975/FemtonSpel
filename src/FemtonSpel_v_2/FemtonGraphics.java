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

    boolean firstStart = true;
    int gameSize = 4;
    int emptyBrickStartPosition = (gameSize * gameSize);
    int emptyBrickCurrentPosition;
    final int PLAYAREASIZE = 400;
    JPanel femtonPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JButton startKnapp = new JButton("Nytt spel");
    String gameSizeArray[] = {"3x3", "4x4", "5x5", "6x6"};
    JComboBox chooseGameSize = new JComboBox(gameSizeArray);
    GridLayout gameAreaLayout;
    Border gameAreaBorder;

    public FemtonGraphics() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(PLAYAREASIZE + 200, PLAYAREASIZE + 200));

        inputPanel.add(startKnapp);
        inputPanel.add(chooseGameSize);
        startKnapp.addActionListener(this);
        chooseGameSize.addActionListener(this);
        inputPanel.setLayout(new FlowLayout());

        add(femtonPanel);
        add(inputPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void newGame() {
        if (firstStart) {
            emptyBrickStartPosition = (gameSize * gameSize);
            gameAreaLayout = new GridLayout(gameSize, gameSize, 1, 1);
            gameAreaBorder = new LineBorder(Color.BLACK, 3);

            femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE, PLAYAREASIZE));
            femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
            femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());
            femtonPanel.setBorder(gameAreaBorder);
            femtonPanel.setLayout(gameAreaLayout);

            FemtonSetup fs = new FemtonSetup(gameSize, 0);
            bricksList = fs.createBricksObjectsAndList(femtonPanel);
            add(inputPanel);
            setListeners();
            moveBricks();
            firstStart=false;
        }
        else{
            boolean shuffleOK = false;
            while (!shuffleOK) {
                Collections.shuffle(bricksList);
                setEmptyBrickPosition();
                if (isSolvable()) {
                    moveBricks();
                    shuffleOK = true;
                }
            }
        }
    }

    public void setListeners() {
        for (Bricks br : bricksList) {
            br.getBrick().addMouseListener(this);
        }
    }

    public void setEmptyBrickPosition() {
        int counter = 0;
        for (Bricks br : bricksList) {
            if (br.getStartPosition() == emptyBrickStartPosition) {
                emptyBrickCurrentPosition = counter;
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
        setEmptyBrickPosition();
    }

    public boolean isSolvable() {
        int inversions = 0;
        for (int i = 0; i < gameSize * gameSize; i++) {
            for (int j = i + 1; j < gameSize * gameSize; j++) {
                if ((bricksList.get(i).getStartPosition() > bricksList.get(j).getStartPosition()) &&
                        bricksList.get(i).getStartPosition() != emptyBrickStartPosition) {
                    inversions++;
                }
            }
        }
        double rad = ((Math.ceil(((double) emptyBrickCurrentPosition + 1) / gameSize)));
        System.out.println("Inversions: " + inversions);
        System.out.println("Rad: " +  rad);
        boolean oddNrOfInversions = true;
        boolean oddNrOfInversionsPlusEmptyRaw = true;
        if (inversions % 2 == 0) {
            oddNrOfInversions = false;
        }
        if (((rad + inversions) % 2) == 0) {
            oddNrOfInversionsPlusEmptyRaw = false;
        }
        if ((gameSize % 2 != 0) && (!oddNrOfInversions)) {
            System.out.println("Solvable");
            return true;
        }
        if ((gameSize % 2 == 0) && (!oddNrOfInversionsPlusEmptyRaw)) {
            System.out.println("Solvable");
            return true;
        }
        System.out.println("NOT Solvable");
        return false;
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
        }
    }

    public void moveIfMovable(Bricks br) {
        int indexOf16 = emptyBrickCurrentPosition;
        int indexOfThis = bricksList.indexOf(br);
        boolean movable = false;
        if ((indexOfThis + 1 == indexOf16 && (indexOfThis + 1) % gameSize != 0) || (indexOfThis - 1 == indexOf16 && (indexOf16 + 1) % gameSize != 0)) {
            movable = true;
        }
        if ((indexOfThis + gameSize == indexOf16) || indexOfThis - gameSize == indexOf16) {
            movable = true;
        }
        if (movable) {
            Collections.swap(bricksList, indexOf16, indexOfThis);
            moveBricks();
            checkIfGameWon();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startKnapp) {
            //newGame();
        }

        String selectedSize = (String) chooseGameSize.getSelectedItem();

        if (selectedSize != null) {
            if (selectedSize.equalsIgnoreCase("3x3")) {
                gameSize = 3;
            } else if (selectedSize.equalsIgnoreCase("4x4")) {
                gameSize = 4;
            } else if (selectedSize.equalsIgnoreCase("5x5")) {
                gameSize = 5;
            } else if (selectedSize.equalsIgnoreCase("6x6")) {
                gameSize = 6;
            }

            if(e.getSource() == chooseGameSize) {
                firstStart = true;
            }
            newGame();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Bricks br : bricksList) {
            if (e.getSource().equals(br.getBrick())) {
                moveIfMovable(br);
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Bricks br : bricksList) {
            if (e.getSource().equals(br.getBrick())) {
                moveIfMovable(br);
                break;
            }
        }
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
