import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tiket> daftarTiket = new ArrayList<>();
        boolean lanjutPesan = true;
        int nomorTiket = 100;
        
        Film film1 = new Film("polet the slayer", "Action", "14:00", 50000);
        Film film2 = new Film("ada apa dengan fatih?", "Drama", "16:00", 45000);
        Film film3 = new Film("ketika archie menjemput", "Horror", "18:00", 40000);

        Studio studio1 = new Studio(1, 50, film1);
        Studio studio2 = new Studio(2, 60, film2);
        Studio studio3 = new Studio(3, 40, film3);

        System.out.println("Selamat datang di Loteng Cinema!");

        while (lanjutPesan) {
            System.out.println("\nPilih film yang ingin Anda tonton:");
            System.out.println("1. polet the slayer (Action) - 14:00 - Rp 50000");
            System.out.println("2. ada apa dengan fatih? (Drama) - 16:00 - Rp 45000");
            System.out.println("3. ketika archie menjemput (Horror) - 18:00 - Rp 40000");

            System.out.print("Masukkan nomor film: ");
            int pilihFilm = scanner.nextInt();
            scanner.nextLine();

            Film filmTerpilih = null;
            Studio studioTerpilih = null;

            switch (pilihFilm) {
                case 1:
                    filmTerpilih = film1;
                    studioTerpilih = studio1;
                    break;
                case 2:
                    filmTerpilih = film2;
                    studioTerpilih = studio2;
                    break;
                case 3:
                    filmTerpilih = film3;
                    studioTerpilih = studio3;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    continue;
            }

            System.out.print("Masukkan nama Anda: ");
            String namaPenonton = scanner.nextLine();

            int nomorKursi;
            boolean kursiTersedia;
            
            do {
                System.out.print("Pilih nomor kursi (1 - " + studioTerpilih.kapasitasKursi + "): ");
                nomorKursi = scanner.nextInt();
                scanner.nextLine();

                kursiTersedia = cekKursiTersedia(daftarTiket, studioTerpilih, nomorKursi);

                if (!kursiTersedia) {
                    System.out.println("Maaf, nomor kursi ini sudah dipesan. Silakan pilih nomor kursi lain.");
                }
            } while (!kursiTersedia);

            Penonton penonton = new Penonton(namaPenonton);
            Tiket tiket = new Tiket(nomorTiket++, filmTerpilih, studioTerpilih, nomorKursi, penonton);

            daftarTiket.add(tiket);

            System.out.println("\nTiket yang berhasil dipesan:");
            tiket.tampilkanInfo();

            System.out.print("\nIngin memesan tiket lagi? (ya/tidak): ");
            String jawaban = scanner.nextLine();
            if (!jawaban.equalsIgnoreCase("ya")) {
                lanjutPesan = false;
            }
        }
        System.out.println("\n-----------------------------------");
        System.out.println("Ringkasan Semua Tiket yang Dipesan:");
        System.out.println("-----------------------------------");
        for (Tiket tiket : daftarTiket) {
            tiket.tampilkanInfo();
            System.out.println("-----------------------------");
        }

        System.out.println("Terima kasih telah memesan tiket di Bioskop ABC!");
        scanner.close();
    }

    public static boolean cekKursiTersedia(List<Tiket> daftarTiket, Studio studio, int nomorKursi) {
        for (Tiket tiket : daftarTiket) {
            if (tiket.studio.equals(studio) && tiket.nomorKursi == nomorKursi) {
                return false;
            }
        }
        return true;
    }
}