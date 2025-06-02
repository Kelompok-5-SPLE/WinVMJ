package Restaurant.menu;

import Restaurant.menu.core.Menu;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.logging.Logger;

public class MenuFactory{
    private static final Logger LOGGER = Logger.getLogger(MenuFactory.class.getName());

    public MenuFactory()
    {

    }

    public static Menu createMenu(String fqn, Object... args) {
        Class<?> clz = Class.forName(fqn);
        Class<?>[] actualTypes = Arrays.stream(args)
                                       .map(a -> a == null ? Object.class : a.getClass())
                                       .toArray(Class<?>[]::new);

        for (Constructor<?> ctor : clz.getDeclaredConstructors()) {
            Class<?>[] formal = ctor.getParameterTypes();
            if (formal.length != actualTypes.length) continue;

            boolean ok = true;
            for (int i = 0; i < formal.length; i++) {
                if (!wrap(formal[i]).isAssignableFrom(wrap(actualTypes[i]))) {
                    ok = false; break;
                }
            }
            if (ok) {
                ctor.setAccessible(true);
                return (Menu) ctor.newInstance(args);
            }
        }
        throw new IllegalArgumentException(
            "No matching constructor in " + fqn + " for " + Arrays.toString(actualTypes));
    }

    /** primitive → wrapper; wrapper stays wrapper */
    private static Class<?> wrap(Class<?> c) {
        if (!c.isPrimitive()) return c;
        return switch (c.getName()) {
            case "int"    -> Integer.class;
            case "long"   -> Long.class;
            case "double" -> Double.class;
            case "float"  -> Float.class;
            case "char"   -> Character.class;
            case "byte"   -> Byte.class;
            case "short"  -> Short.class;
            case "boolean"-> Boolean.class;
            default       -> c;
        };
    }

}
