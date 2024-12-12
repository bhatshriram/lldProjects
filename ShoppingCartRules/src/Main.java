import model.*;

public class Main {

    public static void main(String[] args) {

        User primeUser= new User("prime", UserType.PRIME);
        User nonPrimeUser= new User("non_prime", UserType.NON_PRIME);

        Item item1= new Item("kitchen towel", ItemType.NON_GROCERY, 25.0);
        Item item2= new Item("bag", ItemType.NON_GROCERY, 5.0);

        Item item3= new Item("Dal", ItemType.GROCERY, 15.0);
        Item item4= new Item("Rice", ItemType.GROCERY, 5.0);

        Order order= new Order(nonPrimeUser);
        order.addItem(item1);
        order.addItem(item2);

        Order order2= new Order(primeUser);
        order2.addItem(item3);
        order2.addItem(item4);

        ShoppingCartService shoppingCartService= ShoppingCartService.getInstance();
        shoppingCartService.checkout(order);

        System.out.println("Order id: "+order.getOrderId()+" delivery option is:"+ order.getShippingOption());

        shoppingCartService.checkout(order2);

        System.out.println("Order id: "+order2.getOrderId()+" delivery option is:"+ order2.getShippingOption());
    }
}
