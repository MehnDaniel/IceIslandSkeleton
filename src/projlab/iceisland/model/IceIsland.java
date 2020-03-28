package projlab.iceisland.model;

public class IceIsland {
    private static Random random;
    //private IOutput output;
    //private IInput input;
    //private IActionInput actionInput;
    private ArrayList<Player> players;
    private ArrayList<AbstractField> fields;
    private GameState currentState = GameState.Going;

    public static Random getRandom() {
        return random;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<AbstractField> getFields() {
        return fields;
    }

    enum GameState {
        Going, Won, Lost
    }

    /*private IceIsland(final IOutput output,
                      final IInput input,
                      final List<Player> players,
                      final ArrayList<AbstractField> fields,
                      final IActionInput actionInput) {
        this(output, input, players, fields, actionInput, new Random());
    }*/

    /*private IceIsland(final IOutput output,
                      final IInput input,
                      final List<Player> players,
                      final ArrayList<AbstractField> fields,
                      final IActionInput actionInput,
                      Random random){
        IceIsland.random = random;
        this.output = output;
        this.input = input;
        this.players = new ArrayList<>(players);
        this.actionInput = actionInput;

        for (Player player : this.players) {
            player.setIsland(this);
        }
        this.fields = fields;
    } */


    public static class Builder {
      //  private IOutput _output;
        //private IInput _input;
        private List<Player> _players;
        private IslandGenerator _generator;
       // private IActionInput _actionInput;
        private Random _random;
/*
        public Builder output(IOutput _output) {
            this._output = _output;
            return this;
        }

        public Builder input(IInput _input) {
            this._input = _input;
            return this;
        }

        public Builder players(List<Player> _players) {
            this._players = _players;
            return this;
        }

        public Builder generator(IslandGenerator _generator) {
            this._generator = _generator;
            return this;
        }

        public Builder actionInput(IActionInput _actionInput) {
            this._actionInput = _actionInput;
            return this;
        }

        public Builder random(Random _random){
            this._random = _random;
            return this;
        }

        public IceIsland createIceIsland() {
            if(_random != null){
                return new IceIsland(_output, _input, _players, _generator.generate(_players), _actionInput);
            }
            return new IceIsland(_output, _input, _players, _generator.generate(_players), _actionInput, _random);
        }
    }
*/




    @Override
    public void nextRound() {
        output.draw(this);
        actionInput.act(player, input, output);
        updateAll();
    }

    private void updateAll() {
            field.update();
            player.update();
            if(player.isDead()){
                lose();
                return;
            }
        }

    }
/*
    public AbstractField getField(int id) throws OutOfIslandException {
        for(AbstractField field : fields){
            if(field.getId() == id){
                return field;
            }
        }
        throw new OutOfIslandException("asd");
    }*/


    public boolean isAssembleFlareGunPossible(AbstractField where){

            Thing thing = player.getThing();
            switch (thing) {
                case Beacon:
                    break;
                case FlareGun:
                    break;
                case Cartridge:
            }
        }

        return true;
    }

    @Override
    public boolean isOver() {
        return currentState != GameState.Going;
    }

    public void win() {
    }

    public void lose() {
    }
}
