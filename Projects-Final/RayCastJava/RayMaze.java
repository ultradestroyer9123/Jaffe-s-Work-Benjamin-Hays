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
    private JButton exitButton;
    public RayMaze() {
        
        setUndecorated(true);
        setTitle("Ray Maze");
        setBackground( new Color(0,0,0,85) );
        setSize(400, 325);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 8));
        
        exitButton = new JButton("<html><font color='white'>Exit</font></html>");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        exitButton.setBackground( new Color(0,0,0,85) );
        add(exitButton);
        titleLabel = new JLabel("<html><font color='white'>Ray Maze</font></html>");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        gridSizeLabel = new JLabel("<html><font color='white'>Grid Size</font></html>", SwingConstants.CENTER);
        add(gridSizeLabel);

        gridSizeTextField = new JTextField("50");
        gridSizeTextField.setHorizontalAlignment(JTextField.CENTER);
        gridSizeTextField.setForeground(Color.BLACK);
        add(gridSizeTextField);

        wallInstanceLabel = new JLabel("<html><font color='white'>Wall Instance Amount</font></html>", SwingConstants.CENTER);
        add(wallInstanceLabel);

        wallInstanceTextField = new JTextField("50");
        wallInstanceTextField.setHorizontalAlignment(JTextField.CENTER);

        wallInstanceTextField.setForeground(Color.BLACK);
        add(wallInstanceTextField);

        startButton = new JButton("<html><font color='white'>Start Game</font></html>");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int gridSize = Integer.parseInt(gridSizeTextField.getText());
                int wallInstanceAmount = Integer.parseInt(wallInstanceTextField.getText());
                DrawFrame frame = new DrawFrame(gridSize, wallInstanceAmount);
                dispose();
            }
        });
        startButton.setBackground( new Color(0,0,0,85) );
        add(startButton);

        setVisible(true);
    }
}
