/*
* State design pattern allows an object tp change its behavior dynamically based on its current state
* Imagine you order product online. Your order goes through different states:
* New order: -> You juts placed the order
* Processing -> The seller is preparing your package
* Shipped-> The package is on my way
* Delivered -> You received the package
* Each state has its own behavior
* You can cancel an order when its New but not when its shipped
* You can track an order when its shipped
* You cannot go back once an order is delivered
*
* How do we implement this in java
* Instead of using if-else conditions we create separate class for each state and
* let the system switch between them dynamically
*
* */

/*
* Each state will have next() to move to next state and previous to go to previous state
* */
interface OrderState
{
    void next(OrderContext ctx);
    void previous(OrderContext ctx);
    void printStatus();
}

class NewOrderState implements OrderState
{

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new ProcessingState());
    }

    @Override
    public void previous(OrderContext ctx) {
        System.out.println("Mew order. Mo previous state");
    }

    @Override
    public void printStatus() {
        System.out.println("Order placed. Waiting for processing");
    }
}

class ProcessingState implements OrderState
{

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new NewOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Processing state..");
    }
}
class ShippedState implements OrderState
{

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new DeliveredState());
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new ProcessingState());
    }

    @Override
    public void printStatus() {
        System.out.println("Shipping State");
    }
}
class DeliveredState implements OrderState
{

    @Override
    public void next(OrderContext ctx) {
System.out.println("Order is already delivered");
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is delivered");

    }
}
class OrderContext
{
    private OrderState orderState;
    public OrderContext()
    {
        orderState=new NewOrderState();
    }
    public void setState(OrderState orderState)
    {
        this.orderState =orderState;
    }
    public void nextState()
    {
        orderState.next(this);
    }
    public void previousState()
    {
        orderState.next(this);
    }
    public void printStatus()
    {
        orderState.printStatus();
    }
}
public class StateDesignPattern {
    public static void main(String[] args) {
    OrderContext orderContext = new OrderContext();
    orderContext.printStatus();
    orderContext.nextState();
        orderContext.printStatus();
        orderContext.nextState();
        orderContext.printStatus();
        orderContext.nextState();
        orderContext.printStatus();
        orderContext.nextState();
    }
}
