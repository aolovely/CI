import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemyShoot implements Attack {
    private List<BulletEnemy> bulletEnemies;
    private Counter counter;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
        this.counter = new Counter(20);
    }

    @Override
    public void run(GameObject gameObject) {
        gameObject.position.addUp(((Enemy) gameObject).velocity);
        if (this.counter.run()) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(gameObject.position);
            bulletEnemy.velocity.set(((Enemy) gameObject).velocity.copy().multiply(2f));
            this.bulletEnemies.add(bulletEnemy);
            this.counter.reset();
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    @Override
    public void render(Graphics graphics) {
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
