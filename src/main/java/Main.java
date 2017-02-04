import java.io.IOException;

/**
 * @author Stepan
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, IOException {
        Factory factory = Factory.getInstance();
        B b = factory.getB("F:\\Development\\DependencyInjection\\src\\main\\resources\\prop.properties");
        b.g();
    }
}
