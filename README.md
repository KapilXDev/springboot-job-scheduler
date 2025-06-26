# 🧠 Spring Boot Job Scheduler

A simple yet powerful in-memory job scheduler built with Java and Spring Boot. Schedule background tasks with delay and priority — perfect for backend job processing, queueing systems, or cron-like scheduling.

---

### 🚀 Live Demo

[![Deployed on Render](https://img.shields.io/badge/render-live-success?logo=render&style=flat-square)](https://springboot-job-scheduler.onrender.com)

🔗 **API Base URL**:  
`https://springboot-job-scheduler.onrender.com`

📘 **Swagger UI**:  
[https://springboot-job-scheduler.onrender.com/swagger-ui/index.html](https://springboot-job-scheduler.onrender.com/swagger-ui/index.html)

---

### 🔧 Features

- 📬 Schedule jobs with a delay and priority
- ⚙️ In-memory `PriorityQueue` to manage execution order
- 🔁 Background job runner executes jobs at the right time
- 🌐 REST API with Swagger documentation
- ☁️ Deployed on [Render](https://render.com)

---

### 📬 API Endpoints

| Method | Endpoint           | Description                      |
|--------|--------------------|----------------------------------|
| POST   | `/jobs`            | Schedule a new job               |
| GET    | `/jobs`            | List all scheduled jobs          |
| DELETE | `/jobs/{name}`     | Cancel a scheduled job by name   |

---

### 📤 Example Request (POST /jobs)

```json
{
  "name": "Email Reminder",
  "delaySeconds": 10,
  "priority": 1
}
