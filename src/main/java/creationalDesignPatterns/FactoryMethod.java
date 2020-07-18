package creationalDesignPatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class FactoryMethod {
    public static void main(String[] args) {
        Shipyard shipyard = new NavyShipyard();
        Ship ship = shipyard.manufactureShip("USS Saratoga");
        System.out.println(ship.getName());
    }
}

interface Shipyard {
    Ship manufactureShip(String name);
}

class NavyShipyard implements Shipyard {
    public Ship manufactureShip(String name) {
        return new NavyShip(name);
    }
}

class PirateShipyard implements Shipyard {
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
class Ship {
    String name;
}
