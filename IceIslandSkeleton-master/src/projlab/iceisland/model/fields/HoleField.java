package projlab.iceisland.model.fields;

import projlab.iceisland.Skeleton;
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
        Skeleton.called(this,"step",player.toString());
        super.step(player);
        Underwater.interact(player);
        this.currentState = Water;
        Skeleton.returned(this,"step",player.toString());
    }
    @Override
    public void snowing() {
        Skeleton.called(this,this.getName(),"snowing","");
        if(currentState != Water || people.size() == 0){
            super.snowing();
        }
        Skeleton.returned(this,this.getName(),"snowing","");
    }
    @Override
    public int getCapacity() {
        Skeleton.called(this,this.getName(),"getCapacity","");
        Skeleton.returned(this,this.getName(),"getCapacity","");
        return 0;

    }

    @Override
    public void update() {
        Skeleton.called(this,this.getName(),"update","");
        super.update();
        for (Player player : people) {
            Underwater.interact(player);
        }
        Skeleton.returned(this,this.getName(),"update","");

    }
}
