package org.milaifontanals;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import p_interficiepersistencia.GestorBDExceptionTOT;

public class Principal extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTable table;

    private BDGeneral bd;

    //LOGIN
    public Principal() {
        // Configurar el formulario de inicio de sesión
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setBackground(new java.awt.Color(23, 208, 119));

        // Crear los campos de entrada de texto y el botón de inicio de sesión
        JPanel panel = new JPanel(new GridLayout(5, 3));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(this);

        // Agregar los componentes al panel
        panel.add(new JLabel("Nombre de usuario:"));
        panel.add(usernameField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);
        panel.add(loginButton);

        // Agregar el panel al formulario de inicio de sesión
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar si el nombre de usuario y la contraseña son correctos
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean loginSuccessful = false; 
        try {
        loginSuccessful = bd.validarLogn(username, password);
        } catch (GestorBDExceptionTOT e1) {
            e1.printStackTrace();
            System.out.println("Error al validar el login");
        }


        if (loginSuccessful) {
            // Si el inicio de sesión es correcto, cerrar el formulario de inicio de sesión y abrir el otro frame
            dispose();
            OtherFrame otherFrame = new OtherFrame(username);
            otherFrame.setVisible(true);
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
        
        try {
            loginFrame.bd = new BDGeneral("Oracle.properties");
        } catch (GestorBDExceptionTOT e) {
            System.out.println("Error al crear la conexion con la base de datos");
            e.printStackTrace();
        }

    }
}

class OtherFrame extends JFrame {

    private JTable jTable;

    public OtherFrame( String username) {
        // Configurar el otro frame
        setTitle("Otro frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Agregar un mensaje al otro frame
        JLabel label = new JLabel("¡Bienvenido!     " +  username);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        

        

    }
}


