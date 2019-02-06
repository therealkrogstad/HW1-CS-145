import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DungeonMap dungeonMap = new DungeonMap();
        System.out.println("Do you want the basic map dimensions? y/n ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("y")){
            dungeonMap.setDungeonMap(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }else {
            int x = 0;
            int y = 0;
            while(x < 3) {
                System.out.println("Enter X dimension that is greater than 3");
                x = scanner.nextInt();
            }
            while(y < 3) {
                System.out.println("Enter Y dimension that is greater than 3");
                y = scanner.nextInt();
            }
            dungeonMap.setDungeonMap(x, y);
        }
        
        DungeonGame dungeonGame = new DungeonGame();
        dungeonGame.play();
    }
}
