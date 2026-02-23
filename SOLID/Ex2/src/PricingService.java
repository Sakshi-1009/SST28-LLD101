import java.util.*;

class PricingService {

    double calculateSubtotal(
            List<OrderLine> lines,
            Map<String, MenuItem> menu) {

        double total = 0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            total += item.price * l.qty;
        }

        return total;
    }
}