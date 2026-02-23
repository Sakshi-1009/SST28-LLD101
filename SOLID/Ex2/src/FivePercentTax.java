class FivePercentTax implements TaxPolicy {

    public double computeTax(double subtotal) {
        return subtotal * 0.05;
    }

    public String label() {
        return "Tax(5%)";
    }
}