package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;
import game.effect.EffectTripShoot;
import input.KeyboardInput;

public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;
    private TripShoot tripShoot;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
        this.tripShoot = new TripShoot();
    }

    @Override
    public void run(Player gameObject) {
        if (this.frameCounter.run() && EffectTripShoot.chonceTripShoot && KeyboardInput.instance.isSpace) {
            this.tripShoot.run(gameObject);
            this.frameCounter.reset();
        } else if (this.frameCounter.run() && KeyboardInput.instance.isSpace) {
            BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
            this.frameCounter.reset();
        }
    }
}
