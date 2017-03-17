package news;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class NewsImpl implements News {
   static int x = 0;

    @Override
    public String getNews() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        Document doc = null;
        try {
            doc = Jsoup.connect("http://news.bigmir.net/ukraine?p=1").get();
        } catch (IOException e) {
         //   e.printStackTrace();
            System.out.println("Не доступен ресурс");
        }
        ArrayList<Object> list = new ArrayList<>();
        Elements divElements = doc.getElementsByAttributeValueContaining(
                "class", "b-prev-articles__list-item__image-outer");
        list.add(divElements);
        String a = list.get(0).toString();
        String[] b = a.split("</a>");
        int k = b[x].indexOf("alt=\"");
        String c = b[x].substring(k + 5, b[x].length());
        int l = c.indexOf("\">");
        String f = c.substring(0, l);
        String news = time + ": " +f;
        x++;
        if(x==10){
            x =0;
        }
        System.out.println(f);
        return news;
    }

}