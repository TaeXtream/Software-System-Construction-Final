package structuralDesignpatterns;


public class Decorator {
    public static void main(String[] args) {
        Dragon dragon = new NormalDragon();
        dragon.attack();

        Dragon fireDragon = new FireDragon(dragon);
        fireDragon.attack();
    }

}

interface Dragon {
    void attack();
    int getAttackPower();
}

class NormalDragon implements Dragon {

    @Override
    public void attack() {
        System.out.println("Dragon is attacking!!!!");
    }

    @Override
    public int getAttackPower() {
        return 100;
    }

}

class FireDragon implements Dragon {

    private final Dragon decorated;

    public FireDragon(Dragon decorated){
        this.decorated = decorated;
    }

    @Override
    public void attack() {
        decorated.attack();
        System.out.println("Dragon use Fire Breath!!!!");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower()+100;
    }
}

