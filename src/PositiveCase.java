import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PositiveCase {

  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    // get locator of all Capitals and Countries
    WebElement Seoul = driver.findElement(By.xpath("//*[text()='Seoul' and @id='box5']"));
    WebElement Korea = driver.findElement(By.xpath("//*[text()='South Korea']"));

    new Actions(driver).dragAndDrop(Seoul, Korea).perform();
    String backgroundColor = Korea.getCssValue("background-color");

    assert backgroundColor.equals("rgb(0, 255, 0)") : "Background color is not as expected";

    driver.quit();
  }
}