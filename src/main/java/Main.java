import state.Map;
import state.Orientation;
import state.Position;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern POSITION_REGEX = Pattern.compile("(\\d) (\\d) ([NWES])");

    private static final Pattern ACTION_REGEX = Pattern.compile("([LRM]*)");

    private static final Pattern MAP_REGEX = Pattern.compile("(\\d) (\\d)");
    private static Scanner inputScanner;

    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);

        Matcher mapMatcher = readNext(MAP_REGEX);
        Map map = new Map(Integer.parseInt(mapMatcher.group(1)), Integer.parseInt(mapMatcher.group(2)));

        while (true) {
            Matcher roverPositionMatcher = readNext(POSITION_REGEX);
            Rover rover = new Rover(new Position(
                    Integer.parseInt(roverPositionMatcher.group(1)),
                    Integer.parseInt(roverPositionMatcher.group(2)),
                    Orientation.fromString(roverPositionMatcher.group(3)).orElseThrow()
            ), map);

            Matcher roverActionsMatcher = readNext(ACTION_REGEX);

            rover.applyActions(roverActionsMatcher.group(1));
            System.out.println(rover.getPosition());
        }

    }

    private static Matcher readNext(Pattern pattern) {
        String mapInput = inputScanner.nextLine();
        Matcher matcher = pattern.matcher(mapInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Input should match " + pattern);
        }
        return matcher;
    }
}
