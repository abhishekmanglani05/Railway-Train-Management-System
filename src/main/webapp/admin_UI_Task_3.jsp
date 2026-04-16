<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    // OPTIONAL: Session check (recommended)
    // Uncomment after login session is implemented
    /*
    String adminUser = (String) session.getAttribute("adminUser");
    if (adminUser == null) {
        response.sendRedirect("login_UI_Task_3.jsp");
        return;
    }
    */
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Train Admin Portal</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<style>
:root {
	--blue: #0D6EFD;
	--blue-dark: #0b5ed7;
	--bg: #f8fbff;
	--text: #0a2540;
	--white: #ffffff;
	--border: #e6eef8;
	--danger: #dc3545;
	--success: #198754;
	--muted: #5b6b8a;
}

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial,
		sans-serif;
	background: var(--bg);
	color: var(--text);
}

nav {
	background: var(--blue);
	color: var(--white);
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 14px 18px;
	position: sticky;
	top: 0;
	z-index: 100;
	box-shadow: 0 6px 18px rgba(13, 110, 253, 0.12);
}

.brand {
	font-weight: 700;
}

.menu {
	display: flex;
	gap: 12px;
}

.menu a {
	color: var(--white);
	text-decoration: none;
	font-weight: 600;
	padding: 8px 10px;
	border-radius: 8px;
}

.menu a.active, .menu a:hover {
	background: rgba(255, 255, 255, 0.18);
}

main {
	padding: 18px;
	max-width: 1100px;
	margin: 0 auto;
}

.section {
	background: var(--white);
	border: 1px solid var(--border);
	border-radius: 12px;
	padding: 18px;
	margin-bottom: 18px;
	box-shadow: 0 8px 24px rgba(13, 110, 253, 0.08);
}

h2 {
	margin: 0 0 6px;
}

h3 {
	margin: 0 0 10px;
	color: var(--muted);
}

.grid {
	display: grid;
	gap: 12px;
}

@media ( min-width : 800px) {
	.grid.cols-2 {
		grid-template-columns: 1fr 1fr;
	}
}

table {
	width: 100%;
	border-collapse: collapse;
	border-radius: 8px;
	overflow: hidden;
}

th, td {
	border-bottom: 1px solid var(--border);
	padding: 10px;
	text-align: left;
}

th {
	background: #f1f6ff;
	color: #23395d;
}

.pill {
	background: #e6f0ff;
	padding: 4px 8px;
	border-radius: 999px;
	font-size: 0.8rem;
}

.footer {
	text-align: center;
	color: var(--muted);
	padding: 16px 0 40px;
}
</style>
</head>

<body>

	<!-- NAVBAR -->
	<nav>
		<div class="brand">Train Admin Portal</div>
		<div class="menu">
			<a href="admin_UI_Task_3.html" class="active">Home</a> <a
				href="RegisterTrain_UI_Task_3.jsp">Register a Train</a> <a
				href="Profile_UI_Task_3.html">Profile</a> <a href="LogoutServlet">Logout</a>
		</div>
	</nav>

	<main>

		<!-- HOME SECTION -->
		<section class="section">
			<h2>
				Home <span class="pill">current</span>
			</h2>
			<h3>Aggregate Table Section</h3>

			<div class="grid cols-2">

				<!-- 1.1 Tickets per class -->
				<div class="section">
					<h3>1.1 Number of tickets booked per class</h3>
					<table>
						<thead>
							<tr>
								<th>Class</th>
								<th>Tickets Booked</th>
							</tr>
						</thead>
						<tbody>
							<%-- Example dynamic rows later
            <tr>
              <td>First Class</td>
              <td>120</td>
            </tr>
            --%>
						</tbody>
					</table>
				</div>

				<!-- 1.2 Sales per quarter -->
				<div class="section">
					<h3>1.2 Sales done per quarter</h3>
					<table>
						<thead>
							<tr>
								<th>Quarter</th>
								<th>Sales (₹)</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>

			</div>

			<!-- CLIENT TABLE -->
			<div class="section" style="margin-top: 12px;">
				<h3>2. Table Section — Clients</h3>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Mobile</th>
							<th>Tickets Booked</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<%-- Dynamic rows via JSTL / scriptlet later --%>
					</tbody>
				</table>
			</div>

		</section>

	</main>

	<div class="footer">© Train Admin Portal · Blue & White Theme</div>

</body>
</html>
