public class NullBug {
    public String getUpper(String s) {
        if (s == null) return null;
        return s.toUpperCase();
    }

    public void run() {
        String result = getUpper(null);
        System.out.println(result.length());
    }

    public static void main(String[] args) {
        new NullBug().run();
    }
}
