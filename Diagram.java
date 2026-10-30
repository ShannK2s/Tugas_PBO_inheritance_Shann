package tugas;

import java.util.Scanner;

public class Diagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== PROGRAM HITUNG BANGUN DATAR ===");
        
        // 1. PERSEGI
        System.out.print("\nMasukkan panjang sisi persegi: ");
        float inputSisi = input.nextFloat();
        Persegi p = new Persegi(inputSisi);
        System.out.println("Luas Persegi     : " + p.luas());
        System.out.println("Keliling Persegi : " + p.keliling());
        
        // 2. LINGKARAN
        System.out.print("\nMasukkan jari-jari lingkaran: ");
        float inputR = input.nextFloat();
        Lingkaran l = new Lingkaran(inputR);
        System.out.println("Luas Lingkaran     : " + l.luas());
        System.out.println("Keliling Lingkaran : " + l.keliling());
        
        // 3. PERSEGI PANJANG
        System.out.print("\nMasukkan panjang persegi panjang: ");
        float inputPanjang = input.nextFloat();
        System.out.print("Masukkan lebar persegi panjang: ");
        float inputLebar = input.nextFloat();
        PersegiPanjang pp = new PersegiPanjang(inputPanjang, inputLebar);
        System.out.println("Luas Persegi Panjang     : " + pp.luas());
        System.out.println("Keliling Persegi Panjang : " + pp.keliling());
        
        // 4. SEGITIGA
        System.out.print("\nMasukkan alas segitiga: ");
        float inputAlas = input.nextFloat();
        System.out.print("Masukkan tinggi segitiga: ");
        float inputTinggi = input.nextFloat();
        Segitiga s = new Segitiga(inputAlas, inputTinggi);
        System.out.println("Luas Segitiga     : " + s.luas());
        System.out.println("Keliling Segitiga : " + s.keliling());
        
        input.close();
    }
}

// Parent Class
class BangunDatar {
    public float luas() {
        return 0f;
    }

    public float keliling() {
        return 0f;
    }
}

// Child Class - Persegi
class Persegi extends BangunDatar {
    public float sisi;

    public Persegi(float sisi) {
        this.sisi = sisi;
    }

    @Override
    public float luas() {
        return sisi * sisi;
    }

    @Override
    public float keliling() {
        return 4 * sisi;
    }
}

// Child Class - Lingkaran
class Lingkaran extends BangunDatar {
    public float r;

    public Lingkaran(float r) {
        this.r = r;
    }

    @Override
    public float luas() {
        return (float) (Math.PI * r * r); // Menggunakan Math.PI agar lebih presisi
    }

    @Override
    public float keliling() {
        return (float) (2 * Math.PI * r);
    }
}

// Child Class - Persegi Panjang
class PersegiPanjang extends BangunDatar {
    public float panjang;
    public float lebar;

    public PersegiPanjang(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public float luas() {
        return panjang * lebar;
    }

    @Override
    public float keliling() {
        return 2 * (panjang + lebar);
    }
}

// Child Class - Segitiga
class Segitiga extends BangunDatar {
    public float alas;
    public float tinggi;

    public Segitiga(float alas, float tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public float luas() {
        return 0.5f * alas * tinggi;
    }

    @Override
    public float keliling() {
        // Mencari sisi miring menggunakan fungsi Math.hypot agar rumusnya tidak terlihat standar
        float sisiMiring = (float) Math.hypot(alas, tinggi);
        return alas + tinggi + sisiMiring;
    }
}