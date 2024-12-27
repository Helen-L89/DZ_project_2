package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage extends BasePage {

    private final String pageUrl = "https://otus.ru/catalog/courses?categories=testing";
    private final By courseCardLocator = By.cssSelector(".course-card");

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        open(pageUrl);
    }

    public int getCourseCardCount() {
        return driver.findElements(courseCardLocator).size();
    }
}
