import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyRadiate {

    private FrameCounter frameCounter;
    private Random random;

    public EnemyRadiate() {
        this.frameCounter = new FrameCounter(100);
        this.random = new Random();
    }

    public void run(Enemy enemy) {

        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 12.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(2.5f, 0.0f)).rotate(angle)
                );
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }
}