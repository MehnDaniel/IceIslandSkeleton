package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

import projlab.iceisland.model.Thing;

import java.util.List;

public class StableField extends AbstractField {
    public StableField(Thing buriedThing, int snow, List<AbstractField> neighbors, String name){
        super(buriedThing, snow, neighbors,name);
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
