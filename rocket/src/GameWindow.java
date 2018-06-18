import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;

    long lastTime = 0;

    //viet contructor
    public GameWindow(){
        this.setSize(1024,600);

        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);//dua gamecanvas vao trong gameWindow

        //bat su kien ban phim
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("keyEvent");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.positionXPlayer -= 3;
//                    System.out.println("keyPressed");
                    if(gameCanvas.positionXPlayer <= 0){
                        gameCanvas.positionXPlayer = 1024;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    gameCanvas.positionXPlayer += 3;
                    if(gameCanvas.positionXPlayer >= 1024){
                        gameCanvas.positionXPlayer = 0;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("keyReleased");
            }
        });

        //nhan nut do de dung ct
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(EXIT_ON_CLOSE);
//                System.exit(1);
            }
        });
        this.setVisible(true);
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();//lay thoi gian hien tai la so minis tinh thu thoi diem 0h0'0' ngay1/1/ 1970
            if(currentTime - this.lastTime >= 17_000_000){
                this.gameCanvas.positionXStart -= 4;
                this.gameCanvas.positionXEnemy -= 2;
                this.gameCanvas.positionYEnemy -= 2;
//                this.gameCanvas.repaint(); //yeu cau ve lai
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

//            this.gameCanvas.positionXStart -= 4;
//            this.gameCanvas.repaint(); //yeu cau ve lai
        }
    }
}
