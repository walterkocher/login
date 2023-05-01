import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroFrame extends JFrame {

    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton registerButton;
    private UsuariosCSV usuariosCSV;

    public RegistroFrame(UsuariosCSV usuariosCSV) {
        this.usuariosCSV = usuariosCSV;

        setTitle("Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        usernameTextField = new JTextField(20);
        passwordPasswordField = new JPasswordField(20);
        registerButton = new JButton("Register");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameTextField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordPasswordField);
        panel.add(registerButton);

        getContentPane().add(panel, BorderLayout.CENTER);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordPasswordField.getPassword());
                Usuario usuario = new Usuario(username, password);
                usuariosCSV.agregarUsuario(usuario);
                JOptionPane.showMessageDialog(RegistroFrame.this, "Registration successful!");
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
