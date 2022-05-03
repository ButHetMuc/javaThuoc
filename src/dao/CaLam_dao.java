package dao;

import entity.CaLam;
import entity.NhanVien;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDBNV;

public class CaLam_dao {
    public List<CaLam> getAllCaLam() {
        List<CaLam> caLams = new ArrayList<>();
        ConnectDBNV.getInstance();
        Connection con = ConnectDBNV.getConnection();
        try {
            String sql = "Select * from calam";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maCaLam = rs.getString(1);
                String tenCaLam = rs.getString(2);
                String thoiGianBatDau = rs.getString(3);
                String thoiGianKetThuc = rs.getString(4);
                CaLam caLam = new CaLam(maCaLam,tenCaLam,thoiGianBatDau,thoiGianKetThuc);
                caLams.add(caLam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caLams;
    }
}