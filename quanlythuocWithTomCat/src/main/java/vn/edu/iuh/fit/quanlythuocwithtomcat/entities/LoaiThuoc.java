package vn.edu.iuh.fit.quanlythuocwithtomcat.entities;

public class LoaiThuoc {
    private int maLoaiThuoc;
    private String tenLoaiThuoc;

    public LoaiThuoc(int maLoaiThuoc, String tenLoaiThuoc) {
        this.maLoaiThuoc = maLoaiThuoc;
        this.tenLoaiThuoc = tenLoaiThuoc;
    }

    public LoaiThuoc() {
    }

    public LoaiThuoc(int maLoaiThuoc) {
        this.maLoaiThuoc = maLoaiThuoc;
    }

    public int getMaLoaiThuoc() {
        return maLoaiThuoc;
    }

    public void setMaLoaiThuoc(int maLoaiThuoc) {
        this.maLoaiThuoc = maLoaiThuoc;
    }

    public String getTenLoaiThuoc() {
        return tenLoaiThuoc;
    }

    public void setTenLoaiThuoc(String tenLoaiThuoc) {
        this.tenLoaiThuoc = tenLoaiThuoc;
    }

    @Override
    public String toString() {
        return "LoaiThuoc{" +
                "maLoaiThuoc=" + maLoaiThuoc +
                ", tenLoaiThuoc='" + tenLoaiThuoc + '\'' +
                '}';
    }
}
