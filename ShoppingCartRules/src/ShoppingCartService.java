import core.NonPrimeMemberRuleHandler;
import core.PrimeMemberRuleHandler;
import core.RuleHandler;
import model.Order;

public class ShoppingCartService {

    private ShoppingCartService() {

    }

    private static class helper {
        private static final ShoppingCartService instance= new ShoppingCartService();
    }

    public static ShoppingCartService getInstance() {
        return helper.instance;
    }

    public void checkout(Order order) {

        RuleHandler handler= new PrimeMemberRuleHandler(new NonPrimeMemberRuleHandler(null));
        handler.applyRule(order);

    }
}
