public class HardcodedSecret {
    // hardcoded credentials - Semgrep should catch this
    private static final String API_KEY = "sk-1234567890abcdef";
    private static final String DB_PASSWORD = "supersecret123";
    private static final String AWS_SECRET = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

    public void connect() {
        System.out.println("Connecting with key: " + API_KEY);
    }
}
