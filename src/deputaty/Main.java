package deputaty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tВітаємо у верховній зраді");
        menu();
    }


    public static void menu() {
        System.out.println("Введіть 1 щоб додати фракцію\n" +
                "Введіть 2 щоб видалити фракцію\n" +
                "Введіть 3 щоб очистити фракцію\n" +
                "Введіть 4 щоб вивести фракції\n" +
                "Введіть 5 щоб вивести фракцію\n" +
                "Введіть 6 щоб додати депутата до фракції\n" +
                "Введіть 7 щоб видалити депутата з фракції\n" +
                "Введіть 8 щоб вивести список хабарників\n" +
                "Введіть 9 щоб вивести найбільшого хабарника\n"+
                "--------------------------------------\n" +
                "Введіть 10 щоб дати хабар\n"+
                "Введіть 11 щоб показати всіх хабарників фракції\n"+
                "Введіть 12 щоб показати найбільшого хабарника фракції\n");

        Scanner scr = new Scanner(System.in);
        String choose = scr.next();
        switch (choose) {
            case "1":
                VerchovnaRada.addFraction();
                recursion();
                break;
            case "2":
                VerchovnaRada.removeFraction();
                recursion();
                break;
            case "3":
                Fraction.cleanFraction();
                recursion();
                break;
            case "4":
                VerchovnaRada.showAllFraction();
                recursion();
                break;
            case "5":
                VerchovnaRada.showFraction();
                recursion();
                break;
            case "6":
                Fraction.addDeputy();
                recursion();
                break;
            case "7":
                Fraction.removeDeputy();
                recursion();
                break;
            case "8":
                Fraction.showAllBribes();
                recursion();
                break;
            case "9":
                Fraction.showBiggestBribe();
                recursion();
                break;
            case "10":
                Deputat.getBribe();
                recursion();
                break;
            case "11":
                Fraction.showAllFractionBribes();
                recursion();
                break;
            case "12":
                Fraction.showBiggestFractionBribe();
                recursion();
                break;
            default:
                System.out.println("Введіть 1-10");
                menu();
                break;
        }

    }

    public static void recursion() {
        System.out.println("\n\nЩоб продовжити натисніть       - 1\n" +
                "Щоб завершити роботу натисніть - 2\n");
        Scanner scr = new Scanner(System.in);
        String chose = scr.next();
        switch (chose) {
            case "1":
                menu();
                break;

            case "2":
                System.out.println("Бомба вже летить на раду");
                System.exit(0);
            default:
                System.out.println("Введіть 1 або 2");
                recursion();
        }
    }
}
