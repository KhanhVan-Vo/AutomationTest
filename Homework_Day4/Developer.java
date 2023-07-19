package Homework_Day4;

public class Developer {
    public static void main(String[] args) {
        Employee developer = new Employee();
        developer.setId(1234);
        developer.setName("Nguyen Van A");
        System.out.println(developer.getInfo());
    }
    /* Nhận xét
     * - Vì thuộc tính salary có giá trị private nên tại class Developer không thể gọi trực tiếp biến salary để lấy cập nhật giá trị được mà phải sử dụng đến phương thức setter() và getter()
     * - Vì không có phương thức setter tại class Employee nên tại class Developer không cập nhật được giá trị của thuộc tính salary
     * --> Nên khi 1 object gọi hàm getter để in ra giá trị lương của nhân viên (dòng code 8) thì chỉ in ra được giá trị mặc định ban đầu (ở đây là 0) của thuộc tính lương
     * --> Nếu 1 thuộc tính không có hàm setter thì chúng sẽ chỉ có 1 giá trị duy nhất là giá trị mặc định ban đầu đối với tất cả các object.
     * - Trong trường hợp này nếu không có hàm setter mà vẫn muốn lấy ra được lương của từng đối tượng khác nhau thì cần phải tạo ra 1 phương thức mới để tính lương
     * (Ví dụ là phương thức rawSalary tại class Employee)
     * Tuy nhiên phương thức này có nhược điểm là phải update biến salary tại luôn phương thức --> Biến salary bị update
     * --> điều này trái với mong muốn là ngăn chặn sự thay đổi và truy cập đến biến
     * --> khá kém linh động trong việc sử dụng đối với các object khác nhau
     */
}

