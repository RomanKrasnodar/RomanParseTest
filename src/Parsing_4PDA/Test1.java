package Parsing_4PDA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test1 {

  public static void main(String[] args) {

    List<Article> articleList = new ArrayList<>();

    Document document = null;

    {
      try {
        document = Jsoup.connect("https://4pda.ru/").get();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    Elements h1Elements = document.getElementsByAttributeValue("class", "list-post-title");

    h1Elements.forEach(h1Element -> {
      Element aElement = h1Element.child(0);
      String url = aElement.attr("href");
      String title = h1Element.child(0).text();

      articleList.add(new Article(url,title));
    });

    articleList.forEach(System.out::println);

  }

}
