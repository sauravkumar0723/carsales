🚗 Car Sales Analytics AI Advisor
Spring Boot + AI + Python Library Full-Stack Analytics System

An end-to-end AI-powered Car Sales Analytics & Recommendation System that combines:


📌 Project Overview

The Car Sales AI Advisor is a real-world intelligent analytics system built using:

⚙️ Spring Boot (Backend APIs)
🧠 Spring AI + LLaMA (Ollama Local AI)
🐍 Python (Data Analytics & Visualization)
📊 Streamlit (Interactive Dashboard)
🗄️ MySQL (Database)

🏠 Application Preview
### 📊 Dashboard UI

![Dashboard](screenshots/dashboard.png)

It provides:

🚀 AI-powered car recommendations + sales analytics + dynamic SQL generation system

🌟 Key Highlights

✔ AI converts natural language → SQL
✔ Real-time database-driven insights
✔ Car sales analytics (yearly/monthly trends)
✔ AI-based car recommendation system
✔ CSV upload & processing
✔ Interactive dashboard (Streamlit)
✔ Clean layered Spring Boot architecture
✔ End-to-end full-stack AI system

🏗️ System Architecture
👤 User (Streamlit UI)
        ↓
🐍 Python (Pandas + Requests)
        ↓
⚙️ Spring Boot REST APIs
        ↓
🧠 Spring AI (LLaMA via Ollama)
        ↓
🔄 SQL Generation Engine
        ↓
⚡ Spring JDBC Executor
        ↓
🗄️ MySQL Database
        ↓
🤖 AI Response Formatter
        ↓
📊 Streamlit Dashboard
📸 Application Screenshots

📌 Add your screenshots here (store inside /screenshots folder)

🖥️ Dashboard UI (Streamlit)

📍 URL: http://localhost:8501

🖼️ Screenshot:
👉 View Dashboard Screenshot

![Dashboard](screenshots/dashboard.png)
           
📊 Sales Analytics Graphs
![Dashboard](screenshots/dashboard.png)
📍 URL: http://localhost:8501

🖼️ Screenshot:
👉 View Analytics Screenshot
  ![Dashboard](screenshots/dashboard.png)
⚙️ Spring Boot API Response

📍 URL: http://localhost:8081/api/cars
 
🖼️ Screenshot:
👉 View API Screenshot
   ![Dashboard](screenshots/dashboard.png)
🧠 AI Query Flow

📍 URL: http://localhost:8081/api/ai/query

🖼️ Screenshot:
👉 View AI Flow Screenshot
   ![Dashboard](screenshots/dashboard.png)
   
## 🧩 Tech Stack

⚙️ Backend  
- Java 17+  
- Spring Boot  
- Spring AI  
- Spring JDBC  
- REST APIs  
🧠 AI Layer
Ollama
LLaMA 3 (Local LLM)
Spring AI ChatClient
🗄️ Database
MySQL
🐍 Data & Visualization
Python
Pandas
Plotly
Matplotlib
Jupyter Notebook
🎨 Frontend
Streamlit
🔐 Core Features
📊 Data Pipeline
CSV upload via API
Data validation & cleaning
Store into MySQL database
⚙️ Backend System
REST API architecture
Controller → Service → Repository flow
Global Exception Handling
Standard API Response structure
🧠 AI Intelligence
Natural language input
AI generates SQL dynamically
Spring JDBC executes queries
AI formats final response
📈 Analytics Dashboard
Year-wise sales analysis
Monthly trend analysis
Interactive graphs
🔑 Key Functionalities

✔ CRUD Operations
✔ File Upload System
✔ AI Query System
✔ Session-like flow via API
✔ Database-driven architecture
✔ Clean MVC-style backend design

📂 Project Structure
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── exception
 └── config

src/main/resources
 ├── templates (optional)
 ├── static
 └── application.properties

ai-python/
 ├── streamlit-app
 ├── notebooks
 ├── visualization

database/
 └── schema.sql

screenshots/
 ├── dashboard.png
 ├── analytics.png
 ├── api-response.png
 ├── ai-flow.png
🚀 How to Run Locally
1️⃣ Clone Repository
git clone https://github.com/your-username/car-sales-ai-advisor.git
2️⃣ Configure Database
spring.datasource.url=jdbc:mysql://localhost:3306/car_sales_db
spring.datasource.username=root
spring.datasource.password=your_password
3️⃣ Run Spring Boot Backend
mvn spring-boot:run

Backend runs on:

http://localhost:8081
4️⃣ Run Streamlit UI
streamlit run app.py

UI runs on:

http://localhost:8501
📊 Engineering Highlights

✔ Real AI integration (not chatbot only)
✔ Dynamic SQL generation using LLM
✔ Full-stack Spring Boot + Python system
✔ Production-level backend structure
✔ Real-time analytics dashboard
✔ End-to-end intelligent workflow

🎯 Skills Demonstrated
Spring Boot Development
Spring AI Integration
JDBC Dynamic Query Execution
MySQL Database Design
Python Data Analytics
Streamlit Dashboard Development
AI System Architecture
📸 Screenshot Folder Structure
screenshots/
 ├── dashboard.png
 ├── analytics.png
 ├── api-response.png
 ├── ai-flow.png
 ├── controller.png
 ├── service.png
👨‍💻 Developer

Car Sales AI Advisor Project
Built with ⚙️ Spring Boot + 🧠 AI + 🐍 Python

⭐ Project Status

✔ Completed
✔ Fully Functional
✔ Portfolio Ready
✔ Recruiter Friendly

📜 License

This project is developed for learning and educational purposes only.
