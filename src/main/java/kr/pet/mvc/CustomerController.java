package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    //고객 등록 삭제 검색
    private List<Customer> customers;
    private MedicalRecordController recordController; //진료기록관리 컨트롤러

    //새로운
    public CustomerController(MedicalRecordController recordController){
        this.customers = new ArrayList<>();
        this.recordController = recordController;
    }
    // 고객 정보를 등록하는 메서드
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    //고객정보 삭제 메서드 (반드시 해당 고객의 진료 기록도 삭제해야)
    //그래서 생성자 메서드서 진료기록을 받음 CustomerController(MedicalRecordController recordController)
    public void removeCustomer(String tel){
        for(int i=0; i< customers.size(); i++){
            //customers배열에 해당 전화번호와 삭제하려는 전화번호가 같다면
            if(customers.get(i).getTel().equals(tel)){
                //삭제한다
                customers.remove(i);
                //recordController의 removeMedicalRecord에 tel전화번호를 넣어주면
                recordController.removeMedicalRecord(tel); //해당 고객의 진료 기록 삭제
                break;
            }
        }
    }

    //고객 등록 여부 확인 메서드
   public Customer findCustomer(String tel){ //전화번호가 넘어온다면
        for( Customer customer : customers){ //customers 배열에서 검색
            if(customer.getTel().equals(tel)){ //입력된 customer과 기존 customers에 일치하는 것이 있다면
                return customer; //일치하는 고객 정보만 넘겨준다.
            }
        }
        return  null; //일치하는 것이 없다면 null;
   }
   //기존 tel로 고객 중복 여부
    public boolean isTelExist(String tel){ //tel이 넘어오면
        for(Customer customer: customers){// customers배열서 하나씩 꺼내
            if( customer.getTel().equals(tel)){ //고객의 getTel()전화번호를 하나씩 가져온다음
                //equals(tel) 비교

                //일치하는 것이 있다면 true. 중복
                return true;
            }
        }
        //중복 아님
        return  false;
    }
}
