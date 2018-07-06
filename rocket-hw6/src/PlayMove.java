import java.util.Random;

public class PlayMove {

    public Vector2D velocity;
    private Random random;
    public double angle = 0.0;

    public PlayMove() {
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    public void run(Player player) {
        if (KeyBoard.keyBoard.keyLeft) {
            this.angle -= 5.0;
            KeyBoard.keyBoard.keyLeft = false;
        }
        if (KeyBoard.keyBoard.keyRight) {
            this.angle += 5.0;
            KeyBoard.keyBoard.keyRight = false;
        }
        Vector2D vector2D = new Vector2D(3.5f,0.0f);
        this.velocity.set(vector2D.rotate(angle));
        player.position.addUp(this.velocity);
        this.backtoScreen(player);
    }

    private void backtoScreen(Player player) {
        if (player.position.x < 0) player.position.set(1024, this.random.nextInt(600));

        if (player.position.x > 1024) player.position.set(0, this.random.nextInt(600));

        if (player.position.y < 0) player.position.set(this.random.nextInt(1024), 600);

        if (player.position.y > 600) player.position.set(this.random.nextInt(1024), 0);
    }
}
