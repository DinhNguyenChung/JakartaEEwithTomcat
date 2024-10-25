package vn.edu.iuh.fit.quanlythuocwithtomcat.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.quanlythuocwithtomcat.dao.QuanLyThuocDao;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.LoaiThuoc;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.State;
import vn.edu.iuh.fit.quanlythuocwithtomcat.entities.Thuoc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "QuanLyThuocServlet", value="/QuanLyThuocServlet")
public class QuanLyThuocServlet extends HttpServlet {
    private QuanLyThuocDao quanLyThuocDao;

    @Override
    public void init() throws ServletException {
        quanLyThuocDao = new QuanLyThuocDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "quanlythuoc":
                HttpSession session = req.getSession();
                List<Thuoc> dsthuoc = new ArrayList<Thuoc>();
                dsthuoc = quanLyThuocDao.getAllThuoc();
                List<LoaiThuoc> dsloaithuoctimkiem = new ArrayList<>();
                dsloaithuoctimkiem = quanLyThuocDao.getAllLoaiThuoc();
                session.setAttribute("dsloaithuoc", dsloaithuoctimkiem);
                session.setAttribute("dsthuoc", dsthuoc);
                resp.sendRedirect("quanlythuoc.jsp");
                break;
            case "quanlyloaithuoc":
                HttpSession session1 = req.getSession();
                List<LoaiThuoc> dsloaithuoc = new ArrayList<LoaiThuoc>();
                dsloaithuoc = quanLyThuocDao.getAllLoaiThuoc();
                session1.setAttribute("dsloaithuoc", dsloaithuoc);
                resp.sendRedirect("quanlyloaithuoc.jsp");
                break;
            case "themthuocmoi":
                resp.sendRedirect("themthuocmoi.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        switch (action) {
            case "themthuocmoi":
                String tenThuoc= req.getParameter("tenThuoc");
                double gia = Double.parseDouble(req.getParameter("gia"));
                // Chuyển chuỗi ngày thành đối tượng Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date NSX = dateFormat.parse(req.getParameter("nsx")); // Lấy ngày sản xuất từ request
                    Date HSD = dateFormat.parse(req.getParameter("hsd")); // Lấy ngày hết hạn từ request
                    // Lấy trạng thái của thuốc (Y/N từ form), chuyển đổi thành Enum State
                    String stateParam = req.getParameter("state");
                    State state = stateParam.equals("Y") ? State.Y : State.N;

                    int maLoai = Integer.parseInt(req.getParameter("maLoai"));
                    LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai);
                    Thuoc thuoc = new Thuoc(tenThuoc,gia,NSX,HSD,state,loaiThuoc);
                    if(quanLyThuocDao.AddThuoc(thuoc)){
                        HttpSession session = req.getSession();
                        List<Thuoc> dsT = quanLyThuocDao.getAllThuoc();
                        session.setAttribute("dsthuoc", dsT);
                        resp.sendRedirect("quanlythuoc.jsp");
                    }
                    else{
                        //failed thêm thất bại
                        System.out.println("Thêm thất bại");

                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "timThuocTheoMaLoai":
                List<Thuoc> dsthuoc = new ArrayList<>();
                String maLoaiThuoc = req.getParameter("maLoai");
                if(maLoaiThuoc.equals("")){
                    dsthuoc = quanLyThuocDao.getAllThuoc();
                }
              else {
                  int maloai = Integer.parseInt(maLoaiThuoc);
                    dsthuoc = quanLyThuocDao.getAllThuocByMaLoai(maloai);

                }
              HttpSession session = req.getSession();
              session.setAttribute("dsthuoc", dsthuoc);
              resp.sendRedirect("quanlythuoc.jsp");
                break;
            case "chinhsuathuoc":
                HttpSession session1 = req.getSession();
                Thuoc thuoc = quanLyThuocDao.getThuocByID(Integer.parseInt(req.getParameter("mathuoc")));
                session1.setAttribute("thuoc", thuoc);

                resp.sendRedirect("chinhsuathuoc.jsp");
                break;
            case "update":
                HttpSession session2 = req.getSession();
                String tenThuocUpdate= req.getParameter("tenThuoc");
                double giaUpdate = Double.parseDouble(req.getParameter("gia"));
                // Chuyển chuỗi ngày thành đối tượng Date
                SimpleDateFormat dateFormatUpdate = new SimpleDateFormat("yyyy-MM-dd");


                try {
                   Date NSX = dateFormatUpdate.parse(req.getParameter("nsx"));
                    Date HSD = dateFormatUpdate.parse(req.getParameter("hsd")); // Lấy ngày hết hạn từ request
                    int maLoai = Integer.parseInt(req.getParameter("maLoai"));
                    LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai);
                    int maThuoc = Integer.parseInt(req.getParameter("maThuoc"));
                    Thuoc thuocUpdate = new Thuoc(maThuoc,tenThuocUpdate,giaUpdate,NSX,HSD,loaiThuoc);
                    if(quanLyThuocDao.UpdateThuoc(thuocUpdate)){
                        List<Thuoc> dsUpdate = quanLyThuocDao.getAllThuoc();
                        session2.setAttribute("dsthuoc", dsUpdate);
                        resp.sendRedirect("quanlythuoc.jsp");
                    }
                    else{
                        System.out.println("Update failed");
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
