package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.Collider;
import renderer.ImageRenderer;

public class BulletEnemy extends GameObject implements Collider {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
        this.boxCollider = new BoxCollider(8,8);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 4, this.position.y - 4);

    }

    @Override
    public void hit(GameObject gameObject) {
        if (gameObject instanceof BulletPlayer || gameObject instanceof Player)
            this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
