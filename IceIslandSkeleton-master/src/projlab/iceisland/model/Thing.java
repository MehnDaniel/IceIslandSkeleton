package projlab.iceisland.model;

import projlab.iceisland.Skeleton;
import projlab.iceisland.model.thingusagestrategies.BarehandsDig;
import projlab.iceisland.model.thingusagestrategies.RopeRescue;
import projlab.iceisland.model.thingusagestrategies.ShovelDig;

public enum Thing {

    Nothing{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Nothing", "getDiggingStrategy", "");
            Skeleton.returned(this, "Nothing", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Nothing", "getRescueStrategy", "");
            Skeleton.returned(this, "Nothing", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Nothing", "useForSwimming", "");
            Skeleton.returned(this, "Nothing", "useForSwimming", "");

            return false;
        }
        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Nothing", "useForEating", who.toString());
            Skeleton.returned(this, "Nothing", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Nothing", "useForShooting", from.toString()+", "+island.toString());
            Skeleton.returned(this, "Nothing", "useForShooting", from.toString()+", "+island.toString());

        }

    },
    Food{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Food", "getDiggingStrategy", "");
            Skeleton.returned(this, "Food", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Food", "getRescueStrategy", "");
            Skeleton.returned(this, "Food", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Food", "useForSwimming", "");
            Skeleton.returned(this, "Food", "useForSwimming", "");

            return false;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Food", "useForEating", who.toString());
            who.ate();
            Skeleton.returned(this, "Food", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Food", "useForShooting", from.toString()+", "+island.toString());
            Skeleton.returned(this, "Food", "useForShooting", from.toString()+", "+island.toString());

        }
    }, Shovel{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Shovel", "getDiggingStrategy", "");
            Skeleton.returned(this, "Shovel", "getDiggingStrategy", "");

            return new ShovelDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Shovel", "getRescueStrategy", "");
            Skeleton.returned(this, "Shovel", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Shovel", "useForSwimming", "");
            Skeleton.returned(this, "Shovel", "useForSwimming", "");

            return false;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Shovel", "useForEating", who.toString());
            Skeleton.returned(this, "Shovel", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Shovel", "useForShooting", from.toString()+", "+island.toString());
            Skeleton.returned(this, "Shovel", "useForShooting", from.toString()+", "+island.toString());

        }
    }, Scuba{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Scuba", "getDiggingStrategy", "");
            Skeleton.returned(this, "Scuba", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Scuba", "getRescueStrategy", "");
            Skeleton.returned(this, "Scuba", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Scuba", "useForSwimming", "");
            Skeleton.returned(this, "Scuba", "useForSwimming", "");

            return true;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Scuba", "useForEating", who.toString());
            Skeleton.returned(this, "Scuba", "useForEating", who.toString());

        }


        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Scuba", "useForShooting", from.toString()+", "+island.toString());
            Skeleton.returned(this, "Scuba", "useForShooting", from.toString()+", "+island.toString());

        }
    }, Rope{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Rope", "getDiggingStrategy", "");
            Skeleton.returned(this, "Rope", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Rope", "getRescueStrategy", "");
            Skeleton.returned(this, "Rope", "getRescueStrategy", "");

            return new RopeRescue();
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Rope", "useForSwimming", "");
            Skeleton.returned(this, "Rope", "useForSwimming", "");

            return false;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Rope", "useForEating", who.toString());
            Skeleton.returned(this, "Rope", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Rope", "useForShooting", from.toString()+", "+island.toString());
            Skeleton.returned(this, "Rope", "useForShooting", from.toString()+", "+island.toString());

        }
    }, FlareGun{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "FlareGun", "getDiggingStrategy", "");
            Skeleton.returned(this, "FlareGun", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "FlareGun", "getRescueStrategy", "");
            Skeleton.returned(this, "FlareGun", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "FlareGun", "useForSwimming", "");
            Skeleton.returned(this, "FlareGun", "useForSwimming", "");

            return false;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "FlareGun", "useForEating", who.toString());
            Skeleton.returned(this, "FlareGun", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "FlareGun", "useForShooting", from.getName() + ", island");
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }

            Skeleton.returned(this, "FlareGun", "useForShooting", "");

        }
    }, Cartridge{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Cartridge", "getDiggingStrategy", "");
            Skeleton.returned(this, "Cartridge", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Cartridge", "getRescueStrategy", "");
            Skeleton.returned(this, "Cartridge", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Cartridge", "useForSwimming", "");
            Skeleton.returned(this, "Cartridge", "useForSwimming", "");

            return false;
        }

        @Override
        void useForEating(Player who) {
            Skeleton.called(this, "Cartridge", "useForEating", who.toString());
            Skeleton.returned(this, "Cartridge", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Cartridge", "useForShooting", from.getName() + ", island");
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }
            Skeleton.returned(this, "Cartridge", "useForShooting", "");

        }
    }, Beacon{
        @Override
        DiggingStrategy getDiggingStrategy() {
            Skeleton.called(this, "Beacon", "getDiggingStrategy", "");
            Skeleton.returned(this, "Beacon", "getDiggingStrategy", "");

            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            Skeleton.called(this, "Beacon", "getRescueStrategy", "");
            Skeleton.returned(this, "Beacon", "getRescueStrategy", "");

            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            Skeleton.called(this, "Beacon", "useForSwimming", "");
            Skeleton.returned(this, "Beacon", "useForSwimming", "");

            return false;
        }

        @Override
        public void useForEating(Player who){
            Skeleton.called(this, "Beacon", "useForEating", who.toString());
            Skeleton.returned(this, "Beacon", "useForEating", who.toString());

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            Skeleton.called(this, "Beacon", "useForShooting", from.getName() + ", island");
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }

            Skeleton.returned(this, "Beacon", "useForShooting", "");

        }
    };

    public interface DiggingStrategy{
        void dig(Player who);
    }

    public interface RescueStrategy {
        void rescuePlayer(Player who, int from);

    }

    public RescueStrategy cantRescue = (who , from)->{};

    abstract DiggingStrategy getDiggingStrategy();
    abstract RescueStrategy getRescueStrategy();
    abstract boolean useForSwimming();
    abstract void useForEating(Player who);
    abstract void useForShooting(AbstractField from, IceIsland island);
}
