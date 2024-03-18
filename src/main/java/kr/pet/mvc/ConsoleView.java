package kr.pet.mvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner sc = new Scanner(System.in);
    //tel 입력
    public String getTel(){
        System.out.println("전화번호를 입력 하세요.");
        return sc.next();
    }
    //신규고객 정보 입력
    public Customer getCustomerInfo(){
        System.out.println("신규 고객 정보를 입력하세요");
        System.out.println(" 전화번호");
        String tel = sc.nextLine();
        System.out.println("소유주 이름");
        String ownerName = sc.nextLine();
        System.out.println("동물 이름 :");
        String petName = sc.nextLine();
        sc.nextLine();
        return new Customer(tel, ownerName, petName);
    }

    //진료 기록을 입력 받는 화면
    public MedicalRecord getMedicalRecordInfo(){
        System.out.println("진료일을 입력 하세요. :");
        String date = sc.nextLine();
        System.out.println(" 진료 내용을 입력하세요.");
        String content = sc.nextLine();

        //date, content 입력 받아 하나로 만든 후 리턴
        return new MedicalRecord(null, date, content);
    }

    //진료기록 조회하여 출력하는 메서드
    public void printMedicalRecordInfo(Customer customer){
        //고객customer가 가지고 있는 진료기록을 호출. 고객이 가지고 있는 진료 기록만 가져온다.
        List<MedicalRecord> records = customer.getMedicalRecords();
        System.out.println(customer.getPetName() + "님의 진료 기록");
        for(MedicalRecord record :records){
            System.out.println("진료일" + record.getDate() );
            System.out.println("진료 내용" + record.getContent());
            System.out.println("사람 이름" + customer.getOwnerName());
            System.out.println("동물 이름" + customer.getPetName());

        }
    }
    //메세지 뿌림
    public void printMessage(String message){
        System.out.println(message);
    }
}
