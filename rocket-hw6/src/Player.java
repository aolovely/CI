import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public PlayMove playMove;
    public PlayerAttack playerAttack;
    private Random random = new Random();

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playMove = new PlayMove();
        this.playerAttack = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playMove.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playMove.angle;
        this.playerAttack.run(this);
    }


}
