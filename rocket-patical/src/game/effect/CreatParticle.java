package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class CreatParticle {
    private FrameCounter frameCounter;

    public CreatParticle() {
        this.frameCounter = new FrameCounter(100);
    }

    public void run(GameObject gameObject) {
        if (gameObject.isAlive == false) {
            int number = 4;
            while (number >= 0){
                if (this.frameCounter.run()){
                    for (double angle = 0.0; angle < 360.0; angle += 360.0 / 12.0) {
                        Particle particle = GameObjectManager.instance.recycle(Particle.class);
                        particle.position.set(gameObject.position);
                        particle.velocity.set(new Vector2D(3.5f, 0.0f).rotate(angle));
                    }
                    number -= 1;
                    this.frameCounter.reset();
                }
            }
        }
    }
}
