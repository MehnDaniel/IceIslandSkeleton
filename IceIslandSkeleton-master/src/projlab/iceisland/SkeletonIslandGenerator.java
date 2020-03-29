package projlab.iceisland;

import projlab.iceisland.model.AbstractField;
import projlab.iceisland.model.IslandGenerator;
import projlab.iceisland.model.Player;

import java.util.ArrayList;
import java.util.List;

public class SkeletonIslandGenerator implements IslandGenerator {

    private List<AbstractField> fields;

    SkeletonIslandGenerator(List<AbstractField> fields){
        this.fields = fields;
    }


    @Override
    public ArrayList<AbstractField> generate(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        for(Player player : players){
            sb.append(player.getName()).append(" ");
        }
        Skeleton.called(this, "generate", sb.toString());
        for(Player player : players){
            fields.get(0).step(player);
        }

        return new ArrayList<>(fields);
    }
}
