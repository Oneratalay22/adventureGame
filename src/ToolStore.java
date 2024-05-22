public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz...!");
        boolean showMenu = true;
        while (true) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.println("Seçiminiz ...!");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer tekrar giriniz...!");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha beklerız");
                    showMenu = false;
                    break;
            }
            return true;
        }
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + "\t Para : " + w.getPrice() + "\t Hasar : " + w.getDamage());
        }
       /* System.out.println("Bir Silah Seçiniz ..!");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer tekrar giriniz...!");
            selectWeaponID = input.nextInt();
        }*/
    }

    public void buyWeapon() {
        System.out.println("Bir Silah Seçiniz ..!");
        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer tekrar giriniz...!");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır..!");
            } else {
                // Satın alma gerçekleşir.
                System.out.println(selectedWeapon.getName() + "Silahını satın aldınız");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }

    public void printArmor() {
        System.out.println("Zırhlar");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " Para : " + a.getPrice() + " Absorbe : " + a.getAbsorbe());
        }
    }

    public void buyArmor() {
        System.out.println("Bir Zırh Seçiniz ..!");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz değer tekrar giriniz...!");
            selectArmorID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır..!");
            } else {
                // Satın alma gerçekleşir.
                System.out.println(selectedArmor.getName() + "Zırhını satın aldınız");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);

            }


        }

    }

}








