package pb1_10;

import java.util.Scanner;

class Student {
    String name;
    int ks;
    int es;
    int ms;

    public Student(String name, int ks, int es, int ms) {
        this.name = name;
        this.ks = ks;
        this.es = es;
        this.ms = ms;
    }
    void printInfor() {
        int total = this.ks + this.es + this.ms;
        double avg = (double)total / 3;
        System.out.print("이름: " + this.name);
        System.out.print(" 국어: " + this.ks);
        System.out.print(" 영어: " + this.es);
        System.out.print(" 수학: " + this.ms);
        System.out.print(" 총점: " + total);
        System.out.println(" 평균: " + avg);
    }

    public void setKs(int ks) {
        this.ks = ks;
    }
    public void setEs(int es) {
        this.es = es;
    }
    public void setMs(int ms) {
        this.ms = ms;
    }
}

public class mini5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idx = 0;
        Student[] students = new Student[2];
        while(true) {
            System.out.println("-----------성적 관리 프로그램-------------");
            System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number == 1) {
                System.out.print("이름 입력 : ");
                String name = scanner.nextLine();
                System.out.print("국어점수 입력 : ");
                int ks = scanner.nextInt();
                System.out.print("영어점수 입력 : ");
                int es = scanner.nextInt();
                System.out.print("수학점수 입력 : ");
                int ms = scanner.nextInt();
                students[idx] = new Student(name, ks, es, ms);
                idx++;
            } else if (number == 2) {
                for (int i = 0; i < idx; i++) {
                    students[i].printInfor();
                }
            } else if (number == 3) {
                System.out.print("검색할 사람의 이름 : ");
                String name = scanner.nextLine();
                for (int i = 0; i < idx; i++) {
                    if (name.equals(students[i].name)) {
                        students[i].printInfor();
                    }
                }
            } else if (number == 4) {
                System.out.print("수정할 사람의 이름 : ");
                String name = scanner.nextLine();
                System.out.print("수정할 내용은? 1.국어 2.영어 3.수학 : ");
                int num = scanner.nextInt();

                for (int i = 0; i < idx; i++) {
                    if (name.equals(students[i].name)) {
                        if (num == 1) {
                            System.out.print("국어점수 수정 : ");
                            int ks = scanner.nextInt();
                            students[i].setKs(ks);
                        } else if (num == 2) {
                            System.out.print("영어점수 수정 : ");
                            int es = scanner.nextInt();
                            students[i].setEs(es);
                        } else {
                            System.out.print("수학점수 수정 : ");
                            int ms = scanner.nextInt();
                            students[i].setMs(ms);
                        }
                    }
                }
            } else if (number == 5) {
                System.out.print("삭제할 사람의 이름 : ");
                String name = scanner.nextLine();
                for (int i = 0; i < idx; i++) {
                    if (name.equals(students[i].name)) {
                        students[i] = null;
                        if (i != idx - 1) {
                            for (int j = i; j < idx; j++) {
                                students[i] = students[i + 1];
                            }
                        }
                        idx--;
                        break;
                    }
                }
            } else if (number == 6) {
                System.out.println("종료!!");
                break;
            }
        }
    }
}
