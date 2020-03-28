package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.model.Player;

import static projlab.iceisland.model.Thing.*;

public class BarehandsDig implements DiggingStrategy {
    @Override
    public void dig(Player who) {
        who.getCurrentField().dig(1);
    }
}
