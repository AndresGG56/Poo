import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    public LoginForm() {
        // Configurar el marco
        setTitle("Formulario de Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear panel principal y establecer layout
        JPanel panel = new JPanel();
        panel.setLayout(null); // Usar layout nulo para posiciones absolutas
        getContentPane().add(panel);

        // Crear y configurar etiquetas y campos de texto
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(140, 50, 200, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(140, 100, 200, 25);
        panel.add(passwordText);

        // Crear y configurar botón de inicio de sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(140, 150, 150, 25);
        panel.add(loginButton);

        // Crear etiqueta para mostrar mensajes
        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(50, 200, 300, 25);
        panel.add(messageLabel);

        // Añadir ActionListener al botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Comprobar credenciales (usuario: admin, contraseña: password)
                if (user.equals("admin") && password.equals("password")) {
                    messageLabel.setText("Inicio de sesión exitoso");
                } else {
                    messageLabel.setText("Credenciales incorrectas");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Ejecutar el formulario de inicio de sesión en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}