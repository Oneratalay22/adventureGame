public class Obstacle {
    private int id;
    private String name;
    private int damege;
    private int healt;
    private int award;
    private int orjinalHealt;



    public Obstacle(int id, String name, int damege, int healt, int award) {
        this.id = id;
        this.name = name;
        this.damege = damege;
        this.healt = healt;
        this.orjinalHealt=healt;
        this.award = award;
    }
    public int getAward(){
        return award;
    }
    public void setAward(int money){
        this.award = money;
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

    public int getDamege() {
        return damege;
    }

    public void setDamege(int damege) {
        this.damege = damege;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        if(healt<0)
            healt = 0;
        this.healt = healt;
    }

    public int getOrjinalHealt() {
        return orjinalHealt;
    }

    public void setOrjinalHealt(int orjinalHealt) {
        this.orjinalHealt = orjinalHealt;
    }
}



