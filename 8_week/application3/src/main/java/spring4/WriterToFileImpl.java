package spring4;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class WriterToFileImpl implements WriterToFile {
    private File file;
    private String fileName = "storage5.txt";

    @PostConstruct
    public void init() throws IOException {
        System.out.println("In init method");
        this.file = new File(fileName);
        if(!file.canWrite()){
            System.err.println("Cannot write to file");
        }
    }

    private Date date;
    private DateFormat df;

    public WriterToFileImpl(Date date, DateFormat df, String fileName ) {
        this.date = date;
        this.df = df;
        this.fileName = fileName;
    }

    public void write(String str) {
        try {
            System.out.println("write to file");
            FileUtils.write(new File(fileName), date + ": " + str + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
