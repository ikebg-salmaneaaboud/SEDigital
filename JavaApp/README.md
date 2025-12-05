# BackupApp

Aplicación Java para gestionar y exportar datos de tablas de la base de
datos a archivos XML.

## Requisitos

- Java 17 o superior
- Maven 3.4+
- Conexión a la base de datos configurada en `config.properties`

## Comandos para generar el proyecto y la documentación

1. Limpiar el proyecto:
   ```bash
   mvn clean

2. Compilar el código:
   ```bash
   mvn compile

3. Ejecutar pruebas:
   ```bash
   mvn clean

4. Empaquetar el proyecto (si se requiere el artefacto .jar):
   ```bash
   mvn package

5. Generar la documentación del proyecto:
    ```bash
    mvn javadoc:javadoc

6. Copiar la documentación generada a la carpeta doc del nivel superior: 
    ```bash
   cp -r target/reports/apidocs/* doc/
