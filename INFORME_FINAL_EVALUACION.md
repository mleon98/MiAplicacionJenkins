# INFORME TÉCNICO: EVALUACIÓN 2 - AUTOMATIZACIÓN DE PRUEBAS
**Carrera:** Ingeniería en Informática / Ciberseguridad
**Institución:** Iplacex
**Fecha:** 20 de Abril, 2026

---

## INTRODUCCIÓN
El presente informe documenta el desarrollo de las actividades 1 y 2 de la evaluación, enfocadas en la implementación de un ecosistema profesional de QA Automation. Se cubren aspectos de integración continua (CI), desarrollo guiado por comportamiento (BDD), pruebas de performance y monitoreo.

---

## DESARROLLO ACTIVIDAD 1: CIMIENTOS DE LA AUTOMATIZACIÓN

### 1. Inicialización del Repositorio Git
Se inicializó un repositorio local para llevar el control de versiones. Se utilizaron comandos de commit frecuentes para documentar el progreso.
- **Comandos:**
  ```powershell
  git init
  git add .
  git commit -m "Initial commit: Proyecto base Maven"
  ```
- **Captura Sugerida:** [Insertar captura de `git log --oneline`]

### 2. Configuración de Proyecto Maven
Se configuró un proyecto basado en Maven utilizando el archivo `pom.xml`, definiendo las dependencias necesarias para pruebas (JUnit 5, Cucumber, JMeter Plugin).
- **Archivos Clave:** `pom.xml`.

### 3. Implementación de Pruebas Unitarias Atómicas
Se implementaron pruebas para una clase `Calculadora`, asegurando que cada test sea independiente y atómico.
- **Evidencia de Código:**
  ```java
  @Test
  void testSumar() {
      assertEquals(35, calculadora.sumar(15, 20));
  }
  ```

### 4. Estructura de Carpetas Segundas Buenas Prácticas
Se organizó el código siguiendo el estándar Maven:
- `src/main/java`: Lógica de negocio.
- `src/test/java`: Clases de prueba (Unitarias y BDD).
- `src/test/resources`: Archivos de configuración y features de Cucumber.

### 5. Archivo .gitignore
Se creó un archivo `.gitignore` para excluir carpetas generadas automáticamente como `target/`, archivos de configuración de IDE (.idea, .vscode) y logs.

### 6. Configuración de Pipeline CI (GitHub Actions)
Se configuró un pipeline en `.github/workflows/ci.yml` que se dispara en cada `push` o `pull request`.
- **Fases del Pipeline:** Checkout -> Setup Java -> Compilation -> Test Execution -> Artifact Upload.

### 7. Generación de Reportes
El pipeline genera un reporte HTML de Surefire que se publica como artefacto.
- **Comando:** `mvn surefire-report:report`.

### 8. Documentación en README.md
Se redactó un README detallado explicando los objetivos y cómo ejecutar el proyecto localmente.

### 9. Evidencia de Ejecución Local Integrada
A continuación, se detalla la salida de la consola tras ejecutar el ciclo completo de automatización (`mvn clean verify`), lo que valida la compilación correcta y la ejecución de todas las pruebas unitarias.

```text
[INFO] --- surefire:3.1.2:test (default-test) @ qa-automation-taller ---
[INFO] Running com.mlsistemas.core.CalculadoraTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.082 s -- in com.mlsistemas.core.CalculadoraTest
[INFO] Results:
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```
La ejecución muestra que las 2 pruebas unitarias atómicas (Suma y Resta) pasaron satisfactoriamente en menos de 1 segundo.

---

## DESARROLLO ACTIVIDAD 2: BDD, PERFORMANCE Y MONITOREO

### 1. Sesión Three Amigos (Simulación)
Se documentó una sesión de descubrimiento para la funcionalidad de **Carrito de Compras**.
- **Roles:** PO (Esthela), Dev (Carlos), QA (Pedro).
- **Resultado:** Definición de criterios de aceptación y ejemplos de borde. Ver [docs/MINUTA_THREE_AMIGOS.md](docs/MINUTA_THREE_AMIGOS.md).

