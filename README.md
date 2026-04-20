# Ecosistema Profesional de Automatización de Pruebas - ML Sistemas

Este proyecto representa una solución integral de QA Automation que integra control de versiones, gestión de dependencias, pruebas unitarias atómicas, BDD (Behavior Driven Development), pruebas de performance y un pipeline de Integración Continua (CI).

## 1. Objetivos del Proyecto (Actividad 1 y 2)
*   **Fase 1: Arquitectura**: Establecer la arquitectura base con Maven y JUnit 5.
*   **Fase 2: BDD y Colaboración**: Implementar sesiones 'Three Amigos' y escenarios Gherkin (Calculadora y Autenticación).
*   **Fase 3: Performance**: Validar rendimiento bajo carga con JMeter y definir SLAs.
*   **Visibilidad**: Generar reportes navegables y dashboards de métricas.
*   **Guía Detallada**: Ver el [Paso a Paso del Proyecto](docs/GUIA_PASO_A_PASO.md) para el detalle técnico de la implementación.

## 2. Simulación 'Three Amigos' (Actividad 2)
Se realizó una sesión de descubrimiento para la funcionalidad de **Carrito de Compras**. 
*   **Documentación**: Ver el detalle en [MINUTA_THREE_AMIGOS.md](docs/MINUTA_THREE_AMIGOS.md).
*   **Roles**: Product Owner (Esthela), Desarrollador (Carlos) y QA (Pedro) colaboraron para definir los criterios de aceptación.

## 3. Pruebas BDD (Gherkin)
Se implementaron escenarios complejos utilizando Gherkin, incluyendo el uso de **Scenario Outlines** (Esquemas de escenario) para validaciones de stock y límites.
*   **Nuevos Archivos**: 
    *   `src/test/resources/features/carrito.feature`
    *   `src/test/java/com/mlsistemas/stepdefinitions/CarritoSteps.java`
*   **Existentes**: `login.feature`, `calculadora.feature`.

## 4. Pruebas de Performance (JMeter)
Se diseñó un plan de carga para el flujo de compra:
*   **Escenario**: Simulation de Login y Agregar al Carrito.
*   **Métricas Monitoreadas**: TPS (Transacciones por segundo), Latencia (Latencia variable simulada) y Tasa de Errores (2% de error simulado en stock).
*   **Archivo**: `src/test/jmeter/performance-test-ecommerce.jmx`.

## 5. Estrategia de Monitoreo y Alertas
Se documentó la integración de métricas en dashboards y la configuración de alertas automáticas:
*   **Detalle**: Ver estrategias en [DASHBOARDS_Y_ALERTAS.md](docs/DASHBOARDS_Y_ALERTAS.md).

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
