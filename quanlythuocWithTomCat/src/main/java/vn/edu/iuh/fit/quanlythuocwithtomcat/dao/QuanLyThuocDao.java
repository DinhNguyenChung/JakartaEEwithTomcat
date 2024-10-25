package vn.edu.iuh.fit.quanlythuocwithtomcat.dao;

import vn.edu.iuh.fit.quanlythuocwithtomcat.connectDB.ConnectDB;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.LoaiThuoc;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.State;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.Thuoc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyThuocDao {
    private ConnectDB connectDB;
    public QuanLyThuocDao() {
        connectDB = new ConnectDB();
    }
    public List<Thuoc> getAllThuoc() {
        List<Thuoc> thuocList = new ArrayList<Thuoc>();
//        String sql = "select * from thuoc";
        String sql = "SELECT t.MATHUOC, t.TENTHUOC, t.GIA, t.NSX,t.HSD,t.STATE, l.MALOAI, l.TENLOAI " +
                "FROM thuoc t " +
                "JOIN LoaiThuoc l ON t.MALOAI = l.MALOAI";
        try {

            Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                int id = rs.getInt("MATHUOC");
                String name = rs.getString("TENTHUOC");
                double price = rs.getDouble("GIA");
                Date NSX = rs.getDate("NSX");
                Date HSD = rs.getDate("HSD");
                // Lấy giá trị cột STATE (Y/N) và chuyển thành Enum State
                String stateValue = rs.getString("STATE");
                State state = stateValue.equals("Y") ? State.Y : State.N;
                int maLoai1 = rs.getInt("MALOAI");
                String tenloai = rs.getString("TENLOAI");
                LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai1,tenloai);
                thuoc = new Thuoc(id, name, price, NSX,HSD,state, loaiThuoc);
                thuocList.add(thuoc);

            }
            return thuocList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LoaiThuoc> getAllLoaiThuoc() {
        List<LoaiThuoc> loaithuocList = new ArrayList<LoaiThuoc>();
        String sql = "select * from loaithuoc";
        try {
            Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int maLoai = rs.getInt("MALOAI");
                String tenthuoc = rs.getString("TENLOAI");
                LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai, tenthuoc);

                loaithuocList.add(loaiThuoc);

            }
            return loaithuocList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Thuoc> getAllThuocByMaLoai(int maLoai) {
        List<Thuoc> thuocList = new ArrayList<Thuoc>();
//        String sql = "select * from thuoc where MALOAI = ?";
        String sql = "SELECT t.MATHUOC, t.TENTHUOC, t.GIA, t.NSX,t.HSD,t.STATE, l.MALOAI, l.TENLOAI " +
                "FROM thuoc t " +
                "JOIN LoaiThuoc l ON t.MALOAI = l.MALOAI where l.MALOAI = ?";
        try {
            Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maLoai);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                int id = rs.getInt("MATHUOC");
                String name = rs.getString("TENTHUOC");
                double price = rs.getDouble("GIA");
               Date NSX = rs.getDate("NSX");
               Date HSD = rs.getDate("HSD");
                // Lấy giá trị cột STATE (Y/N) và chuyển thành Enum State
                String stateValue = rs.getString("STATE");
                State state = stateValue.equals("Y") ? State.Y : State.N;
                int maLoai1 = rs.getInt("MALOAI");
                String tenloai = rs.getString("TENLOAI");
                LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai1,tenloai);
                thuoc = new Thuoc(id, name, price, NSX,HSD,state, loaiThuoc);
                thuocList.add(thuoc);

            }
            return thuocList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean AddThuoc(Thuoc thuoc) {
        String sql = "insert into thuoc(TENTHUOC,GIA,NSX,HSD,STATE,MALOAI) values(?,?,?,?,?,?)";
        try {
            Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,thuoc.getTenThuoc());
            stmt.setDouble(2,thuoc.getGia());
//            stmt.setInt(3,thuoc.getNamSX());
            stmt.setDate(3,new java.sql.Date(thuoc.getNgaySX().getTime()));
            stmt.setDate(4,new java.sql.Date(thuoc.getNgayHH().getTime()));
            String stateValue = thuoc.getState()== State.Y ? "Y" : "N";
            stmt.setString(5,stateValue);
            stmt.setInt(6,thuoc.getLoaiThuoc().getMaLoaiThuoc());
            int rs = stmt.executeUpdate();

            return rs >0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean UpdateThuoc(Thuoc thuoc){
        String sql = "update thuoc set TENTHUOC = ?,GIA=?,NSX=?,HSD=?,STATE=?,MALOAI=? where MATHUOC = ?";
        try {
            Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,thuoc.getTenThuoc());
            stmt.setDouble(2,thuoc.getGia());
            stmt.setDate(3,new java.sql.Date(thuoc.getNgaySX().getTime()));
            stmt.setDate(4,new java.sql.Date(thuoc.getNgayHH().getTime()));
            java.util.Date today = new java.util.Date();
            String stateValue = thuoc.getNgayHH().after(today) ? "Y" : "N";
            stmt.setString(5,stateValue);
            stmt.setInt(6,thuoc.getLoaiThuoc().getMaLoaiThuoc());
            stmt.setInt(7,thuoc.getMaThuoc());
            int rs = stmt.executeUpdate();
            return rs >0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Thuoc getThuocByID(int maThuoc){
//        String sql = "select * from thuoc where MATHUOC = ?";
        String sql = "SELECT t.MATHUOC, t.TENTHUOC, t.GIA, t.NSX,t.HSD,t.STATE, l.MALOAI, l.TENLOAI " +
                "FROM thuoc t " +
                "JOIN LoaiThuoc l ON t.MALOAI = l.MALOAI where t.MATHUOC = ?";
        try {
            Connection conn = connectDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,maThuoc);
            ResultSet rs = ps.executeQuery();
            Thuoc thuoc = new Thuoc();
            while (rs.next()) {

                int id = rs.getInt("MATHUOC");
                String name = rs.getString("TENTHUOC");
                double price = rs.getDouble("GIA");
                Date NSX = rs.getDate("NSX");
                Date HSD = rs.getDate("HSD");
                String stateValue = rs.getString("STATE");
                State state = stateValue.equals("Y") ? State.Y : State.N;
                int maLoai = rs.getInt("MALOAI");
                String tenloai = rs.getString("TENLOAI");
                LoaiThuoc lt = new LoaiThuoc(maLoai,tenloai);
                thuoc = new Thuoc(id,name,price,NSX,HSD,state,lt);
            }
            return thuoc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
