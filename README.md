# Ecosistema Profesional de Automatización de Pruebas - ML Sistemas

Este proyecto representa una solución integral de QA Automation que integra control de versiones, gestión de dependencias, pruebas unitarias atómicas, BDD (Behavior Driven Development), pruebas de performance y un pipeline de Integración Continua (CI).

## 1. Objetivos del Proyecto
*   **Fase 1**: Establecer la arquitectura base con Maven y JUnit 5, garantizando la idempotencia y atomicidad de las pruebas unitarias.
*   **Fase 2**: Implementar el enfoque BDD con Cucumber y Gherkin para mejorar la comunicación entre los stakeholders técnicos y de negocio.
*   **Fase 3**: Validar el rendimiento del sistema bajo carga utilizando JMeter y definir métricas de calidad (SLAs).
*   **Pipeline CI**: Automatizar todo el ciclo de vida (compilación, testeo y reportabilidad) mediante GitHub Actions.

## 2. Comandos Principales
Para ejecutar el ciclo de vida completo (incluyendo unitarias, BDD y performance), utiliza el siguiente comando desde la carpeta raíz del proyecto:

```powershell
mvn clean verify
```

*Nota: Debido a la configuración local del entorno, se recomienda especificar explícitamente el JAVA_HOME si no está en el PATH:*
```powershell
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\jbr"; & "C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\plugins\maven\lib\maven3\bin\mvn.cmd" clean verify
```

## 3. Estructura del Proyecto
El proyecto sigue la estructura estándar de Maven, extendida para BDD y Performance:

```text
qa-automation-taller/
├── .github/workflows/          # Definición del Pipeline de CI
├── docs/                       # Documentación técnica y métricas (SLAs)
├── src/
│   ├── main/java/              # Código fuente (Clase Calculadora)
│   └── test/
│       ├── java/
│       │   ├── core/           # Pruebas unitarias JUnit 5
│       │   ├── stepdefinitions/# Implementación de pasos Gherkin (Glue code)
│       │   └── runners/        # Orquestador para Cucumber
│       ├── jmeter/             # Escenarios de carga (.jmx)
│       └── resources/features/ # Especificación en Gherkin (Español)
├── pom.xml                     # Gestión de dependencias y plugins
└── README.md                   # Documentación principal del sistema
```

## 4. Archivos Clave y Funcionalidad
*   **`pom.xml`**: Corazón del proyecto. Gestiona JUnit 5, Cucumber 7, el plugin de JMeter y la generación de reportes HTML.
*   **`Calculadora.java`**: Lógica de negocio core (Suma y Resta).
*   **`CalculadoraTest.java`**: Garantiza que los métodos core funcionen de forma independiente (Idempotencia).
*   **`calculadora.feature`**: Especificación legible de casos de uso en español.
*   **`load-test-calculadora.jmx`**: Escenario de JMeter para medir tiempos de respuesta y tasas de error bajo carga.

## 5. Explicación del Pipeline (CI)
Ubicado en `.github/workflows/ci.yml`, el pipeline se dispara automáticamente en cada `push` o `pull_request`.
1.  **Entorno**: Corre sobre agentes `ubuntu-latest`.
2.  **JDK 17**: Configura el entorno Java necesario.
3.  **Ejecución**: Ejecuta `mvn clean test surefire-report:report`.
4.  **Artefactos**: Publica el reporte de pruebas navegable (Surefire) como un artefacto descargable de GitHub, asegurando la trazabilidad de los fallos.

## 6. Métricas y SLAs (Fase 3)
Se han definido umbrales de aceptación para el performance:
- **Tasa de Error**: < 1%.
- **Latencia promedio**: < 500ms.
El pipeline marcará la falla de la construcción (build) si estos criterios no se cumplen.

---
*Desarrollado para la Evaluación de Automatización de Pruebas - Iplacex.*
