public class Application {
    public static void main(String args[]){
        InventoryManager manager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.populateSoldProducts();
            }
        });

        Thread displayTask = new Thread(new Runnable(){
            @Override
            public void run(){
                manager.displaySoldProducts();
            }
        });

        inventoryTask.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*try {
            inventoryTask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        displayTask.start();
    }
}
