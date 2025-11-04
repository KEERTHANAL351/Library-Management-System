package librarymanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import librarymanagementsystem.model.Member;
import librarymanagementsystem.util.DBConnection;

public class MemberDAO {
	public void addMember(Member member) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.executeUpdate();
            conn.close();
            System.out.println("Member added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    public List<Member> getAllMembers() {
        List<Member> list = new ArrayList<Member>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM members";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                list.add(m);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error fetching members: " + e.getMessage());
        }
        return list;
    }
}
