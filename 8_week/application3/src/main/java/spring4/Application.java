package spring4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private WriterToFile writer;
    private Messenger messenger;

    public Application(WriterToFile writer, Messenger messenger) {
        this.writer = writer;
        this.messenger = messenger;
    }

    public static void main(String[] args) {
     ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = (Application) ctx.getBean("app");

        for(int i = 0 ; i<5; i++){
            String message = app.messenger.getMessage();
            app.writer.write(message);
        }
        ctx.close();

    }

}