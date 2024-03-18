package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {
    private List<MedicalRecord> records = new ArrayList<>();
    //진료 기록을 등록하는 메서드
    public void addMedicalRecord(MedicalRecord record){
        //() 안에 진료 기록 정보 하나가 들어오면 records에 add더해준다.
        records.add(record);
    }

    //진료 기록 삭제 메서드
    public void removeMedicalRecord(String tel){
        //전화번호 사용해 삭제.
        for(int i=0; i< records.size(); i++){
            if(records.get(i).getTel().equals(tel)){
                //들어온 전화번호와 같은 전화번호를 찾으면 remove
                records.remove(i);
                break;
            }
        }
    }

    //해당 전화번호의 모든 진료기록 검색하여 새로운 list<MedicalRecord>를 만들어주는 메서드
   public List<MedicalRecord> findMedicalRecords (String tel){
       //전화번호가 넘어오면
        List<MedicalRecord> result = new ArrayList<>();
        for(MedicalRecord record : records){
            //기존 records에서 하나 꺼내 record에 저장
            if(record.getTel().equals(tel)){
                //꺼내온 것과 입력받은 전화번호가 같다면
                result.add(record);
                //result List에 add(꺼내온 전화번호) 더한다
            }
        }
        return result;
        //같은 전화번호의 진료 기록이 저장되어 있는 list반환
   }
}
