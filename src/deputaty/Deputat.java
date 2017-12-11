package deputaty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Deputat extends People {

    private String name;
    private String surName;
    private int age;
    private boolean bribe;
    private int bribeValue;

    public Deputat(int height, int weight, String name, String surName, int age, boolean bribe) {
        super(height, weight);
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.bribe = bribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBribe() {
        return bribe;
    }

    public void setBribe(boolean bribe) {
        this.bribe = bribe;
    }

    public int getBribeValue() {
        return bribeValue;
    }

    public void setBribeValue(int bribeValue) {
        this.bribeValue = bribeValue;
    }

    @Override
    public String toString() {
        return "Deputat{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", bribe=" + bribe +
                ", bribeValue=" + bribeValue +
                '}';
    }

    public static void getBribe() {
        System.out.println("Депутати: " + VerchovnaRada.hashMap.values());
        if (!VerchovnaRada.hashMap.values().isEmpty()) {
            Iterator<Map.Entry<String, ArrayList<Deputat>>> entryIt = VerchovnaRada.hashMap.entrySet().iterator();
            System.out.println("Введіть ім'я та прізвище депутата якому дати хабар: ");
            String name = Fraction.scann();
            String surName = Fraction.scann();
            while (entryIt.hasNext()) {
                Map.Entry<String, ArrayList<Deputat>> fractionIt = entryIt.next();
                if (!fractionIt.getValue().isEmpty()) {
                    Iterator<Deputat> iterator = fractionIt.getValue().iterator();
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.getName().equals(name) && deputat.getSurName().equals(surName)) {
                            if (deputat.isBribe()) {
                                System.out.println("\n\tВведіть розмір взятки:");
                                int bribeV = Fraction.scannInt();
                                deputat.setBribeValue(bribeV);
                                if (deputat.getBribeValue() > 5000) {
                                    System.out.println("\n\tМіліція ув'язнить депутата");
                                    Main.recursion();
                                } else {
                                    deputat.setBribeValue(bribeV);
                                    Main.recursion();

                                }
                            } else {
                                System.out.println("\n\tДепутат взяток не бере");
                                Main.recursion();
                            }
                        }
                    }
                } else {
                    System.out.println("\n\tХабарників нема");
                }
            }
        } else {
            System.out.println("\n\tНема депутатів");
            Main.recursion();
        }
    }
}