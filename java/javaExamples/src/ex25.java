//싱글톤(Singleton)
//  : 프로그램안에서의 유일한 클래스 객체
//  : new를 통해서 여러개의 객체를 반복적으로 찍어낼 수 있다.
//  : 예) 붕어빵1, 붕어빵2, ....
//      절대붕어빵(유일한 붕어빵)
//유일한 객체가 필요한 이유
//  : 유일한 정보를 저장하기 위해서
class FishBun { // 일반붕어빵
    int bunNo = 10;
}
class UniqueFishBun {
    int bunNo = 30;
    private static UniqueFishBun singleton;  //null

    public static UniqueFishBun getInstance() {
        if (singleton == null) {  // 맨 처음에 한해 딱 한번 생성
            singleton = new UniqueFishBun();
        }
        return singleton;
    }
}

public class ex25 {
    public static void main(String[] args) {
        // 몇 개를 선언하든 주소값이 동일 => 값 공유
        UniqueFishBun uBun1 = UniqueFishBun.getInstance();
        UniqueFishBun uBun2 = UniqueFishBun.getInstance();
        System.out.println(uBun1);  // 0x23fc625e
        System.out.println(uBun2);  // 0x23fc625e
        //                          => 몇 개를 선언하든 주소값이 동일 => 값 공유
        uBun1.bunNo = 40;
        System.out.println(uBun1.bunNo);  // 40
        System.out.println(uBun2.bunNo);  // 40


        FishBun bun1 = new FishBun();
        FishBun bun2 = new FishBun();
        FishBun bun3 = new FishBun();
        System.out.println(bun1);  // 0x4f023edb
        System.out.println(bun2);  // 0x3a71f4dd
        //                         => 서로 다른 주소, 값 공유X
        bun1.bunNo = 20;
        System.out.println(bun1.bunNo); // 20
        System.out.println(bun2.bunNo); // 10
        // => 따라서, 일반 객체는 일관된 데이터를 저장하기 어렵다.

        // dynamic 객체는 Heap 영역에 저장된다.
        // GC(Garbage Collector)가 사용하지 않는 객체에 대해
        // 메모리를 자동으로 회수
    }
}
