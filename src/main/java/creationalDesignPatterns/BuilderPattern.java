package creationalDesignPatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BuilderPattern {
    public static void main(String[] args) {
        Hero knight = new Hero.Builder("Knight", "Rio").withAttack(50).build();
        System.out.println(knight.toString());
    }
}


@Getter
@Setter
@ToString
final class Hero {
    private final String profession;
    private final String name;
    private final Integer armor;
    private final Integer attack;

    private Hero(Builder builder) {
        this.profession = builder.getProfession();
        this.name = builder.getName();
        this.attack = builder.getAttack();
        this.armor = builder.getArmor();
    }

    @Getter
    static class Builder {
        private final String profession;
        private final String name;
        private  Integer attack = 0;
        private  Integer armor = 0;

        public Builder(String profession, String name) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public Builder withArmor(Integer armor) {
            this.armor = armor;
            return this;
        }

        public Builder withAttack(Integer attack) {
            this.attack = attack;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}

