import java.io.*;

public class ImageTest {
    public static void main(String[] args) {
        try {
            //(1)Fileオブジェクトの生成
            File directory1 = new File("c:\\image", "FILE_CLASS");
            //(2)Fileオブジェクトの生成
            File file1 = new File(directory1, "a.txt");
            //(3)ディレクトリの作成
            directory1.mkdir();
            //(4)ファイルの作成
            file1.createNewFile();

            if(file1.exists()) {  //(5)ファイルがあればtrueを返す
                //(6)ファイル名を表示
                System.out.println("ファイル名：" + file1.getName());
                //(7)ファイルの格納ディレクトリ名を表示
                System.out.println("格納ディレクトリ名：" + file1.getParent());
                //(8)ファイルのPATH名を表示
                System.out.println("PATH名：" + file1.getAbsolutePath());
                System.out.println("－－－－－－－－－－－－－－－－");
            }

            //(9)ディレクトリ内のファイル・ディレクトリ一覧を取得
            String[] directory_list = directory1.list();
            for (int i = 0; i < directory_list.length; i++) {
                //(10)ファイル・ディレクトリ一覧の表示
                System.out.println("ディレクトリの中身：" + directory_list[i]);
            }
        } catch(IOException e) {
        }
    }
}