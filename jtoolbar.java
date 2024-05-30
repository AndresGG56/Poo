import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteApp extends JFrame implements Runnable {

    private DefaultListModel<String> noteListModel;
    private JList<String> noteList;
    private JTextField noteField;

    public NoteApp() {
        // Configuración del JFrame
        setTitle("Aplicación de Notas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuración de la barra de herramientas
        JToolBar toolBar = new JToolBar();
        JButton addButton = new JButton("Añadir");
        JButton clearButton = new JButton("Limpiar");
        toolBar.add(addButton);
        toolBar.add(clearButton);
        add(toolBar, BorderLayout.NORTH);

        // Configuración de la barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem exitItem = new JMenuItem("Salir");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Panel principal con campo de texto y lista
        JPanel mainPanel = new JPanel(new BorderLayout());

        noteField = new JTextField();
        mainPanel.add(noteField, BorderLayout.NORTH);

        noteListModel = new DefaultListModel<>();
        noteList = new JList<>(noteListModel);
        JScrollPane scrollPane = new JScrollPane(noteList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        // Añadir ActionListeners a los botones y elementos del menú
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String note = noteField.getText();
                if (!note.isEmpty()) {
                    noteListModel.addElement(note);
                    noteField.setText("");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteField.setText("");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void run() {
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new NoteApp());
    }
}