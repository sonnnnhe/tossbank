public class ex45 {
    public static void main(String[] args) {
        // 예외 처리 (Exception Handling)
        //  : 예상치 못한 오류 - 개발/런타임(실행)에서 처리가능함

        // 1. try catch문
        // 2. throws문

        // 패턴
        // try {
        //     예외가 발생할 만한 실행문
        // }
        // catch( 예외클래스 객체 ) {
        //     예외 발생 시 처리하는 실행문 - 에러내용 출력
        // }

        String name = null;
        System.out.println(name);
//        System.out.println(name.toLowerCase()); // null pointer exception

        try {
            // java.lang.NullPointerException
            System.out.println(name.toLowerCase());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
