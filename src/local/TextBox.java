import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class TextBox extends JPanel implements KeyListener {

    private StringBuilder text;
    private int cursorPosition;
    private BufferedImage buffer;
    private Font font;
    private int fontHeight;

    public TextBox() {
        this.text = new StringBuilder();
        this.cursorPosition = 0;
        this.font = new Font("Monospaced", Font.PLAIN, 20);
        this.fontHeight = getFontMetrics(font).getHeight();
        this.buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(800, 600));
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) buffer.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);

        // Draw the text
        g2d.drawString(text.toString(), 10, 30);

        // Draw the cursor
        int cursorX = 10 + g2d.getFontMetrics().stringWidth(text.substring(0, cursorPosition));
        g2d.drawLine(cursorX, 10, cursorX, 10 + fontHeight);

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)){
            text.insert(cursorPosition, c);
            cursorPosition++;
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_BACK_SPACE:
                if(cursorPosition > 0){
                    while (!Character.isWhitespace(text.charAt(cursorPosition - 1))) { 
                        text.deleteCharAt(cursorPosition - 1);
                        cursorPosition--;
                    }
                }
                    break;
    
                case KeyEvent.VK_LEFT:
                if(cursorPosition > 0){
                    cursorPosition--;
                }
                    break;
    
                case KeyEvent.VK_RIGHT:
                if(cursorPosition < text.length()){
                    cursorPosition++;
                }
                    break;            
            }
            repaint();
        }
        switch(e.getKeyCode()){
            case KeyEvent.VK_BACK_SPACE:
            if(cursorPosition > 0){
                text.deleteCharAt(cursorPosition - 1);
                cursorPosition--;
            }
                break;

            case KeyEvent.VK_LEFT:
            if(cursorPosition > 0){
                cursorPosition--;
            }
                break;

            case KeyEvent.VK_RIGHT:
            if(cursorPosition < text.length()){
                cursorPosition++;
            }
                break;            
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
