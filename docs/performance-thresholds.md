# Definición de Métricas y SLAs Corporativos - ML Sistemas

Este documento establece los criterios de aceptación para las pruebas de performance automatizadas.

## Indicadores Clave de Desempeño (KPIs)

| Métrica | Descripción | Umbral (SLA) |
| :--- | :--- | :--- |
| **Latencia (Avg)** | Tiempo promedio de respuesta. | < 500 ms |
| **Percentil 90** | El 90% de las peticiones debe ser más rápida que: | < 800 ms |
| **Throughput** | Cantidad de peticiones procesadas por segundo. | > 10 TPS |
| **Tasa de Error** | Porcentaje máximo de peticiones fallidas permitido. | < 1 % |

## Alertas y Fallos de Build

El pipeline de CI está configurado (vía `jmeter-maven-plugin`) para analizar el archivo de resultados. Se disparará una alerta o fallo si:
1. El **Error Rate** supera el 1%.
2. La latencia media sobrepasa los 1000ms en condiciones de carga nominal.

## Reportabilidad
Los resultados detallados se encuentran en:
- `target/jmeter/reports/index.html` (Dashboard interactivo).
- `target/jmeter/results/*.jtl` (Logs crudos).
