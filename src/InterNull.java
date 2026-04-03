public class InterNull {
    public static String getValue(int x) {
        if (x < 0) return null;
        return "valid";
    }

    public static void main(String[] args) {
        String result = getValue(-1);
        System.out.println(result.length()); // null deref across functions
    }
}
