public class Employee {

    public void handleCustomer(Customer cust,boolean finance,Vehicle vehicle){
        if(finance && cust.getCashOnHand() < vehicle.getPrice() ){
            double loanAmount = vehicle.getPrice() - cust.getCashOnHand();
            runCredit(cust,loanAmount);
        }
        else if(vehicle.getPrice() <= cust.getCashOnHand())
            processTransaction(cust,vehicle);
        else
            System.out.println("Bring More Money.");
    }

    public void runCredit(Customer cust,double loanAmount){
        System.out.println("Hello " + cust.getName() + " You get the loan of Rs " + loanAmount);
    }

    public void processTransaction(Customer cust,Vehicle vehicle){
        System.out.println("Congratulations," + cust.getName() + " You bought the " + vehicle.getCarName() +
                " of " + vehicle.getCarColor() + " color" );
    }
}
