class FlatDiscount implements DiscountPolicy {

    public double computeDiscount(double subtotal) {
        return 10.0;
    }
}