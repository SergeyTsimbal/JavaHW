package spring4;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CacheWriter extends WriterToFileImpl {
    private int cacheSize;
    private List<String> cache;

    public CacheWriter(int cacheSize , Date date, DateFormat df, String fileName) {
        super(date, df, fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
    }

    public void destroy() {
        System.out.println("DESTROY method");
        if ( ! cache.isEmpty()) {
            writeMsgCache();
        }
    }

    public void write(String str) {
        cache.add(str);
        if (cache.size() == cacheSize) {
            writeMsgCache();
            cache.clear();
        }
    }

    private void writeMsgCache() {
        for (int i = 0; i < cache.size(); i++) {
            super.write(cache.get(i));
        }
    }

}

