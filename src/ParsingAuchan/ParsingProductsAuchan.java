package ParsingAuchan;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsingProductsAuchan {

  private static ParsingProductsAuchan productLinksService = new ParsingProductsAuchan();

  public static void main(String[] args) throws IOException {

    List<String> testParseProducts = productLinksService.parseAllProductCatalogLinks();

    testParseProducts.forEach(System.out::println);

  }

  public List<String> parseAllProductCatalogLinks() throws IOException {

    List<String> productLinks = new ArrayList<>();

    Document document = Jsoup
        .parse(new URL("https://www.auchan.ru/catalog/sport-i-otdyh/komandnye-vidy-sporta/myachi/"),
            10000);

    Elements elements = document.getElementsByAttributeValue("class", "linkToPDP css-1kl2eos");
    elements.forEach(element -> {
      String urlProduct = element.attr("href");
      productLinks.add(urlProduct);
    });

    return productLinks;

  }
}
//<a class="linkToPDP css-1kl2eos" href="/product/myach-basketbolnyy-cups-cs100-razmer-3/" dataga-autotrack="link">Мяч баскетбольный Cups CS100, размер 3</a>

