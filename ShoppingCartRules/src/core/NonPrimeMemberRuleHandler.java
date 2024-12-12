package core;

import model.Order;
import model.User;
import model.UserType;

public class NonPrimeMemberRuleHandler extends RuleHandler{

    public NonPrimeMemberRuleHandler(RuleHandler nextRuleHandler) {
        super(nextRuleHandler);
    }

    @Override
    public void applyRule(Order order) {
        User user= order.getUser();

        if(user.getUserType().equals(UserType.NON_PRIME) && order.getTotalPrice()>35.0) {
            //System.out.println("Free two day delivery applied for the order: "+order.getOrderId());
            order.setShippingOption("2 day delivery option is set.");
        } else if(user.getUserType().equals(UserType.NON_PRIME)){
            order.setShippingOption("Standard delivery option is set.");
            //System.out.println("Standard delivery delivery option is set.");
        } else {
            setNextRule(order);
        }
    }

    @Override
    public void setNextRule(Order order) {
        if(nextRuleHandler!=null) {
            nextRuleHandler.applyRule(order);
        }
    }
}
