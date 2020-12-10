import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)throws Exception {
        Method cagir=new Method();
        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("*   SÖZLÜK PROGRAMINA HOŞGELDİNİZ    *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println("*Sözlük uygulamamızın içinde yaklaşık 2000 adet kelime bulunmaktadır.\n" +
                "*Uygulama içinde olmayan kelimeleri ekleyebilir,çeviri yapabilir ve kelimeleri listeleyebilirsiniz.\n" +
                "*Uygulamada hangi işlemi yapmak istiyorsanız aşağıdaki numaralara göre seçiminizi yapabilirsiniz. ");
        int secenek;
        while(true){
            secenek=getMenu();
            switch(secenek){
                case 1:  cagir.KelimeEkle();
                    break;
                case 2:
                    cagir.KelimeleriYazdir();
                    break;
                case 3:
                    cagir.TurkceIngilizce();
                    break;
                case 4:
                    cagir.IngilizceTurkce();
                    break;

                case 5:
                    programCikis();
                    break;
                default:
                    System.err.println("Program beklenmeyen bir hata nedeniyle sonlandırıldı!");
                    break;
            }
        }
    }
    public static int getMenu(){
        int secenek;
        Scanner oku = new Scanner(System.in);
        do{
            System.out.println("======================================");
            System.out.println("|            DICTIONARY              |");
            System.out.println("======================================");
            System.out.println("| 1-) Kelime Ekle                    |");
            System.out.println("| 2-) Bütün Kelimeleri Göster        |");
            System.out.println("| 3-) Türkçe-İngilizce çeviri        |");
            System.out.println("| 4-) İngilizce-Türkçe çeviri        |");
            System.out.println("| 5-) Programdan Çıkış Yap!          |");
            System.out.println("======================================");
            System.out.print("Seçiminiz : ");
            secenek=oku.nextInt();
            System.out.println();
            if(!(secenek==1||secenek==2||secenek==3||secenek==4 || secenek==5)){
                System.out.println("Yanlış Seçenek Girdiniz!");
                continue;
            }
            else{
                break;
            }
        }while(true);
        return secenek;

    }


    public static void programCikis(){
        System.out.println("ÇIKIŞ YAPILDI! Tekrar görüşmek üzere :)");
        System.exit(0);
    }


}