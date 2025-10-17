package curso.devc;
public class Main {
    public static void main(String[] args){
        String who = args.length > 0 ? args[0] : "VM";
        System.out.println("Hello from DevContainer, " + who + "!");
    }
}
