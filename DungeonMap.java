public class DungeonMap {


    private int playerXLocation = 1;
    private int playerYLocation = 1;
    private String dungeonMap[][];
    private Player player;
    public Room room;
    private String player_icon;

    private final String MAP_NS_WALL = "-";
    private final String MAP_WE_WALL = "|";
    private final String MAP_CORNER_WALL = "+";
    private final String MAP_FLOOR = " ";
    private final String MAP_EXPLORED = "*";

    public void setDungeonMap(int xPos, int yPos){
        dungeonMap = new String[yPos][xPos];
        for (int i = 0; i < yPos; i++){
            for (int j = 0; j < xPos; j++){
                if (j== playerXLocation && i == playerYLocation){
                    dungeonMap[i][j] = player_icon;
                } else if (j == 0 && i == 0||j == 0 && i == yPos-1||j == xPos-1 && i == 0||j == xPos-1 && i == yPos-1){
                    dungeonMap[i][j] = MAP_CORNER_WALL;
                } else if(j == 0 || j == xPos-1) {
                    dungeonMap[i][j] = MAP_WE_WALL;
                } else if(i == 0 || i == xPos-1) {
                    dungeonMap[i][j] = MAP_NS_WALL;
                }else{
                    dungeonMap[i][j] = MAP_FLOOR;
                }
            }
        }
        if (player.getPlayerClass() == "1"){
            player_icon = "W";
        } else if (player.getPlayerClass() == "2"){
            player_icon = "T";
        }

    }

    public boolean playerLocationValid(int x, int y){
        if (playerYLocation + y != 0 || playerYLocation + y != dungeonMap.length-1 || playerXLocation + x != 0 || playerXLocation + x != dungeonMap[0].length){
            return true;
        }else {
            System.out.println("Not a valid direction.");
            return false;
        }
    }
    public void playerLocation(int x, int y){
        if (dungeonMap[playerYLocation + y][playerXLocation + x].equalsIgnoreCase("*")){
            dungeonMap[playerYLocation][playerXLocation] = MAP_EXPLORED;
            playerYLocation += y;
            playerXLocation += x;
            dungeonMap[playerYLocation][playerXLocation] = player_icon;
            room.setEncounter(false);
        } else {
            dungeonMap[playerYLocation][playerXLocation] = MAP_EXPLORED;
            playerYLocation += y;
            playerXLocation += x;
            dungeonMap[playerYLocation][playerXLocation] = player_icon;
            room.setEncounter(true);
        }

    }

    public void print(){
        for (int i = 0; i < dungeonMap.length; i++){
            for (int j = 0; j < dungeonMap[i].length; j++){
                System.out.print(dungeonMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
