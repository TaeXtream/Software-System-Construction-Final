package behavioralDesignpatterns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class CommandPattern {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Target goblin = new Goblin();
        System.out.println(goblin.toString());
        wizard.castSpell(new ShrinkSpell(), goblin);
        System.out.println(goblin.toString());
        wizard.castSpell(new DeadSpell(), goblin);
        System.out.println(goblin.toString());
    }


}

@NoArgsConstructor
class Wizard {

    public void castSpell(command command, Target target) {
        System.out.printf("%s cast %s at %s\n", this.toString(), command.getName(), target.getName());
        command.execute(target);
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}

@Getter
@Setter
abstract class command {
    private String name;

    public abstract void execute(Target target);
}

class ShrinkSpell extends command {

    public ShrinkSpell() {
        setName("Shrink Spell");
    }

    @Override
    public void execute(Target target) {
        target.setSize("Small");
    }
}

class DeadSpell extends command {

    public DeadSpell() {
        setName("Dead Spell");
    }

    @Override
    public void execute(Target target) {
        target.setAlive(false);
    }
}

@Getter
@Setter
@ToString
abstract class Target {

    private String name;
    private String size;
    private boolean alive;
}

class Goblin extends Target {

    public Goblin() {
        setName("Goblin");
        setSize("Normal");
        setAlive(true);
    }
}
