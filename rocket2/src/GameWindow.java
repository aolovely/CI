import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;


    public GameWindow() {
        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);

        this.keyboardEvent();

        this.windowEvent();

        this.setVisible(true);
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.playerPolygon.setRadian(gameCanvas.playerPolygon.getRadian() - 4.0);
                    gameCanvas.player.setX(gameCanvas.player.getX() - gameCanvas.player.getVelocityX());
                    if(gameCanvas.player.getX() < 0 + 10)
                        gameCanvas.player.setX(1024);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.playerPolygon.setRadian(gameCanvas.playerPolygon.getRadian() + 4.0);
                    gameCanvas.player.setX(gameCanvas.player.getX() + gameCanvas.player.getVelocityX());
                    if(gameCanvas.player.getX() > 1024 - 10)
                        gameCanvas.player.setX(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }


    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }

}