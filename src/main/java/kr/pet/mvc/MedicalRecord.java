package kr.pet.mvc;

public class MedicalRecord {
    private String tel;
    private String date;
    private String content;

    public MedicalRecord() {}

    public MedicalRecord(String tel, String date, String content) {
        this.tel = tel;
        this.date = date;
        this.content = content;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
