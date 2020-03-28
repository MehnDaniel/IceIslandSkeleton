package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;
import model.AbstractField;
import model.Thing;

public class StableField extends AbstractField {
    public StableField(Thing buriedThing,int snow,string name){
        super(buriedThing, snow,name);
    }
    public StableField(Thing buriedThing) {
        super(buriedThing, 8,"");
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
