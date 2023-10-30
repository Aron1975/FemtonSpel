package FemtonSpel;

import javax.swing.*;
import java.util.Collections;

public class Drivers {

    public Drivers(){

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
}
