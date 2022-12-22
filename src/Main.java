package HomeWork4_java;
//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Example1();
        //Example2();
        Example3();
    }
    private static void Example1(){
        /**
         * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
         * */
        int[] listMas = new int[]{45,72,1,76,3,16,90,3,55};

        System.out.print("Изначальный массив = [");
        for(int i=0; i<listMas.length; i++){
            System.out.print(listMas[i]+", ");
        }
        System.out.println("]");

        LinkedList<Integer> linkList = new LinkedList<>();

        for (Integer temp : listMas) {
            linkList.add(temp);
        }
        int temp = 0;
        while (temp != linkList.size() - 1) {
            linkList.add(linkList.size()-temp, linkList.getFirst());
            linkList.removeFirst();
            temp++;
        }
        System.out.println("Перевёрнутый массив = " + linkList);
    }
    private static void Example2(){
        /**
         * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
         * enqueue() - помещает элемент в конец очереди,
         * dequeue() - возвращает первый элемент из очереди и удаляет его,
         * first() - возвращает первый элемент из очереди, не удаляя.
         */
        Deque<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(3);
        queue.add(17);
        queue.add(5);
        System.out.println(queue);
        enqueue(1, queue);
        System.out.println(queue);
        System.out.println(dequeue(queue));
        System.out.println(queue);
        System.out.println(first(queue));
        System.out.println(queue);
    }
    private static void enqueue(int element, Deque<Integer> queue) {
        queue.addLast(element);
    }
    private static int dequeue(Deque<Integer> queue) {
        return queue.pollFirst();
    }
    private static int first(Deque<Integer> queue) {
        return queue.peekFirst();
    }


    private static void Example3() {
        /**
         * 3. В калькулятор добавьте возможность отменить последнюю операцию.
         */
        Deque<Integer> queue = new LinkedList<>();
        boolean flag = true;
        while (flag) {
            int num = calculator();
            queue.addLast(num);
            System.out.println(queue);
            System.out.println("Для отмены действия введите 'отменить'");
            System.out.println("Для выхода из калькулятора введите 'выход'");
            System.out.println("Для дальнейшего использования введите любую букву");
            Scanner scanner = new Scanner(System.in);
            String back = scanner.next();

            if (back.equals("отменить")) {
                queue.pollLast();
                System.out.println(queue);
            }
            if (back.equals("выход")) {
                flag = false;
            }
        }
    }
    public static int calculator() {
        System.out.println("Введите первое число: ");
        Scanner enterNumber = new Scanner(System.in);
        int a = enterNumber.nextInt();
        System.out.println("Введите второе число: ");
        int b = enterNumber.nextInt();
        System.out.println("Введите действие (+,-,*,/): ");
        char c = enterNumber.next().charAt(0);
        if(c == '+') {
            return sum(a, b);
        } else if (c == '-') {
            return difference(a, b);
        } else if (c == '*') {
            return multiplication(a, b);
        } else if (c == '/') {
            return division(a, b);
        } else {
            System.out.println("Неверное значение");
            return 0;
        }
    }
    public static int sum(int a, int b) {
        return a+b;
    }
    public static int difference(int a, int b) {
        return a-b;
    }
    public static int multiplication(int a, int b) {
        return a*b;
    }
    public static int division(int a, int b) {
        return a/b;
    }

}