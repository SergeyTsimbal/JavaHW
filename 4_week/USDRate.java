import java.io.*;
import java.net.URL;


public class USDRate {
	static String s;
	static int f;

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://finance.i.ua");
		InputStream is = url.openStream();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));

		while ((s = dis.readLine()) != null) {
		if (f == 185) {
			int f = s.indexOf("<span>");
			String t = s.substring(f + 6, s.length());
				int b = t.indexOf("</span>");
				String USD = t.substring(0, b);
				System.out.println("Курс доллара НБУ на сегодня = " + USD);
			}
			f++;
		}
		is.close();

	}

}
