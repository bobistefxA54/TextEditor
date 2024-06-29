import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        TextBox textBox = new TextBox();
        frame.add(textBox);
        frame.setSize(800, 600);
        frame.setLocation(120, 60);
        frame.setVisible(true);
        frame.getContentPane().add(jScrollPane).setBackground(Color.DARK_GRAY);
    }
}