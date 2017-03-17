package news;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfig {

    @Bean
    public News news(){
        return new NewsImpl();
    }

    @Bean
    @Scope("prototype")
    public WriterToFile writerToFile(){
        return new WriterToFileImpl("news.txt");
    }

    @Bean(destroyMethod = "destroy")
    public CacheWriter cacheWriter(){
        return new CacheWriter(20, "news.txt");
    }


    @Bean(name = "app")
    public Application application() {
        return new Application(cacheWriter(),news());
    }
}
