<%@ page import="java.util.List, com.Model.Booking"%>
<%@ page import="java.util.List, com.Model.Train"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	session="true"%>
<%
  String userName = (String) session.getAttribute("userName");
	Integer customerId = (Integer) session.getAttribute("customerId");
	//int customerId
  if (userName == null || userName.isEmpty()) {
      response.sendRedirect("login.jsp");
      return;
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Portal</title>

<style>

/* ===== Booking Ticket Form Styling ===== */
.booking-form {
	display: grid;
	gap: 0.75rem;
	max-width: 520px;
}

.booking-form label {
	font-size: 0.9rem;
	color: var(--muted);
}

.booking-form input, .booking-form select {
	padding: 0.6rem 0.7rem;
	border: 1px solid var(--border);
	border-radius: 0.5rem;
	font: inherit;
	background: white;
}

.booking-form input[readonly] {
	background: #f8fafc;
	color: var(--muted);
}

.booking-form input[type="submit"] {
	margin-top: 0.75rem;
	padding: 0.65rem;
	background: var(--primary);
	color: white;
	border: none;
	border-radius: 0.5rem;
	font-weight: 600;
	cursor: pointer;
}

.booking-form input[type="submit"]:hover {
	opacity: 0.95;
}

.booking-form hr {
	margin: 1.25rem 0;
	border: none;
	border-top: 1px solid var(--border);
}

/* / end here */
:root {
	--bg: #f4f7f8;
	--card: #ffffff;
	--primary: #4f46e5; /* Indigo */
	--accent: #14b8a6; /* Teal */
	--text: #0f172a;
	--muted: #6b7280;
	--danger: #dc2626;
	--success: #059669;
	--border: #e5e7eb;
}

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: system-ui, -apple-system, Segoe UI, Roboto, Helvetica,
		Arial, sans-serif;
	background: var(--bg);
	color: var(--text);
}

header {
	background: var(--card);
	border-bottom: 1px solid var(--border);
	position: sticky;
	top: 0;
	z-index: 50;
}

.container {
	max-width: 1100px;
	margin: 0 auto;
	padding: 1rem;
}

.brand {
	display: flex;
	align-items: center;
	gap: .75rem;
}

.brand h1 {
	margin: 0;
	font-size: 1.25rem;
}

nav {
	display: flex;
	flex-wrap: wrap;
	gap: .5rem;
	margin-top: .75rem;
}

nav button {
	padding: .5rem .75rem;
	border: 1px solid var(--border);
	background: var(--card);
	color: var(--text);
	border-radius: .5rem;
	cursor: pointer;
}

nav button.active {
	background: var(--primary);
	color: white;
	border-color: var(--primary);
}

.content {
	padding: 1rem;
}

.card {
	background: var(--card);
	border: 1px solid var(--border);
	border-radius: .75rem;
	padding: 1rem;
	margin-bottom: 1rem;
	box-shadow: 0 1px 2px rgba(0, 0, 0, .03);
}

h2, h3 {
	margin-top: 0;
}

.grid {
	display: grid;
	gap: 1rem;
}

@media ( min-width : 900px) {
	.grid.cols-2 {
		grid-template-columns: 1fr 1fr;
	}
}

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	border-radius: .5rem;
	overflow: hidden;
}

th, td {
	padding: .65rem .75rem;
	border-bottom: 1px solid var(--border);
	text-align: left;
}

th {
	background: #f1f5f9;
	font-weight: 600;
}

tr:last-child td {
	border-bottom: none;
}

.muted {
	color: var(--muted);
}

.row {
	display: flex;
	gap: 1rem;
	align-items: center;
	flex-wrap: wrap;
}

.form {
	display: grid;
	gap: .75rem;
}

.form .field {
	display: grid;
	gap: .25rem;
}

.form label {
	font-size: .9rem;
	color: var(--muted);
}

.form input, .form select, .form textarea {
	padding: .6rem .7rem;
	border: 1px solid var(--border);
	border-radius: .5rem;
	background: white;
	font: inherit;
}

