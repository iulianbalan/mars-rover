package state;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

public enum Orientation {
    N {
        @Override
        public Consumer<Position> moveFunction() {
            return Position::incrementY;
        }

        @Override
        public Consumer<Position> rotateLeftFunction() {
            return position -> position.setOrientation(W);
        }

        @Override
        public Consumer<Position> rotateRightFunction() {
            return position -> position.setOrientation(E);
        }
    },
    E {
        @Override
        public Consumer<Position> moveFunction() {
            return Position::incrementX;
        }

        @Override
        public Consumer<Position> rotateLeftFunction() {
            return position -> position.setOrientation(N);
        }

        @Override
        public Consumer<Position> rotateRightFunction() {
            return position -> position.setOrientation(S);
        }
    },
    S {
        @Override
        public Consumer<Position> moveFunction() {
            return Position::decrementY;
        }

        @Override
        public Consumer<Position> rotateLeftFunction() {
            return position -> position.setOrientation(E);
        }

        @Override
        public Consumer<Position> rotateRightFunction() {
            return position -> position.setOrientation(W);
        }
    },
    W {
        @Override
        public Consumer<Position> moveFunction() {
            return Position::decrementX;
        }

        @Override
        public Consumer<Position> rotateLeftFunction() {
            return position -> position.setOrientation(S);
        }

        @Override
        public Consumer<Position> rotateRightFunction() {
            return position -> position.setOrientation(N);
        }
    };

    public static Optional<Orientation> fromString(String input) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.toString().equals(input))
                .findFirst();
    }


    public abstract Consumer<Position> moveFunction();

    public abstract Consumer<Position> rotateLeftFunction();

    public abstract Consumer<Position> rotateRightFunction();

}
