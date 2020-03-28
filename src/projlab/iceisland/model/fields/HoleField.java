package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;
import projlab.iceisland.model.Player;
import projlab.iceisland.model.Thing;

import java.util.List;

import static projlab.iceisland.model.AbstractField.FieldState.Water;
import static projlab.iceisland.model.Interaction.Underwater;


public class HoleField extends AbstractField {
    public HoleField(int snow, List<AbstractField> neighbors, String name){
        super(Thing.Nothing, snow, neighbors, name);
    }


    @Override
    public void step(Player player) {
        super.step(player);
        Underwater.interact(player);
    }
    @Override
    public void snowing() {
        if(currentState != Water || people.size() == 0){
            super.snowing();
        }
    }
    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public void update() {
        super.update();
        for (Player player : people) {
            Underwater.interact(player);
        }
    }
}
