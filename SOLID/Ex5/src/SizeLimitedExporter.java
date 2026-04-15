public class SizeLimitedExporter extends Exporter {
    private final Exporter delegate;
    private final int maxSize;
    private final String errorMsg;

    public SizeLimitedExporter(Exporter delegate, int maxSize, String errorMsg) {
        this.delegate = delegate;
        this.maxSize = maxSize;
        this.errorMsg = errorMsg;
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        if (req.body != null && req.body.length() > maxSize) {
            throw new IllegalArgumentException(errorMsg);
        }
        return delegate.export(req);
    }
}
