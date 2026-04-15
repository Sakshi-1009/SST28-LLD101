public class SanitizedExporter extends Exporter {
    private final Exporter delegate;

    public SanitizedExporter(Exporter delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String safeBody = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        ExportRequest sanitized = new ExportRequest(req.title, safeBody);
        return delegate.export(sanitized);
    }
}
