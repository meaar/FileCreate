import java.io.File;

public class FileCreate {
    private String fileName;
    private String filePath;
    private File file;

    public FileCreate(String filePath) {

    }

    public String getFilePath() {
        return this.filePath;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public File getFile() {
        return this.file;
    }
}
