package dungeon;

public enum WALL{
    DOORH,
    DOORV,
    WALLH,
    WALLV;

    public String print(){
        switch(this){
            case DOORH:
                return "---||---";
            case DOORV:
                return "|--|";
            case WALLH:
                return "--------";
            case WALLV:
                return "||||";
        }

        return "invalid type";
    }

}
