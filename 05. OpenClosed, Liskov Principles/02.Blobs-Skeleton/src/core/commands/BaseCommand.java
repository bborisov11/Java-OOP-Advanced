package core.commands;

import interfaces.BlobFactory;
import interfaces.Executable;
import interfaces.Repository;

public abstract class BaseCommand implements Executable {
    private String[] data;
    private BlobFactory factory;
    private Repository repository;

    protected BaseCommand(String[] data, BlobFactory factory, Repository repository) {
        this.data = data;
        this.factory = factory;
        this.repository = repository;
    }

    protected BlobFactory getFactory() {
        return factory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }
}
