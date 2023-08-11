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
    WebElement Copenhagen = driver.findElement(By.xpath("//*[text()='Copenhagen' and @id='box4']"));
    WebElement Washington = driver.findElement(By.xpath("//*[text()='Washington' and @id='box3']"));
    WebElement Rome = driver.findElement(By.xpath("//*[text()='Rome' and @id='box6']"));
    WebElement Oslo = driver.findElement(By.xpath("//*[text()='Oslo' and @id='box1']"));
    WebElement Stockholm = driver.findElement(By.xpath("//*[text()='Stockholm' and @id='box2']"));
    WebElement Madrid = driver.findElement(By.xpath("//*[text()='Madrid' and @id='box7']"));

    WebElement Korea = driver.findElement(By.xpath("//*[text()='South Korea']"));
    WebElement Italy = driver.findElement(By.xpath("//*[text()='Italy']"));
    WebElement Spain = driver.findElement(By.xpath("//*[text()='Spain']"));
    WebElement Norway = driver.findElement(By.xpath("//*[text()='Norway']"));
    WebElement Denmark = driver.findElement(By.xpath("//*[text()='Denmark']"));
    WebElement Sweden = driver.findElement(By.xpath("//*[text()='Sweden']"));
    WebElement UnitedStates = driver.findElement(By.xpath("//*[text()='United States']"));

    WebElement[] capitals = {Seoul, Madrid, Copenhagen, Rome, Oslo, Stockholm, Washington};
    WebElement[] countries = {Korea, Spain, Denmark, Italy, Norway, Sweden, UnitedStates};

    for (int i = 0; i < capitals.length; i++) {
      new Actions(driver).dragAndDrop(capitals[i], countries[i]).perform();

      // Assert the background color has been changed if the combination is correct
      String backgroundColor = capitals[i].getCssValue("background-color");
      if (backgroundColor.equals("rgba(0, 255, 0, 1)")) {
        System.out.println("Correct: " + capitals[i].getText());
      }
      else {
        System.out.println("Incorrect: " + capitals[i].getText());
      }
    }

    driver.quit();
  }
}