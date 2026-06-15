# 🚗 Car Sales Analytics + AI Advisor
Spring Boot + AI + Python Library Full-Stack Analytics System
- This project is a data-driven Car Sales Dashboard built using SpringBoot, RestAPIs, Streamlit, Matplot, and data visualization libraries. 
- It helps analyze car sales data through an interactive web interface, providing insights such as monthly sales trends, yearly performance, and overall market behavior.

- The dashboard allows users to upload CSV files, explore data dynamically, and visualize key business metrics in real-time.
- It is designed to make car sales data easy to understand for both technical and non-technical users.

An end-to-end AI-powered Car Sales Analytics & Recommendation System that combines:

---

## 📌 Project Overview

The Car Sales AI Advisor is a real-world intelligent analytics system built using:

* ⚙️ Spring Boot (Backend APIs)
* 🧠 Spring AI + LLaMA (Ollama Local AI)
* 🐍 Python (Data Analytics & Visualization)
* 📊 Streamlit (Interactive Dashboard)
* 🗄️ MySQL (Database)

---

## 🏠 Application Preview
### 📊 Dashboard UI

| Module               | URL                                               |
| -------------------  | ------------------------------------------------- |
| 🏠 Main Application  | http://localhost:8501/#yearly-car-sales-analysis  |

<img src="https://github.com/user-attachments/assets/ed2978e6-04aa-4c9a-9d33-280716e8960d" width="800"/>

---

## 🌟 Key Highlights

* AI converts natural language → SQL
* Real-time database-driven insights
* Car sales analytics (yearly/monthly trends)
* AI-based car recommendation system
* CSV upload & processing
* Interactive dashboard (Streamlit)
* Clean layered Spring Boot architecture
* End-to-end full-stack AI system

---

## 🏗️ System Architecture
```
 * 👤 User (Streamlit UI)
         ↓
 *🐍 Python (Pandas + Requests)
         ↓
* ⚙️ Spring Boot REST APIs
         ↓
* 🧠 Spring AI (LLaMA via Ollama)
         ↓
* 🔄 SQL Generation Engine
         ↓
* ⚡ Spring JDBC Executor
         ↓
* 🗄️ MySQL Database
         ↓
* 🤖 AI Response Formatter
         ↓
* 📊 Streamlit Dashboard
```
---

## 📸 Application Screenshots

- 📌 Add your screenshots here

### 🖥️ Dashboard UI (Streamlit)

| Module               | URL                                              |
| -------------------  | ------------------------------------------------ |
| 🏠 Main Application  | http://localhost:8501/#yearly-car-sales-analysis |

