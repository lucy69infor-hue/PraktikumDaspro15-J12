import java.util.Scanner;

public class BankSampah15 {
    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            data[i] = sc.nextDouble();
        }
        return data;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\n--- Daftar Setoran & Saldo Nasabah ---");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], 3000);
            System.out.printf("Nasabah ke-%d : %.2f kg | Saldo: Rp%,.0f\n", (i + 1), setoran[i], saldo);
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n);
        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        int idxTerbanyak = nasabahTerbanyak(dataSetoran);

        System.out.println("\n--- Ringkasan Bank Sampah ---");
        System.out.printf("Total berat setoran seluruh nasabah : %.2f kg\n", totalBerat);
        System.out.printf("Total seluruh saldo nasabah         : Rp%,.0f\n", hitungSaldo(totalBerat, 3000));
        System.out.printf("Nasabah dengan setoran terbanyak    : Nasabah ke-%d (%.2f kg)\n",
                (idxTerbanyak + 1), dataSetoran[idxTerbanyak]);
    }
}