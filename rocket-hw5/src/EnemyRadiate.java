import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyRadiate implements Attack {

    private List<BulletEnemy> bulletEnemies;
    private Counter counter;

    private Random random;

    public EnemyRadiate(){

        this.bulletEnemies = new ArrayList<>();
        this.counter = new Counter(30);
        this.random = new Random();
    }
    @Override
    public void run(GameObject gameObject) {
        ((Enemy)gameObject).velocity.set(1.0f,0.0f);
        gameObject.position.addUp(((Enemy)gameObject).velocity);
        if(this.counter.run()){
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 12.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(gameObject.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(2.5f, 0.0f)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }

            this.counter.reset();
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
        this.backtoScreen(((Enemy)gameObject));
    }

    @Override
    public void render(Graphics graphics) {
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

    private void backtoScreen(Enemy enemy) {
        if (enemy.position.x < 0) enemy.position.set(1024, this.random.nextInt(600));

        if (enemy.position.x > 1024) enemy.position.set(0, this.random.nextInt(600));

        if (enemy.position.y < 0) enemy.position.set(this.random.nextInt(1024), 600);

        if (enemy.position.y > 600) enemy.position.set(this.random.nextInt(1024), 0);
    }
}
