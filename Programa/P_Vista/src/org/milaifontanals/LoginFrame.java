package org.milaifontanals;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecemos el tamaño de la ventana
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(78, 185, 154));
        GridBagConstraints gbc = new GridBagConstraints();

        // Agregamos un JLabel centrado como título
        JLabel titleLabel = new JLabel("WikiLoc - Inicio de Sesión");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));


        JLabel usuJLabel = new JLabel("Usuario:");
        usuJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel passJLabel = new JLabel("Contraseña:");
        passJLabel.setFont(new Font("Arial", Font.PLAIN, 15));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.insets = new Insets(0, 0, 50, 0); // Márgenes en la parte inferior
        panel.add(titleLabel, gbc);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Iniciar Sesión");

        gbc.insets = new Insets(0, 0, 10, 0); // Restauramos los márgenes
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Restauramos el valor
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usuJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        // Configura el botón para que ocupe dos columnas y esté centrado
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel);
        loginButton.setBackground( new Color(178, 230, 210));
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin")) {
            dispose(); // Cierra la ventana de inicio de sesión
            Principal mainFrame = new Principal(username);
            mainFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
