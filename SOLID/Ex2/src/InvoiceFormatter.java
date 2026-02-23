import java.util.*;

class InvoiceFormatter {

    String format(String invoiceNo,
                  List<OrderLine> lines,
                  Map<String, MenuItem> menu,
                  double subtotal,
                  TaxPolicy taxPolicy,
                  double tax,
                  double discount,
                  double total) {

        StringBuilder sb = new StringBuilder();

        sb.append("Invoice# ").append(invoiceNo).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);

            sb.append("- ")
              .append(item.name)
              .append(" x")
              .append(l.qty)
              .append(" = ")
              .append(String.format("%.2f",
                       item.price * l.qty))
              .append("\n");
        }

        sb.append("Subtotal: ")
          .append(String.format("%.2f", subtotal))
          .append("\n");

        sb.append(taxPolicy.label())
          .append(": ")
          .append(String.format("%.2f", tax))
          .append("\n");

        sb.append("Discount: -")
          .append(String.format("%.2f", discount))
          .append("\n");

        sb.append("TOTAL: ")
          .append(String.format("%.2f", total))
          .append("\n");

        return sb.toString();
    }
}