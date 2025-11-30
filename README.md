# 📥 File Download Manager (Java)

A multi-threaded **File Download Manager** built using **Java**, **ExecutorService**, and **HttpURLConnection**.  
This project allows you to download multiple files in parallel, manage download tasks efficiently, and handle file validations in a clean and modular way.

## 🚀 Features

- ✔ Download multiple files simultaneously  
- ✔ URL validation using `HEAD` request  
- ✔ Auto-create destination directory  
- ✔ Clean separation of logic: Manager, Task, Utilities  
- ✔ Multithreaded architecture using `ExecutorService`  
- ✔ Proper exception handling  
- ✔ Beginner-friendly and scalable codebase  

---

## 🛠️ Tech Stack

- **Java 17+**
- **ExecutorService (Concurrency API)**
- **HttpURLConnection**
- **I/O Streams**
- **Java NIO (Files, Paths)**

---

## 📂 Project Structure
src/
└── com.managerDownload/
├── DownloadManager.java     # Controls the overall download flow
├── DownloadTask.java        # Single file download task (Callable)
├── DownloadUtils.java       # Network + file handling helpers

---

## ⚙️ How It Works

### 1️⃣ DownloadManager  
- Accepts multiple file URLs  
- Creates multiple `DownloadTask` objects  
- Uses a **thread pool** to download files in parallel  
- Collects results using `Future` objects  

### 2️⃣ DownloadTask  
- Implements `Callable<String>`  
- Calls the actual download logic  
- Returns status of each download  

### 3️⃣ DownloadUtils  
- Validates URLs  
- Handles GET requests  
- Downloads file data using streams  
- Creates destination folder if not found  

---

## ▶️ How to Run

1. Clone the repository:
```bash
git clone https://github.com/your-username/FileDownloadManager.git
