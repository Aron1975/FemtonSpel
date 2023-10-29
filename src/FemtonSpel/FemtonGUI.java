package FemtonSpel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

//Original Master

public class FemtonGUI extends JFrame implements MouseListener {

    final int PLAYAREASIZE = 400;
    final int HORIZONTALIMAGESIZE = (PLAYAREASIZE/4)+0;
    final int VERTICALIMAGESIZE = (PLAYAREASIZE/4)+0;

    final int IMAGESIZE = PLAYAREASIZE/4;

    Icon icon1 = new ImageIcon(new ImageIcon("Images/thumbnail_1.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_REPLICATE));
    Icon icon2 = new ImageIcon(new ImageIcon("Images/thumbnail_2.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon3 = new ImageIcon(new ImageIcon("Images/thumbnail_3.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon4 = new ImageIcon(new ImageIcon("Images/thumbnail_4.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon5 = new ImageIcon(new ImageIcon("Images/thumbnail_5.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon6 = new ImageIcon(new ImageIcon("Images/thumbnail_6.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon7 = new ImageIcon(new ImageIcon("Images/thumbnail_7.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon8 = new ImageIcon(new ImageIcon("Images/thumbnail_8.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon9 = new ImageIcon(new ImageIcon("Images/thumbnail_9.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon10 = new ImageIcon(new ImageIcon("Images/thumbnail_10.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon11 = new ImageIcon(new ImageIcon("Images/thumbnail_11.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon12 = new ImageIcon(new ImageIcon("Images/thumbnail_12.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon13 = new ImageIcon(new ImageIcon("Images/thumbnail_13.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon14 = new ImageIcon(new ImageIcon("Images/thumbnail_14.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));
    Icon icon15 = new ImageIcon(new ImageIcon("Images/thumbnail_15.jpg").
            getImage().getScaledInstance(HORIZONTALIMAGESIZE, VERTICALIMAGESIZE, Image.SCALE_SMOOTH));

    JPanel femtonPanel = new JPanel();
    JPanel newPanel = new JPanel();
    JButton knapp1 = new JButton("Knapp1");
    JButton knapp2 = new JButton("Knapp2");

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
    ArrayList<JLabel> rutLista = new ArrayList<>();
    Font f = new Font(null, 3, 20);

    GridLayout gameAreaLayout = new GridLayout(4, 4,0,0);
    GridLayout functionAreaLayout = new GridLayout(2,1);

    //EtchedBorder border = new EtchedBorder();
    EmptyBorder emptyBorder = new EmptyBorder(5,5,5,5);
    SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);
    //Border border = BorderFactory.createLineBorder(Color.red);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.WHITE);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.blue, Color.BLACK);
    //Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    //Border border = BorderFactory.createRaisedBevelBorder();
    //Border border = BorderFactory.createLoweredBevelBorder();
    /*


ImageIcon icon1 = new ImageIcon(new ImageIcon("Images/thumbnail_1.jpg").
            getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
     */



    public FemtonGUI() throws InterruptedException{

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        chooseImage(1);
        setMinimumSize(new Dimension(PLAYAREASIZE+200, PLAYAREASIZE+200));
        femtonPanel.setPreferredSize(new Dimension(PLAYAREASIZE,PLAYAREASIZE));
        femtonPanel.setMinimumSize(femtonPanel.getPreferredSize());
        femtonPanel.setMaximumSize(femtonPanel.getPreferredSize());
        //femtonPanel.setLocation(50,0);

        addRutorToList();
        femtonPanel.setLayout(gameAreaLayout);

        newPanel.add(knapp1);
        newPanel.add(knapp2);

        newPanel.setLayout(functionAreaLayout);

        add(femtonPanel);
        add(newPanel);

        pack();
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*moveBricks();
        TimeUnit.SECONDS.sleep(2);
        moveBricks();
        TimeUnit.SECONDS.sleep(2);
        moveBricks();
        TimeUnit.SECONDS.sleep(2);
        moveBricks();
        TimeUnit.SECONDS.sleep(2);
        moveBricks();*/
    }


    public void chooseImage(int choice) {
        if (choice == 1) {
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
        }
        else{
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
        }
    }

    public void addRutorToList() {
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
        Collections.shuffle(rutLista);
        for (JLabel l : rutLista) {
            l.setOpaque(true);
            l.setFont(f);
            l.setForeground(Color.BLACK);
            //l.setSize(50,50);
            l.setBorder(border);
            Color myColor = new Color(200,90,170,160);
            l.setBackground(Color.YELLOW);
            femtonPanel.add(l);
            l.addMouseListener(this);
        }
        //ruta1.setOpaque(true);
        ruta16.setBackground(Color.DARK_GRAY);
        //ruta16.setBorder(emptyBorder);
        //ruta2.setForeground(Color.BLACK);

        /*label.setOpaque(true);

        // sets the background color of this component
        // the background color is used only if the component is opaque
        label.setBackground(Color.BLUE);

        // add label to frame
        add(label);*/

    }

    public void moveBricks(){
        try {
            femtonPanel.removeAll(); //erase everything from your JPanel

            //Collections.shuffle(rutLista);
            for (JLabel l : rutLista) {
                femtonPanel.add(l);
            }
            femtonPanel.revalidate();

            //femtonPanel.repaint();
        }catch(Exception e){
            e.printStackTrace();
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
       /* if(e.getSource() == ruta1){
            System.out.println("Ruta1 tryckt");
        }
        if(e.getSource() == ruta2){

        }
        if(e.getSource() == ruta3){

        }
        if(e.getSource() == ruta4){

        }
        if(e.getSource() == ruta5){

        }
        if(e.getSource() == ruta6){

        }
        if(e.getSource() == ruta7){

        }
        if(e.getSource() == ruta8){

        }
        if(e.getSource() == ruta9){

        }
        if(e.getSource() == ruta10){

        }
        if(e.getSource() == ruta11){

        }
        if(e.getSource() == ruta12){

        }
        if(e.getSource() == ruta13){

        }
        if(e.getSource() == ruta14){

        }
        if(e.getSource() == ruta15){

        }*/
        moveIfMovable((JLabel)e.getSource());
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

    public static void main(String[] args) throws InterruptedException{
        new FemtonGUI();
    }
}
