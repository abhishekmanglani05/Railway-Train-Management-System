
<%
    String serverMessage = (String) request.getAttribute("serverMessage");
    String serverMessageType = (String) request.getAttribute("serverMessageType");
    List<Train> trains = (List<Train>) request.getAttribute("trains");

    if (trains == null) {
        response.sendRedirect(request.getContextPath() + "/Servlet4");
        return;
    }
%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List, com.Model.Train"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Register a Train (Admin)</title>
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

.field {
	margin-bottom: 12px;
}

label {
	display: block;
	margin-bottom: 6px;
	font-weight: 600;
}

input[type="text"], input[type="number"], input[type="time"], select {
	width: 100%;
	padding: 10px 12px;
	border: 1px solid var(--border);
	border-radius: 8px;
	font-size: 0.95rem;
	outline: none;
	background: var(--white);
}

input:focus, select:focus {
	border-color: var(--blue);
	box-shadow: 0 0 0 3px rgba(13, 110, 253, 0.15);
}

.btn {
	background: var(--blue);
	color: var(--white);
	border: none;
	border-radius: 8px;
	padding: 10px 12px;
	font-weight: 600;
	cursor: pointer;
}

.btn:hover {
	background: var(--blue-dark);
}

.msg {
	margin-top: 8px;
	font-size: 0.92rem;
}

.msg.success {
	color: var(--success);
}

.msg.error {
	color: var(--danger);
}

table {
	width: 100%;
	border-collapse: collapse;
	overflow: hidden;
	border-radius: 8px;
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
</style>
</head>
<body>
	<!-- NAV -->
	<nav>
		<div class="brand">Train Admin Portal</div>
		<div class="menu">
			<a href="admin_UI_Task_3.html">Home</a> <a
				href="login_UI_Task_3.html">Logout</a> <a
				href="Profile_UI_Task_3.html"> Profile </a>
		</div>
	</nav>

	<main>
		<section class="section">
			<h2>Register a Train (Admin)</h2>
			<p style="color: #5b6b8a;">All fields are required (no null/empty
				values). Registered trains can be used later for schedules and user
				selection.</p>

			<!-- Server-side form: posts to Servlet4#doPost -->
			<form action="Servlet4" method="post">
				<div class="field">
					<label>Train Number</label> <input type="text" name="train_number"
						required>
				</div>

				<div class="field">
					<label>Train Name</label> <input type="text" name="train_name"
						required>
				</div>

				<div class="field">
					<label>Origin Station</label> <input type="text"
						name="origin_station" required>
				</div>

				<div class="field">
					<label>Destination Station</label> <input type="text"
						name="destination_station" required>
				</div>

				<div class="field">
					<label>Departure Time</label> <input type="time"
						name="departure_time" required>
				</div>

				<div class="field">
					<label>Arrival Time</label> <input type="time" name="arrival_time"
						required>
				</div>

				<div class="field">
					<label>Number of Seats</label> <input type="number"
						name="number_of_seats" min="1" required>
				</div>

				<button type="submit" class="btn">Add Train</button>

				<!-- Server message, if any -->
				<% if (serverMessage != null) { %>
				<div
					class="msg <%= "success".equals(serverMessageType) ? "success" : "error" %>">
					<%= serverMessage %>
				</div>
				<% } %>
			</form>
		</section>

		<section class="section">
			<h3>Registered Trains</h3>
			<table id="tableTrains">
				<thead>
					<tr>
						<th>Train #</th>
						<th>Name</th>
						<th>From</th>
						<th>To</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>Seats</th>
					</tr>
				</thead>
				<tbody>
					<% if (trains == null || trains.isEmpty()) { %>
					<tr>
						<td colspan="7">No trains registered yet.</td>
					</tr>
					<% } else {
             for (Train t : trains) { %>
					<tr>
						<td><%= t.getTrainNumber() %></td>
						<td><%= t.getTrainName() %></td>
						<td><%= t.getOriginStation() %></td>
						<td><%= t.getDestinationStation() %></td>
						<td><%= t.getDepartureTime() %></td>
						<td><%= t.getArrivalTime() %></td>
						<td><%= t.getNumberOfSeats() %></td>
					</tr>
					<%   }
           } %>
				</tbody>
			</table>
		</section>
	</main>

	<div style="text-align: center; color: #5b6b8a; padding: 16px 0 40px;">©
		Train Admin Portal · Blue &amp; White Theme</div>
</body>
</html>
