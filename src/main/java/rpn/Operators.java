package rpn;

import java.util.List;

public class Operators {

    private List<Operator> operators;

    public Operators(List<Operator> operators){
        this.operators = operators;
    }

    public Operator findOperator(String token) throws NullPointerException{
        Operator operator = null;

        for(Operator operatorToCheck: operators){
            String value = operatorToCheck.getValue();
            if(value.equals(token)){
                operator = operatorToCheck;
            }
        }
        return operator;
    }
}
