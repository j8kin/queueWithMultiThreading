import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Vector<String> outArray = new Vector<>();

        ArrayList<MainThread> listOfThreads = new ArrayList<>();
        for (int i=0; i<100; i++) {
            listOfThreads.add(new MainThread(i));
        }

        for (Thread thread: listOfThreads) {
            thread.start();
        }

        while (listOfThreads.size() > 0) {
            // search all threads for completed threads
            for (int i = 0; i < listOfThreads.size(); i++)
            {
                if (!listOfThreads.get(i).isAlive()) {
                    // if thread complete store thread number in outArray
                    outArray.add(listOfThreads.get(i).getValue());

                    // remove completed thread from list of threads
                    listOfThreads.remove(i);
                    break;
                }
            }
            Thread.sleep(200);
        }

        // print outArray
        for (String elem: outArray) {
            System.out.println(elem);
        }
    }
}
