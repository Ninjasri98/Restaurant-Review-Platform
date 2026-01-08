# 🎟️ Restaurant Review Platform

A web-based platform that enables users to discover local restaurants, read authentic reviews from other diners, share their own dining experiences through detailed reviews and ratings. The platform will help users make informed decisions about where to eat by providing comprehensive restaurant information and user-generated content.

---

## 👥 Technical Considerations

- Geospatial functionality for restaurant location
- Image Upload & Display
- User authentication
- Review management system
- Sorting and filtering capabilities
- Business logic for review submission and editing

---

## 👥 Core Domain Objects

### 1. **Users**
The User object represents registered users of the platform. We're keeping this minimal since authentication will be
handled by Keycloak:
- Basic identification (ID, name, email)
- Can create restaurants (as an owner)
- Can write reviews for restaurants

### 2. **Restaurant**
The Restaurant entity is central to our platform:
- Core details (name, cuisine type, contact information)
- Average rating (calculated from reviews)
- Contains complex nested objects:
    - Address (including geolocation)
    - Operating hours
    - Photos
    - Reviews


### 3. **Reviews**
Reviews capture user experiences:
- Written content
- Numerical rating (1-5 stars)
- Metadata (author, posting date, last edit date)
- Can include multiple photos
- Editable within 48 hours of posting

---

## 🧩 Key Features

### ✅ Home Page
The homepage features a navigation bar with a login button that integrates with Keycloak for authentication.
Below the navigation, restaurant cards display essential information including:
- An image of the restaurant
- The restaurant's name
- A 0-5 star rating
- The type of cuisine served

### 💳 Restaurant Details Page
When users click a restaurant card, they're taken to a detailed view that includes:
- A prominent restaurant image
- An interactive map showing the restaurant's location
- The restaurant's average review rating
- A sortable list of customer reviews
- A "Write Review" button (requires authentication)
- 
The review submission form allows users to:
- Select a star rating
- Write their review content
- Upload photos of their experience
- Submit their review

### 🛂 Search and Navigation
The platform includes several ways to find restaurants:
- A search bar for text-based queries
- Cuisine type filtering
- Star rating filters
- Pagination controls for browsing results
  
Restaurant owners can add new establishments through a dedicated form accessed via the top navigation menu,
which includes fields for:
- Restaurant details
- Operating hours
- Location information

---

## ⚙️ Tech Stack & Architecture

### Frontend (`/frontend`)
- Provides the user interface
- Handles client-side interactions
- Communicates with backend via REST API
- React (Typescript) with TailWind CSS

### Backend (`/restaurant`)
- Java 21
- Spring Boot 3.5.4
- Core of our implementation
- Processes business logic
- Manages data flow between frontend and persistence layer
- Handles authentication and authorization
- Exposes REST API endpoints

### Elasticsearch
- Serves as our persistence layer
- Stores all primary data
- Provides advanced search capabilities

### Keycloak Server
- Manages authentication and user management
- Implements OAuth 2 and OpenID Connect standards
- Integrates with Spring Security
- Handles user creation and managemen

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/Ninjasri98/Restaurant-Review-Platform.git
cd foodscope
```

### 2. Start the backend
```bash
cd tickets
docker-compose up
./mvnw spring-boot:run
```

### 3. Start the frontend
```bash
cd ../frontend
npm install
npm run dev
```

