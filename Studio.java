class Film {
    String judul, genre, jamTayang;
    int hargaTiket;

    public Film(String judul, String genre, String jamTayang, int hargaTiket) {
        this.judul = judul;
        this.genre = genre;
        this.jamTayang = jamTayang;
        this.hargaTiket = hargaTiket;
    }
}

class Studio {
    int nomorStudio, kapasitasKursi;
    Film film;

    public Studio(int nomorStudio, int kapasitasKursi, Film film) {
        this.nomorStudio = nomorStudio;
        this.kapasitasKursi = kapasitasKursi;
        this.film = film;
    }
}
 
class Penonton {
    String nama;

    public Penonton(String nama) {
        this.nama = nama;
    }
}

class Tiket {
    int nomorTiket, nomorKursi;
    Film film;
    Studio studio;
    Penonton penonton;

    public Tiket(int nomorTiket, Film film, Studio studio, int nomorKursi, Penonton penonton) {
        this.nomorTiket = nomorTiket;
        this.film = film;
        this.studio = studio;
        this.nomorKursi = nomorKursi;
        this.penonton = penonton;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Tiket: " + nomorTiket);
        System.out.println("Penonton: " + penonton.nama);
        System.out.println("Film: " + film.judul);
        System.out.println("Studio: " + studio.nomorStudio);
        System.out.println("Nomor Kursi: " + nomorKursi);
        System.out.println("Harga: Rp " + film.hargaTiket);
    }   
}