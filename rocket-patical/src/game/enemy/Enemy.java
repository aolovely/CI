package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.effect.CreatParticle;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private CreatParticle creatParticle;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
        this.creatParticle = new CreatParticle();

    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vector2D velocity = player.position
                    .subtract(this.position)
                    .normalize()
                    .multiply(1.5f);
            this.velocity.set(velocity);
        }
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        this.creatParticle.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
