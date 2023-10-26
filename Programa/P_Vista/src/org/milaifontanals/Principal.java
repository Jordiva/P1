package org.milaifontanals;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import p_interficiepersistencia.GestorBDExceptionTOT;

public class Principal extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JLabel userLabel;
    private JLabel passLabel;
    private JButton loginButton;
    //private BDGeneral bd;

    //LOGIN
    public Principal() {
        
        setTitle("WikiLoc Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Username:");
        userField = new JTextField();
        passLabel = new JLabel("Password:");
        passField = new JPasswordField();
        loginButton = new JButton("Login");

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


        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        
        loginButton.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar si el nombre de usuario y la contraseña son correctos
        String username = userField.getText();
        String password = new String(passField.getPassword());
        
        /*
        boolean loginSuccessful = false; 
        try {
        loginSuccessful = bd.validarLogn(username, password);
        } catch (GestorBDExceptionTOT e1) {
            e1.printStackTrace();
            System.out.println("Error al validar el login");
        }
        */

        if (username.equals("admin") && password.equals("admin")) {
            // Si el inicio de sesión es correcto, cerrar el formulario de inicio de sesión y abrir el otro frame
            
            //alerta de login correcto
            JOptionPane.showMessageDialog(this, "Login correcto", "Login", JOptionPane.INFORMATION_MESSAGE);

           
        } else {
            // Si el inicio de sesión es incorrecto, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Crear el formulario de inicio de sesión


        Principal loginFrame = new Principal();
        loginFrame.setVisible(true);
        //crear la conexion con la base de datos
        
        /*
        try {
            loginFrame.bd = new BDGeneral("Oracle.properties");
        } catch (GestorBDExceptionTOT e) {
            System.out.println("Error al crear la conexion con la base de datos");
            e.printStackTrace();
        }
         */

    }
}


