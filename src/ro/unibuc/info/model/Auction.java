package ro.unibuc.info.model;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class Auction {
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bid> bids;
    private List<Product> products;
    private double fixedPrice;


    public Auction(int id, LocalDateTime startDate, LocalDateTime endDate, double fixedPrice, List<Product> products) {
        // Constructor with parameter list
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bids = new ArrayList<>();
        this.products = products;
        this.fixedPrice = fixedPrice;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public void sortBidsByValue() {
        // Lambda function that sorts the bids by value
        bids.sort(Comparator.comparingDouble(Bid::getValue));
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<Bid> getBids() {
        return bids;
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auction{");
        sb.append("id=").append(id);
        sb.append(", startDate=").append(startDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        //ISO_LOCAL_DATE_TIME is this format yyyy-MM-dd'T'HH:mm:ss.SSS
        sb.append(", endDate=").append(endDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        sb.append(", fixedPrice=").append(fixedPrice);
        sb.append(", bids=").append(bids);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}