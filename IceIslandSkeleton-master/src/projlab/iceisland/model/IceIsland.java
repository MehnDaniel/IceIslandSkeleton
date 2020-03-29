package projlab.iceisland.model;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.fields.StableField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IceIsland {

    private ArrayList<Player> players;
    private ArrayList<AbstractField> fields;


    private GameState currentState = GameState.Going;



    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<AbstractField> getFields() {
        return fields;
    }

    enum GameState {
        Going, Won, Lost
    }


    private IceIsland(final List<Player> players,
                      final ArrayList<AbstractField> fields) {
        this.players = new ArrayList<>(players);

        for (Player player : this.players) {
            player.setIsland(this);
        }
        this.fields = fields;
    }


    //nagyobb lesz amikor elkezdjük az iot hozzáadni azért van Builder class
    public static class Builder {
        private List<Player> _players;
        private IslandGenerator _generator;


        public Builder players(List<Player> _players) {
            StringBuilder sb = new StringBuilder();
            for (Player player : _players){
                sb.append(player.getName()).append(" ");
            }
            Skeleton.called(this, "players", sb.toString());
            this._players = _players;
            Skeleton.returned(this, "players", this.toString());
            return this;
        }

        public Builder generator(IslandGenerator _generator) {
            Skeleton.called(this, "generator", _generator.toString());
            this._generator = _generator;
            Skeleton.returned(this, "generator", this.toString());
            return this;
        }



        public IceIsland createIceIsland() {
            Skeleton.called(this, "createIceIsland", "");

            Skeleton.returned(this, "createIceIsland", "");
            return new IceIsland(_players, _generator.generate(_players));
        }
    }


    public void updateAll() {
        Skeleton.called(this, "updateAll", "");

        for (AbstractField field : fields) {
            field.update();
        }

        for (Player player : players) {
            player.update();
            if (player.isDead()) {
                lose();
                return;
            }
        }
        Skeleton.returned(this, "updateAll", "");

    }


    public boolean isOver() {
        Skeleton.called(this, "isOver", "");
        boolean ret = currentState != GameState.Going;
        Skeleton.returned(this, "isOver", ret ? "true" : "false");
        return ret;
    }

    public boolean isAssembleFlareGunPossible(AbstractField where) {
        Skeleton.called(this, "isAssembleFlareGunPossible", where.getName());
        boolean hasFlareGun = false;
        boolean hasCartridge = false;
        boolean hasBeacon = false;

        for (Player player : where.getPeople()) {
            Thing thing = player.getThing();
            switch (thing) {
                case Beacon:
                    hasBeacon = true;
                    break;
                case FlareGun:
                    hasFlareGun = true;
                    break;
                case Cartridge:
                    hasCartridge = true;
            }
        }

        boolean allOnOneField = players.size() == where.getPeople().size();

        Skeleton.returned(this, "isAssembleFlareGunPossible", hasFlareGun && hasCartridge && hasBeacon && allOnOneField ? "true" : "false");
        return hasFlareGun && hasCartridge && hasBeacon && allOnOneField;

    }


    public void win() {
        Skeleton.called(this, "win", "");
        currentState = GameState.Won;
        Skeleton.returned(this, "win", "");

    }

    public void lose() {
        Skeleton.returned(this, "lose", "");
        currentState = GameState.Lost;
        Skeleton.returned(this, "lose", "");

    }
}