.form input[disabled] {
	background: #f8fafc;
	color: var(--muted);
}

.actions {
	display: flex;
	gap: .5rem;
	flex-wrap: wrap;
}

.btn {
	padding: .6rem .85rem;
	border: 1px solid var(--border);
	background: var(--card);
	border-radius: .5rem;
	cursor: pointer;
}

.btn.primary {
	background: var(--primary);
	color: white;
	border-color: var(--primary);
}

.btn.danger {
	background: var(--danger);
	color: white;
	border-color: var(--danger);
}

.btn.success {
	background: var(--success);
	color: white;
	border-color: var(--success);
}

.note {
	padding: .6rem .75rem;
	border-left: 4px solid var(--accent);
	background: #e0f2fe;
	color: #0c4a6e;
	border-radius: .25rem;
}

.empty {
	padding: 1rem;
	border: 1px dashed var(--border);
	border-radius: .5rem;
	color: var(--muted);
	text-align: center;
	background: #f8fafc;
}

.pill {
	display: inline-block;
	padding: .25rem .5rem;
	border-radius: 999px;
	background: #eef2ff;
	color: #3730a3;
	font-size: .8rem;
}

.right {
	margin-left: auto;
}

.hidden {
	display: none !important;
}

footer {
	text-align: center;
	padding: 1rem;
	color: var(--muted);
}

.modal {
	position: fixed;
	inset: 0;
	background: rgba(0, 0, 0, .4);
	display: none;
	align-items: center;
	justify-content: center;
}

.modal .dialog {
	background: white;
	padding: 1rem;
	border-radius: .5rem;
	width: min(480px, 90vw);
}

.tag {
	font-size: .85rem;
	color: var(--muted);
}
</style>

