# Birth Day API

A simple API built with Spring Boot to upload and display images. This project is integrated with PostgreSQL as the database and Cloudinary for image file storage.

## Features

-   Upload images with captions.
-   Display a list of all uploaded images.
-   Interactive API documentation using Swagger UI.

## Tech Stack

-   **Backend:** Java 17, Spring Boot 3
-   **Database:** PostgreSQL
-   **Image Storage:** Cloudinary
-   **Build Tool:** Maven
-   **Containerization:** Docker

## How to Run the Project

1.  **Clone this repository:**
    ```bash
    git clone https://github.com/fahmi-dot/birth-day-api.git
    cd birth-day-api
    ```

2.  **Configure the Environment**

    Create a `.env` file in the project's root directory. You can copy it from `.env.example` (if it exists) or create it manually. Fill in the required variables:

    ```env
    # PostgreSQL Database Configuration
    DATABASE_URL=jdbc:postgresql://localhost:5432/your_database_name
    DATABASE_USERNAME=your_database_username
    DATABASE_PASSWORD=your_database_password

    # Cloudinary Configuration
    CLOUDINARY_CLOUD_NAME=your_cloudinary_cloud_name
    CLOUDINARY_API_KEY=your_cloudinary_api_key
    CLOUDINARY_API_SECRET=your_cloudinary_api_secret
    ```

3.  **Running the Application (Locally)**

    You can run the application using the Maven wrapper:

    ```bash
    ./mvnw spring-boot:run
    ```

    The application will be running at `http://localhost:8080`.

4.  **Running the Application (Docker)**

    Ensure Docker is running on your system.

    -   **Build the Docker image:**
        ```bash
        docker build -t birth-day-api .
        ```

    -   **Run the Docker container:**
        ```bash
        docker run -p 8080:8080 --env-file .env birth-day-api
        ```
        *Note: This command assumes all environment variables are defined in the `.env` file.*

## API Documentation

This project includes Swagger UI for interactive API documentation. Once the application is running, you can access it in your browser:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Here are the main available endpoints:

-   `POST /image`
    -   **Description:** Uploads a new image.
    -   **Request Body:** `multipart/form-data`
        -   `caption` (String): A caption or description for the image.
        -   `file` (File): The image file to be uploaded.
    -   **Response:** `200 OK` on success.

-   `GET /image`
    -   **Description:** Retrieves a list of all images.
    -   **Response:** `200 OK` with a JSON array of image data.
      ```json
      [
          {
              "id": "uuid",
              "caption": "Sample Caption",
              "imageUrl": "http://link-to-image.com/image.jpg"
          }
      ]
      ```