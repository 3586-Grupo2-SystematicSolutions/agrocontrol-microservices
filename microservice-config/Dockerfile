# Usa Amazon Corretto 21 (Java 21) sobre Alpine
FROM amazoncorretto:21-alpine-jdk

# Directorio de trabajo en el contenedor
WORKDIR /app

# Expone el puerto 8888 (como se define en application.yml)
EXPOSE 8888

# Copia el archivo .jar a la imagen
ADD ./target/microservice-config-0.0.1-SNAPSHOT.jar microservice-config.jar

# Copia configuraciones externas necesarias (para perfil native)
COPY src/main/resources/configurations ./configurations

# Ejecuta la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "microservice-config.jar"]
