package tests;

import pages.EventsPage;
import utils.DriverManager;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventsTests {

    private WebDriver driver;
    private EventsPage eventsPage;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.createDriver();
        eventsPage = new EventsPage(driver);

    }

    @Test
    public void testEventDates() {
        eventsPage.openPage();
        eventsPage.getEventCards().forEach(eventCard -> {
            String dateText = eventsPage.getEventDate(eventCard);
            LocalDate eventDate = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            assertFalse(eventDate.isBefore(LocalDate.now()), "Event date should not be in the past.");
        });
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
