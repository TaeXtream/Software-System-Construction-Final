package creationalDesignPatterns;

public class AbstractFactory {
    public static void main(String[] args) {
        KingdomFactory factory = new ElfKingdomFactory();
        Castle castle = factory.createCastle();
        King king = factory.createKing();
        Army army = factory.createArmy();

        System.out.println(castle.getDescription());
        System.out.println(king.getDescription());
        System.out.println(army.getDescription());
    }
}

interface Castle {
    String getDescription();
}
interface King {
    String getDescription();
}
interface Army {
    String getDescription();
}

// Elven implementations ->
class ElfCastle implements Castle {
    static final String DESCRIPTION = "This is the Elven castle!";
    public String getDescription() {
        return DESCRIPTION;
    }
}
class ElfKing implements King {
    static final String DESCRIPTION = "This is the Elven king!";
    public String getDescription() {
        return DESCRIPTION;
    }
}
class ElfArmy implements Army {
    static final String DESCRIPTION = "This is the Elven Army!";
    public String getDescription() {
        return DESCRIPTION;
    }
}

interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}

class ElfKingdomFactory implements KingdomFactory {
    public Castle createCastle() {
        return new ElfCastle();
    }
    public King createKing() {
        return new ElfKing();
    }
    public Army createArmy() {
        return new ElfArmy();
    }

}