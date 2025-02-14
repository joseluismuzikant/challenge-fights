# ✈️ Flight Booking API

🚀 A **Spring Boot 3.4.2 REST API** for managing flight bookings, handling availability, and preventing overbooking.

## 📌 Features

✔️ **RESTful Endpoints** for searching, booking, and canceling flights.  
✔️ **Database Integration** with **H2/PostgreSQL** for flight and booking records.  
✔️ **Optimistic Locking** to prevent overbooking.  
✔️ **JWT Authentication** for securing booking endpoints.  
✔️ **Cache Mechanism** for improving API response times.  
✔️ **Booking Expiry Mechanism** (auto-cancel unconfirmed bookings after **15 minutes**).

## ⚙️ Tech Stack

- **Spring Boot 3.4.2**
- **JDK 21**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **H2/PostgreSQL**
- **Spring Cache**
- **Lombok**
- **Docker (optional)**

## 📖 API Endpoints

### ✈️ Flights

| Method | Endpoint      | Description                   |
|--------|-------------|-------------------------------|
| `GET`  | `/flights`  | Get available flights        |

### 🎫 Bookings

| Method   | Endpoint          | Description                           |
|----------|------------------|---------------------------------------|
| `POST`   | `/bookings`       | Create a new booking                 |
| `GET`    | `/bookings/{id}`  | Retrieve booking details             |
| `DELETE` | `/bookings/{id}`  | Cancel a booking                     |

## 📦 Installation & Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/joseluismuzikant/challenge-fights.git
cd challenge-fights
