/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

public class sinhvien {

    protected String Masv, hoten, email, sđt, diachi, gioitinh, hinh;


    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public sinhvien() {
    }

    public String getMasv() {
        return Masv;
    }

//    public void setMasv(String Masv) {
//        this.Masv = Masv;
//    }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public sinhvien(String Masv, String hoten, String email, String sđt, String diachi, String gioitinh, String hinh) {
        this.Masv = Masv;
        this.hoten = hoten;
        this.email = email;
        this.sđt = sđt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.hinh = hinh;
    }

}
