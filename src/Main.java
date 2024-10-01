import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static boolean storeOpen = true;
    public static final int NUM_CASHIERS = 2;

    public static void main(String[] args) {


        CustomerFactory factory = new CustomerFactory();
        ArrayList<Cashier> cashiers = new ArrayList<>();

        for(int i = 0; i < NUM_CASHIERS; i++) {
            Cashier c = new Cashier();
            cashiers.add(c);
            c.start();
        }
        long simTime = 12000;
        long startTimeStamp = System.currentTimeMillis();

        factory.start();

        while(startTimeStamp + simTime > System.currentTimeMillis()) {

        }
        System.out.println("Stopped");
        factory.stopFactory();
        storeOpen = false; // doors close

        
    }
}