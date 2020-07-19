package behavioralDesignpatterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class InterpreterPattern {

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }

    //Rule: Robert and John are male
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //Rule: Julie is a married women
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }
}

interface Expression {
    boolean interpret(String context);
}

@AllArgsConstructor
@Getter
@Setter
class TerminalExpression implements Expression {

    private String data;

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

@AllArgsConstructor
@Getter
@Setter
class OrExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

@AllArgsConstructor
@Getter
@Setter
class AndExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}


