package core.commands;

import interfaces.BlobFactory;
import interfaces.Repository;

public class StatusCommand extends BaseCommand {

    protected StatusCommand(String[] data, BlobFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public void execute() {
        this.getRepository().status();
    }
}
