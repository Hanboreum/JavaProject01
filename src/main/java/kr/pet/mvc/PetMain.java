package kr.pet.mvc;

import java.util.List;
import java.util.Scanner;

public class PetMain {
    public static void main(String[] args) {
        MedicalRecordController recordController = new MedicalRecordController(); //진료기록
        CustomerController customerController = new CustomerController(recordController); //진료기록 넘겨줌
        ConsoleView view = new ConsoleView();// 화면 출력
        while(true){
            System.out.println("==아완 동물 진료 관리 시스템==");
            System.out.println("1. 신규 고객 등록");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.println("원하는 기능을 선택하세요: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1: //신규등록. 고객 정보 입력 화면.
                    Customer newCustomer =view.getCustomerInfo();
                    String Tel = newCustomer.getTel(); //phoneNumber == Tel
                    if(customerController.isTelExist(Tel)){ //tel이 이미 있다면
                        view.printMessage("이미 등록된 전화번호 입니다. ");
                        continue; //위로 다시
                    }
                    customerController.addCustomer(newCustomer); //고객 추가 add
                    view.printMessage("고객 정보가 추가되었습니다. ");
                    break;

                case 2: //진료 고객 저장
                       Tel = view.getTel();  //등록 고객인지 판별하려고 tel 받음
                if(customerController.findCustomer(Tel) == null){
                    System.out.println(" 등록된 정보가 없습니다. ");
                    break;
                }
                Customer customer = customerController.findCustomer(Tel); //tel 있으면 고객의 정보 가져옴
                MedicalRecord newRecord = view.getMedicalRecordInfo();// 진료 정보 받기
                newRecord.setTel(Tel); //ContentView에서 null 이었던걸 채워줌
                recordController.addMedicalRecord(newRecord); //새로운 진료 저장
                customer.addMedicalRecord(newRecord); //새로운 고객 저장, 진료 기록 조회 시 같이 출력
                view.printMessage("진료 기록이 저장되었습니다. ");
                break;

                case 3: //진료 기록 조회
                    Tel = view.getTel();
                    //tel에 해당하는 정보 records 출력
                    List<MedicalRecord> records = recordController.findMedicalRecords(Tel);
                    if(records.isEmpty()){
                        view.printMessage("등록된 진료 기록이 없습니다. ");
                        break;
                    }

                    //tel에 해당하는 정보가 있다면, costomer의 정보를 print
                    customer = customerController.findCustomer(Tel);
                    view.printMedicalRecordInfo(customer);
                    break;
                case 4: //삭제
                    Tel = view.getTel(); //tel에 맞는 정보 찾기
                    if(customerController.findCustomer(Tel)== null){
                        view.printMessage("해당 전화번호를 가진 고객의 정보가 없습니다. ");
                        break;
                    }
                    recordController.removeMedicalRecord(Tel);
                    view.printMessage("진료 기록이 삭제되었습니다. ");
                    break;
                case 5:
                    System.out.println(" 프로그램을 종료합니다. ");
                    return;
                default:
                    System.out.println("잘못된 선택입니다");
                    break;

            }
        }
    }
}
