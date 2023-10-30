package FemtonSpel;

import javax.swing.*;

public class Bricks {

    JPanel brick = new JPanel();
    private boolean inPosition = true;
    private int position;

    public Bricks(){

    }

    public Bricks(JPanel brick, int position) {
        this.brick = brick;
        this.position = position;
    }

    public JPanel getBrick() {
        return brick;
    }

    public void setBrick(JPanel brick) {
        this.brick = brick;
    }

    public boolean isInPosition() {
        return inPosition;
    }

    public void setInPosition(boolean inPosition) {
        this.inPosition = inPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void changePosition(){

    }
}
