package actions;

import state.Position;

import java.util.function.Consumer;

public class RightRotation extends Rotation {
    private static final RightRotation INSTANCE = new RightRotation();

    public static RightRotation instance() {
        return INSTANCE;
    }
    @Override
    Consumer<Position> getAction(Position position) {
        return position.getOrientation().rotateRightFunction();
    }
}
