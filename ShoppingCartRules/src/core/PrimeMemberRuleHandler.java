package core;

import model.*;

import java.util.List;

public class PrimeMemberRuleHandler extends RuleHandler {
    public PrimeMemberRuleHandler(RuleHandler nextRuleHandler) {
        super(nextRuleHandler);
    }

    @Override
    public void applyRule(Order order) {
        User user= order.getUser();

        if(user.getUserType().equals(UserType.PRIME) && order.getTotalPrice()>=125.0) {
            order.setShippingOption("1 day delivery option is set.");
        } else if(user.getUserType().equals(UserType.PRIME) && isGroceryItems(order) && order.getTotalPrice()>=25) {
            order.setShippingOption("2 hours delivery is set.");
        }
        else if(user.getUserType().equals(UserType.PRIME)) {
            order.setShippingOption("2 day delivery option is set.");
            //System.out.println("Free two day delivery applied for the order: "+order.getOrderId());
        } else {
            setNextRule(order);
        }
    }

    private boolean isGroceryItems(Order order) {
        List<Item> items= order.getItems();

        return items.stream().allMatch(item -> item.getItemType().equals(ItemType.GROCERY));
    }

    @Override
    public void setNextRule(Order order) {
        if(nextRuleHandler!=null) {
            nextRuleHandler.applyRule(order);
        }
    }
}
