# 🤖 Spring AI Agent – Chat, Movies & Image Generator

This project is a Spring Boot application demonstrating how to use **Spring AI** to integrate:

1. ✅ Generic chat interface with memory
2. 🎬 Movie-specific structured answers
3. 🖼️ AI-powered image generation via DALL·E 3

---

## 📚 Features

- 🧠 Conversational AI (`/chat`) – returns uppercase answers
- 🎬 Movie domain expert (`/askAgent`) – returns a `MovieList` (structured JSON)
- 🖼️ Image generation (`/generateImage`) – returns a DALL·E-generated image URL

---

## 🛠️ Technologies

- Java 17+
- Spring Boot 3.x
- [Spring AI](https://docs.spring.io/spring-ai/)
- OpenAI GPT & DALL·E 3

---

## 🚀 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/Elhajbi/Spring-AI-Agent
cd spring-ai-agents
```
## 2. Configure `application.properties`

```properties
spring.ai.openai.api-key=sk-xxxxxxxxxxxx
spring.ai.openai.chat.model=gpt-4
spring.ai.openai.image.model=dall-e-3
```
## ▶️ Run the App

```bash
./mvnw spring-boot:run
```
## 📡 API Endpoints
## 🧠 /chat
## Chat with the AI (uppercase responses):
```bash
curl "http://localhost:8080/chat?query=bonjour"
```
## 📤 Response:
```bash
BONJOUR À VOUS !
```
## 🎬 /askAgent
Structured response about movies:
```bash
curl "http://localhost:8899/askAgent?query=recommande moi 2 films"
```
## 📤 JSON:
```bash
{
  "movies": [
    { "title": "Inception", "genre": "Sci-Fi", "year": 2010 },
    { "title": "The Matrix", "genre": "Sci-Fi", "year": 1999 }
  ]
}
```
## 🖼️ /generateImage
Generate a high-quality image from a prompt using DALL·E 3:
```bash
curl "http://localhost:8080/generateImage?prompt=un%20chien%20dans%20une%20montagne"
```
## 📤 Response:
```bash
https://image.openai.com/generated-image-url-here.png
```
## ✍️ Author
Abdelkarim El Hajbi
