
import java.util.Random;

public class Enemy extends GameObject {

    public Vector2D velocity;
    public EnemyRadiate enemyRadiate;

    private Random random = new Random();
    private int enemyRadiateIsHere = random.nextInt(4);

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.enemyRadiate = new EnemyRadiate();
    }

    @Override
    public void run() {
        super.run();
        if (this.enemyRadiateIsHere == 3) {
            this.velocity.set(3.0f,0.0f);
            this.enemyRadiate.run(this);
        }
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null && this.enemyRadiateIsHere != 3 ) {
            Vector2D velocity = player.position
                    .subtract(this.position)
                    .normalize()
                    .multiply(1.5f);
            this.velocity.set(velocity);
        }
        this.position.addUp(this.velocity);
    }
}
