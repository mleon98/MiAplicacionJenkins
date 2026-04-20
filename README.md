# Ecosistema Profesional de Automatización de Pruebas - ML Sistemas

Este proyecto representa una solución integral de QA Automation que integra control de versiones, gestión de dependencias, pruebas unitarias atómicas, BDD (Behavior Driven Development), pruebas de performance y un pipeline de Integración Continua (CI).

## 1. Objetivos del Proyecto (Actividad 1 y 2)
*   **Fase 1: Arquitectura**: Establecer la arquitectura base con Maven y JUnit 5.
*   **Fase 2: BDD y Colaboración**: Implementar sesiones 'Three Amigos' y escenarios Gherkin (Calculadora y Autenticación).
*   **Fase 3: Performance**: Validar rendimiento bajo carga con JMeter y definir SLAs.
*   **Visibilidad**: Generar reportes navegables y dashboards de métricas.

## 2. Simulación 'Three Amigos' (Actividad 2)
Se realizó una sesión de descubrimiento para la funcionalidad de **Login**. 
*   **Documentación**: Ver el detalle en [three-amigos-login.md](docs/three-amigos-login.md).
*   **Roles**: Product Owner, Desarrollador y QA colaboraron para definir los ejemplos y criterios de aceptación.

## 3. Pruebas BDD (Gherkin)
Se implementaron escenarios complejos, incluyendo el uso de **Scenario Outlines** para la validación de múltiples juegos de datos.
*   **Archivos**: 
    *   `src/test/resources/features/login.feature` (Autenticación)
    *   `src/test/resources/features/calculadora.feature` (Cálculos)

## 4. Ejecución y Reportabilidad
El proyecto genera reportes automáticos en cada ejecución:
*   **Unitarias/BDD**: Reporte HTML via `maven-surefire-report-plugin`.
*   **Performance**: Dashboard interactivo detallado (JMeter).
*   **CI/CD**: Los reportes se publican como artefactos en GitHub Actions después de cada ejecución de `mvn verify`.

## 5. Estrategia de Monitoreo y Alertas
Para un entorno productivo, el sistema propone:
*   **Métricas**: TPS, Latencia (P95) y Tasa de Error integrados en Dashboards (Grafana).
*   **Alertas**: Notificaciones automáticas via Webhooks cuando se degradan los SLAs o falla el pipeline.
*   **Detalle**: Ver estrategias en [dashboards-and-alerts.md](docs/dashboards-and-alerts.md).

## 6. Comandos de Ejecución
```powershell
# Ejecutar todo el conjunto de pruebas
mvn clean verify

# Alternativa con JAVA_HOME configurado (Entorno Local)
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\jbr"; & "C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\plugins\maven\lib\maven3\bin\mvn.cmd" clean verify
```

## 7. Estructura del repositorio
```text
qa-automation-taller/
├── .github/workflows/          # Pipeline CI
├── docs/                       # Sesión Three Amigos y Estrategia de Alertas
├── src/
│   ├── main/java/com/mlsistemas/core/   # Lógica Business
│   └── test/
│       ├── java/com/mlsistemas/         # Tests Unitarios y Steps
│       ├── jmeter/                      # Planes de Carga
│       └── resources/features/          # Escenarios Gherkin
├── pom.xml                     # Configuración Maven
└── README.md                   # Documentación principal
```

---
*Desarrollado para la Evaluación de Automatización de Pruebas - Iplacex.*
