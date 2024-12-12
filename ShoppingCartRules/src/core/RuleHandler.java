package core;

import model.Order;

public abstract class RuleHandler {

    protected RuleHandler nextRuleHandler;

    public RuleHandler(RuleHandler nextRuleHandler) {
        this.nextRuleHandler = nextRuleHandler;
    }

    public abstract void applyRule(Order order);

    public abstract void setNextRule(Order order);
}
