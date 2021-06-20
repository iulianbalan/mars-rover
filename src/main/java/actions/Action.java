package actions;

import state.Position;

import java.util.function.Consumer;

public abstract class Action {

    abstract Consumer<Position> getAction(Position currentPosition);

    public final void apply(Position position) {
        getAction(position).accept(position);
    }

    public static Action fromString(String inputAction) {
        return switch (inputAction) {
            case "L" -> LeftRotation.instance();
            case "R" -> RightRotation.instance();
            case "M" -> Movement.instance();
            default ->  new InvalidAction(inputAction);
        };
    }
}
