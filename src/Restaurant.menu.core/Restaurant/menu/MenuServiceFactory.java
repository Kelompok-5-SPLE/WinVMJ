package Restaurant.menu;

import Restaurant.menu.core.MenuService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MenuServiceFactory{
    private static final Logger LOGGER = Logger.getLogger(MenuFactory.class.getName());

    public MenuServiceFactory()
    {

    }

    public static MenuService createMenuService(String fullyQualifiedName, Object ... base)
    {
        MenuService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (MenuService) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Menu.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Menu.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of Menu.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of Menu.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
