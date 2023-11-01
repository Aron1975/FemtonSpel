package FemtonSpel_v_2;

// jkdjkfbn
// kjasvj

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.util.ArrayList;

public class FemtonSetup {

    ArrayList<Bricks> bricksList = new ArrayList<>();

    private int size;
    private int image;
    //private Bricks bricks = new Bricks();

    public FemtonSetup(int size,int image){
        if(size>2 && size<=6) {
            this.size = size;
            this.image = 0;

            //createBricksObjectsAndList();
        }
    }
    public ArrayList<Bricks> createBricksObjectsAndList(JPanel jp) {
        Font f = new Font(null, 3, 20);
        SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);
        for(int i=0; i<size*size; i++) {
            JLabel jl = new JLabel();
            if(image == 0) {
                if(i!=size*size-1) {
                    String text = Integer.toString(i + 1);
                    jl.setText(text);
                    jl.setHorizontalAlignment(SwingConstants.CENTER);
                    jl.setVerticalAlignment(SwingConstants.CENTER);
                    jl.setOpaque(true);
                    jl.setFont(f);
                    jl.setForeground(Color.BLACK);
                    jl.setBorder(border);
                    jl.setBackground(Color.YELLOW);
                    //jl.addMouseListener(new FemtonGraphics());
                }
            }
            Bricks br = new Bricks(jl, i+1);
            bricksList.add(br);

        }
        return bricksList;
    }

}
