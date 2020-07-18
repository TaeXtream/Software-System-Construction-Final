package creationalDesignPatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Prototype {
    public static void main(String[] args) {
        Sheep original = new Sheep("Sammy");
        System.out.println(original.getName());
        Sheep clone = original.clone();
        clone.setName("Jimmy");
        System.out.println(clone.getName());


    }
}

@AllArgsConstructor
@Getter
@Setter
class Sheep implements Cloneable {
    private String name;
    @Override
    public Sheep clone() {
        try {
            return (Sheep)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
