📌 Overview

SafeCampus is a web-based disaster monitoring system designed for schools and colleges. It allows users to report emergencies like fire, floods, and accidents, and helps administrators monitor them through a dashboard.

✨ Features
📝 Report disasters easily
📊 View all reported incidents
📌 Dashboard for monitoring
💾 Centralized database storage
⚡ Quick and simple interface
🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot
Database	MySQL
ORM	Spring Data JPA
Frontend	HTML, CSS, Bootstrap
API Testing	Postman
🔗 API Endpoints
➤ Report Disaster

POST /disaster/report

{
  "disasterType": "Fire",
  "location": "Block A",
  "description": "Fire in chemistry lab"
}
➤ Get All Disasters

GET /disaster/all

🖥️ Project Structure
SafeCampus/
│── controller/
│── service/
│── repository/
│── model/
│── resources/
│── static/
⚙️ Setup & Run
1️⃣ Clone Repository
git clone https://github.com/your-username/safecampus.git
2️⃣ Configure Database
Create MySQL database
Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/safecampus
spring.datasource.username=root
spring.datasource.password=your_password
3️⃣ Run Application
mvn spring-boot:run
4️⃣ Access
Backend: http://localhost:8080
Use Postman for API testing

✅ Advantages

✔ Easy disaster reporting
✔ Real-time monitoring
✔ User-friendly interface
✔ Improves campus safety

🔮 Future Enhancements
🔔 Real-time alerts (WebSocket)
🗺️ Map-based disaster tracking
🔐 Admin authentication
📱 Mobile app integration
🤖 AI-based prediction
📚 Conclusion

SafeCampus provides a simple and effective solution for disaster management in educational institutions using modern web technologies.
