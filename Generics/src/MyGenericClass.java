public class MyGenericClass<i1,i2> {
    i1 item1;
    i2 item2;

    public MyGenericClass(i1 item1,i2 item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public void printItems(){
        System.out.println("Item1 : " + item1);
        System.out.println("Item2 : " + item2);
    }

    public i1 getItem1() {
        return item1;
    }

    public i2 getItem2() {
        return item2;
    }
}
