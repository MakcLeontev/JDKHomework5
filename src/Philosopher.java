public class Philosopher implements Runnable{
    private int id = 0;
    private int countEat = 0;
    private final Object monitor;
    private boolean meal = false;

    public Philosopher(int id) {
        this.id = id;
        this.monitor = Philosopher.class;
    }

    private void eating() throws InterruptedException {
        Thread.sleep(500);
        System.out.println(this.id + "-й философ поел");
        this.countEat++;
        this.meal = true;
    }
    private void meditation(){
        this.meal = false;
        System.out.println(this.id + "-й философ закончил размышление");
    }

    @Override
    public void run() {
        while (true){
            synchronized (monitor){
                try {
                    if (this.meal){
                        this.meditation();
                    }else {
                        this.eating();
                    }
                    monitor.notify();
                    if (this.countEat > 2){
                        break;
                    }else {
                        monitor.wait();
                    }
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(this.id + "-й закончил");
    }
}
