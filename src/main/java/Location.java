public enum Location {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, TWENTY

    public static int toInteger(Location location) {
        return switch (location) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN -> 10;
            case ELEVEN -> 11;
            case TWELVE -> 12;
            case THIRTEEN -> 13;
            case FOURTEEN -> 14;
            case FIFTEEN -> 15;
            case SIXTEEN -> 16;
            case SEVENTEEN -> 17;
            case EIGHTEEN -> 18;
            case NINETEEN -> 19;
            case TWENTY -> 20;
        };
    }

    public static Location fromInteger(int integer) {
        return switch(integer) {
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            case 6 -> SIX;
            case 7 -> SEVEN;
            case 8 -> EIGHT;
            case 9 -> NINE;
            case 10 -> TEN;
            case 11 -> ELEVEN;
            case 12 -> TWELVE;
            case 13 -> THIRTEEN;
            case 14 -> FOURTEEN;
            case 15 -> FIFTEEN;
            case 16 -> SIXTEEN;
            case 17 -> SEVENTEEN;
            case 18 -> EIGHTEEN;
            case 19 -> NINETEEN;
            case 20 -> TWENTY;
            default -> null;
        };
    }
}
