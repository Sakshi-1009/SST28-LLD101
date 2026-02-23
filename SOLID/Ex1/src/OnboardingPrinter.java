import java.util.*;

public class OnboardingPrinter {

    void printSuccess(StudentRecord rec, int total) {

        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }

    void printErrors(List<String> errors) {

        System.out.println("ERROR: cannot register");
        for (String e : errors)
            System.out.println("- " + e);
    }
}