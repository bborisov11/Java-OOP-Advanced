package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;

import java.util.NoSuchElementException;

public class RetireCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.data[1]);
        }
        catch (NoSuchElementException nsee) {
            return nsee.getMessage();
        }
        return this.data[1] + " retired!";
    }
}