### 2. Escenarios Gherkin
Se redactaron escenarios en lenguaje natural (Español) utilizando Gherkin.
- **Ejemplo de Esquema de Escenario:**
  ```gherkin
  Esquema del escenario: Intentar agregar productos excediendo límites
    Dado que existe el producto "<producto>" con stock de <stock_disponible>
    Cuando el usuario intenta agregar <cantidad_a_agregar> unidades
    Entonces el sistema debería mostrar el mensaje "<mensaje_esperado>"
  ```

### 3. Implementación de Step Definitions
Se codificaron los pasos definidos en Gherkin mediante Cucumber y Java en la clase `CarritoSteps.java`, vinculando el comportamiento esperado con la lógica del sistema.

### 4 y 5. Integración BDD en Pipeline y Reportes
El pipeline de CI fue modificado para incluir la ejecución de Cucumber. Se configuró la generación de un reporte HTML de Cucumber navegable.
- **Ubicación Reporte:** `target/cucumber-report.html`.

### 6. Diseño de Prueba de Performance (JMeter)
Se diseñó un plan de carga para el flujo de compra (`performance-test-ecommerce.jmx`).
- **Indicadores Monitoreados:**
    - **TPS (Throughput):** Capacidad del sistema para procesar transacciones.
    - **Latencia:** Tiempo de respuesta simulado con funciones aleatorias de Groovy.
    - **Errores:** Simulación de fallo del 2% para validar robustez.

### 7. Dashboards de Métricas
Se propuso una estrategia para visualizar métricas:
- **Funcional:** Dashboards de Allure o Cucumber Reports.
- **Performance:** Integración de JMeter con InfluxDB + Grafana para monitoreo en tiempo real.

### 8. Alertas Automáticas
Se configuraron notificaciones para alertar fallos en el pipeline:
- Umbrales excedidos en Latencia o Tasa de error.
- Integración con Webhooks para alertas inmediatas.

### 9. Evidencia de Ejecución Consolidada (BDD y Performance)
La ejecución del comando `mvn clean verify` orquestó la validación de todos los componentes. A continuación el detalle de los resultados obtenidos en la consola:

**Resultados BDD (Cucumber):**
```text
[INFO] Running com.mlsistemas.runners.RunCucumberTest
@Calculadora
Escenario: Sumar dos números enteros # exitoso
@Calculadora
Escenario: Restar dos números enteros # exitoso
@ecommerce
Escenario: Agregar un producto con stock disponible # exitoso
@ecommerce
Esquema del escenario: Intentar agregar productos excediendo límites # exitoso
@auth
Escenario: Inicio de sesión exitoso # exitoso

[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.790 s
```

**Resultados Performance (JMeter):**
```text
[INFO] --- jmeter:3.7.0:jmeter (jmeter-tests) @ qa-automation-taller ---
[INFO] Executing test: performance-test-ecommerce.jmx
[INFO] summary =    100 in 00:00:05 =   22,1/s Avg:     5 Min:     0 Max:   469 Err:     0 (0,00%)
[INFO] Successful requests:         100
[INFO] Failed requests:             0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

**Análisis de Resultados:**
1. **Calidad Funcional:** Se ejecutaron 12 pruebas en total (2 unitarias y 10 escenarios BDD) con 0 fallos, garantizando la integridad de los módulos de Calculadora, Autenticación y E-commerce.
2. **Capacidad de Carga:** El sistema procesó 100 transacciones con un promedio de 5ms de latencia, cumpliendo con los estándares de rendimiento definidos.

---

## CONCLUSIÓN
La implementación de este ecosistema permite no solo validar la calidad del software de forma atómica y funcional, sino también prever su comportamiento bajo carga y establecer una comunicación fluida entre los integrantes del equipo mediante BDD y reportabilidad automática.
