package com.parse.v1;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.jsoup.nodes.Node;

public class ArticleParse {

	/**
	 * Testing Jsoup Library Functionality
	 */
	public static void main(String[] args) {
		
		Document doc;
		int categoriesCount = 0;
		int pCount = 0;
		
		try{
			//http protocol
			doc = Jsoup.connect("http://www.washingtonpost.com/national/health-science/healthcaregov-goal-80-percent-able-to-enroll-for-insurance-through-web-site/2013/11/16/04fa02a2-4e1a-11e3-ac54-aa84301ced81_story.html").get();
			//title
			String title = doc.title();
			System.out.println("title: "+title);
			System.out.println("****************End of Title*********************");
			
			//Top Image
			/*Elements h1 = doc.select("h1");
			for(Element h: h1){
				System.out.println(h.nextElementSibling().select("img"));
			}*/
			
			/*Elements images = doc.select("img");
			for(Element image: images){
				System.out.println(image);
			}*/
			
				
			/*for(Element image: Images){
				System.out.println("img src: "+image.attr("src"));
			}*/
			//System.out.println("****************End of Image*********************");
			
			//Article Text
			Elements article = doc.select("article").select("p");
			for(Element articleText: article){
				++pCount;
				System.out.println("p"+pCount+" :"+articleText.text());
			}
			System.out.println("No. of Ptags inside an Article: "+pCount);
			
			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
