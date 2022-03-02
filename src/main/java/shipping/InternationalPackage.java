package shipping;

public class InternationalPackage implements Transportable{
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    private static final int INTERNATIONAL_PRICE = 1200;
    private static final int PRICE_BY_KM = 10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int price = INTERNATIONAL_PRICE;
        if (breakable){
            price *= 2;
        }
        price += distance * PRICE_BY_KM;
        return price;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
