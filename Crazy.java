import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* This program puts an exit button on the window. Whenever the cursor moves
 * over the button, it jumps to a random location in the window. Most of the
 * program is just standard Swing boilerplate.  */

public class Crazy extends JFrame{
  private static final int DEFAULT_WIDTH = 500;
  private static final int DEFAULT_HEIGHT = 300;
  
  private JPanel crazyPanel = new JPanel();
  private JButton crazyButton = new JButton("Exit");
  private int buttonWidth;
  private int buttonHeight;
  private int screenWidth = DEFAULT_WIDTH;
  private int screenHeight = DEFAULT_HEIGHT;
  private Random random = new Random();
  
  public Crazy() {
    
    // Set up the window and put a button in it.
    setSize(screenWidth, screenHeight);
    crazyPanel.add(crazyButton);
    add (crazyPanel);
    
    // Set up the button so it would exit if it could be pressed.
    crazyButton.addActionListener(event -> System.exit(0));
    
    // Whenever the mouse is moved over the button, the button should jump to
    // a random place in the window.
    crazyButton.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        moveButtonRandomly();
      }
    });

    // Initially, move the button to the center of the window.
    addWindowListener( new WindowAdapter() {
      @Override
      public void windowOpened(WindowEvent e) {
        centerButton();
      }
    });

    // Also center the button when the window is resized.
    addComponentListener( new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        centerButton();
      }
    });
  }
  
  // Choose random numbers for the top left corner of the button inside the
  // window. They are chosen so that the button is entirely inside the window.
  private void moveButtonRandomly() {
    buttonWidth = crazyButton.getWidth();
    buttonHeight = crazyButton.getHeight();
    screenWidth = crazyPanel.getWidth();
    screenHeight = crazyPanel.getHeight();

    int x = random.nextInt(screenWidth - buttonWidth);
    int y = random.nextInt(screenHeight - buttonHeight);
    crazyButton.setLocation(x, y);
  }
  
  // Calcuate the location and move the button to the center of the screen
  private void centerButton() {
    buttonWidth = crazyButton.getWidth();
    buttonHeight = crazyButton.getHeight();
    screenWidth = crazyPanel.getWidth();
    screenHeight = crazyPanel.getHeight();

    int x = (screenWidth - buttonWidth) / 2;
    int y = (screenHeight - buttonHeight) / 2;
    crazyButton.setLocation(x, y);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(() ->
       {
    	 JFrame frame = new Crazy();
         frame.setTitle("Good Luck Clicking the Exit Button!");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
       });
  }
}
