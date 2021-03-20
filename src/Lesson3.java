/*
1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
2. * Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
"grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
 */

import java.lang.reflect.Array;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {

        choiceGame();



    }

    private static void print1MassiveMethod(char[] arr) {
        for (char a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("\n");
    }


    private static int randomIntMethod(int i) {
        int a = 0;
        int b = i;
        return (int) (a + (Math.random() * b));
    }

    private static boolean repeatMethod() {
        System.out.println("Повторить игру?" + "\n" + "1.Да" + "\n" +"0.Нет");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) return true;
        else return false;


    }

    private static void choiceGame() {
        System.out.println("Выберите игру:" + "\n" + "1.Игра про числа" + "\n" + "2.Игра про слова");
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        switch (temp) {
            case (1):  numberGame();
            break;
            case  (2): wordGame();
        }

    }

    private static void wordGame() {
        boolean boo = true;
        while (boo) {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                    "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

            char[] word = new char[15];


            for (int i = 0; i < word.length; i++) {
                word[i] = '#';
            }
            String randomWord = words[randomIntMethod(words.length)];
            boolean boo2 =true;
            do {
                int temp = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите слово: ");
                String tempWord = scanner.nextLine();
                if (tempWord.equals(randomWord)) {
                    System.out.println("Вы угадали!");
                    boo2 = false;
                    boo = repeatMethod();
                    break;
                }
                 if (tempWord.length() > randomWord.length()) {
                     temp = randomWord.length();
                 }
                 else temp = tempWord.length();
                    for (int x = 0; x < temp; x++) {

                        char a = tempWord.charAt(x);
                        char b = randomWord.charAt(x);
                        if (a == b) {
                            word[x] = a;

                        }
                    }

                print1MassiveMethod(word);
                } while (boo2);

            }





    }

    private static void numberGame() {
        boolean boo =true;
        while (boo) {
            int randomInt = randomIntMethod(9);
            Scanner scanner1 = new Scanner(System.in);
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    System.out.println("Вы проиграли!!!");
                    boo = repeatMethod();
                    break;
                }

                System.out.println("Введите число от 0 до 9: ");
                int tempInt = scanner1.nextInt();
                if (tempInt == randomInt) {
                    System.out.println("Вы угадали!!!");
                    boo = repeatMethod();
                    break;

                }
                else if (tempInt < randomInt) {
                    System.out.println("Это не то число, загаданное число больше");
                }
                else if (tempInt > randomInt) System.out.println("Это не то число, загаданное число меньше");
            }
        }


    }
}
