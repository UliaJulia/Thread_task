public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[]{new Fork(), new Fork(), new Fork(), new Fork(), new Fork()};

        Thread t1 = new Thread(new Philosopher(forks[0], forks[1]));
        t1.setName("Декарт");
        Thread t2 = new Thread(new Philosopher(forks[1], forks[2]));
        t2.setName("Фрейд");
        Thread t3 = new Thread(new Philosopher(forks[2], forks[3]));
        t3.setName("Сократ");
        Thread t4 = new Thread(new Philosopher(forks[3], forks[4]));
        t4.setName("Архимед");
        Thread t5 = new Thread(new Philosopher(forks[4], forks[0]));
        t5.setName("Аристотель");

        t1.start();
        t3.start();
        t2.start();
        t5.start();
        t4.start();
    }
}
