public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private String playerIcon = "W";
    private double lootModifier;



    // set constants for classes
    private final int THIEF_STARTING_HEALTH = 70;
    private final int THIEF_STARTING_GOLD = 0;
    private final int THIEF_STARTING_DAMAGE = 10;
    private final double THIEF_LOOT_MODIFIER = 0.2;

    private final int WARRIOR_STARTING_HEALTH = 100;
    private final int WARRIOR_STARTING_GOLD = 0;
    private final int WARRIOR_STARTING_DAMAGE = 15;



    // accessors and mutators to keep encapsulation
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;

        // if player chooses warrior class
        if(this.playerClass.equals("1")){
            health = WARRIOR_STARTING_HEALTH;
            damage = WARRIOR_STARTING_DAMAGE;
            gold = WARRIOR_STARTING_GOLD;
            playerIcon = "W";
        }

        // if player chooses thief class
        else if(this.playerClass.equals("2")){
            health = THIEF_STARTING_HEALTH;
            damage = THIEF_STARTING_DAMAGE;
            gold = THIEF_STARTING_GOLD;
            lootModifier = THIEF_LOOT_MODIFIER;
            playerIcon = "T";
        }





    }

    public void attack(Monster target){
        System.out.println("Player hits " + target.getMonsterType() + " for " + damage);

        target.onHit(damage);
    }
    public void onHit(int damage){

        health -= damage;

        if(health <=0){
            System.out.println("The player has died");
        }

    }

    public void onHeal(int health){
        this.health += health;
        //check for max health
        if(getPlayerClass().equals("1")){
            if(health > WARRIOR_STARTING_HEALTH){
                this.health = WARRIOR_STARTING_HEALTH;
            }
        }
        else if(getPlayerClass().equals("2")){
            if(health > THIEF_STARTING_HEALTH){
                this.health = THIEF_STARTING_HEALTH;
            }
        }

    }

    public void onLoot(int gold){
        if(getPlayerClass().equals("1"){
            this.gold += gold;
        }
        else if(getPlayerClass().equals("2"){
            this.gold += (gold * THIEF_LOOT_MODIFIER);
        }
    }

    public String getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(String playerIcon) {
        this.playerIcon = playerIcon;
    }
}
