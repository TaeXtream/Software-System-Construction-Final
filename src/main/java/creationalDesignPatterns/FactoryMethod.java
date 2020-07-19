package creationalDesignPatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FactoryMethod {
    public static void main(String[] args) {
        ShipFactory shipFactory = new NavyShipFactory();
        Ship ship = shipFactory.manufactureShip("USS Saratoga");
        System.out.println(ship.toString());
    }
}

interface ShipFactory {
    Ship manufactureShip(String name);
}

class NavyShipFactory implements ShipFactory {
    public Ship manufactureShip(String name) {
        return new NavyShip(name);
    }
}

class PirateShipFactory implements ShipFactory {
    public Ship manufactureShip(String name) {
        return new PirateShip(name);
    }
}



class NavyShip extends Ship {
    public NavyShip(String name) {
        super(name);
    }
}

class PirateShip extends Ship{
    public PirateShip(String name) {
        super(name);
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class Ship {
    String name;
}
