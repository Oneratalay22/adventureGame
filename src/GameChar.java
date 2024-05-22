public abstract class GameChar {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int armor;
    private int money;


    public GameChar(String name, int id, int damage,int armor, int health, int money) {
        this.name = name;
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.armor = armor;
        this.health = health;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
