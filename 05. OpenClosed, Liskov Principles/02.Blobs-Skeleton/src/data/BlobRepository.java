package data;

import interfaces.Repository;
import models.Blob;

import java.util.*;

public class BlobRepository implements Repository {

    private Map<String, Blob> blobs = new LinkedHashMap<>();

    @Override
    public void addBlob(Blob blob) {
        if(blob != null) {
            blobs.putIfAbsent(blob.getName(), blob);
        }
    }
    @Override
    public Blob getBlob(String name) {
        return this.blobs.get(name);
    }

    @Override
    public void status() {
        this.blobs.values()
        .forEach(x -> System.out.println(x.toString()));
    }
}
