package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreatEnemy extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public CreatEnemy() {
        this.frameCounter = new FrameCounter(150);
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.frameCounter.reset();
        }
    }
}
