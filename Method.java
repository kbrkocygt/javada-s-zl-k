import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Method {


    String kayitVerisi = "";
    Scanner verial = new Scanner(System.in);
    File dosya = new File("Kelime.txt");


    public void KelimeEkle() throws IOException {
        try {
            if (!dosya.exists())
                dosya.createNewFile();
            String[] array = new String[2];
            System.out.print("Kelimenin Ingilizcesi : ");
            array[0] = verial.next();
            System.out.print("Kelimenin Türkçesi : ");
            array[1] = verial.next();

            String line = null;
            line = array[0] + "\t" + array[1];
            FileWriter yaz = new FileWriter(dosya, true);//üst üste ekleyebilmesi için true yaptık
            BufferedWriter veriyaz = new BufferedWriter(yaz);
            //BufferedWriter sınıfı  dosyaya
            // bir kayıt yazarken
            // bize ayarlanabilir bir tampon bellek sunar.
            BufferedReader br=new BufferedReader(new FileReader(dosya));
            String varmı;
            while((varmı= br.readLine())==null){//br dosyasını okuyor eğer dosyada veri yoksa klavyeden alınan degeri
                //dosyaya yazdırır
                veriyaz.write(line);//zaten dosyada veri varsa donguyeb gırmıyor
                veriyaz.newLine();//imleci bir alt satıra geçirir
                veriyaz.close();
                yaz.close();
                System.out.println("                                      ");
                System.out.println("*       Kelime Ekleme Başarılı       *");
                System.out.println("                                      ");
                break;
            }br.close();
            String pathToFile="Kelime.txt";
            if (new Scanner(new File(pathToFile)).useDelimiter("\t\n").next().contains(line)) { //Scanner la dosyamızı okuttuk.
                System.out.println("Girdiğiniz Kelime Mevcut");                                 //\t\n olan satır satır hepsini okuttuk.
            } else {                                                                            //ve birleştirerek aldığımız line değişkeni ile karşılaştırdık.
                veriyaz.write(line);
                veriyaz.newLine();//imleci bir alt satıra geçirir
                veriyaz.close();
                yaz.close();
                System.out.println("                                      ");
                System.out.println("*       Kelime Ekleme Başarılı       *");
                System.out.println("                                      ");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void KelimeleriYazdir() throws FileNotFoundException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader("Kelime.txt"));
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TurkceIngilizce() throws IOException {
        BufferedReader oku = new BufferedReader(new FileReader("Kelime.txt"));
        String str;

        System.out.print("Kelimenin Tukcesi: ");
        kayitVerisi = verial.next();
        while ((str = oku.readLine()) != null) {
            String[] kelimeler = str.split("\t");
            if (kayitVerisi.equals(kelimeler[1])) {
                System.out.println(kelimeler[0]);
            }
        }
        oku.close();
    }

    public void IngilizceTurkce() throws IOException {
        BufferedReader oku = new BufferedReader(new FileReader("Kelime.txt"));
        String str;

        System.out.print("Kelimenin İngilizcesi: ");
        kayitVerisi = verial.next();
        while ((str = oku.readLine()) != null) {
            String[] kelimeler = str.split("\t");
            if (kelimeler[0].equals(kayitVerisi)) {
                System.out.println(kelimeler[1]);
            }
        }
        oku.close();
    }
}