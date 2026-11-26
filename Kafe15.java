import java.util.Scanner;
public class Kafe15 {
    public static void main(String [] args) {
        String namaPelanggan;
        boolean isMember;
        menu();
    }
    
    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat datang!, Masukkan nama Anda :");
        String namaPelanggan = input.nextLine();
        System.out.println("Selamat datang,"+ namaPelanggan + "!");
        System.out.println("Apakah anda seorang member ? (true/false)");
        boolean isMember = input.nextBoolean();
        if (isMember){
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        } else {
            System.out.println("Maaf anda bukan member, diskon 10% hanya diberikan kepada member saja");
        }
        System.out.println("Jam kunjung " + namaPelanggan + ": ");
        int jam = input.nextInt();
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
        input.close();
    }
}