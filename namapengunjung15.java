public class namaPengunjung15  {
    public static void main(String [] args){
        daftarPengunjung();
        daftarPengunjung();
        daftarPengunjung();
    }
    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");    
        for (int i = 0; i < namaPengunjung.length; i++) {        
        System.out.println("- " + namaPengunjung[i]);    
        }
    }
}