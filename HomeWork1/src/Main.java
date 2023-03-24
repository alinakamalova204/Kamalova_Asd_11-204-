import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stack");
        StackNew stackNew = new StackNew(6);
        stackNew.add(1);
        stackNew.add(2);
        stackNew.add(3);
        stackNew.add(4);
        stackNew.add(5);
        stackNew.add(6);
        System.out.println(stackNew);
        stackNew.getOutFirst();
        printStack(stackNew);

        System.out.println("Queue");
        MyQueue myQueue = new MyQueue(4);
        System.out.println(myQueue.isEmpty());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.getOutELem();
        myQueue.add(4);
        printQueue(myQueue);
        System.out.println(myQueue.isEmpty());
        printQueue(myQueue);
    }
    public static void printQueue(MyQueue a){
        while (!a.isEmpty()){
            System.out.println(a.getOutELem());
        }
    }
    public static void printStack(StackNew a){
        while (!a.isEmpty()){
            System.out.println(a.getOutFirst());
        }
    }
    public static class StackNew {
        private int[] arr;
        private int current;//ссылка на вершину

        public StackNew(int size){
            arr = new int[size];
            current = -1;
        }
        public boolean add(int elem){ //добавить элемент
            arr[++current] = elem;
            return true;
        }
        public int getOutFirst() { //удалить первый
            Integer a = arr[current];
            current--;
            return a;
        }
        public int viewFirst(){ //посмотреть первый
            return arr[current];
        }
        public boolean isEmpty(){ //пустой или нет
            return (current == -1);
        }

        @Override
        public String toString() {
            return "StackNew{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }
    }
    public static class MyQueue {
        private StackNew first;
        private StackNew last;

        public MyQueue(int size){
            this.last = new StackNew(size);
            this.first = new StackNew(size);
        }

        public boolean add(int i){
            first.add(i);
            return true;
        }
        public int getOutELem(){
            if (last.isEmpty()) {
                while (!first.isEmpty()) {
                    last.add(first.getOutFirst());
                }
            }
            return last.getOutFirst();
        }
        public boolean isEmpty(){
            return first.isEmpty() && last.isEmpty();
        }
    }

}
