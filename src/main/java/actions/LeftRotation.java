package actions;

import state.Position;

import java.util.function.Consumer;

public class LeftRotation extends Rotation {

    private static final LeftRotation INSTANCE = new LeftRotation();

    public static LeftRotation instance() {
        return INSTANCE;
    }

    @Override
    Consumer<Position> getAction(Position currentPosition) {
        return currentPosition.getOrientation().rotateLeftFunction();
    }
}