</head>
<body>

	<!-- Portal Header -->
	<header id="portalHeader">
		<div class="container">
			<div class="row">
				<div class="brand">
					<svg width="28" height="28" viewBox="0 0 24 24" fill="none"
						aria-hidden="true">
            <circle cx="12" cy="12" r="10" stroke="#1f6feb"
							stroke-width="2" />
            <path d="M4 12h16M12 4v16" stroke="#1f6feb" stroke-width="2" />
          </svg>
					<h1>User Portal</h1>
				</div>
				<div class="right muted" id="userTag"><%= userName %></div>
				<p>
					<strong>Customer ID:</strong>
					<%= customerId %></p>
			</div>
			<nav>
				<button class="active" data-target="homeSection">Home</button>
				<button data-target="bookSection">Book Ticket</button>
				<button data-target="viewSection">Cancel Booking</button>
				<button data-target="updateSection">Update Details</button>
				<button data-target="logoutSection">Logout</button>
			</nav>
		</div>
	</header>

	<main class="container content" id="portalContent">
		HOME
		<section id="homeSection" class="">
			<div class="card">
				<h2>Home</h2>
				<h3>Your Bookings</h3>

				<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>

				<% if (bookings == null || bookings.isEmpty()) { %>
				<div class="empty">No bookings found.</div>
				<% } else { %>

				<table>
					<thead>
						<tr>
							<th>Booking ID</th>
							<th>Train No</th>
							<th>Date</th>
							<th>Seats</th>
							<th>Fare (₹)</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<% for (Booking b : bookings) { %>
						<tr>
							<td><%= b.getBookingId() %></td>
							<td><%= b.getTrainNumber() %></td>
							<td><%= b.getBookingDate() %></td>
							<td><%= b.getNumber_of_seats() %></td>
							<td><%= b.getFare() %></td>
							<td><span class="pill"><%= b.getStatus() %></span></td>
						</tr>
						<% } %>
					</tbody>
				</table>

				<% } %>
				<!--         <p class="muted">Quick stats and aggregates.</p> -->
				<!--         <div class="grid cols-2"> -->
				<!--           <div class="card"> -->
				<!--             <h3>Table Aggregate: Number of Tickets per Class</h3> -->
				<!--             <table id="aggTicketsByClassTable"> -->
				<!--               <thead><tr><th>Ticket Category</th><th>Tickets Booked</th></tr></thead> -->
				<!--               <tbody></tbody> -->
				<!--             </table> -->
				<!--             <div id="aggTicketsByClassEmpty" class="empty hidden">No tickets booked yet.</div> -->
				<!--           </div> -->
				<!--           <div class="card"> -->
				<!--             <h3>Table Aggregate: Sales per Quarter</h3> -->
				<!--             <table id="salesPerQuarterTable"> -->
				<!--               <thead><tr><th>Year - Quarter</th><th>Sales (₹)</th></tr></thead> -->
				<!--               <tbody></tbody> -->
				<!--             </table> -->
				<!--             <div id="salesPerQuarterEmpty" class="empty hidden">No sales data yet.</div> -->
				<!--             <p class="tag">Sales are calculated from <strong>boarding date</strong> × tickets × category base price.</p> -->
			</div>
			</div>
			</div>
		</section>


		<!-- 			old -->
		<!-- BOOK -->
		<!--     <section id="bookSection" class="hidden"> -->
		<!--       <div class="card"> -->
		<!--         <h2>Book Ticket</h2> -->
		<!--         <form id="bookForm" class="form"> -->
		<!--           <div class="grid cols-2"> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookUserId">ID (Auto)</label> -->
		<!--               <input id="bookUserId" type="text" disabled /> -->
		<!--             </div> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookUserName">Name</label> -->
		<%--               <input id="bookUserName" type="text" value="<%= userName %>" required /> --%>
		<!--             </div> -->
		<!--           </div> -->

		<!--           <div class="grid cols-2"> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookMobile">Mobile</label> -->
		<!--               <input id="bookMobile" type="tel" placeholder="10-digit" required /> -->
		<!--             </div> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookAge">Age</label> -->
		<!--               <input id="bookAge" type="number" min="1" max="120" required /> -->
		<!--             </div> -->
		<!--           </div> -->

		<!--           <div class="grid cols-2"> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookDate">Date</label> -->
		<!--               <input id="bookDate" type="date" required /> -->
		<!--             </div> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookCategory">Ticket Category</label> -->
		<!--               <select id="bookCategory" required></select> -->
		<!--             </div> -->
		<!--           </div> -->

		<!--           <div class="grid cols-2"> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookBoarding">Boarding Station</label> -->
		<!--               <input id="bookBoarding" type="text" placeholder="e.g., Mumbai CST" required /> -->
		<!--             </div> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookDestination">Destination Station</label> -->
		<!--               <input id="bookDestination" type="text" placeholder="e.g., New Delhi" required /> -->
		<!--             </div> -->
		<!--           </div> -->

		<!--           <div class="grid cols-2"> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookTrain">Trains Available</label> -->
		<!--               <select id="bookTrain" required></select> -->
		<!--             </div> -->
		<!--             <div class="field"> -->
		<!--               <label for="bookQty">Number of Tickets</label> -->
		<!--               <input id="bookQty" type="number" min="1" max="10" required /> -->
		<!--             </div> -->
		<!--           </div> -->

		<!--           <div class="actions"> -->
		<!--             <button type="submit" class="btn primary">Submit</button> -->
		<!--             <button type="reset" class="btn">Reset</button> -->
		<!--           </div> -->
		<!--         </form> -->
		<!--         <div id="bookError" class="note hidden"></div> -->
		<!--       </div> -->

		<!--       <div id="confirmationCard" class="card hidden"> -->
		<!--         <h3>Booking Confirmation</h3> -->
		<!--         <p class="muted">Your booking has been confirmed. Details below:</p> -->
		<!--         <div id="confirmationDetails"></div> -->
		<!--         <div class="actions"> -->
		<!--           <button class="btn success" id="confirmationBack">Back to Home</button> -->
		<!--           <button class="btn" data-target="viewSection" id="confirmationViewTickets">View Tickets</button> -->
		<!--         </div> -->
		<!--       </div> -->
		<!--     </section> -->


		<section id="bookSection" class="hidden">
			<div class="card">
				<h2>Search Trains</h2>

				<!-- IMPORTANT: use POST and add name attributes -->
				<form id="bookForm" class="form" action="req2" method="post">
					<div class="grid cols-2">
						<div class="field">
							<label for="boarding">Boarding Station :</label> <input
								id="boarding" name="boarding" type="text"
								placeholder="e.g., Mumbai CST" required />
						</div>
						<div class="field">
							<label for="destination">Destination Station :</label> <input
								id="destination" name="destination" type="text"
								placeholder="e.g., Pune JN" required />
						</div>
					</div>
					<input type="submit" value="Submit">
				</form>

				<!-- ✅ RESULTS AREA: visible only when attributes are set -->
				<div id="searchResults">
					<%-- Use JSTL if available; otherwise scriptlets are fine --%>
					<%
        java.util.List<Train> trains = (java.util.List<Train>) request.getAttribute("trains");
        String boardingVal = (String) request.getAttribute("boarding");
        String destinationVal = (String) request.getAttribute("destination");
      %>

					<% if (boardingVal != null && destinationVal != null) { %>
					<h3>
						Results for:
						<%= boardingVal %>
						→
						<%= destinationVal %></h3>

					<% if (trains == null || trains.isEmpty()) { %>
					<div class="empty">No trains found for this route.</div>
					<% } else { %>
					<table>
						<thead>
							<tr>
								<th>#</th>
								<th>Train Number</th>
								<th>Train Name</th>
								<th>Origin</th>
								<th>Destination</th>
								<th>Departure</th>
								<th>Arrival</th>
								<th>Seats</th>
							</tr>
						</thead>
						<tbody>
							<% for (int i = 0; i < trains.size(); i++) {
                   Train t = trains.get(i); %>
							<tr>
								<td><%= (i + 1) %></td>
								<td><%= t.getTrainNumber() %></td>
								<td><%= t.getTrainName() %></td>
								<td><%= t.getOriginStation() %></td>
								<td><%= t.getDestinationStation() %></td>
								<td><%= t.getDepartureTime() %></td>
								<td><%= t.getArrivalTime() %></td>
								<td><%= t.getNumberOfSeats() %></td>
							</tr>
							<% } %>
						</tbody>
					</table>
					<% } %>
					<% } %>


					<%
