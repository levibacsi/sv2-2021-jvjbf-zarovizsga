package shipping;

import java.util.*;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public List<Transportable> getPackages() {
        return List.copyOf(packages);
    }

    public void addPackage(Transportable pack){
        packages.add(pack);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        return packages.stream()
                .filter(transportable -> transportable.isBreakable() == breakable &&
                        transportable.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry(){
        Map <String, Integer> transportablesByCountry = new HashMap<>();
        for (Transportable transportable: packages){
            transportablesByCountry.compute(transportable.getDestinationCountry(),
                    (key, value) -> value == null ? 1 : value + 1);
        }
        return transportablesByCountry;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(InternationalPackage.class::isInstance)
                .sorted(Comparator.comparingInt(p -> ((InternationalPackage) p).getDistance()))
                .toList();

    }
}
