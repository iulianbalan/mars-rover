package actions;

import state.Position;

import java.util.function.Consumer;

public class InvalidAction extends Action {

    public InvalidAction(String action) {
        throw new IllegalStateException("Invalid action named: " + action);
    }

    @Override
    Consumer<Position> getAction(Position currentPosition) {
        throw new IllegalStateException();
    }
}
