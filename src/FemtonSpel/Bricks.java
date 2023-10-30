package FemtonSpel;

import javax.swing.*;

public class Bricks {

    JLabel brick = new JLabel();
    private boolean inPosition = true;
    private int startPosition;

    public Bricks(){

    }

    public Bricks(JLabel brick, int startPosition) {
        this.brick = brick;
        this.startPosition = startPosition;
    }

    public JLabel getBrick() {
        return brick;
    }

    public void setBrick(JLabel brick) {
        this.brick = brick;
    }

    public boolean isInPosition() {
        return inPosition;
    }

    public void setInPosition(boolean inPosition) {
        this.inPosition = inPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void changePosition(){

    }
}
