package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entity.CaLam;

import connectdb.ConnectDB;

public class CaLam_dao {
    public List<CaLam> getAllCaLam() {
        List<CaLam> caLams = new ArrayList<>();
         
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "Select * from CaLam";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int maCaLam = rs.getInt(1);
                String tenCaLam = rs.getString(2);
                Time thoiGianBatDau = rs.getTime(3);
                Time thoiGianKetThuc = rs.getTime(4);
                CaLam caLam = new CaLam(maCaLam, tenCaLam, thoiGianBatDau, thoiGianKetThuc);
                caLams.add(caLam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caLams;
    }
    public CaLam getCaLamById(int maCl) {
        CaLam caLam = new CaLam();
         
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("Select * from calam where maCaLam =?");
            ps.setInt(1, maCl);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maCaLam = rs.getInt(1);
                String tenCaLam = rs.getString(2);
                Time thoiGianBatDau = rs.getTime(3);
                Time thoiGianKetThuc = rs.getTime(4);
                caLam = new CaLam(maCaLam, tenCaLam, thoiGianBatDau, thoiGianKetThuc);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return caLam;
    }
}