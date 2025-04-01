// 상속관계에서 생성자함수 호출되는 순서
class Energy {
    int price = 1000;

    public Energy() {
        System.out.println("Energy()");
    }

    public Energy(int price) {
        this.price = price;
        System.out.println("Energy(int)");
    }
}
class WindEnergy extends Energy {
    int price = 2000;

    public WindEnergy() {
        System.out.println("WindEnergy()");
    }

    public WindEnergy(int price) {
        super(price);  // 상위 클래스(부모 클래스)의 생성자 함수 호출
                       // 항상 제일 첫 줄에 써야함
        this.price = price;
        System.out.println("WindEnergy(int)");
    }
}

//this.  : 자기 클래스의 필드 / 메소드 접근
//this() : 자기 클래스의 생성자 함수 호출
//super. : 부모 클래스의 필드 / 메소드 접근
//super() : 부모 클래스의 생성자 함수 호출
public class ex32 {
    public static void main(String[] args) {
//        WindEnergy we = new WindEnergy();
        WindEnergy we2 = new WindEnergy(3000);
    }
}
