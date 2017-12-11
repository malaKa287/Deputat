package deputaty;

import java.util.*;

public class Fraction {

    public static String scann() {
        return new Scanner(System.in).nextLine();
    }

    public static int scannInt() {
        return new Scanner(System.in).nextInt();
    }


    public static void addDeputy() {
        if (!VerchovnaRada.hashMap.isEmpty()) {
            System.out.println("Введіть назву фракції, в яку добавити депутата");
            System.out.println(VerchovnaRada.hashMap.keySet());
            Scanner scr = new Scanner(System.in);
            String fractionName = scann();
            if (VerchovnaRada.hashMap.containsKey(fractionName)) {
                System.out.println("Введіть висоту, вагу, ім'я, прізвище, вік, хабарник?   (через enter)");
                try {
                    VerchovnaRada.hashMap.get(fractionName).add(new Deputat(scannInt(), scannInt(), scann(), scann(), scannInt(), scr.nextBoolean()));
                    System.out.println("Депутата додано");
                    Main.recursion();
                } catch (NumberFormatException e) {
                    System.out.println("\n\tВведіть дані правильно");
                    addDeputy();
                } catch (InputMismatchException ex) {
                    System.out.println("\n\tВведіть дані правильно");
                    addDeputy();
                }
            } else {
                System.out.println("\tТакої фракції не існує");
                Main.recursion();
            }
        }else {
            System.out.println("\n\tНема фракцій");
        }
    }

    public static void removeDeputy() {

        System.out.println("Фракції: " + VerchovnaRada.hashMap.keySet());
        if (!VerchovnaRada.hashMap.keySet().isEmpty()) {
            System.out.println("Введіть назву фракції з якої видалити депутата: ");
            String fractionName = Fraction.scann();
            if (VerchovnaRada.hashMap.containsKey(fractionName)) {
                if (!VerchovnaRada.hashMap.get(fractionName).isEmpty()) {
                    System.out.println("Введіть ім'я та прізвище депутата, якого розстріляти:");
                    String name = Fraction.scann();
                    String surName = Fraction.scann();
                    List<Deputat> list = VerchovnaRada.hashMap.get(fractionName);
                    Iterator<Deputat> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.getName().equals(name) && deputat.getSurName().equals(surName)) {
                            iterator.remove();
                            System.out.println("Депутат на вилах");
                        }
                    }
                } else {
                    System.out.println("\n\tФракція пуста");
                    Main.recursion();
                }

            } else {
                System.out.println("\n\tТакої фракції не існує");
                Main.recursion();
            }
        } else {
            System.out.println("\n\tСпочатку створіть фракцію");
            Main.recursion();
        }
    }

    public static void showAllFractionBribes() {
        System.out.println("Фракції: " + VerchovnaRada.hashMap.keySet());
        if (!VerchovnaRada.hashMap.keySet().isEmpty()) {
            System.out.println("Введіть назву фракції, хабарників якої вивести: ");
            String fractionName = Fraction.scann();
            if (VerchovnaRada.hashMap.containsKey(fractionName)) {
                if (!VerchovnaRada.hashMap.get(fractionName).isEmpty()) {
                    List<Deputat> list = VerchovnaRada.hashMap.get(fractionName);
                    Iterator<Deputat> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.isBribe()) {
                            System.out.println(deputat);
                        }
                    }
                } else {
                    System.out.println("\n\tФракція пуста");
                    Main.recursion();
                }

            } else {
                System.out.println("\n\tТакої фракції не існує");
                Main.recursion();
            }
        } else {
            System.out.println("\n\tСпочатку створіть фракцію");
            Main.recursion();
        }
    }

    //
    public static void showAllBribes() { ///////////////
        if (!VerchovnaRada.hashMap.values().isEmpty()) {
            Iterator<Map.Entry<String, ArrayList<Deputat>>> entryIt = VerchovnaRada.hashMap.entrySet().iterator();
            while (entryIt.hasNext()) {
                Map.Entry<String, ArrayList<Deputat>> fractionIt = entryIt.next();
                if (!fractionIt.getValue().isEmpty()) {
                    Iterator<Deputat> iterator = fractionIt.getValue().iterator();
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.isBribe()) {
                            System.out.println(deputat);
                        }
                    }
                }
            }
        } else {
            System.out.println("\tВсі депутати мертві, створіть нового");
        }
    }

    public static void showBiggestBribe() { ////////////
        if (!VerchovnaRada.hashMap.values().isEmpty()) {
            Iterator<Map.Entry<String, ArrayList<Deputat>>> entryIt = VerchovnaRada.hashMap.entrySet().iterator();
            while (entryIt.hasNext()) {
                Map.Entry<String, ArrayList<Deputat>> fractionIt = entryIt.next();
                if (!fractionIt.getValue().isEmpty()) {
                    Iterator<Deputat> iterator = fractionIt.getValue().iterator();
                    int temp = 0;
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.getBribeValue() > temp) {
                            temp = deputat.getBribeValue();
                            System.out.println(deputat);
                        }
                    }

                    System.out.println("Найбільший хабар " + temp);
                    Main.recursion();
                } else {
                    System.out.println("\n\tХабарників нема");
                }
            }
        } else {
            System.out.println("\n\tНема депутатів");
        }
    }

    public static void showBiggestFractionBribe() {
        System.out.println("Фракції: " + VerchovnaRada.hashMap.keySet());
        if (!VerchovnaRada.hashMap.keySet().isEmpty()) {
            System.out.println("Введіть назву фракції, найбільшого хабарника якої вивести: ");
            String fractionName = Fraction.scann();
            if (VerchovnaRada.hashMap.containsKey(fractionName)) {
                if (!VerchovnaRada.hashMap.get(fractionName).isEmpty()) {
                    List<Deputat> list = VerchovnaRada.hashMap.get(fractionName);
                    Iterator<Deputat> iterator = list.iterator();
                    int temp = 0;
                    while (iterator.hasNext()) {
                        Deputat deputat = iterator.next();
                        if (deputat.getBribeValue() > temp) {
                            temp = deputat.getBribeValue();
                            System.out.println(deputat);
                        }
                    }

                    System.out.println("Найбільший хабар " + temp);
                    Main.recursion();
                } else {
                    System.out.println("\n\tФракція пуста");
                    Main.recursion();
                }

            } else {
                System.out.println("\n\tТакої фракції не існує");
                Main.recursion();
            }
        } else {
            System.out.println("\n\tСпочатку створіть фракцію");
            Main.recursion();
        }
    }


    public static void cleanFraction() {
        System.out.println(VerchovnaRada.hashMap.keySet());
        if (!VerchovnaRada.hashMap.isEmpty()) {
            System.out.print("Введіть назву фракції, яку хочите очистити: ");
            String name = Fraction.scann();
            if (!VerchovnaRada.hashMap.keySet().isEmpty()) {
                if (VerchovnaRada.hashMap.keySet().contains(name)) {
                    VerchovnaRada.hashMap.get(name).clear();
                    System.out.println("\n\tФракцію очищено");
                }
            } else {
                System.out.println("\n\tСтворіть фракцію");
            }
        }else {
            System.out.println("\n\tНема фракцій");
        }
    }


}

