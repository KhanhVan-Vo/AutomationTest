package testsuite.VanVo.Day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class EventPaginationTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rise.fairsketch.com/events#");

        // Lấy tháng hiện tại
        String currentMonth = getCurrentMonth();
        System.out.println("Tháng hiện tại: " + currentMonth);

        // Lặp để kiểm tra next và previous trang
        for (int i = 0; i < 2; i++) {
            // In tháng và năm hiện tại
            System.out.println("Tháng và năm hiện tại: " + currentMonth);

            // Thực hiện kiểm tra ở đây, ví dụ: In ra số sự kiện trên trang
            WebElement eventCountElement = driver.findElement(By.className("event-count"));
            String eventCountText = eventCountElement.getText();
            System.out.println("Số sự kiện trên trang: " + eventCountText);

            // Di chuyển đến trang tiếp theo
            WebElement nextButton = driver.findElement(By.className("next-button"));
            nextButton.click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentMonth = getNext1MonthFromCurrentMonth1();
        }

        // Đóng trình duyệt sau khi hoàn thành
        driver.quit();
    }

    public static String getNext1MonthFromCurrentMonth1() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.add(Calendar.MONTH, 1);
        return df.format(calendar.getTime());
    }

    public static String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        return df.format(calendar.getTime());
    }
}
