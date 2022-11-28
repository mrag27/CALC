import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.lang.ArrayIndexOutOfBoundsException;
public class Calculator {
    static int chislo1, chislo2;
    static char operation;
    static int result;
    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) throws Exception {
        String console = scanner.nextLine();
        char[] array = new char[10];
        for (int i = 0; i < console.length(); i++) {
            array[i] = console.charAt(i);
            if (array[i] == '+') {
                operation = '+';
            }
            if (array[i] == '-') {
                operation = '-';
            }
            if (array[i] == '*') {
                operation = '*';
            }
            if (array[i] == '/') {
                operation = '/';
            }
        }
        String maschar = String.valueOf(array);
        String[] split = maschar.split("[+-/*]");
        if (split.length != 2) {
            throw new Exception ("Формат математической операции не удовлетворяет условию");}
        String peremennaya1 = null;
        String peremennaya2 = null;
        try{
            peremennaya1 = split[0];
            peremennaya2 = split[1];}
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неверный знак");
            System.exit(0);
        }
        String peremennaya3 = peremennaya2.trim();

        chislo1 = romanToNumber(peremennaya1);
        chislo2 = romanToNumber(peremennaya3);
        if((chislo1 < 0 && chislo2 > 0) || (chislo2 < 0 && chislo1 > 0)){
            throw new Exception("неверные числа");
        }
        try{
            chislo1 = Integer.parseInt(peremennaya1);
            chislo2 = Integer.parseInt(peremennaya3);}

        catch (InputMismatchException | NumberFormatException e) {

            if (chislo1 > 0 && chislo2 >0 && chislo1 < 11 && chislo2 < 11) {
                result = calculation(chislo1, chislo2, operation);
                System.out.println("Результат для римских цифр");
                String resultRoman = convertNumToRoman(result);
                System.out.println(peremennaya1 + " " + operation + " " + peremennaya3 + " = " + resultRoman);
                System.exit(0);
            }
            else {
                System.out.println("Неверный формат данных");
                System.exit(0);
            }
        }
        if (chislo1 < 0 && chislo2 < 0) {
            result = 0;
        }
        if((chislo1 > 10) || (chislo2 > 10)) {
            throw new Exception("неверные числа");
        }
        result = calculation(chislo1, chislo2, operation);
        System.out.println("Результат для арабских цифр");
        System.out.println(chislo1 + " " + operation + " " + chislo2 + " = " + result);
    }
    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Неверный формат данных");
        }
        return -1;
    }
    private static String convertNumToRoman (int Arabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String k = roman[Arabian];
        return k;
    }
    public static int calculation (int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Неверная операция");
                    System.exit(0);
                    break;
                }
                break;
        }
        return result;
    }
}

