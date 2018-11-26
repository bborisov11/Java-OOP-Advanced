package interfaces;

import models.Blob;

public interface Attack {
    void attack(Blob source, Blob target);
   void respond(int damage);
}
