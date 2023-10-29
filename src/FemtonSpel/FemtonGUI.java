package FemtonSpel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

//Testar ny branch.......

public class FemtonGUI extends JFrame implements MouseListener{

    int test123;
    final int PLAYAREASIZE = 400;
    //Icon icon1 = new ImageIcon("Images/thumbnail_small1.jpg");
    ImageIcon icon1 = new ImageIcon(new ImageIcon("Images/thumbnail_1.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));

    Icon icon2 = new ImageIcon(new ImageIcon("Images/thumbnail_2.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon3 = new ImageIcon(new ImageIcon("Images/thumbnail_3.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon4 = new ImageIcon(new ImageIcon("Images/thumbnail_4.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon5 = new ImageIcon(new ImageIcon("Images/thumbnail_5.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon6 = new ImageIcon(new ImageIcon("Images/thumbnail_6.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon7 = new ImageIcon(new ImageIcon("Images/thumbnail_7.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon8 = new ImageIcon(new ImageIcon("Images/thumbnail_8.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon9 = new ImageIcon(new ImageIcon("Images/thumbnail_9.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon10 = new ImageIcon(new ImageIcon("Images/thumbnail_10.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon11 = new ImageIcon(new ImageIcon("Images/thumbnail_11.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon12 = new ImageIcon(new ImageIcon("Images/thumbnail_12.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon13 = new ImageIcon(new ImageIcon("Images/thumbnail_13.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon14 = new ImageIcon(new ImageIcon("Images/thumbnail_14.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));
    Icon icon15 = new ImageIcon(new ImageIcon("Images/thumbnail_15.jpg").
            getImage().getScaledInstance(PLAYAREASIZE/4, PLAYAREASIZE/4, Image.SCALE_SMOOTH));

    JPanel femtonPanel = new JPanel();
    JLabel ruta1 = new JLabel();//("1", SwingConstants.CENTER);
    JLabel ruta2 = new JLabel();//("2", SwingConstants.CENTER);
    JLabel ruta3 = new JLabel();//("3", SwingConstants.CENTER);
    JLabel ruta4 = new JLabel();//("4", SwingConstants.CENTER);
    JLabel ruta5 = new JLabel();//("5", SwingConstants.CENTER);
    JLabel ruta6 = new JLabel();//("6", SwingConstants.CENTER);
    JLabel ruta7 = new JLabel();//("7", SwingConstants.CENTER);
    JLabel ruta8 = new JLabel();//("8", SwingConstants.CENTER);
    JLabel ruta9 = new JLabel();//("9", SwingConstants.CENTER);
    JLabel ruta10 = new JLabel();//("10", SwingConstants.CENTER);
    JLabel ruta11 = new JLabel();//("11", SwingConstants.CENTER);
    JLabel ruta12 = new JLabel();//("12", SwingConstants.CENTER);
    JLabel ruta13 = new JLabel();//("13", SwingConstants.CENTER);
    JLabel ruta14 = new JLabel();//("14", SwingConstants.CENTER);
    JLabel ruta15 = new JLabel();//("15", SwingConstants.CENTER);
    JLabel ruta16 = new JLabel("");
    ArrayList<JLabel> rutLista = new ArrayList<>();
    Font f = new Font(null, 3, 20);
    GridLayout bl = new GridLayout(4,4);
    //Border border = BorderFactory.createLineBorder(Color.red);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.WHITE);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.BLACK);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    //Border border = BorderFactory.createRaisedBevelBorder();
    Border border = BorderFactory.createLoweredBevelBorder();
    /*
    raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
raisedbevel = BorderFactory.createRaisedBevelBorder();
loweredbevel = BorderFactory.createLoweredBevelBorder();

ImageIcon icon1 = new ImageIcon(new ImageIcon("Images/thumbnail_1.jpg").
            getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
     */

    public FemtonGUI(){

        ruta1.setIcon(icon1);
        ruta2.setIcon(icon2);
        ruta3.setIcon(icon3);
        ruta4.setIcon(icon4);
        ruta5.setIcon(icon5);
        ruta6.setIcon(icon6);
        ruta7.setIcon(icon7);
        ruta8.setIcon(icon8);
        ruta9.setIcon(icon9);
        ruta10.setIcon(icon10);
        ruta11.setIcon(icon11);
        ruta12.setIcon(icon12);
        ruta13.setIcon(icon13);
        ruta14.setIcon(icon14);
        ruta15.setIcon(icon15);

        setSize(PLAYAREASIZE,PLAYAREASIZE);
        setResizable(false);
        addRutorToList();
        //femtonPanel.setSize(400,400);
        femtonPanel.setLayout(bl);



      /*  ruta1.setSize(50,50);
        femtonPanel.add(ruta1);
        ruta2.setSize(50,50);
        femtonPanel.add(ruta2);
        ruta3.setSize(50,50);
        femtonPanel.add(ruta3);
        ruta4.setSize(50,50);
        femtonPanel.add(ruta4);*/
        add(femtonPanel);
        setLocationRelativeTo(null);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void addRutorToList(){
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
        //Collections.shuffle(rutLista);
        for(JLabel l: rutLista){
            l.setFont(f);
            //l.setSize(50,50);
            l.setBorder(border);
            l.setBackground(Color.ORANGE);
            femtonPanel.add(l);
        }
        ruta16.setBackground(Color.WHITE);
    }



    @Override
    public void mouseClicked(MouseEvent e) {

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

    public static void main(String[] args) {
        new FemtonGUI();
    }
}
