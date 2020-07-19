package behavioralDesignpatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Strategy {
    public static void main(String[] args) {
        DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.goToBattle();
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.goToBattle();
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.goToBattle();
    }
}

@AllArgsConstructor
@Getter
@Setter
class DragonSlayer {

    private DragonSlayingStrategy strategy;

    public void changeStrategy(DragonSlayingStrategy strategy) {
        setStrategy(strategy);
    }

    public void goToBattle() {
        strategy.execute();
    }
}

interface DragonSlayingStrategy {

    void execute();
}

class MeleeStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        System.out.println("You use your sword to slash the dragon!!");
    }
}

class ProjectileStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        System.out.println("You use your bow to shoot the dragon!!");
    }
}

class SpellStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        System.out.println("You case a spell into the dragon!!");
    }
}