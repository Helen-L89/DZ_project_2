package tests;

import pages.CoursesPage;
import utils.DriverManager;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class CoursesTests {

    private WebDriver driver;
    private CoursesPage coursesPage;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.createDriver();
        coursesPage = new CoursesPage(driver);

    }

    @Test
    public void testCourseCardCount() {
        coursesPage.openPage();
        assertEquals(10, coursesPage.getCourseCardCount(), "Expected 10 course cards on the page.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}