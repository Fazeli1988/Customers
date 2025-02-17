import com.mysite.customer.view.ConsoleUI;

public class AplicationRunner {
    public static void main(String[] args) {

                try (ConsoleUI consoleUI = new ConsoleUI()){
                   consoleUI.startMenu();
                }
                catch (Throwable ex){
                    ex.getCause();
                    System.out.println("System error!");
                }

    }
}
