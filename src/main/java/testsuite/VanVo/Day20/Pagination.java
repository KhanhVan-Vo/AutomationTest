package testsuite.VanVo.Day20;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pagination {
    // 1. Lấy tháng tiếp theo từ tháng hiện tại theo định dạng "October 2023"
    public String getNext1MonthFromCurrentMonth1() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentMonth = df.format(calendar.getTime());
        System.out.println("current Month: " + currentMonth);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        String nextMonth = df.format(calendar.getTime());
        System.out.println("NextMonth from curent month: " + nextMonth);
        return nextMonth;
    }

    //2. Lấy tháng hiện tại theo định dạng "September 2023"
    public String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        String currentMonth = df.format(calendar.getTime());
        System.out.println("currentMonthAsString: " + currentMonth);
        return currentMonth;
    }
    // 1. Lấy tháng trước từ tháng hiện tại theo định dạng "October 2023"
    public String getPrevious1MonthFromCurrentMonth1() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentMonth = df.format(calendar.getTime());
        System.out.println("current Month: " + currentMonth);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        String nextMonth = df.format(calendar.getTime());
        System.out.println("NextMonth from curent month: " + nextMonth);
        return nextMonth;
    }
}