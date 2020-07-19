package structuralDesignpatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Proxy {
    public static void main(String[] args) {
        WizardTower proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }
}

@AllArgsConstructor
@Getter
@Setter
class Wizard {
    private String name;
}

interface WizardTower {

    void enter(Wizard wizard);
}

class IvoryTower implements WizardTower {

    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard.getName()+ " enters the tower.");
    }
}

@Getter
@Setter
class WizardTowerProxy implements WizardTower {
    private static final int NUM_WIZARDS_ALLOWED = 3;

    private int numWizards;

    private final WizardTower tower;

    public WizardTowerProxy(WizardTower tower) {
        this.tower = tower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            tower.enter(wizard);
            numWizards++;
        } else {
            System.out.println(wizard.getName() + " is not allowed to enter!");
        }
    }
}