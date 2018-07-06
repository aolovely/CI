import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    public static KeyBoard keyBoard = new KeyBoard();
    public boolean keyLeft = false;
    public boolean keyRight = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
