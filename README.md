# 📋💸 BudgetPartner - Backend de app de gastos con SpringBoot 🌱


BudgetPartner es una aplicación móvil desarrollada con [Expo](https://expo.dev) que te ayuda a gestionar tus planes y presupuestos personales o grupales de manera eficiente.


## ⚙️ Requisitos previos

- Java 17 o superior  
- Maven 3.8+  
- PostgreSQL
- IDE compatible con Spring (IntelliJ, VS Code, Eclipse)  
- Docker (opcional, para desarrollo o despliegue en contenedor de las pruebas)
- Ollama (opcional, para el uso de IA en local)  

---

## 🚀 Comenzar

### 1. Clonar el repositorio

```bash
git clone https://github.com/josecmcinco/BudgetPartner-Back.git
cd BudgetPartner-Back
```

###2. Configurar variables de entorno

   ```bash
   # Copia el archivo de ejemplo y renómbralo a .env
   cp .env.example .env
   
   # Edita el archivo .env con tus valores
   ```
###3. Descargar `qwen3:4b` con ollama o cambiar el modelo a usar

   ```bash
   # Descargar el modelo de IA generativa por defecto
   ollama pull qwen3:8b
   ```
   ```application.properties
   # Cambiar el nombre del modelo por otro descargado con ollama
   spring.ai.ollama.chat.options.model = qwen3:4b
   ```

4. Iniciar la aplicación

   ```bash
   ./mvnw spring-boot:run
   ```

Cuando inicies la app podrás añadir los siguientes parámetros:

- `--borrar` -> borra la base de datos
- `--poblar` -> puebla la base de datos usando el archivo /admin/PobladorDB



## Estructura del proyecto

El proyecto utiliza [file-based routing](https://docs.expo.dev/router/introduction) y está organizado de la siguiente manera:

- `/admin`: Funciones administrativas del sistema.
- `/config`: Configuración general de la aplicación.
- `/controller`: Endpoints y rutas REST.
- `/dto`: Objetos de transferencia de datos.
- `/entity`: Entidades JPA (modelo de datos).
- `/enums`: Enumeraciones del dominio.
- `/exceptions`: Manejo de errores y excepciones.
- `/mapper`: Conversión entre entidades y DTOs.
- `/repository`: Acceso a base de datos.
- `/security`: Autenticación y autorización.
- `/service`: Lógica de negocio.


## Recursos útiles

(PENDIENTE)
