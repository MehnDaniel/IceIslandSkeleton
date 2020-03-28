package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

public class StableField extends AbstractField {
    public StableField(Thing buriedThing,int snow){
        super(buriedThing, snow);
    }
    public StableField(Thing buriedThing) {
        super(buriedThing, 8);
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
