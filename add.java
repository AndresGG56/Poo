import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginForm extends JFrame {
    public LoginForm() {
        // Configurar el marco
        setTitle("Formulario de Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Obtener el contenedor principal y establecer el layout
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        // Crear y configurar etiquetas y campos de texto
        JLabel userLabel = new JLabel("Usuario:");
        contentPane.add(userLabel);

        JTextField userText = new JTextField(20);
        contentPane.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        contentPane.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        contentPane.add(passwordText);

        // Crear y configurar botón de inicio de sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        contentPane.add(loginButton);

        // Crear etiqueta para mostrar mensajes
        JLabel messageLabel = new JLabel("");
        contentPane.add(messageLabel);

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

        // Añadir MouseListener al campo de texto de usuario
        userText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Campo de usuario clicado");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No hace nada
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // No hace nada
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entró en el campo de usuario");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse salió del campo de usuario");
            }
        });
    }

    public static void main(String[] args) {
        // Ejecutar el formulario de inicio de sesión en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true); // Hacer visible el frame
            }
        });
    }
}