package edu.csuft.lshring.mspider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author lshring
 *
 */
public class App {

	// alt + /
	// ctrl + s
	public static void main(String[] args) {

		// 目标 URL
		String url = "https://movie.douban.com/top250";

		// 使用 JSOUP 抓去文档
		try {
			Document doc = Jsoup.connect(url).get();

			Elements es = doc.select(".grid_view .item");

			System.out.println(es.size());
			
/*			for (Element e : es) {
			System.out.println(e.attr("src"));
			}*/
			// 创建一个影片的列表
			ArrayList<Film> list = new ArrayList<>();

			for (Element e : es) {
				Film f = new Film();
				// 每一部影片
				Elements id = e.select(".pic em");
				Element title = e.select(".title").first() ;
				Elements poster = e.select("img");
				String info = e.select(".bd p").first().text();
				Elements rating = e.select(".rating_num");
				String num = e.select(".star span").last().text();
				String quote = e.select(".inq").text();
				
				System.out.println(id.text()+ ", " + title.text()+ ", " + poster.attr("src") + ", "+rating.text()  +", " + info + ", " + num+ ", " +quote);

//				f.id
//				f.title
//				f.poster
//				f.info
//				f.rating
//				f.num
//				f.quote
				list.add(f);
			}

//			String title = doc.title();
//			String data = doc.data();

//			System.out.println(title);
//			System.out.println(data);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
