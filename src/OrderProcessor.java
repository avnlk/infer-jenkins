public class OrderProcessor {
    public double calculateDiscount(String customerType, int years, double amount) {
        if (customerType.equals("PREMIUM")) {
            if (years > 10) {
                if (amount > 10000) { return amount * 0.30; }
                else if (amount > 5000) { return amount * 0.25; }
                else { return amount * 0.20; }
            } else if (years > 5) {
                if (amount > 10000) { return amount * 0.25; }
                else { return amount * 0.20; }
            } else { return amount * 0.15; }
        } else if (customerType.equals("REGULAR")) {
            if (years > 10) { return amount * 0.15; }
            else if (years > 5) { return amount * 0.10; }
            else { return amount * 0.05; }
        }
        return 0;
    }
}
