package deputaty;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class VerchovnaRada {

    private static VerchovnaRada instance;

    private VerchovnaRada() {
    }

    public static VerchovnaRada getInstance() {
        if (instance == null) {
            instance = new VerchovnaRada();
        }
        return instance;
    }

    static LinkedHashMap<String, ArrayList<Deputat>> hashMap = new LinkedHashMap<>();

    public static void addFraction() {
        System.out.print("Введіть ім'я фракції, яку хочите додати - ");
        Scanner scr = new Scanner(System.in);
        String fractionName = scr.next();
        hashMap.put(fractionName, new ArrayList<>());
    }

    public static void removeFraction() {
        System.out.println(hashMap.keySet());
        if (!hashMap.isEmpty()) {
            System.out.println(hashMap.keySet());
            System.out.print("Введіть назву фракції, яку хочите видалити: ");
            String choose = Fraction.scann();
            if (hashMap.keySet().contains(choose)) {
                hashMap.remove(choose);
                System.out.println("\n\tФракцію видалено, депутати депортовані");
            } else {
                System.out.println("\n\tТакої фракції не існує");
            }
        }else {
            System.out.println("\n\tНема фракцій");
        }
    }

    public static void showAllFraction() {
        System.out.println(hashMap);
    }

    public static void showFraction() {
        if (!hashMap.isEmpty()) {
            System.out.println(hashMap.keySet());
            System.out.print("Введіть назву фракції, яку хочите вивести: ");
            String name = Fraction.scann();
            if (hashMap.get(name).isEmpty()) {
                System.out.println("\n\t Фракція пуста");
            } else {
                System.out.println(hashMap.get(name));
            }
        }else {
            System.out.println("\n\tНема фракцій");
        }
    }


}