Boolean showForm = (Boolean) request.getAttribute("showBookingForm");
%>

					<% if (showForm != null && showForm) { %>

					<hr>

					<h3>Book Ticket</h3>

					<form action="insertbooking" method="get" class="booking-form">

						<label>Customer ID</label> <input type="text"
							value="<%= customerId %>" readonly> <input type="hidden"
							name="customerId" value="<%= customerId %>"> <label>Train
							Number</label> <input type="text" name="trainNumber" required> <label>Booking
							Date</label> <input type="date" name="bookingDate" required> <label>Number
							of Seats</label> <input type="number" id="seats" name="numberOfSeats"
							min="1" required oninput="calculateFare()"> <label>Class</label>
						<select id="classType" name="classType" required
							onchange="calculateFare()">
							<option value="">-- Select Class --</option>
							<option value="3AC">3rd AC</option>
							<option value="2AC">2nd AC</option>
						</select> <label>Fare</label> <input type="text" id="fareDisplay" readonly>

						<!-- actual fare submitted -->
						<input type="hidden" id="fare" name="fare"> <label>Status</label>
						<input type="text" name="status" value="CONFIRMED" readonly>

						<input type="submit" value="Add Booking">
					</form>

					<!-- <form action="insertbooking" method="get"> -->

					<!--     <label>Customer ID</label> -->
					<%--     <input type="text" value="<%= customerId %>" readonly> --%>

					<!--     hidden actual value -->
					<%--     <input type="hidden" name="customerId" value="<%= customerId %>"> --%>

					<!--     <label>Train Number</label> -->
					<!--     <input type="text" name="trainNumber" required> -->

					<!--     <label>Booking Date</label> -->
					<!--     <input type="date" name="bookingDate" required> -->

					<!--     <label>Number of Seats</label> -->
					<!--     <input type="text" name="numberOfSeats" required> -->

					<!--     <label>Fare</label> -->
					<!--     <input type="text" name="fare" required> -->

					<!--     <label>Status</label> -->
					<!--     <input type="text" name="status" required> -->

					<!--     <input type="submit" value="Add Booking"> -->
					<!-- </form> -->

					<!-- <form action="req1" method="get"> -->

					<!--     <label>Customer ID</label> -->
					<!--     <input type="text" name="customerId" required> -->

					<!--     <label>Train Number</label> -->
					<!--     <input type="text" name="trainNumber" required> -->

					<!--     <label>Booking Date</label> -->
					<!--     <input type="date" name="bookingDate" required> -->

					<!--     <label>Number of Seats</label> -->
					<!--     <input type="text" name="numberOfSeats" required> -->

					<!--     <label>Fare</label> -->
					<!--     <input type="text" name="fare" required> -->

					<!--     <label>Status</label> -->
					<!--     <input type="text" name="status" required> -->

					<!--     <input type="submit" value="Add Booking"> -->

					<!-- </form> -->

					<% } %>
				</div>
			</div>

		</section>



		<!-- VIEW TICKETS -->
		<section id="viewSection" class="hidden">
			<div class="card">
				<h2>Cancel Tickets :</h2>
				<form action="cancelticket" method="get">
					Booking Id<input type="text" name="bookingid" required><br>
					<br> <input type="submit" value="deletebooking">
				</form>
			</div>
		</section>

		<!-- UPDATE DETAILS -->
		<section id="updateSection" class="hidden">

			<form action="updateCustomer" method="post">

				<label>Email</label> <input type="email" name="email" required>

				<label>Address</label> <input type="text" name="address" required>

				<label>Contact Number</label> <input type="text"
					name="contactNumber" maxlength="10" required> <input
					type="submit" value="Update Details">

			</form>
			<!--       <div class="card"> -->
			<!--         <h2>Update Details</h2> -->
			<!--         <form id="updateForm" class="form"> -->
			<!--           <div class="grid cols-2"> -->
			<!--             <div class="field"> -->
			<!--               <label for="updEmail">Email</label> -->
			<!--               <input id="updEmail" type="email" required /> -->
			<!--             </div> -->
			<!--             <div class="field"> -->
			<!--               <label for="updMobile">Mobile Number</label> -->
			<!--               <input id="updMobile" type="tel" placeholder="10-digit" required /> -->
			<!--             </div> -->
			<!--           </div> -->
			<!--           <div class="field"> -->
			<!--             <label for="updAddress">Address</label> -->
			<!--             <textarea id="updAddress" rows="2" required></textarea> -->
			<!--           </div> -->

			<!--           <div class="card"> -->
			<!--             <div class="row"> -->
			<!--               <h3 style="margin:0;">Update Password</h3> -->
			<!--               <label class="row" style="gap:.5rem;margin-left:auto;align-items:center;"> -->
			<!--                 <input type="checkbox" id="togglePasswordUpdate" /> -->
			<!--                 Enable -->
			<!--               </label> -->
			<!--             </div> -->
			<!--             <div id="passwordFields" class="grid cols-2 hidden"> -->
			<!--               <div class="field"> -->
			<!--                 <label for="updCurrentPassword">Current Password</label> -->
			<!--                 <input id="updCurrentPassword" type="password" /> -->
			<!--               </div> -->
			<!--               <div class="field"> -->
			<!--                 <label for="updNewPassword">New Password</label> -->
			<!--                 <input id="updNewPassword" type="password" /> -->
			<!--               </div> -->
			<!--               <div class="field"> -->
			<!--                 <label for="updConfirmPassword">Confirm Password</label> -->
			<!--                 <input id="updConfirmPassword" type="password" /> -->
			<!--               </div> -->
			<!--             </div> -->
			<!--             <p class="tag">Validations same as registration: Email format, 10-digit mobile, non-empty address. Password must be strong (min 8 chars incl. uppercase, lowercase, number, special) and current must match.</p> -->
			<!--           </div> -->

			<!--           <div class="actions"> -->
			<!--             <button type="submit" class="btn primary">Save</button> -->
			<!--           </div> -->
			<!--         </form> -->
			<!--         <div id="updateMsg" class="note hidden"></div> -->
			<!--       </div> -->
		</section>
	</main>

	<footer>
		&copy; <span id="year"></span> Customer Portal
	</footer>
	<div id="modal" class="modal">
		<div class="dialog"></div>
	</div>

	<script>
  
  //new script 
  
