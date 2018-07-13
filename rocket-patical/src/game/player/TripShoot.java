package game.player;

import base.GameObjectAttributes;
import base.GameObjectManager;

public class TripShoot implements GameObjectAttributes<Player> {
    @Override
    public void run(Player gameObject) {
        for (double angle = 0.0; angle <= 360.0; angle += 120.0) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f).rotate(angle));
            GameObjectManager.instance.add(bulletPlayer);
        }
    }
}
