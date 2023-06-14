import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ayuntNombre extends JFrame {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ayuntNombre(String nombre) {
        // Configuración de la ventana
        setTitle("Drop-in - Ayuntamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes de la interfaz

        ImageIcon ayuntamientoImage = new ImageIcon("C:\\Users\\Alejandro\\IdeaProjects\\dropin2-main\\Dropin\\IMAGES\\cas.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen

        if (nombre.equals("castellon")) {
            ImageIcon ayun = new ImageIcon("C:\\Users\\Alejandro\\IdeaProjects\\dropin2-main\\Dropin\\IMAGES\\cas.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage=ayun;

        }
        else if (nombre.equals("beni")) {
            ImageIcon ayun= new ImageIcon("C:\\Users\\Alejandro\\IdeaProjects\\dropin2-main\\Dropin\\IMAGES\\beni.jpg");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage=ayun;
        }
        else if (nombre.equals("vila")) {
            ImageIcon ayun = new ImageIcon("C:\\Users\\Alejandro\\IdeaProjects\\dropin2-main\\Dropin\\IMAGES\\villa.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage=ayun;
        }
        else if (nombre.equals("vall")) {
            ImageIcon ayun= new ImageIcon("C:\\Users\\Alejandro\\IdeaProjects\\dropin2-main\\Dropin\\IMAGES\\vall.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage=ayun;
        }

        JLabel containerLabel = new JLabel("Nº de Contenedores:");
        JTextField containerTextField = new JTextField();

        JButton addButton = new JButton("Añadir");
        JButton backButton = new JButton("Atrás");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        containerLabel.setForeground(buttonColor);
        addButton.setBackground(buttonColor);
        addButton.setForeground(textColor);
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        containerLabel.setFont(labelFont);
        addButton.setFont(buttonFont);
        backButton.setFont(buttonFont);

        JLabel imageLabel = new JLabel();
        // Configurar la imagen del ayuntamiento
        Image image = ayuntamientoImage.getImage();
        Image scaledImage = image.getScaledInstance(350, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        // Agregar componentes al panel principal
        JPanel panelAyuntamiento = new JPanel(new BorderLayout());
        panelAyuntamiento.setBackground(backgroundColor);
        panelAyuntamiento.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(backgroundColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(containerLabel);
        inputPanel.add(containerTextField);

        panelAyuntamiento.add(imageLabel, BorderLayout.NORTH);
        panelAyuntamiento.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        buttonPanel.add(backButton);
        buttonPanel.add(addButton);

        panelAyuntamiento.add(buttonPanel, BorderLayout.SOUTH);

        add(panelAyuntamiento);

        // Acción del botón "Añadir"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntContenedor añadirContenedor = new ayuntContenedor(getNombre());
                añadirContenedor.setNombre(getNombre());
                añadirContenedor.setVisible(true);
                dispose(); // Cierra la ventana actual de ayuntNombre
            }
        });

        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntLogin mapButtons = new ayuntLogin();
                mapButtons.setVisible(true);
                dispose(); // Cierra la ventana actual de ayuntNombre

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntNombre app = new ayuntNombre("vall");
                app.setVisible(true);
            }
        });
    }
}
