📘 SafeCampus – Disaster Monitoring System
📌 Overview

SafeCampus is a web-based application designed to help schools and colleges report and monitor disasters like fire, floods, and accidents. It provides a simple dashboard to track incidents and improve campus safety.

🚀 Features
Report disasters (Fire, Flood, Accident, etc.)
View all reported disasters
Dashboard for monitoring incidents
Stores data in a centralized database
🛠️ Technologies Used
Backend: Spring Boot
Database: MySQL
ORM: Spring Data JPA
Frontend: HTML, CSS, Bootstrap
API Testing: Postman
🔗 API Endpoints
➤ Report Disaster

POST /disaster/report

Example:

{
  "disasterType": "Fire",
  "location": "Block A",
  "description": "Fire in chemistry lab"
}
➤ Get All Disasters

GET /disaster/all

🖥️ How to Run
Clone the repository
Configure MySQL database
Run Spring Boot application
Open dashboard in browser
Use Postman to test APIs
📊 Advantages
Easy to use
Real-time monitoring
Improves campus safety
Centralized data storage
🔮 Future Scope
Real-time alerts
Map-based tracking
Admin login system
Mobile app support
📌 Conclusion

SafeCampus is a simple and effective system for disaster reporting and monitoring, helping institutions respond quickly and maintain safety.
