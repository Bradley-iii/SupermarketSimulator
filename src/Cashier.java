import java.util.Comparator;
import java.util.PriorityQueue;

public class Cashier extends Thread implements Comparable<Customer> {
    private Customer currentCustomer;
    public static PriorityQueue<Customer> queue = new PriorityQueue<>(); // one line for all cashiers
    private int id;
    private static int nextId = 0;



    public Cashier() {
        this.id = nextId;
        nextId++;
        
    }


    public String toString() {
        return "Cashier " + id;
    }


    @Override
    public void run() {
        System.out.println(this + " checking in for duty!");
        while(true) {
            System.out.println(queue);
            // if no customers, no one in line, and no currentCustomer end the cashier

            // the timer for some reason makes the check work
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            synchronized (queue) {
                if(queue.size() != 0) {
                    currentCustomer = queue.peek();
                    queue.remove(queue.peek());
                }
            }

            if (currentCustomer != null) {
                System.out.println(this + " has " + currentCustomer);

                try {
                    Thread.sleep(currentCustomer.getCheckOutTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentCustomer.setCheckedOut(true);
                currentCustomer = null;
            }


            if (!(Main.storeOpen)) {
                if (Customer.allShoppingCusomters.size() == 0) {
                    if (queue.size() == 0) {
                        if (currentCustomer == null) {
                            break;
                        }
                    }
                }
            }
        }




        System.out.println(this + " job done!");
    }


    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
