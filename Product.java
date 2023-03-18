public class Product {
    String type;
    Double price;
    String shippedFrom;
    Double weight;
    Double rate;

    public Product(String type, Double price, String shippedFrom, Double weight, Double rate) {
        this.type = type;
        this.price = price;
        this.shippedFrom = shippedFrom;
        this.weight = weight;
        this.rate = rate;
    }

    public Double getShipping() {
        return this.weight * this.rate * 10;
    }

    public Double getVAT() {
        return this.price * 0.14;
    }
}
