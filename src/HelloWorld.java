public class HelloWorld {
    public void hello(){
        System.out.println("Rivi yksi");
        System.out.println("Rivi kaksi");
    }

    public static void main(String[] args){

        HelloWorld hello = new HelloWorld();
        hello.hello();
    }
}