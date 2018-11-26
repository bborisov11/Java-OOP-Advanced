package core.commands;

import com.sun.org.apache.regexp.internal.RE;
import interfaces.BlobFactory;
import interfaces.Repository;
import models.Blob;

public class CreateCommand extends BaseCommand {

    public CreateCommand(String[] data, BlobFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public void execute() {
        this.getRepository().addBlob(this.getFactory().createBlob(this.getData()));
             this.getFactory().createBlob(this.getData());
    }
}
