import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol : " + obsNumber + " tane " + this.getObstacle().getName() + " Yaşıyor !");
        System.out.println("Savaşmak için <S> veya Kaçmak için <K> seçiniz");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")&& combat(obsNumber)) {
                System.out.println(this.getName() + "Tüm düşmanları yendiniz...!");
                return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz");
            return false;

        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealt(this.obstacle.getOrjinalHealt());
            playerStats();
            obstacleStats(i);

            boolean playerStarts=random.nextBoolean(); // true dönerse oyuncu başlar

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealt() > 0) {
                System.out.println("Vur veya  kaç (K)-(V)");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz : ");
                    this.getObstacle().setHealt(this.obstacle.getHealt()- this.getPlayer().getTotalDamage());
                  afterHit();
                  if(this.getObstacle().getHealt() > 0){
                      System.out.println();
                      System.out.println("Canavar Size vurdu ...!");
                      int obstacleDamage = this.getObstacle().getDamege() - this.getPlayer().getInventory().getArmor().getAbsorbe();
                      if(obstacleDamage < 0){
                          obstacleDamage = 0;
                      }
                      this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                  }
                    // Dövüş sırası değişir
                    playerStarts = !playerStarts;
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealt() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz...!");
                System.out.println(this.obstacle.getAward() + " para kazandınız ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı " + this.getObstacle().getHealt());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri :");
        System.out.println("======================");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah  : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh   : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocklama   : " + this.getPlayer().getInventory().getArmor().getAbsorbe());
        System.out.println("Hasar  : " + this.getPlayer().getTotalDamage());
        System.out.println("Para   : " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i ) {
        System.out.println(i + "."+ this.getObstacle() + " Değerleri ");
        System.out.println("======================");
        System.out.println("Sağlık : " + this.getObstacle().getHealt());
        System.out.println("Hasar  : " + this.getObstacle().getDamege());
        System.out.println("Ödül   : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
