import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {


    public static void main(String[] args) {
         WebDriver d = new ChromeDriver();

        d.get("https://www.google.com");

        d.quit();
    }
}
