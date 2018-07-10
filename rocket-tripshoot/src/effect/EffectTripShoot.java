package effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.util.Random;

public class EffectTripShoot extends GameObject {

    public BoxCollider boxCollider;
    private Random random = new Random();
    private FrameCounter frameCounter;
    public static boolean chonceTripShoot = false;

    public EffectTripShoot() {
        this.boxCollider = new BoxCollider(30, 30);
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 30, 30);
        this.position.set(random.nextInt(1024), random.nextInt(600));
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        if (this.frameCounter.run()) {
            this.frameCounter.reset();
        }
        Player player = GameObjectManager.instance.checkCollsion(this);
        if (player != null) {
            this.isAlive = false;
            EffectTripShoot.chonceTripShoot = true;
        }
    }
}
