import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orijinalHealt;
    private int money;
    private String name;
    private String charName;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();
        // GameChar[] charlist={ new Samurai(), new Knight(), new Archer()};


        System.out.println("====================");
        // for (GameChar gameChar : charlist){
        System.out.println(samurai.getId() + "\t Karakter : Samuray \t Hasar :" + samurai.getDamage() + "\t Sağlık :" + samurai.getHealth() + "\t Para :" + samurai.getMoney() + "\t Zırh : " + samurai.getArmor());
        System.out.println(archer.getId() + "\t Karakter : Okçu \t\t Hasar :" + archer.getDamage() + " \t Sağlık :" + archer.getHealth() + "\t Para :" + archer.getMoney() + "\t Zırh : " + archer.getArmor());
        System.out.println(knight.getId() + "\t Karalter : Şovalye \t Hasar :" + knight.getDamage() + "\t Sağlık :" + knight.getHealth() + "\t Para :" + knight.getMoney() + "\t Zırh : " + knight.getArmor());

        System.out.println("Karakter seçiniz ..!");
        System.out.println("==================");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        //}
        // System.out.println("Karakter : " + this.getCharName() + " Hasar : " + this.getDamage() + " Sağlık : " + this.getHealth() + " Para : " + this.getMoney());

    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealt(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                " Silah : " + this.getInventory().getWeapon().getName() +
                        ", Zırh : " + this.getInventory().getArmor().getName() +
                        ", Bloclama : " + this.getInventory().getArmor().getAbsorbe() +
                        ", Hasarınız : " + this.getDamage() +
                        ", Sağlık : " + this.getHealth() +
                        ", Para : " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrijinalHealt() {
        return orijinalHealt;
    }

    public void setOrijinalHealt(int orijinalHealt) {
        this.orijinalHealt = orijinalHealt;
    }
}

