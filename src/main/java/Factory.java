import java.io.*;
import java.lang.reflect.Field;

/**
 * @author Stepan
 */
public class Factory {

    private static Factory instance = new Factory();

    private Factory(){}

    public static Factory getInstance(){
        return instance;
    }

    public B getB(String fileName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        File f = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] params = line.split(":");

        Class cb = Class.forName(params[0]);
        B pb = (B)cb.newInstance();
        Class cc = Class.forName(params[2]);
        A pc = (A) cc.newInstance();

        Field field = cb.getDeclaredField(params[1]);
        field.setAccessible(true);
        field.set(pb,pc);

        return pb;
    }
}
