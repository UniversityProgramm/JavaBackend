import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String inputStr = sc.nextLine();
        String oldStr1 = "кака";
        String oldStr2 = "бяка";
        String strForReplace = "вырезано цензурой";
        inputStr = inputStr.replaceAll(oldStr1, strForReplace);
        inputStr = inputStr.replaceAll(oldStr2, strForReplace);
        System.out.println(inputStr);
    }
}
