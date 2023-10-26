package org.milaifontanals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPrincila extends JFrame implements ActionListener {
    
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginPrincila() {
        JFrame frame = new JFrame("WikiLoc Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");






        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);

        JLabel titleLabel = new JLabel("WikiLoc");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);


        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        passLabel.setHorizontalAlignment(JLabel.CENTER);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 18));


        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(loginButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    

    }

    public static void main(String[] args) {
        new LoginPrincila();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usuString  = userField.getText();
        String passString = passField.getText();

        if (usuString.equals("admin") && passString.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Login incorrecto");
        }




    }


}
    


