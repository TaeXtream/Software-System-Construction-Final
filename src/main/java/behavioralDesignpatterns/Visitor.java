package behavioralDesignpatterns;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Visitor {
    public static void main(String[] args) {

        Commander commander = new Commander(
                new Sergeant(new Soldier(), new Soldier(), new Soldier()),
                new Sergeant(new Soldier(), new Soldier(), new Soldier())
        );
        commander.accept(new SoldierVisitor());
        commander.accept(new SergeantVisitor());
        commander.accept(new CommanderVisitor());

    }
}


abstract class Unit {

    @Getter
    @Setter
    private String name;

    private Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children).forEach(child -> child.accept(visitor));
    }
}

interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);
}

class Commander extends Unit {

    public Commander(Unit... children) {
        super(children);
        setName("commander");
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitCommander(this);
        super.accept(visitor);
    }

}

class Sergeant extends Unit {

    public Sergeant(Unit... children) {
        super(children);
        setName("sergeant");
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSergeant(this);
        super.accept(visitor);
    }

}

class Soldier extends Unit {

    public Soldier(Unit... children) {
        super(children);
        setName("soldier");
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSoldier(this);
        super.accept(visitor);
    }

}

class CommanderVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {
        // Do nothing
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visitCommander(Commander commander) {
        System.out.printf("Good to see you %s\n", commander.getName());
    }
}

class SergeantVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {
        // Do nothing
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        System.out.printf("Hello %s\n", sergeant.getName());
    }

    @Override
    public void visitCommander(Commander commander) {
        // Do nothing
    }
}

class SoldierVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {
        System.out.printf("Greeting %s\n", soldier.getName());
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visitCommander(Commander commander) {
        // Do nothing
    }
}