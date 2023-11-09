package org.milaifontanals.CodiAsecas;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton button1 = new JButton("Botón 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(button1, constraints);

        JButton button2 = new JButton("Botón 2");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(button2, constraints);

        JButton button3 = new JButton("Botón 3");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(button3, constraints);

        JButton button4 = new JButton("Botón 4");
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(button4, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }
}
