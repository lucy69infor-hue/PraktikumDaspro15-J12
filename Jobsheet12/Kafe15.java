package jobsheet12;
import java.util.Scanner;
public class Kafe15 {
    public static void main(String[] args) {    
    Scanner sc = new Scanner(System.in);       
    boolean lanjut = true;
    int totalBayar = 0;
    int subtotal = 0;
    boolean isMember = menu(sc);
    while (lanjut) {

            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            subtotal = hitungTotalHarga15(pilihanMenu, banyakItem);

            totalBayar += subtotal;

            System.out.println("Subtotal pesanan: Rp" + subtotal);
            System.out.println("Total sementara: Rp" + totalBayar);

            System.out.print("\nApakah ingin memesan menu lain? (y/n): ");
            char jawaban = sc.next().charAt(0);

            if (jawaban == 'n' || jawaban == 'N') {
                lanjut = false;
            }
        }
        double total = hitungDiskon(totalBayar, "", isMember, sc);
        System.out.println("\n===== STRUK PEMBAYARAN =====");
        System.out.println("Total pembayaran: Rp" + total);
        System.out.println("Terima kasih telah berkunjung!");

        sc.close();
}
        
    public static boolean menu(Scanner sc) {
        System.out.println("Selamat datang!, Masukkan nama Anda :");
        String namaPelanggan = sc.nextLine();
        System.out.println("Selamat datang,"+ namaPelanggan + "!");
        System.out.println("Apakah anda seorang member ? (true/false)");
        boolean isMember = sc.nextBoolean();
        if (isMember){
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        } else {
            System.out.println("Maaf anda bukan member, diskon 10% hanya diberikan kepada member saja");
        }
        System.out.println("Jam kunjung " + namaPelanggan + ": ");
        int jam = sc.nextInt();
        if (jam >= 14 && jam <= 16){
            System.out.println("Happy hour!, Anda mendapatkan Diskon 20% untuk seluruh minuman");
        }
        System.out.println("===== MENU RESTO KAFE =====");   
        System.out.println("1. Kopi Hitam - Rp 15,000");   
        System.out.println("2. Cappuccino - Rp 20,000");    
        System.out.println("3. Latte - Rp 22,000");   
        System.out.println("4. Teh Tarik - Rp 12,000");    
        System.out.println("5. Roti Bakar - Rp 10,000");   
        System.out.println("6. Mie Goreng - Rp 18,000");    
        System.out.println("==========================");    
        System.out.println("Silakan pilih menu yang Anda inginkan.");
        return isMember;
    }

    public static int hitungTotalHarga15(int pilihanMenu, int banyakItem) {    
    int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};    
    int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
    return hargaTotal;    
    }

    
    public static double hitungDiskon(int totalBayar, String kodePromo, boolean isMember, Scanner sc) {

    double total = totalBayar;

    if (isMember == true) {
        total = total - (total * 0.1);
    }

    System.out.println("Apakah Anda mempunyai kode promo? (Y/N)");
    char jawaban = sc.next().charAt(0);

    if (jawaban == 'y' || jawaban == 'Y') {

        System.out.println("Masukkan kode promo:");
        kodePromo = sc.next();

        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            total = total - (total * 0.5);

        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            total = total - (total * 0.3);

        } else {
            System.out.println("Maaf, kode tidak terdaftar");
        }
    }

    return total;
    }
} 
