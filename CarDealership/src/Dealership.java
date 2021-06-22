public class Dealership {
    public static void main(String args[]) {

        Customer cust1 = new Customer();
        Vehicle vehicle1 = new Vehicle();
        Employee emp1 = new Employee();

        Customer cust2 = new Customer();
        Vehicle vehicle2 = new Vehicle();
        Employee emp2 = new Employee();

        cust1.setName("Shubham");
        cust1.setAddress("Dhanbad");
        cust1.setCashOnHand(12000);

        vehicle1.setCarName("Porsche");
        vehicle1.setCarColor("Green");
        vehicle1.setPrice(12000);

        cust2.setName("Rahul");
        cust2.setAddress("Delhi");
        cust2.setCashOnHand(6000);

        vehicle2.setCarName("Audi");
        vehicle2.setCarColor("Red");
        vehicle2.setPrice(9000);

        cust1.purchaseCar(vehicle1,emp1,true);
        cust2.purchaseCar(vehicle2,emp2,false);
    }
}
