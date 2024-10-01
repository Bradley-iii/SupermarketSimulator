import java.util.ArrayList;

public class Customer extends Thread implements Comparable<Customer> {
    private long shopTime; // how long in ms the customer shops more
    private long checkOutTime; // how long in ms the customer takes to check out
    private long enterTime; // time in ms the customer enters the store
    private long exitTime; // time in ms the cusomter exits the store
    private long minShopTime = 4000; // min time in ms the customer shops
    private long maxShopTime = 5000; // max time in ms the customer shops
    private int id;
    private static int nextID = 0;
    public static ArrayList<Customer> allShoppingCusomters = new ArrayList<>();
    private boolean isCheckedOut;


    public Customer() {
        id = nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime = (long)(minShopTime + Math.random() * (maxShopTime - minShopTime));
        checkOutTime = 4000;

        allShoppingCusomters.add(this);
    }

    public long getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Customer: " + id;
    }

    @Override
    public void run() {

        System.out.println(this + " enters");
        while(enterTime + shopTime > System.currentTimeMillis()) {

        }
        synchronized (allShoppingCusomters) {
            allShoppingCusomters.remove(this);
            if(!isCheckedOut) {
                synchronized (Cashier.queue) {
                    Cashier.queue.add(this);
                }
                while(!isCheckedOut) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        System.out.println(this + " leaves.");
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
