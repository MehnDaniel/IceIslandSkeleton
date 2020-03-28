package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

public class HoleField extends AbstractField {
    public HoleField(int snow){
        super(Thing.Nothing, snow);
    }

    public HoleField() {
        super(Thing.Nothing, 2);
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