//   function loadTrains() {
//   const boarding = document.getElementById("bookBoarding").value;
//   const destination = document.getElementById("bookDestination").value;

//   if (!boarding || !destination) {
//     alert("Enter boarding and destination");
//     return;
//   }

//   fetch(`searchTrainsAjax?boarding=${boarding}&destination=${destination}`)
//     .then(res => res.json())
//     .then(data => {
//       const select = document.getElementById("bookTrain");
//       select.innerHTML = "<option value=''>-- Select Train --</option>";

//       if (data.length === 0) {
//         alert("No trains available");
//         return;
//       }

//       data.forEach(t => {
//         select.innerHTML +=
//           `<option value="${t.trainNumber}">
//             ${t.trainName} (${t.trainNumber})
//           </option>`;
//       });

//       document.getElementById("bookingDetails").classList.remove("hidden");
//     });
// }
  
  
  //ends here 
    document.getElementById('year').textContent = new Date().getFullYear();
    const yearEl = document.getElementById("year");
    yearEl.textContent = new Date().getFullYear();

    const loginView = document.getElementById("loginView");
    const portalHeader = document.getElementById("portalHeader");
    const portalContent = document.getElementById("portalContent");
    const userTag = document.getElementById("userTag");

    const navButtons = Array.from(document.querySelectorAll("nav button[data-target]"));
    const sections = {
      homeSection: document.getElementById("homeSection"),
      bookSection: document.getElementById("bookSection"),
      viewSection: document.getElementById("viewSection"),
      updateSection: document.getElementById("updateSection")
    };
    navButtons.forEach(btn => btn.addEventListener("click", () => showSection(btn.dataset.target)));

    function showSection(id) {
      Object.entries(sections).forEach(([key, el]) => el.classList.toggle("hidden", key !== id));
      navButtons.forEach(b => b.classList.toggle("active", b.dataset.target === id));
      if (id === "homeSection") renderAggregates();
      if (id === "viewSection") renderTickets();        // ✅ ensure refresh
      if (id === "bookSection") prefillBookForm();
      if (id === "updateSection") prefillUpdateForm();
    }

    document.getElementById("logoutBtn").addEventListener("click", () => {
      // Optional: clear session so next visit forces login
      sessionStorage.removeItem("loggedInUser");
      window.location.href = "index_UI_Task_1.html";
    });
    
    
    // new script: 
    	function calculateFare() {
    const seats = document.getElementById("seats").value;
    const classType = document.getElementById("classType").value;

    let rate = 0;

    if (classType === "3AC") {
        rate = 500;
    } else if (classType === "2AC") {
        rate = 1000;
    }

    if (seats && rate) {
        const totalFare = seats * rate;
        document.getElementById("fareDisplay").value = totalFare;
        document.getElementById("fare").value = totalFare;
    } else {
        document.getElementById("fareDisplay").value = "";
        document.getElementById("fare").value = "";
    }
}
  </script>
</body>
</html>