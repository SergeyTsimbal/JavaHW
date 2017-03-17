package news;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Timer;
import java.util.TimerTask;


public class Application {
    private WriterToFile writer;
    private News news;

    public Application(WriterToFile writer, News news) {
        this.writer = writer;
        this.news = news;
    }

    public static void main(String[] args) {
        //ConfigurableApplicationContext ctx =  new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = (Application) ctx.getBean("app");


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                for (int i = 0; i < 5; i++) {
                    String message = app.news.getNews();
                    app.writer.write(message);
                }

            }

        }, 0, 10000);


    }

}