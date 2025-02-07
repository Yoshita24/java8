public class OrderTest {
    public static void main(String[] args) {
       /* public void getOrder(int orderid)
        {
            if(orderid!=0)
            {
throw new OrderNotFoundException("Order Not found");
            }
        }*/
    }
}
class OrderNotFoundException extends RuntimeException
{
    public OrderNotFoundException(String message)
    {
        super(message);
    }
}