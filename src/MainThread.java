/**
 * There is a Pool of Numbers in NextNumber. Each thread request nextFree number.
 * If Thread receive number it perform some job (Random Sleep) and release this number in nextFree number Pool.
 * Then this number is accessed via getNumber method.
 *
 * NOTICE:
 *   It is not clear from Task how this outArray should be filled.
 *   Another solution is to create outList which append a new number when thread get number from nextFree Pool.
 */
public class MainThread extends Thread {

    // Contains getNumber function which returns next free number to a thread
    static private NextNumber nextFree = new NextNumber();

    // mutex
    private static final Object lock = new Object();

    // number set to current Thread
    private String number = "";

    // Thread number to be printed
    private int threadNum;

    MainThread(int threadNum) {
        this.threadNum = threadNum;
    }
    /**
     * Return number after Thread complete
     * @return number associated to current thread
     *
     */
    String getValue() {
        return number;
    }

    @Override
    public void run() {
        while (true) {
            // lock mutex to synchronize threads access to nextFree
            synchronized (lock) {
                if (!number.equals("")) {

                    // Some action (Random sleep)
                    try {
                        Thread.sleep((int )(Math.random() * 2000 + 1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // release number. now it will be available for another thread
                    nextFree.freeNumber(number);

                    // exit thread
                    return;
                }

                // try to get number
                number = nextFree.getNumber();

                // print which number thread is get
                if (!number.equals("")) {
                    // print what number is allocated to this thread
                    System.out.println("Thread Number " + threadNum + " get number: " + number);
                }
            }

            // get time to another threads to work (random time)
            try {
                Thread.sleep((int )(Math.random() * 50 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
