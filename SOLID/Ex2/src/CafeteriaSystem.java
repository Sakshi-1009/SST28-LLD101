import java.util.*;

public class CafeteriaSystem {

    // MENU STORAGE
    private final Map<String, MenuItem> menu =
            new HashMap<>();

    private final PricingService pricingService =
            new PricingService();

    private final TaxPolicy taxPolicy =
            new FivePercentTax();

    private final DiscountPolicy discountPolicy =
            new FlatDiscount();

    private final InvoiceFormatter formatter =
            new InvoiceFormatter();

    private final InvoiceRepository repository =
            new InMemoryInvoiceRepository();

    // ADD MENU ITEM
    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    // CHECKOUT (matches Main)
    public void checkout(String customerType,
                         List<OrderLine> lines) {

        String invoiceNo = "INV-1001";

        // Subtotal
        double subtotal =
            pricingService.calculateSubtotal(
                lines, menu);

        // Tax
        double tax =
            taxPolicy.computeTax(subtotal);

        // Discount
        double discount =
            discountPolicy.computeDiscount(subtotal);

        // Total
        double total =
            subtotal + tax - discount;

        // Format invoice
        String invoiceText =
            formatter.format(
                invoiceNo,
                lines,
                menu,
                subtotal,
                taxPolicy,
                tax,
                discount,
                total
            );

        // Print
        System.out.print(invoiceText);

        //  Save
        repository.save(invoiceNo, invoiceText);
    }
}