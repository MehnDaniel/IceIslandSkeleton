package projlab.iceisland.model.fields;

import projlab.iceisland.model.AbstractField;

public class StableField extends AbstractField {
    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
