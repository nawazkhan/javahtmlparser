package com.parse.v1;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Parse {

	/**
	 * Testing Jsoup Library Functionality
	 */
	public static void main(String[] args) {
		
		Document doc;
		int categoriesCount = 0;
		int pCount = 0;
		
		try{
			//http protocol
			doc = Jsoup.connect("http://www.yelp.com/biz/big-cinemas-fremont-7-fremont#query:big%20cinema").get();
			//title
			String title = doc.title();
			System.out.println("title: "+title);
			System.out.println("****************End of Title*********************");
			
			//Categories List
			Elements bizCategories = doc.select("#bizCategories");
			Elements Categories = bizCategories.select("#cat_display").select("a[href]");
			for(Element category: Categories){
				++categoriesCount;
				System.out.println("category link: "+category.attr("href"));
				System.out.println("category text: "+category.text());
			}
			System.out.println("No. of Categories: "+categoriesCount);
			System.out.println("****************End of Categories*********************");
			
			Elements address = doc.select("address");
			for(Element addresslevels: address){
				System.out.println("Address text: "+addresslevels.text());
			}
			System.out.println("****************End of Address*********************");
			
			Elements phone = doc.select("#bizPhone");
			System.out.println("Phone no: "+phone.text());
			System.out.println("****************End of Phone*********************");
			
			Elements urlInfo = doc.select("#bizUrl").select("a[href]");
			System.out.println("url href: "+urlInfo.attr("href"));
			System.out.println("url text: "+urlInfo.text());
			System.out.println("****************End of UrlInfo*********************");
			/*String title = doc.title();
			System.out.println("title: "+title);
			System.out.println("****************End of Title*********************");
			
			Elements links = doc.select("a[href]");
			for(Element link : links){
				++linksCount;
				System.out.println("link: "+link.attr("href"));
				System.out.println("link text: "+link.text());
			}
			System.out.println("No. of links: "+linksCount);
			System.out.println("****************End of Links*********************");
			
			
			Elements pTags = doc.select("p");
			for(Element pTag : pTags){
				++pCount;
				System.out.println("p"+pCount+" "+pTag.text());
			}
			System.out.println("No. of pTags: "+pCount);
			System.out.println("****************End of P Tags*********************");*/
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
