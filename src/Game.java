import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.println("Lütfen oyuncu ismi giriniz !:");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " Macera Dolu Adaya  Hoşgeldiniz  !");
        System.out.println("Lütfen Bir Karakter Seçiniz ...!");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("================================");
            System.out.println();
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli Ev ");
            System.out.println("2 - Eşya Dükkanı ");
            System.out.println("3 - Mağara -----> Dikkatli ol Zombi çıkabilir");
            System.out.println("4 - Orman  -----> Dikkatli ol Vampir çıkabilir");
            System.out.println("5 - Nehir  -----> Dikkatli ol Ayı çıkabilir");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçin");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHause(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                    case 5:
                        location = new River(player);
                        break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz ..!");
                    //location = new SafeHause(player);
            }
            if (!location.onLocation()) {
                System.out.println("Öldünüz...!GAME OVER");
                break;
            }
        }


    }
}
