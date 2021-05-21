package com.example.sampah_ku;

public class UserHelperClass {
    String nama, email, sandi;

    public UserHelperClass() {

    }

    public UserHelperClass(String nama, String email, String sandi) {
        this.nama = nama;
        this.email = email;
        this.sandi = sandi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }


}
