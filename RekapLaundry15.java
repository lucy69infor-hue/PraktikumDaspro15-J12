import java.util.Scanner;

public class RekapLaundry15 {
    static Scanner sc = new Scanner(System.in);
    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    static void inputData(int[][] data, String[] layanan) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Input berat cucian (kg) untuk layanan " + layanan[i] + ":");
            for (int j = 0; j < namaHari.length; j++) {
                System.out.print("  " + namaHari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n=================================================================================");
        System.out.printf("%-15s | %-10s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s\n",
                "Layanan", "Harga/kg", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu");
        System.out.println("=================================================================================");
        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s | Rp%-8d |", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf(" %-6d |", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================================================================");
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int beratSaatIni = totalPerLayanan(data, i);
            if (beratSaatIni > maxBerat) {
                maxBerat = beratSaatIni;
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan total berat tertinggi : " + layanan[idxMax] + " (" + maxBerat + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxHariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (j == 0 || totalHari > maxBeratHari) {
                maxBeratHari = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    static void hitungDanTampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n--- Rekap Pendapatan ---");
        int totalSemuaPendapatan = 0;
        for (int i = 0; i < layanan.length; i++) {
            int totalBerat = totalPerLayanan(data, i);
            int pendapatan = totalBerat * harga[i];
            totalSemuaPendapatan += pendapatan;
            System.out.printf("%-15s : Rp%,d\n", layanan[i], pendapatan);
        }
        System.out.printf("Total Pendapatan 6 Hari : Rp%,d\n", totalSemuaPendapatan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        int[][] dataCucian = new int[4][6];

        inputData(dataCucian, layanan);
        tampilTabel(dataCucian, layanan, harga);

        System.out.println();
        tampilLayananTertinggi(dataCucian, layanan);
        int idxSibuk = hariTersibuk(dataCucian);
        System.out.println("Hari tersibuk                        : " + namaHari[idxSibuk]);

        hitungDanTampilPendapatan(dataCucian, layanan, harga);
    }
}