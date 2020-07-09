package com.admin.book.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.book.Service.BService;


@Controller
public class Crwaling2 {

	@Autowired
	BService bservice;

	@RequestMapping("/crwaling")
	public void crwaling() {

		// Jsoup를 이용해서 네이버 스포츠 크롤링

		String url = "http://justshowup.co.kr/content/contentList.ink?brcd=&sntnAuthCode=&contentAll=Y&cttsDvsnCode=001&ctgrId=&orderByKey=publDate&selViewCnt=80&pageIndex=1&recordCount=80";

		Document doc = null;
		try {

			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 주요 뉴스로 나오는 태그를 찾아서 가져오도록 한다.

		Elements element = doc.select(".book_resultList li");

		Elements element2 = doc.select(".img a img");

		for (Element el : element2) {

			// String href = el.attr("abs:src");
			String href = el.attr("src");

			String alt = el.attr("alt");

			System.out.println(href);
			
			System.out.println(alt);
			
			bservice.url_update(href, alt);
			
//			Elements img = el.select(".img a img"); 
//			
//			System.out.println("이미지 : "+img);

		}

		// 1. 헤더 부분의 제목을 가져온다.

		// String title = element.select("h2").text();

		System.out.println("============================================================");

		// System.out.println(title);

		System.out.println("============================================================");

		for (Element el : element) {

			String title = el.select("li .tit").text();

			String company = el.select("li .writer span").text();

			String content = el.select("li .txt").text();

			if (title.isEmpty() || company.isEmpty() || content.isEmpty()) {

			} else {

				System.out.println("제목 : " + title); // 제목

				System.out.println("출판사 : " + company); // 출판사

				System.out.println("내용 : " + content); // 상세설명

				String total = el.select("li .writer").text();

				String open = el.select("li .writer span").text();

				String[] test = total.split(open);

				String writer = test[0];
				
				String date = test[1];
				
		        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		        
		        Date open1 = null;
		      
		        try {
		        	
		        	open1 = format.parse(date);
		        	
		        } 
		        catch (ParseException e) {
		        	
		            e.printStackTrace();
		            
		        }


				System.out.println("저자 :  " + test[0]);
				
				System.out.println("날짜 :  " + test[1]);
				
				System.out.println("날짜2 :  " + open1);
				
				//bservice.book_insert(title, writer, company, open1, content);

			}

		} // else

		System.out.println("============================================================");
	}

}
