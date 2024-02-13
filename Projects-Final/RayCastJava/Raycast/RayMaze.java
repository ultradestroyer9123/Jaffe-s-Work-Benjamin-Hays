import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RayMaze extends JFrame {
    private JLabel titleLabel;
    private JLabel gridSizeLabel;
    private JTextField gridSizeTextField;
    private JLabel wallInstanceLabel;
    private JTextField wallInstanceTextField;
    private JButton startButton;

    public RayMaze() {
        setTitle("Ray Maze");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(16, 4));

        titleLabel = new JLabel("Ray Maze");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        gridSizeLabel = new JLabel("Grid Size", SwingConstants.CENTER);
        add(gridSizeLabel);

        gridSizeTextField = new JTextField("50");
        gridSizeTextField.setHorizontalAlignment(JTextField.CENTER);
        gridSizeTextField.setOpaque(false);
        add(gridSizeTextField);

        wallInstanceLabel = new JLabel("Wall Instance Amount", SwingConstants.CENTER);
        add(wallInstanceLabel);

        wallInstanceTextField = new JTextField("10");
        wallInstanceTextField.setHorizontalAlignment(JTextField.CENTER);
        wallInstanceTextField.setOpaque(false);
        add(wallInstanceTextField);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int gridSize = Integer.parseInt(gridSizeTextField.getText());
                int wallInstanceAmount = Integer.parseInt(wallInstanceTextField.getText());
                // Start your maze generation or any other action here
            }
        });
        add(startButton);

        setVisible(true);
    }
}
