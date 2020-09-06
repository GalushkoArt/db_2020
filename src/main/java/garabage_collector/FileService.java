package garabage_collector;

/**
 * @author Evgeny Borisov
 */
public class FileService {
    public void work(){
        System.out.println(123);
    }

    public static void main(String[] args) throws InterruptedException {
        abc();
        System.gc();

    }

    private static void abc() {
        FileService fileService = new FileService();
        fileService.work();
    }
}
