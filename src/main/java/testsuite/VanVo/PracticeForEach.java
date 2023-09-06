package testsuite.VanVo;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeForEach {
    String name;
    String obj;

    public static void main(String[] args) {
        Scanner employeeNum = new Scanner(System.in);
        System.out.println("Nhập số nhân viên: ");
        int n = employeeNum.nextInt();
        PracticeForEach employeeName[] = new PracticeForEach[n];
        for (int i = 0; i < n; i++) {
            employeeName[i] = new PracticeForEach();
            System.out.print("Nhap ten nhan vien thu " + (i + 1) + ": ");
            employeeName[i].name = employeeNum.next();
        }
        for (PracticeForEach obj : employeeName) {
            System.out.println(obj.name);
        }
    }
}