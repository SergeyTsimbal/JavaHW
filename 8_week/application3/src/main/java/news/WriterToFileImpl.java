package news;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

public class WriterToFileImpl implements WriterToFile {
    private File file;
    private String fileName = "news.txt";

    @PostConstruct
    public void init() throws IOException {
        System.out.println("In init method");
        this.file = new File(fileName);
        if(!file.canWrite()){
            System.err.println("Cannot write to file");
        }
    }

    public WriterToFileImpl(String fileName ) {
        this.fileName = fileName;
    }

    public void write(String str) {
        try {
            System.out.println("write to file");
            FileUtils.write(new File(fileName), str + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
