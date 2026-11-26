import java.util.Scanner;

public class TabungKerucut15 {
    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + (2 * Math.PI * r * t);
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU TABUNG & KERUCUT ===");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            if (pilihan == 0) {
                System.out.println("Program selesai.");
                break;
            }

            System.out.print("Masukkan jari-jari (r): ");
            double r = sc.nextDouble();
            double t = 0;
            if (pilihan >= 2 && pilihan <= 4) {
                System.out.print("Masukkan tinggi (t): ");
                t = sc.nextDouble();
            }

            switch (pilihan) {
                case 1:
                    System.out.printf("Luas Lingkaran: %.2f\n", luasLingkaran(r));
                    break;
                case 2:
                    System.out.printf("Volume Tabung: %.2f\n", volumeTabung(r, t));
                    break;
                case 3:
                    System.out.printf("Luas Permukaan Tabung: %.2f\n", luasPermukaanTabung(r, t));
                    break;
                case 4:
                    System.out.printf("Volume Kerucut: %.2f\n", volumeKerucut(r, t));
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        sc.close();
    }
}