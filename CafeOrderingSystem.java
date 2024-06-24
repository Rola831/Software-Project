import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class CafeOrderingSystem {
    private List<ProductMenu> menu;
    private List<Order> orders;
    
    public CafeOrderingSystem() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }
    
    public void addProduct(ProductMenu product) {
        menu.add(product);
    }
    
    public void delProduct(ProductMenu product) {
        menu.remove(product);
    }
    
    public void placeOrder(Order order) {
        orders.add(order);
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public List<ProductMenu> getMenu(); {
        return menu;
    }
}

class ProductMenu {
    private String name;
    private double price;
    
    public ProductMenu(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
}

class Order {
    private List<ProductMenu> products;
    private String cName;
    
    public Order(String cName) {
        product = new ArrayList<>();
        this.cName = cName;
    }
    
    public void addProductMenu(ProductMenu product) {
        product.add(product);
    }
    
    public double getTotalCost() {
        double total = 0;
        for (ProductMenu product : products) {
            total += product.getPrice();
        }
    }
    
    public String getcName() {
        return cName;
    }
    
    public List<ProductMenu> getProduct() {
        return products;
    }
}

public class etst {
    public static void main(String args[]) {
      CafeOrderingSystem action = new CafeOrderingSystem();
    
      action.addProductMenu(new ProductMenu("Honey Almond Milk Flat White", 24.00));
      action.addProductMenu(new ProductMenu("Coconut Milk Latte", 22.00));
      action.addProductMenu(new ProductMenu("Mocha Frappuccino  ", 24.00));
      action.addProductMenu(new ProductMenu("Iced Matcha Latte  ", 15.50));
      action.addProductMenu(new ProductMenu("Caramel Frappuccino ", 20.00));
      action.addProductMenu(new ProductMenu("Pumpkin Spice Latte  ", 15.50));
      
      Scanner scanner = new Scanner(System.in);
      
      while(true) {
          System.out.println("Menu: ");
          for(ProductMenu product : action.getProduct()) {
              System.out.println(product.getName() + ":  RM " + product.getPrice());
          }
          
          System.out.println("Enter Customer Name: ");
          String name = scanner.nextLine();
          
          Order order = new Order(name);
          
          while(true) {
              System.out.println("Enter Product Name to add to your cart or 'checkout' to submit your order");
              String productName = scanner.nextLine();
              
              if(productName.equalsIgnoreCase("checkout")) {
                  break;
              }
              
              ProductMenu product = findProductMenu(action.getMenu(), productName);
              if(product == null) {
                  System.out.println("This product is not available.");
                  continue;
              }
              order.addProductMenu(product);
          }
          action.placeOrder(order);
          
          System.out.println("Thank you for ordering, " + order.getCname);
          System.out.println("Your order total is:  RM " + order.getTotalCost());
          System.out.println("Your ordered Product: ");
          for(ProductMenu product : action.getProduct()) {
              System.out.println(product.getName() + ":  RM " + product.getPrice());
          }
          
          System.out.println("Enter 'next' to add another order or 'exit' to finish ordering");
          String response = scanner.nextLine();
          if(!response.equalsIgnoreCase("next")) {
              break;
          }
      }
      
      System.out.println("Exiting System....");
    }
    
    private static ProductMenu findMenuProduct(List<ProductMenu> menu, String name) {
        for(ProductMenu product : menu) {
            if(product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}