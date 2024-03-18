package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String tel;
    private String ownerName;
    private String petName;
    private List<MedicalRecord> medicalRecords; //진료 기록을 저장하는 테스트
//진료기록은 고객이 아니기 때문에 생성자에서 뺌
    public Customer(){}

    public Customer(String tel, String name, String petName) {
        this.tel = tel;
        this.ownerName = name;
        this.petName = petName;
        this.medicalRecords = new ArrayList<>(); //빈 리스트로 초기화
        //고객이 만들어 질 때 arraylist가 필요하다.
        //ArrayList를 가지고 있어야 진료를 할때 마다 medicalRecord 에 진료 기록을 집어넣는다
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    //고객별 진료기록 등록
    public void addMedicalRecord(MedicalRecord records) {
        //set -> add로 변경
        //진료기록 하나가 넘어가면 medicalRecords(ArrayList)에 더해준다.add
        medicalRecords.add(records);
    }

}
