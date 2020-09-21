public class Main {

    public static void main(String[] args) throws Exception {

        String filePath = "/Users/mgokcek/Desktop/CounterCallable/src/ggacademy";


        FileReaderExecutor fileExecutor = new FileReaderExecutor(filePath);

        System.out.println("Total word count : " + fileExecutor.call());

    }
}