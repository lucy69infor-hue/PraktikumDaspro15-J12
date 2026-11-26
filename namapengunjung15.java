public class namaPengunjung15  {
    public static void main(String [] args){
        String [] tamu = {"Ali","Budi", "Citra"};
        daftarPengunjung(tamu);
         int total1 = hitungBelanja(15000);
        System.out.println("Total belanja (1 item) : Rp " + total1);

        // Uji dengan 3 argumen
        int total3 = hitungBelanja(15000, 20000, 12000);
        System.out.println("Total belanja (3 item) : Rp " + total3);

        // Uji dengan 5 argumen
        int total5 = hitungBelanja(15000, 20000, 12000, 10000, 18000);
        System.out.println("Total belanja (5 item) : Rp " + total5);

        
        
    }
    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");    
        for (String nama : namaPengunjung ) {        
        System.out.println("- " + nama);    
        }
    }
    static int hitungBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        
        }
        return total;
    }
}