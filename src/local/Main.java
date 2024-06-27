import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        TextBox textBox = new TextBox();
        frame.add(textBox);
        frame.setSize(800, 600);
        frame.setLocation(120, 60);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
    }
}