import java.util.*;

public class OnboardingService {

    private final StudentRepository db;
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final OnboardingPrinter printer = new OnboardingPrinter();

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    public void registerFromRawInput(String raw) {

        System.out.println("INPUT: " + raw);

        // Parse
        StudentDraft draft = parser.parse(raw);

        // Validate
        List<String> errors = validator.validate(draft);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        // Generate ID
        String id = IdUtil.nextStudentId(db.count());

        // Create record
        StudentRecord rec = new StudentRecord(id, draft.name, draft.email, draft.phone, draft.program);

        // Save
        db.save(rec);

        // Print
        printer.printSuccess(rec, db.count());
    }
}