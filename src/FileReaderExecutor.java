import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class FileReaderExecutor implements Callable<Integer> {
    String folderPath;
    
    public FileReaderExecutor(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public Integer call() throws Exception {
        String[] words = null;
        File folder = new File(this.folderPath);
        File[] listOfFiles = folder.listFiles();
        int totalWordCount = 0;
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                FileReader fr = new FileReader(listOfFiles[i].getPath());
                BufferedReader br = new BufferedReader(fr);
                String s;
                int wc = 0;
                while ((s = br.readLine()) != null) {
                    words = s.split(" ");
                    wc = wc + words.length;
                    totalWordCount = totalWordCount + words.length;
                }
                System.out.println(listOfFiles[i].getName() + " dosyasındaki kelime sayısı :" + wc);
                fr.close();
            }
        }

        return totalWordCount;
    }

}