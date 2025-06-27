# 🧠 Spring Boot Job Scheduler

A real-time job scheduling REST API built with Java + Spring Boot.  
Schedule jobs with custom delay and priority using an in-memory queue.

---

### 🚀 Live Demo

[![Deployed on Render](https://img.shields.io/badge/render-live-success?logo=render&style=flat-square)](https://springboot-job-scheduler.onrender.com)

- 🌐 **Base URL**:  
  `https://springboot-job-scheduler.onrender.com`

- 📘 **Swagger UI**:  
  [https://springboot-job-scheduler.onrender.com/swagger-ui/index.html](https://springboot-job-scheduler.onrender.com/swagger-ui/index.html)

- 🏠 **Friendly Home Page**:  
  [https://springboot-job-scheduler.onrender.com/](https://springboot-job-scheduler.onrender.com/)

---

### 🔧 Features

- 📬 Schedule jobs with delay and priority
- ⏳ Background executor checks every second
- ⚙️ Uses `PriorityQueue` for in-memory scheduling
- 📘 REST API documented with Swagger UI
- 🏠 Custom landing page with helpful links
- ☁️ Deployed to Render (Free Tier)

---

### 📬 API Endpoints

| Method | Endpoint         | Description                      |
|--------|------------------|----------------------------------|
| POST   | `/jobs`          | Schedule a new job               |
| GET    | `/jobs`          | List all pending jobs            |
| DELETE | `/jobs/{name}`   | Cancel a scheduled job by name   |

---

### 🧪 Sample Request: `POST /jobs`

```json
{
  "name": "Send Reminder Email",
  "delaySeconds": 10,
  "priority": 1
}
