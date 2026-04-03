public class IntraNull {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length()); // obvious null deref, same function
    }
}
