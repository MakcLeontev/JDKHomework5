public class Main {
//    Есть пять философов (потоки), которые могут либо обедать либо размышлять.
//    Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
//    После каждого приема пищи философ должен размышлять
//    Не должно возникнуть общей блокировки
//    Философы не должны есть больше одного раза подряд
    public static void main(String[] args) {
        Thread p1 = new Thread(new Philosopher(1));
        Thread p2 = new Thread(new Philosopher(2));
        Thread p3 = new Thread(new Philosopher(3));
        Thread p4 = new Thread(new Philosopher(4));
        Thread p5 = new Thread(new Philosopher(5));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }
}