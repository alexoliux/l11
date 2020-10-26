import ru.mirea.zadanie1.*;
import ru.mirea.zadanie2.ArrayQueueN;
import ru.mirea.zadanie2.LinkedQueue;
import ru.mirea.zadanie2.Queue;
import ru.mirea.zadanie3.*;
import ru.mirea.zadanie4.*;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //задание 1
        ArrayQueueADT<Integer> queue = new ArrayQueueADT<Integer>();
        for(int i = 0; i < 10; i++) queue.enqueue(i);
        System.out.println(queue);
        for(int i = 0; i < 5; i++) System.out.println(queue.dequeue());
        System.out.println(queue);

        ArrayQueue queue1 = new ArrayQueue();
        for(int i = 0; i < 10; i++) queue1.enqueue(i);
        System.out.println(queue1.toString());
        for(int i = 0; i < 5; i++) System.out.println(queue1.dequeue());
        System.out.println(queue1.toString());


        for(int i = 0; i < 10; i++) ArrayQueueModule.enqueue(i);
        System.out.println(ArrayQueueModule.print());
        for(int i = 0; i < 5; i++) System.out.println(ArrayQueueModule.dequeue());
        System.out.println(ArrayQueueModule.print());

        //задание 2
        LinkedQueue queue2 = new LinkedQueue();
        test(queue2);
        ArrayQueueN queue3 = new ArrayQueueN();
        test(queue3);

        //задание 3
        System.out.println(new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5)
        );

        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();

        System.out.println(new Add(new Subtract(new Variable("x", 2), new Multiply(new Const(2),
                new Variable("x"))), new Const(1)).evaluate(v));

        //задание 4
        System.out.println("Enter a string:");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
        Parser p = new Parser(b);
        System.out.println(p.getPrefix());
        System.out.println("Вводите построчно значения для каждой пееменной:\nИмя переменной\nЗначение\n...\nend - конец ввода");
        HashMap<String, Double> m = new HashMap<>();
        while(!(b = sc1.nextLine()).equals("end")){
            m.putIfAbsent(b, sc1.nextDouble());
            sc1.nextLine();
        }
        try{
            System.out.println(p.calc(m));

        }catch (VariableNotFoundException e){
            System.out.println(e.getMessage());
        }    }

    public static void test(Queue t) {
        for(int i = 0; i < 10; i++) t.enqueue(i);
        System.out.println(t);
        for(int i = 0; i < 5; i++) t.dequeue();
        System.out.println(t);
    }
}