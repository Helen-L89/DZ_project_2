package pages;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EventsPage extends BasePage {

    private final String pageUrl = "https://otus.ru/events/calendar";
    private final By eventCardLocator = By.cssSelector(".event-card");
    private final By eventDateLocator = By.cssSelector(".event-date");

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        open(pageUrl);
    }

    public List<WebElement> getEventCards() {
        return driver.findElements(eventCardLocator);
    }

    public String getEventDate(WebElement eventCard) {
        return eventCard.findElement(eventDateLocator).getText();
    }
}