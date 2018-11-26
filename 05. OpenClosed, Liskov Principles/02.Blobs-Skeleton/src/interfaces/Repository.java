package interfaces;

import models.Blob;

public interface Repository {
    void addBlob(Blob blob);
    Blob getBlob(String name);
    void status();
}
