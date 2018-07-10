package physic;

import base.GameObject;

public interface Collider {

    void hit(GameObject gameObject);
    BoxCollider getBoxCollider();
}
