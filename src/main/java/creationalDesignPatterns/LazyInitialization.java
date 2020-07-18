package creationalDesignPatterns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LazyInitialization {
    public static void main(String[] args) {
        NumberBlock numberBlock = NumberBlock.getInstance();
        numberBlock.setNumberSlot1(1);
        numberBlock.setNumberSlot2(2);
        numberBlock.setNumberSlot3(3);
        numberBlock.setNumberSlot4(4);
        System.out.println(numberBlock.getDetail());
    }
}

@Getter
@Setter
@NoArgsConstructor
class NumberBlock {
    Integer numberSlot1 = 0;
    Integer numberSlot2 = 0;
    Integer numberSlot3 = 0;
    Integer numberSlot4 = 0;

    private static NumberBlock instance;

    public static NumberBlock getInstance(){
        if(instance == null){
            instance = new NumberBlock();
        }
        return instance;
    }

    public String getDetail() {
        return "[" +
                this.numberSlot1 +
                "] " +
                "[" +
                this.numberSlot2 +
                "] " +
                "[" +
                this.numberSlot3 +
                "] " +
                "[" +
                this.numberSlot4 +
                "] ";
    }

}
