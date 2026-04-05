import java.io.*;

public class ResourceLeak {
    public static void process(boolean condition) throws Exception {
        InputStream is = Runtime.getRuntime().exec("ls").getInputStream();
        if (condition) {
            return;  // leak - InputStream never closed on this path
        }
        is.close();
    }

    public static void main(String[] args) throws Exception {
        process(true);
    }
}
