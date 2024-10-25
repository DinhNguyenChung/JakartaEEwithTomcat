package vn.edu.iuh.fit.quanlythuocwithtomcat.entities;

import java.util.Date;

public class Thuoc {
    private int maThuoc;
    private String tenThuoc;
    private  double gia;
    private Date ngaySX;
    private Date ngayHH;
    private State state;
    private LoaiThuoc loaiThuoc;

    public Thuoc() {
    }

    public Thuoc(int maThuoc, String tenThuoc, double gia, Date ngaySX, Date ngayHH, LoaiThuoc loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.loaiThuoc = loaiThuoc;
    }

    public Thuoc(int maThuoc, String tenThuoc, double gia, Date ngaySX, Date ngayHH, State state, LoaiThuoc loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.state = state;
        this.loaiThuoc = loaiThuoc;
    }

    public Thuoc(String tenThuoc, double gia, Date ngaySX, Date ngayHH,State state, LoaiThuoc loaiThuoc) {
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.state = state;
        this.loaiThuoc = loaiThuoc;
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(Date ngayHH) {
        this.ngayHH = ngayHH;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", gia=" + gia +
                ", ngaySX=" + ngaySX +
                ", ngayHH=" + ngayHH +
                ", state=" + state +
                ", loaiThuoc=" + loaiThuoc +
                '}';
    }
}
