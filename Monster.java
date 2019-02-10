import java.util.Random;


public class Monster {
    private int health;
    private int damage;
    private String monsterType;


    public int getDamage(){return damage;}
    public void setDamage(int damage){this.damage = damage;}

    public int getHealth(){return health;}
    public void setHealth(int health){this.health = health;}



    public void attack(){

    }

    public void onHit(){

    }

    public String getMonsterType(){return monsterType;}
    public void setMonsterType(String monsterType){

        this.monsterType = monsterType;

        String[] monsterClass = {"Goblin", "Zombie", "Orc", "Deneke"};

        Random random = new Random();

        int monsterClassIndex = random.nextInt(monsterClass.length);
        this.monsterType = monsterClass[monsterClassIndex];


        if(this.monsterType.equals("Goblin")){
            this.health = 6;
            this.damage = 10;
        }
        else if(this.monsterType.equals("Zombie")){
            this.health = 12;
            this.damage = 15;
        }
        else if(this.monsterType.equals("Orc")){
            this.health = 18;
            this.damage = 20;
        }
        else if(this.monsterType.equals("Deneke")){
            this.health = 55;
            this.damage = 5;
        }
    }

}
