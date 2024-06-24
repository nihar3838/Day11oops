import java.util.Scanner;

class stockportfolio {
    String name;
    int numshares, shareprice;
    public  stockportfolio(String name, int numshares, int shareprice){
        this.name=name;
        this.numshares=numshares;
        this.shareprice=shareprice;
        System.out.println("Name of stock  is "+name);
        System.out.println(" Number of shares of "+name +" is "+numshares);
        System.out.println("Price per share is "+shareprice);
    }
    public void  compute() {
        int  totalprice = numshares*shareprice;
        System.out.println("total price of share is "+totalprice);
    }
}
public class Stock{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number of stock : ");
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            System.out.println("What is the name of stock : ");
            String name = sc.next();
            System.out.println("enter the number of shares of the stock : ");
            int num = sc.nextInt();
            System.out.println("enter the price per share ");
            int price = sc.nextInt();
            stockportfolio sc1 = new stockportfolio(name,num,price);
            sc1.compute();
        }
    }
}
