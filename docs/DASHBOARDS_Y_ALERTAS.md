# Estrategia de Monitoreo, Dashboards y Alertas en el Pipeline

## 1. Integración de Métricas en Dashboards
Para centralizar la visibilidad de los resultados de pruebas funcionales (BDD) y de performance, se proponen las siguientes herramientas integradas al pipeline de CI/CD:

### Pruebas Funcionales (BDD)
- **Allure Framework:** Se integra con el pipeline para recolectar los archivos JSON generados por Cucumber. Allure genera una tendencia de "Success vs Fail" a lo largo del tiempo.
- **Publishing:** En GitHub Actions, se puede utilizar `peaceiris/actions-gh-pages` para desplegar el reporte estático y tener un historial navegable por versión.

### Pruebas de Performance
- **JMeter Dashboard (HTML):** Generado automáticamente por el plugin de Maven. Muestra:
    - **TPS (Transactions Per Second):** Cantidad de operaciones por segundo manejadas.
    - **Latencia (Percentiles 90, 95, 99):** Tiempo que tarda el 90-99% de las peticiones.
    - **Tasa de Error:** % de peticiones que fallan (HTTP 500, timeouts).
- **Grafana + InfluxDB:** Para un monitoreo en tiempo real, se configura un *Backend Listener* en JMeter que envía métricas a InfluxDB, las cuales son visualizadas en un dashboard de Grafana.

## 2. Configuración de Alertas Automáticas
Las alertas aseguran que el equipo sea notificado proactivamente ante degradaciones sin tener que revisar el log del pipeline manualmente.

### Umbrales de Performance (Thresholds)
Se configuran fallos en el pipeline si:
- El **Error Rate** es superior al 1%.
- El **Percentil 95 de latencia** supera los 500ms para el servicio de Login.
- El **Throughput** cae por debajo del esperado (ej: < 50 TPS).

### Canales de Notificación
- **Slack/Discord/Teams:** Integración mediante Webhooks. El pipeline envía un mensaje con el enlace al reporte si el job falla o detecta degradación crítica.
- **Check Status (GitHub):** Bloqueo de Pull Requests si las pruebas de performance muestran una regresión (ej: aumento del 10% en tiempos de respuesta respecto a la rama base).

### Simulación de Alerta (Ejemplo de script en Pipeline)
```yaml
- name: Send Alert on Failure
  if: failure()
  run: |
    curl -X POST -H 'Content-type: application/json' \
    --data '{"text":"🚨 ALERTA: Fallo detectado en Pipeline de QA. Revisar reportes de Performance y BDD."}' \
    ${{ secrets.SLACK_WEBHOOK_URL }}
```
