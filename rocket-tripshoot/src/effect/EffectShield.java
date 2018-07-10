package effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;
import physic.Collider;
import renderer.ImageRenderer;

import java.util.Random;

public class EffectShield extends GameObject implements Collider {
    public BoxCollider boxCollider;
    private Random random = new Random();

    public EffectShield() {
        this.boxCollider = new BoxCollider(30, 30);
        this.renderer = new ImageRenderer("resources/images/powerup_shield.png", 30, 30);
        this.position.set(random.nextInt(1024), random.nextInt(600));

    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        Player player = GameObjectManager.instance.checkCollsion(this);
        if (player != null) {
            this.isAlive = false;
            GameObjectManager.instance.add(new Shield());
        }

    }

    public void hit(GameObject gameObject) {
        if (gameObject instanceof Player)
            this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
