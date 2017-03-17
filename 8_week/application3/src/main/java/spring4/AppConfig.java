package spring4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.DateFormat;
import java.util.Date;

@Configuration
public class AppConfig {
    DateFormat df = DateFormat.getDateInstance();
    @Bean
    public Messenger messengerImpl(){
        return new MessengerImpl();
    }

    @Bean
    @Scope("prototype")
    public WriterToFile writerToFile(){
        return new WriterToFileImpl(new Date(), df, "storage5.txt");
    }

    @Bean(destroyMethod = "destroy")
    public CacheWriter cacheWriter(){
        return new CacheWriter(3, new Date(), df, "storage5.txt");
    }


    @Bean(name = "app")
    public Application application() {
        return new Application(cacheWriter(),messengerImpl());
    }
}
