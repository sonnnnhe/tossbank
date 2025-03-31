public class ex10 {
    // main or psvm
    public static void main(String[] args) {
        // thr : throw new
        // sout : System.out.println();
        int i = 10;
        System.out.println("i = " + i);  // soutv 하면 자동으로 i가 들어감

        myFunc(20);

        // fori
        /* for (int j = 0; j < ; j++) {

        } */

        for (i = 0; i < 5; i++) {
            System.out.println("i = " + i); // soutv
        }

        // ifn (if null)
        /* if (i == null) {

        } */
        int[] array = {};
        if (array == null) {

        }
    }
    static void myFunc(int p) {
        System.out.println("ex10.myFunc"); // soutm 현재 클래스 및 메소드 이름
        System.out.println("p = " + p); // soutp (파라미터)
    }
}
