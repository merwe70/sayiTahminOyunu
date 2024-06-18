import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void wrongNumber(int[] wrong) {
        for (int i : wrong) {
            if (i != 0) {
                System.out.print(i + ",");
            }
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int number = rand.nextInt(100);
        Scanner input = new Scanner(System.in);
        System.out.println(number);

        int selected, right = 0;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right < 5) {
            System.out.print("Tahmininizi giriniz : ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {

                if (!isWrong) {
                    isWrong = true;
                    System.out.println("0-100 arası bir değer girmediniz tekrar ederseniz hakkınızdan düşülecektir.");
                } else {
                    wrong[right] = selected;
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hakkınız : " + (5 - right));

                }
                continue;
            }

            if (selected == number) {
                System.out.println("Tebrikler doğru tahmin ettiniz. Random sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz.");
                wrong[right] = selected;
                right++;
                if (selected < number) {
                    System.out.println("Girdiğiniz sayı random sayıdan küçüktür.");
                }
                if (selected > number) {
                    System.out.println("Girdiğiniz sayı random sayıdan büyüktür.");
                }
                System.out.println("Kalan hakkınız : " + (5 - right));
            }
        }
        if (!isWin) {
            System.out.println("Kaybettiniz.");
            if (isWrong) {
                System.out.print("Hatalı girişler : ");
                wrongNumber(wrong);
            }

        }

    }
}