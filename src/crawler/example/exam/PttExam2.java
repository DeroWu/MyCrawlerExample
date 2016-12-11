package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */

public class PttExam2 {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481414372.A.E7F.html";



		Document elem=CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri);
			    //.getFromXml(uri)

			    // 這兒開始是 Jsoup Document 物件操作

		for(Element content:elem.select("#main-content div")){
					content.remove();
		}
		for(Element content:elem.select("#main-content [target='_blank']~span")){
				content.remove();
		}
		elem.select("#main-content [target='_blank']").remove();

		System.out.println(elem.select("#main-content").text());

	}
}
