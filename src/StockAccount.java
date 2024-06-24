public class StockAccount{
    String companyname;int price;

    public  StockAccount(String companyname){
        this.companyname=companyname;
        System.out.println("Name of company is "+companyname);
    }
    double value(int value){
        System.out.println("price of share of "+companyname+" is "+value);
        return value;

    }
    void buy(int price , String Symbol) {
        this.price=price;
        System.out.println("amount of stock is " + price + " and symbol is " + Symbol);
    }
    void sell(int amount , String symbol){
        amount = amount;

        System.out.println("selling amount is "+amount);
        int sharetotal = amount*price;
        System.out.println("total share amount is "+sharetotal);
    }
    void save(String companyname){
        this.companyname=companyname;

    }
    public static void main(String[] args) {
        StockAccount sc = new StockAccount("sahil");
        System.out.println(sc.value(2000));
        sc.buy(100,"ABC");
        sc.sell(50, "ABC");
        sc.save("Sahil");
    }
}