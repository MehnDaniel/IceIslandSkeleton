package projlab.iceisland.model;

public enum Interaction {
    Underwater{
        @Override
        public void interact(Player with) {
            if(!with.getThing().useForSwimming()){
                with.setWorkPoints(0);
            }
        }
    }, Cold{
        @Override
        public void interact(Player with) {
            if(!with.isWarm()){
                with.damage();
            }
        }
    };

    public abstract void interact(Player with);
}
