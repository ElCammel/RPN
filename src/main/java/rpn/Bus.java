package rpn;

public interface Bus{
    void publish(ExpressionMessage expressionMessage);
    void subscribe(String expressiontype, TokenizerConsumer tokenizerConsumer);
}
