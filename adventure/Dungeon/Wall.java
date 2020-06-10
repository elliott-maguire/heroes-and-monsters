package adventure.Dungeon;

public enum Wall {
    WALL_INNER_HORIZONTAL, WALL_INNER_VERTICAL, WALL_OUTER_HORIZONTAL, WALL_OUTER_VERTICAL, DOOR_HORIZONTAL,
    DOOR_VERTICAL;

    public String toString() {
        switch (this) {
            case WALL_INNER_HORIZONTAL:
                return "---------";
            case WALL_INNER_VERTICAL:
                return "|";
            case WALL_OUTER_HORIZONTAL:
                return "*********";
            case WALL_OUTER_VERTICAL:
                return "*";
            case DOOR_HORIZONTAL:
                return "---| |---";
            case DOOR_VERTICAL:
                return "=";
            default:
                return "NULL";
        }
    }
}