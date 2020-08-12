/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

public class điem {

    protected String hoten, masv;
    protected float tin, tanh, gdcd, dtb;

    public điem(String hoten, String masv, float tanh,  float tin,float gdcd, float dtb) {
        this.hoten = hoten;
          this.tanh = tanh;
        this.tin = tin;
      
        this.gdcd = gdcd;
        this.dtb = dtb;
        this.masv = masv;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public điem() {
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getTin() {
        return tin;
    }

    public void setTin(float tin) {
        this.tin = tin;
    }

    public float getTanh() {
        return tanh;
    }

    public void setTanh(float tanh) {
        this.tanh = tanh;
    }

    public float getGdcd() {
        return gdcd;
    }

    public void setGdcd(float gdcd) {
        this.gdcd = gdcd;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

}
