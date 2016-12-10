package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/feed?fields=id,link,message,created_time,reactions.limit(0).summary(true)&until=1480854000&since=1480853000"
				+ "&access_token=EAACEdEose0cBAAZChcZAJ7Azw8XYWZA3FGdPEZBCKT6wglgmCqoZAl7iRIGR3fQTVAh4pZB7lOzZAvBzlPh5RDSBFqiIfBtI5FAe0OXSFuRlKE3TOXZCZCpXZBDOcTe7l8ZA3a7LU2ZC7VFxKbOwZCoscRm5JBTvfNU3Cyv0nkCZAS9TrxPQZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String message = data.select("message").text();
			// FIXIT
			String reactions = data.select("reactions total_count").text();


			output += id + "," +message+"," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
