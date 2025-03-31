//연습문제 - 싱글톤 만들기
//클래스 이름 : HanaAccount
//  필드(private) : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
//  메소드 : 입금(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회
class HanaAccount {
    private int accountNum = 1234;
    private String name = "홍길동";
    private double balance = 1000;
    private double interestRate = 0.03;

    private static HanaAccount singleton;

    public static HanaAccount getInstance() {
        if (singleton == null) {
            singleton = new HanaAccount();
        }
        return singleton;
    }
    public void deposit() {
        balance += 100;
    }
    public void withdraw() {
        balance -= 100;
    }
    public double calculate() {
        balance = balance * (1 + interestRate);
        return balance;
    }
    public double getBalance() {
        return balance;
    }
}

public class ex26 {
    public static void main(String[] args) {
        //싱글톤을 호출후
        //1. 입금 메소드 호출
        //2. 출금 메소드 호출
        //3. 이자계산은 이자율을 읽어서 참조한다.
        //   이자계산후 잔액 증가한다.
        //4. 최종 잔액을 출력한다.
        HanaAccount hanaaccount = HanaAccount.getInstance();
        hanaaccount.deposit();
        hanaaccount.withdraw();
        hanaaccount.calculate();

        System.out.println(hanaaccount.getBalance());
    }
}
