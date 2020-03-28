package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

public class HoleField extends AbstractField {
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
        Underwater.interact(player);
    }
}
