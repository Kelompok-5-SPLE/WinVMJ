package Restaurant.promo.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Promo {
	public UUID getPromoId();
	public void setPromoId(UUID PromoId);
	public String getEventName();
	public void setEventName(String eventName);
	public EDate getEventStartDate();
	public void setEventStartDate(EDate eventStartDate);
	public EDate getEventFinishDate();
	public void setEventFinishDate(EDate eventFinishDate);
	public Map<MenuImpl, int> getMenuPromo();
	public void setMenuPromo(Map<MenuImpl, int> menuPromo);
	public void reducePrice();
	public void calculatePrice();
	HashMap<String, Object> toHashMap();
}
