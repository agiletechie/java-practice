import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

    List<Product> soldProductList = new CopyOnWriteArrayList<>();

    public void populateSoldProducts(){
        for(int i = 0;i <= 1000;i++){
            Product prod = new Product(i,"test_product_" + i);
            soldProductList.add(prod);
            System.out.println("Added: " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts(){
        for(Product prod : soldProductList){
            System.out.println("Printing the Sold " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
