public class SafeHause extends NormalLoc {
    public SafeHause(Player player) {
        super(player, "Güvenli Ev");

    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz...!");
        System.out.println("Canınız yenilendi...!");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealt());
        return true;
    }
}
