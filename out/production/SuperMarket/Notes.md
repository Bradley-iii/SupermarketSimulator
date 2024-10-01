# Notes 

## Two main topics 
1. Queue
2. Threads


### Queue
- Implemented with a linked list, it is a FIFO (First in, first out)
- Like a line at a super market.

#### Two Operations
- Add (Adds to end)
- Remove (remove from front) 
- Peek or get front

### Threads 
- Up to this point all of our programs used a single thread. A single execution pipeline
- Threads allow us to run parts of our code simultaneously, on multiple processor cores. For example, video games usually have the following threads:
1. Graphics
2. AI Threads
3. User Input Thread

- Using threads leads to data issues: what if one thread is changing data while the other is accessing data
- We have to synchronize our data. 
- This is achieved with locking and unlocking access while we work with data.


# Things we still need to do: 
- [ ] Customers need to remove themselves from the allShoppingCustomers list and add themselves to the queue in Cashier 
  - May need to synchronize the list and queue during these operations
  - Customer thread needs to keep running until they are process by a cashier: Problem
    - boolean variable? 
- [ ] The Cashiers run method needs to be developed
  - The cashier needs to grab/remove a customer from the queue, if customer, set customer to currentCustomer
- [ ] Customer has checkOutTime - the amount of time they spend with a Cashier once called on 
- [ ] Work on the stats
  - Average shop time, average checkout state, average time spent in queue
- [ ] Reach goals
  - Improve customer factory to more closely model Customers entering (two customers at time, more control over variables, some modeling equation)
  - Why does the cashier thread need to sleep in order to work? 
  - Improved states (more meaningful data/stats) - can we use this to actually sim a store
    - $$$ on cashiers, $$$ in, how many cashiers to maximize profit
  - 