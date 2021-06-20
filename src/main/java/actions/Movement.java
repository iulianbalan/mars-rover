package actions;

import state.Position;

import java.util.function.Consumer;

public class Movement extends Action {

    private static final Movement INSTANCE = new Movement();

    public static Movement instance() {
        return INSTANCE;
    }

    @Override
    Consumer<Position> getAction(Position position) {
        return position.getOrientation().moveFunction();
    }
}