![Dashboard](https://github.com/user-attachments/assets/71ad003b-bf2e-4a1b-99a1-215474df345c)

---

### 📈 Yearly Car Sales Analysis
| Module               | URL                                              |
| -------------------  | ------------------------------------------------ |
| 📊 Year Sales Graph  | http://localhost:8080/api/car-sales/yearly-count |

![Year Wise Count](https://github.com/user-attachments/assets/3b22bfc2-be31-4283-8597-b0f4d424de2a)

--- 
### 📅 Monthly Sales Analysis
| Module                | URL                                                         |
| -------------------   | ----------------------------------------------------------- |
| 📊 Month Sales Graph  | http://localhost:8080/api/car-sales/monthly-count?year=2024 |

![Monthly Sales](https://github.com/user-attachments/assets/748f7657-541b-41c2-8ebd-bdf482a02cb6)

---
### jyupter Notebook

![Jupyter Notebook](https://github.com/user-attachments/assets/ce5c8389-a7c1-4533-91c5-af25c01c7b62)

---

## ⚙️ Spring Boot API Response

-📍 URL: http://localhost:8080/api/car-sales

👉 View API Screenshot

| Module               | URL                                                         |
| -------------------  | ----------------------------------------------------------- |
| 📊 Year Sales Graph  | http://localhost:8080/api/car-sales/monthly-count?year=2024 |
| 📊 Month Sales Graph | http://localhost:8080/api/car-sales/monthly-count?year=2024 |
| 📊 Upload csv        | http://localhost:8080/api/car-sales/upload-csv              |

  ![API](https://github.com/user-attachments/assets/ffa96fcb-2f5d-4c8a-a6a9-893aa55b776a)
   
---

## 🧠 AI Query Flow

-📍 URL: localhost:8080/api/ai/ask

👉 Query Generate
![Query](https://github.com/user-attachments/assets/744ed645-ab89-4e1e-99a8-82c7d413dcad)

---

## 🧩 Tech Stack

###⚙️ Backend  
- Java 17+  
- Spring Boot  
- Spring AI  
- Spring JDBC  
- REST APIs

---

### 🧠 AI Layer
- Ollama
- LLaMA 3 (Local LLM)
- Spring AI ChatClient

  ---

### 🗄️ Database
- MySQL

---

### 🐍 Data & Visualization
- Plotly
- Matplotlib
- Jupyter Notebook

---

### 🎨 Frontend
- Streamlit

---

### 🔐 Core Features

### 📊 Data Pipeline
- CSV upload via API
- Data validation & cleaning
- Store into MySQL database

---

### ⚙️ Backend System
- REST API architecture
- Controller → Service → Repository flow
- Global Exception Handling
- Standard API Response structure


---

### 🧠 AI Intelligence
- Natural language input
- AI generates SQL dynamically
- Spring JDBC executes queries
- AI formats final response
---

### 📈 Analytics Dashboard
- Year-wise sales analysis
- Monthly trend analysis
- Interactive graphs

---

### 🔑 Key Functionalities

- CRUD Operations
- File Upload System
- AI Query System
- Session-like flow via API
- Database-driven architecture
- Clean MVC-style backend design

---

## 📂 Project Structure
```bash
Car-Sales-AI-Advisor/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── entity/
│       │   ├── dto/
│       │   ├── exception/
│       │   └── config/
│       │
│       └── resources/
│           ├── templates/
│           ├── static/
│           └── application.properties
│
├── ai-python/
│   ├── streamlit-app/
│   ├── notebooks/
│   └── visualization/
│
├── database/
│   └── schema.sql
│
├── screenshots/
│   ├── dashboard.png
│   ├── analytics.png
│   ├── api-response.png
│   ├── ai-flow.png
│   ├── controller.png
│   └── service.png
│
└── README.md
```
 ---
 ## 🚀 How to Run Locally
 
### 1️⃣ Clone Repository
```bash id="clone01"
git clone [https://github.com/your-username/car-sales-ai-advisor.git]
```
---

### 2️⃣ Configure Database

Update `application.properties`

```properties id="dbconfig01"
spring.datasource.url=jdbc:mysql://localhost:3306/carsales
spring.datasource.username=root
spring.datasource.password=Saurav@123
```
---

### 3️⃣ Run Spring Boot Backend
Excute:

```bash id="runapp01"
Backend runs on:

http://localhost:8081
```
---
### 4️⃣ Run Streamlit UI

```bash id="stream02"
streamlit run app.py
UI runs on:

http://localhost:8501
```
---

## 📊 Engineering Highlights

* Real AI integration (not chatbot only)
* Dynamic SQL generation using LLM
* Full-stack Spring Boot + Python system
* Production-level backend structure
* Real-time analytics dashboard
* End-to-end intelligent workflow

---

### 🎯 Skills Demonstrated
* Spring Boot Development
* Spring AI Integration
* JDBC Dynamic Query Execution
* MySQL Database Design
* Python Data Analytics
* Streamlit Dashboard Development
* AI System Architecture

---

## 📸 Project Structure
```bash id="projectstructure01"
screenshots/
 ├── dashboard.png
 ├── analytics.png
 ├── api-response.png
 ├── ai-flow.png
 ├── controller.png
 ├── service.png
👨‍💻 Developer
```
---

## Car Sales AI Advisor Project
✔ Built with ⚙️ Spring Boot + 🧠 AI + 🐍 Python

---

## 👨‍💻 Developer

**Saurav Kumar**
Java | Spring Boot | Backend Developer | REST APIs | MATTPLOT| Juypter notebook | My SQL

---

## ⭐ Project Status

* Completed
* Fully Functional
* Recruiter Friendly

---

## 📜 License

This project is developed for learning and educational purposes only.
