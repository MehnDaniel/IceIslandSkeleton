package projlab.iceisland.model;

import java.util.*;

import static projlab.iceisland.model.AbstractField.FieldState.NoSnow;
import static projlab.iceisland.model.AbstractField.FieldState.UnderSnow;
import static projlab.iceisland.model.Building.NoBuilding;
import static projlab.iceisland.model.Interaction.Cold;

import projlab.iceisland.Skeleton;

public abstract class AbstractField {
    protected int snow;
    protected List<Player> people;
    protected FieldState currentState;
    protected Thing buriedThing;
    protected Building building;
    protected boolean hasStorm;
    protected List<AbstractField> neighbors;
    private String name;

    public AbstractField getNeighbor(int n) {
        Skeleton.called(this, this.getName(), "getNeighbor", n + "");
        if (n >= neighbors.size()) {
            Skeleton.returned(this, this.getName(), "getNeighbor", "null");
            return null;
        }
        AbstractField field = neighbors.get(n);
        Skeleton.returned(this, this.getName(), "getNeighbor", field.getName());
        return neighbors.get(n);
    }

    public String getName() {
        return name;
    }

    public void stepTo(Player player, AbstractField field) {
        Skeleton.called(this, this.getName(), "stepTo", player.getName() + ", " + field.getName());
        field.step(player);
        player.worked();
        people.remove(player);
        Skeleton.returned(this, this.getName(), "stepTo", "");
    }

    public enum FieldState {
        UnderSnow, NoSnow, Water
    }

    public abstract int getCapacity();

    public AbstractField(int startingSnow, List<Player> players, List<AbstractField> neighbors, Thing buriedThing, Building building, String name) {
        this.snow = startingSnow;
        people = players;
        this.buriedThing = buriedThing;
        this.building = building;
        this.name = name;
        this.neighbors = neighbors;
        this.currentState = startingSnow > 0 ? UnderSnow : NoSnow;
    }

    public AbstractField(Thing buriedThing, int startingSnow, List<AbstractField> neighbors, String name) {
        this(startingSnow, new ArrayList<>(), neighbors, buriedThing, NoBuilding, name);
    }

    public void step(Player player) {
        Skeleton.called(this, this.getName(), "step", player.getName());
        people.add(player);
        player.setCurrentField(this);
        Skeleton.returned(this, this.getName(), "step", player.getName());

    }

    public void dig(int n) {
        Skeleton.called(this, this.getName(), "dig", "12");
        if (currentState == UnderSnow) {
            snow -= n;
        }
        building = NoBuilding;
        if (snow <= 0) {
            currentState = FieldState.NoSnow;
            snow = 0;
        }
        Skeleton.returned(this, this.getName(), "dig", "12");
    }

    public List<Player> getPeople() {
        return people;
    }

    public Player rescueSomeone() {
        Skeleton.called(this, this.getName(), "rescueSomeone", "");
        if (currentState == FieldState.Water && !people.isEmpty()) {
            Player player = people.get(0);
            people.remove(player);
            Skeleton.returned(this, this.getName(), "rescueSomeone", player.getName());
            return player;
        }
        Skeleton.returned(this, this.getName(), "rescueSomeone", "null");
        return null;
    }

    public void takeThing(Player player) {
        Skeleton.called(this, this.getName(), "takeThing", player.getName());
        if (snow > 0) {
            return;
        }
        if (this.buriedThing != Thing.Nothing) {
            player.setThing(buriedThing);
            this.buriedThing = Thing.Nothing;
        }
        Skeleton.returned(this, this.getName(), "takeThing", "");

    }

    public Building getBuilding() {
        return building;
    }

    public FieldState getState() {
        return currentState;
    }

    public Thing getThing() {
        return buriedThing;
    }

    public boolean hasStorm() {
        return hasStorm;
    }

    public void setStorm(boolean bool) {
        hasStorm = bool;
    }

    public boolean build(Building building) {
        Skeleton.called(this, this.getName(), "build", building.toString());
        if (currentState == UnderSnow) {
            this.building = building;
            for (Player player : people) {
                player.buildingBuilt(building);
            }
            Skeleton.returned(this, this.getName(), "build", "true");
            return true;
        }
        Skeleton.returned(this, this.getName(), "build", "false");
        return false;
    }

    public void snowing() {
        Skeleton.called(this, this.getName(), "snowing", "");
        snow++;
        currentState = UnderSnow;
        Skeleton.returned(this, this.getName(), "snowing", "");
    }

    public void update() {
        Skeleton.called(this, this.getName(), "update", "");

        if (hasStorm) {
            snowing();
            for (Player player : people) {
                Cold.interact(player);
            }
        }
        Skeleton.returned(this, this.getName(), "update", "");

    }
}

