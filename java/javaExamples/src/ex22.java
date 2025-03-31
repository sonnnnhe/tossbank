// 접근제한자
//  : 클래스,함수,변수 앞에 위치하여 접근을 제한할때 사용
// * C언어 : 접근제한자가 없어서, 모든 곳에서 접근가능.
//        : 변수의 변경을 감지하기 어렵다. 유지보수가 힘들다.
// public : 같은 폴더(패키지)에서, 다른 폴더의 클래스에서 접근가능.
// protected : 같은 폴더 + 상속관계 클래스에서 접근가능
// default : 같은 폴더
// private : 같은 클래스안에서 접근 가능(캡슐화,은닉)
//         : Getter/Setter함수통해서 접근 가능하도록 허용.
//         : 은행잔고를 창구를 통해서만 접근가능하도록
class Hong {
    // default: 같은 폴더 + 자기 클래스 접근 가능
    String name = "홍길동";
    // public: 모든 폴더 + 상속관계 + 같은 폴더 + 자기 클래스
    public int age = 20;
    // protected: 상속관계 + 같은 폴더 + 자기 클래스
    protected int korScore = 80;
    // private: 자기클래스에서만 접근 가능
    private int engScore = 90;

    // Getter/Setter 함수를 제공
    // 오른쪽 마우스 클릭 -> 생성 -> getter / setter 선택 -> 변수 선택
    // Get engScore
    public int getEngScore() {
        return engScore;
    }
    // Set engScore
    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }
}

public class ex22 {
    public static void main(String[] args) {
        Hong hong = new Hong();
        System.out.println(hong.name); // default
        System.out.println(hong.age);  // public
        System.out.println(hong.korScore);  // protected
        // System.out.println(hong.engScore); private는 접근 불가능
    }
}
