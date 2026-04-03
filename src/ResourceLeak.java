import java.io.*;

public class ResourceLeak {
    public static void process(boolean condition) throws Exception {
        FileReader f = new FileReader("data.txt");
        if (condition) {
            return;  // leak - FileReader never closed on this path
        }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        process(true);
    }
}
