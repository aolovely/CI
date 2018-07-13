package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import effect.Shield;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.util.Random;

public class EffectShield extends GameObject implements PhysicBody {
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

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Player)
            this.isAlive = false;
        GameObjectManager.instance.add(new Shield());
    }
}
