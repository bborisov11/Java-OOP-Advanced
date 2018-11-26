package interfaces;

import models.Blob;

public interface BlobFactory {
    Blob createBlob(String[] data);
}
