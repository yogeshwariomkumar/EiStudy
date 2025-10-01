package behavioral;

import java.util.ArrayList;
import java.util.List;

// Subject
class Stock {
    private String name;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void attach(Investor investor) {
        investors.add(investor);
    }

    public void detach(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    private void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(this);
        }
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Observer
interface Investor {
    void update(Stock stock);
}

// Concrete Observer
class ConcreteInvestor implements Investor {
    private String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Investor " + name + " notified. " + stock.getName() + " price changed to " + stock.getPrice());
    }
}

// Main class
public class ObserverExample {
    public static void main(String[] args) {
        Stock google = new Stock("Google", 2800.0);

        Investor alice = new ConcreteInvestor("Alice");
        Investor bob = new ConcreteInvestor("Bob");

        google.attach(alice);
        google.attach(bob);

        google.setPrice(2850.0);
        google.setPrice(2900.0);
    }
}
