public class Philosopher implements Runnable{

    private Fork fork1;
    private Fork fork2;

    public Philosopher(Fork fork1, Fork fork2) {
        this.fork1 = fork1;
        this.fork2 = fork2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            eat();
            think();
        }
    }

    public void eat() {
        fork1.take();
        fork2.take();
        System.out.println(Thread.currentThread().getName() + " кушает.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void think() {
        fork1.drop();
        fork2.drop();
        System.out.println(Thread.currentThread().getName() + " думает.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
