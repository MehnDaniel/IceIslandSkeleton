package projlab.iceisland.model.thingusagestrategies;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.Player;

import static projlab.iceisland.model.Thing.*;

public class BarehandsDig implements DiggingStrategy {
    @Override
    public void dig(Player who) {
        Skeleton.called(this,"dig",who.toString());
        who.getCurrentField().dig(1);
        Skeleton.returned(this,"dig",who.toString());
    }
}
