package FemtonSpel;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class GUI extends JFrame implements MouseListener, ActionListener {

    final int PLAYAREASIZE = 400;
    JPanel femtonPanel = new JPanel();
    JPanel newPanel = new JPanel();
    JButton knapp1 = new JButton("Nytt spel");

    //<editor-fold desc="JLabels">
    JLabel ruta1 = new JLabel();
    JLabel ruta2 = new JLabel();
    JLabel ruta3 = new JLabel();
    JLabel ruta4 = new JLabel();
    JLabel ruta5 = new JLabel();
    JLabel ruta6 = new JLabel();
    JLabel ruta7 = new JLabel();
    JLabel ruta8 = new JLabel();
    JLabel ruta9 = new JLabel();
    JLabel ruta10 = new JLabel();
    JLabel ruta11 = new JLabel();
    JLabel ruta12 = new JLabel();
    JLabel ruta13 = new JLabel();
    JLabel ruta14 = new JLabel();
    JLabel ruta15 = new JLabel();
    JLabel ruta16 = new JLabel();
    //</editor-fold>
    ArrayList<JLabel> rutLista = new ArrayList<>();
    Font f = new Font(null, 3, 20);
    GridLayout gameAreaLayout = new GridLayout(4, 4, 0, 0);
    SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);

    public void runGame(){
    setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
    setMinimumSize(new Dimension(PLAYAREASIZE+200, PLAYAREASIZE+200));

    femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE,PLAYAREASIZE));
    femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
    femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());

    createGame();
    femtonPanel.setLayout(gameAreaLayout);
    newPanel.add(knapp1);
    knapp1.addActionListener(this);
    newPanel.setLayout(new FlowLayout());

    add(femtonPanel);
    add(newPanel);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createGame() {

        //<editor-fold desc="Sätter texter">
        ruta1.setText("1");
        ruta1.setHorizontalAlignment(SwingConstants.CENTER);
        ruta1.setVerticalAlignment(SwingConstants.CENTER);
        ruta2.setText("2");
        ruta2.setHorizontalAlignment(SwingConstants.CENTER);
        ruta2.setVerticalAlignment(SwingConstants.CENTER);
        ruta3.setText("3");
        ruta3.setHorizontalAlignment(SwingConstants.CENTER);
        ruta3.setVerticalAlignment(SwingConstants.CENTER);
        ruta4.setText("4");
        ruta4.setHorizontalAlignment(SwingConstants.CENTER);
        ruta4.setVerticalAlignment(SwingConstants.CENTER);
        ruta5.setText("5");
        ruta5.setHorizontalAlignment(SwingConstants.CENTER);
        ruta5.setVerticalAlignment(SwingConstants.CENTER);
        ruta6.setText("6");
        ruta6.setHorizontalAlignment(SwingConstants.CENTER);
        ruta6.setVerticalAlignment(SwingConstants.CENTER);
        ruta7.setText("7");
        ruta7.setHorizontalAlignment(SwingConstants.CENTER);
        ruta7.setVerticalAlignment(SwingConstants.CENTER);
        ruta8.setText("8");
        ruta8.setHorizontalAlignment(SwingConstants.CENTER);
        ruta8.setVerticalAlignment(SwingConstants.CENTER);
        ruta9.setText("9");
        ruta9.setHorizontalAlignment(SwingConstants.CENTER);
        ruta9.setVerticalAlignment(SwingConstants.CENTER);
        ruta10.setText("10");
        ruta10.setHorizontalAlignment(SwingConstants.CENTER);
        ruta10.setVerticalAlignment(SwingConstants.CENTER);
        ruta11.setText("11");
        ruta11.setHorizontalAlignment(SwingConstants.CENTER);
        ruta11.setVerticalAlignment(SwingConstants.CENTER);
        ruta12.setText("12");
        ruta12.setHorizontalAlignment(SwingConstants.CENTER);
        ruta12.setVerticalAlignment(SwingConstants.CENTER);
        ruta13.setText("13");
        ruta13.setHorizontalAlignment(SwingConstants.CENTER);
        ruta13.setVerticalAlignment(SwingConstants.CENTER);
        ruta14.setText("14");
        ruta14.setHorizontalAlignment(SwingConstants.CENTER);
        ruta14.setVerticalAlignment(SwingConstants.CENTER);
        ruta15.setText("15");
        ruta15.setHorizontalAlignment(SwingConstants.CENTER);
        ruta15.setVerticalAlignment(SwingConstants.CENTER);
        //</editor-fold>

        //<editor-fold desc="Lägger in alla rutor i en lista">
        rutLista.add(ruta1);
        rutLista.add(ruta2);
        rutLista.add(ruta3);
        rutLista.add(ruta4);
        rutLista.add(ruta5);
        rutLista.add(ruta6);
        rutLista.add(ruta7);
        rutLista.add(ruta8);
        rutLista.add(ruta9);
        rutLista.add(ruta10);
        rutLista.add(ruta11);
        rutLista.add(ruta12);
        rutLista.add(ruta13);
        rutLista.add(ruta14);
        rutLista.add(ruta15);
        rutLista.add(ruta16);
        //</editor-fold>

        //Collections.shuffle(rutLista);
        for (JLabel l : rutLista) {
            l.setOpaque(true);
            l.setFont(f);
            l.setForeground(Color.BLACK);
            l.setBorder(border);
            l.setBackground(Color.YELLOW);
            femtonPanel.add(l);
            l.addMouseListener(this);
        }
        ruta16.setBackground(Color.DARK_GRAY);
    }

    public void newGame(){
        Collections.shuffle(rutLista);
        moveBricks();
    }

    public void moveBricks(){
        try {
            femtonPanel.removeAll();
            for (JLabel l : rutLista) {
                femtonPanel.add(l);
            }
            femtonPanel.revalidate();

        }catch(Exception e){
            e.printStackTrace();
        }
        gameWon();
    }

    public void gameWon(){
        boolean arraySorted = true;

        for (int i = 0; i < rutLista.size() - 1; i++) {
            String currentText = rutLista.get(i).getText();
            String nextText = rutLista.get(i + 1).getText();

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
    }

    public void moveIfMovable(JLabel jl){
        int indexOf16 = rutLista.indexOf(ruta16);
        int indexOfThis = rutLista.indexOf(jl);
        System.out.println("Nr: " + jl.getText() + " is at: "+ indexOfThis);
        System.out.println("Nr16 is at: "+ indexOf16);

        if((indexOfThis+1 == indexOf16 && (indexOfThis+1)%4 != 0) || indexOfThis-1 == indexOf16) {
            Collections.swap(rutLista, indexOf16, indexOfThis);
            moveBricks();
        }

        if((indexOfThis+4 == indexOf16) || indexOfThis-4 == indexOf16) {
            Collections.swap(rutLista, indexOf16, indexOfThis);
            moveBricks();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        moveIfMovable((JLabel)e.getSource());
        gameWon();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == knapp1){
            newGame();
        }
    }
}
