package com.szymonharabasz.miniforum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sandbox")
public class SandboxController {
	@Autowired
	private DataSource dataSource;
	private static final String SQL_INSERT_USER = "insert into users (username, password, info, joined) values (?, ?, ?, ?)";

	// @RequestMapping(value="/storesome")
	String storeSomeUsersJdbc(Model model) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean success = true;
		try {
			long now = java.util.Calendar.getInstance().getTimeInMillis();
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT_USER);
			stmt.setString(1, "jonny");
			stmt.setString(2, "admin123");
			stmt.setString(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
					+ "Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. "
					+ "Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra " + "nulla ac diam.");
			stmt.setDate(4, new Date(now));
			stmt.execute();

			stmt.setString(1, "chefin");
			stmt.setString(2, "secret");
			stmt.setString(3,
					"Quisque semper justo at risus. Donec venenatis, turpis vel "
							+ "hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui "
							+ "id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate arcu,");
			stmt.setDate(4, new Date(now));
			stmt.execute();

			stmt.setString(1, "jochen");
			stmt.setString(2, "v9j9TVRSsJGR");
			stmt.setString(3,
					"vel tempus metus leo non est. Etiam sit amet lectus quis est "
							+ "congue mollis. Phasellus congue lacus eget neque. Phasellus ornare, "
							+ "ante vitae consectetuer consequat, purus sapien ultricies dolor, et "
							+ "mollis pede metus eget nisi. Praesent sodales velit quis augue. Cras "
							+ "suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in interdum "
							+ "massa nibh nec erat.");
			stmt.setDate(4, new Date(now));
			stmt.execute();

		} catch (SQLException e) {
			model.addAttribute("errorMessage", e.getMessage());
			success = false;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				model.addAttribute("errorMessage", e.getMessage());
				success = false;
			}
		}
		model.addAttribute("success", success);
		return "addusersresult";
	}
}
