import java.util.*;

class InMemoryInvoiceRepository
        implements InvoiceRepository {

    private final Map<String,String> store =
            new HashMap<>();

    public void save(String invoiceNo,
                     String invoiceText) {

        store.put(invoiceNo, invoiceText);

        System.out.println(
            "Saved invoice: " + invoiceNo +
            " (lines=" +
            invoiceText.split("\n").length + ")"
        );
    }
}