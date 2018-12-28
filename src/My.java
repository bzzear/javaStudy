
public class My {
    static int  i;
    static char c;

    public static void main(String[] args) {
        System.out.println("fefqwfqwefqef");
        System.out.println("i=" + i);
        System.out.println("c=" + c);

        class ATypeName {
            int i;
            double d;
            boolean b;
            void show() {
                System.out.println(i);
                System.out.println(d);
                System.out.println(b);
            }
        }
        ATypeName a = new ATypeName();
        a.i = 3;
        a.d = 2.71828;
        a.b = false;
        a.show();

        class StoreStuff {
            int storage(String s) {
                return s.length() * 2;
            }
        }
        StoreStuff x = new StoreStuff();
        System.out.println(x.storage("hi"));
        System.out.println(12 >> 1);
        System.out.println(Integer.toBinaryString(12 >> 1));

        double above = 29.7;
        System.out.println((int) above);


        
    }





}
