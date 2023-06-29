public class Fork {
    private int number;
    private boolean isBusy;
    private static int count = 0;

    public Fork() {
        number = ++count;
        isBusy = false;
    }

    public synchronized void take() {
        if (isBusy) {
            System.out.println("Вилка занята" + number + "для " + Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Вилку " + number + " взял " + Thread.currentThread().getName());
        isBusy = true;
    }

    public synchronized void drop() {
        if (isBusy) {
            System.out.println("Вилку " + number + " освободил " + Thread.currentThread().getName());
            isBusy = false;
            notify();
        }
    }
}
