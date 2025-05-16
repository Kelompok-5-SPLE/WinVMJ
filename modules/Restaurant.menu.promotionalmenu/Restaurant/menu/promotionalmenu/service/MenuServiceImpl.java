package Restaurant.menu.promotionalmenu;

import java.util.*;

import vmj.routing.route.VMJExchange;

import Restaurant.menu.core.MenuServiceDecorator;
import Restaurant.menu.core.MenuImpl;
import Restaurant.menu.core.MenuServiceComponent;

public class MenuServiceImpl extends MenuServiceDecorator {
    public MenuServiceImpl (MenuServiceComponent record) {
        super(record);
    }

    
}
