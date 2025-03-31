public class ex15 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + "," + j);
            }
        }
        int [][] nums = { {1, 2}, {3, 4} };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println( nums[i][j] );
            }
        }

        // 별찍기
        /*
         *****
         *****
         *****
         *****
         *****
        */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        /*
             *   공백4 별1  i = 4
            **   공백3 별2  i = 3
           ***   공백2 별3  i = 2
          ****   공백1 별4  i = 1
         *****   공백0 별5  i = 0
         */
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
         *******    *****
         *    **        *   idx5  i = 1  j = 5
         *   * *       *    idx4  i = 2  j = 4
         *  *  *      *     idx3  i = 3  j = 3
         * *   *     *      idx2  i = 4  j = 2
         **    *    *       idx1  i = 5  j = 1
         *******    *****
         */
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 || i == 6 || j == 0 || j == 6) {
                    System.out.print("*");
                } else if (i + j == 6) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
