import core.Engine;
import data.BlobRepository;
import factories.BlobFactoryImpl;
import interfaces.BlobFactory;
import interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository repository =  new BlobRepository();
        BlobFactory factory = new BlobFactoryImpl();
        Runnable executable = new Engine(factory, repository);
        executable.run();
    }
}
