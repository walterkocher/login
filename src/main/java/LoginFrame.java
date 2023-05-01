import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JButton registerButton;
    private UsuariosCSV usuariosCSV;

    public LoginFrame(UsuariosCSV usuariosCSV) {
        this.usuariosCSV = usuariosCSV;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameTextField = new JTextField(20);
        passwordPasswordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameTextField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordPasswordField);
        panel.add(loginButton);
        panel.add(registerButton);

        getContentPane().add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordPasswordField.getPassword());
                boolean loginSuccessful = usuariosCSV.validarUsuario(username, password);
                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordPasswordField.getPassword());
                Usuario usuario = new Usuario(username, password);
                usuariosCSV.agregarUsuario(usuario);
                JOptionPane.showMessageDialog(LoginFrame.this, "Registration successful!");
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}