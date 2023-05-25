package ro.unibuc.info.model;

public class DigitalAsset extends Product {
    private String fileFormat;
    private long fileSize;
    private String downloadLink;
    private String filePath;

    public DigitalAsset(int id, String name, String description, int registeredUserId, String fileFormat, long fileSize, String downloadLink) {
        super(id, name, description, registeredUserId);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    public DigitalAsset() {

    }

    public DigitalAsset(int id, String name, String description, int registeredUserId, String filePath) {
        super(id, name, description, registeredUserId);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DigitalAsset{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name=").append(getName());
        sb.append(", description").append(getDescription());
        sb.append(", registeredUserId").append(getRegisteredUserId());
        sb.append(", fileFormat=").append(fileFormat);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", downloadLink=").append(downloadLink);
        sb.append('}');
        return sb.toString();
    }
}
