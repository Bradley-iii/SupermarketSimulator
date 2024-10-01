import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerFactory extends Thread{
    private long delay = 2000;
    private long lastCustomerTimeStamp = 0;
    private long nextCustomerTime = lastCustomerTimeStamp + delay;


    public CustomerFactory() {

    }

    public void stopFactory() {
        this.interrupt();
    }





    @Override
    public void run() {
        while(true) {
            if (nextCustomerTime < System.currentTimeMillis()) {
                int chance = (int) (Math.random() * 1000);
                if (chance < 10) {
                    Customer c = new Customer();



                    c.start();
                    nextCustomerTime = System.currentTimeMillis() + delay;
                }
                // add more than 1 customer at a random chance
                if(chance < 2) {
                    int chance_2 = (int)(1 + Math.random() * 2);
                    for(int i = 0; i < chance_2; i++) {
                        Customer c = new Customer();
                        c.start();
                    }
                    if(chance_2 == 1) {
                        nextCustomerTime = System.currentTimeMillis() + 2*delay;
                    } else if(chance_2 == 2) {
                        nextCustomerTime = System.currentTimeMillis() + 3 * delay;
                    }
                }


            }

            // If the customer factory is stopped, break out of the thread.
            if(this.isInterrupted()) {
                break;
            }
        }
    }
}
