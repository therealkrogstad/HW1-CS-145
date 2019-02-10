import java.util.Scanner;
import java.util.Random;

public class Room {
    private boolean visited = false;

    private String mapIcon;



    public void enter(Player player) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int encounter = random.nextInt(2);

        if (!visited) {


            // if encounter is monster
            if (encounter == 0) {

                Monster monster = new Monster();
                monster.initializeMonster();

                System.out.println("A " + monster.getMonsterType() + " appears");

                while (monster.getHealth() > 0) {
                    System.out.println("Select an action: [1] Attack, [2] Run ");
                    int combatAction = scanner.nextInt();


                    //attack
                    if (combatAction == 1) {
                        //monster attack
                        monster.attack(player);
                        System.out.println("The " + monster.getMonsterType() + "hits you for " + monster.getDamage() + " damage!");

                        //player attack
                        player.attack(monster);
                        System.out.println("You attack and hit the " + monster.getMonsterType() + " for " + player.getDamage() + " damage");
                        if (monster.getHealth() <= 0) {
                            System.out.println("The " + monster.getMonsterType() + " dies!");

                        }
                    }

                    //run
                    else if (combatAction == 2) {
                        monster.attack(player);
                        System.out.println("You try to run... ");
                        System.out.println("The " + monster.getMonsterType() + "attacks and hits you for " + monster.getDamage() + " damage as you try to escape");
                        break;

                    } else {
                        System.out.println("Invalid input");

                    }


                }
                visited = true;

            }

            // if encounter is loot
            else if (encounter == 1) {
                int goldOrHeal = random.nextInt(2);

                // health encounter
                if (goldOrHeal == 0) {
                    int healthPotion = random.nextInt(30);
                    player.onHeal(healthPotion);
                }

                // gold encounter
                if (goldOrHeal == 1) {
                    int goldLoot = random.nextInt(30);
                    player.onLoot(goldLoot);


                }
            }

        }
    }



    public String getMapIcon() {
        return mapIcon;
    }

    public void setMapIcon(String mapIcon) {
        this.mapIcon = mapIcon;
    }
}
