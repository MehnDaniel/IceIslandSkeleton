package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing.DiggingStrategy;

public class ShovelDig implements DiggingStrategy {
    @Override
    public void dig(Player who) {
        who.getCurrentField().dig(2);
    }
}
