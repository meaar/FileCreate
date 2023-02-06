import java.io.File;
import java.io.IOException;

public class FileCreate {
    private String fileName;
    private String filePath;
    private File file;

    public FileCreate(String filePath) {
        if (filePath.endsWith("/")) {
            return;
        }
        this.fileName = filePath;
        this.filePath = "";
        if (filePath.contains("/")) {
            String[] str = filePath.split("/");
            if (str.length > 1) {
                this.fileName = str[str.length-1];
                for (int i = 0; i < str.length-1; i++) {
                    if (this.filePath.endsWith("/") && str[i].isEmpty()) {
                        return;
                    }
                    this.filePath = this.filePath+str[i]+"/";
                }
            }
        }
        if (this.filePath.isEmpty()) {
            this.file = new File(this.fileName);
        } else {
            this.file = new File(this.filePath);
            if (!this.file.isDirectory()) {
                this.file.mkdirs();
                this.file = new File(this.filePath+"/"+this.fileName);
            }
        }
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
