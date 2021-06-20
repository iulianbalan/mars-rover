import actions.Action;
import state.Map;
import state.Position;

import java.util.concurrent.atomic.AtomicInteger;

public class Rover {

    private static final AtomicInteger roverNumber = new AtomicInteger(0);

    public final String name;
    private final Map marsMap;
    private Position position;

    public Rover(Position position, Map marsMap) {
        this.marsMap = marsMap;
        this.name = "mars-rover-" + roverNumber.getAndIncrement();
        this.position = position;
    }

    public void applyAction(Action action) {
        Position nextPosition = this.position.clone();
        action.apply(nextPosition);
        if (marsMap.isOnTheMap(nextPosition)) {
            this.position = nextPosition;
        } else {
            throw new IllegalArgumentException(this.name + " went off the map");
        }
    }

    public void applyActions(String actions) {
        actions.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(Action::fromString)
                .forEach(this::applyAction);
    }

    public Position getPosition() {
        return position;
    }
}
