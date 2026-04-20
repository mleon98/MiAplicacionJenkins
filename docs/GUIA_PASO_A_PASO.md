# Guía Paso a Paso: Implementación del Ecosistema de QA Automático

Este documento detalla secuencialmente los pasos realizados para completar las Actividades 1 y 2 de la evaluación.

---

## 1. Inicialización y Arquitectura (Actividad 1)
- **Paso 1.1:** Inicialización del repositorio Git mediante `git init` para habilitar el control de versiones.
- **Paso 1.2:** Creación de la estructura de carpetas estándar de Maven:
    - `src/main/java`: Para el código fuente de la aplicación.
    - `src/test/java`: Para el código de las pruebas.
    - `src/test/resources/features`: Para los escenarios BDD en lenguaje Gherkin.
- **Paso 1.3:** Configuración del `pom.xml` con las dependencias críticas:
    - **JUnit 5 Jupiter**: Para pruebas unitarias atómicas.
    - **Cucumber Java & JUnit Platform Engine**: Para la ejecución de escenarios BDD.
    - **JMeter Maven Plugin**: Para orquestar pruebas de carga desde el ciclo de vida de Maven.

## 2. Implementación de Lógica y Pruebas Unitarias
- **Paso 2.1:** Creación de la clase `Calculadora` con métodos base de aritmética (suma, resta).
- **Paso 2.2:** Codificación de `CalculadoraTest.java`, implementando pruebas independientes que utilizan `@BeforeEach` para asegurar que cada test sea atómico y no dependa de estados previos.

## 3. Estrategia Colaborativa BDD (Actividad 2)
- **Paso 3.1:** **Simulación Three Amigos**: Se definió la funcionalidad de "Carrito de Compras" integrando las perspectivas de Negocio (PO), Desarrollo y QA. El resultado fue la `MINUTA_THREE_AMIGOS.md`.
- **Paso 3.2:** **Diseño de Escenarios**: Se redactaron los archivos `.feature` en español, definiendo criterios de aceptación claros y utilizando un **Scenario Outline** con tablas de ejemplos para validar casos de borde (sin stock, límite de unidades, éxito).
- **Paso 3.3:** **Desarrollo de Step Definitions**: Se crearon las clases Java que "traducen" el lenguaje natural de Gherkin en lógica ejecutable mediante anotaciones `@Dado`, `@Cuando` y `@Entonces`.

## 4. Pruebas de Performance y Carga
- **Paso 4.1:** Creación del plan de pruebas JMeter `performance-test-ecommerce.jmx`.
- **Paso 4.2:** Inserción de lógica Groovy (JSR223) para simular latencias de red y tasas de error aleatorias, permitiendo una prueba de carga realista.
- **Paso 4.3:** Configuración del plugin de Maven para generar automáticamente el **Dashboard HTML de JMeter** tras cada ejecución exitosa.

## 5. Pipeline de Integración Continua (CI)
- **Paso 5.1:** Creación de `.github/workflows/ci.yml`.
- **Paso 5.2:** Definición del workflow para que en cada `push`:
    - Se compile el proyecto.
    - Se ejecuten los tests unitarios.
    - Se ejecuten los escenarios de Cucumber.
    - Se ejecute el plan de JMeter.
    - Se publiquen los reportes resultantes como artefactos descargables.

## 6. Monitoreo y Alertas
- **Paso 6.1:** Documentación de la estrategia de observabilidad en `DASHBOARDS_Y_ALERTAS.md`, explicando la integración con herramientas como Grafana y Slack para recibir notificaciones proactivas ante fallos.

## 7. Consolidación de Resultados
- **Paso 7.1:** Ejecución del comando `mvn clean verify` para validar el 100% de los componentes.
- **Paso 7.2:** Generación del **Informe Técnico Final** en formatos Markdown y HTML para la entrega de la evaluación.
- **Paso 7.3:** Sincronización de todo el ecosistema al repositorio remoto de GitHub.
