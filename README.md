# Gestión de Franjas Horarias, Docentes y Espacios Físicos

Este proyecto implementa una solución al taller de la sección 21 de la asignatura **Análisis y Simulación de Aplicaciones Empresariales (ASAE)** de la carrera de Ingeniería de Sistemas en la **Universidad del Cauca**.

## Descripción

Este proyecto consiste en una serie de servicios diseñados para gestionar franjas horarias, docentes y espacios físicos. Se utiliza **Spring Boot 3** y **Java 17** para el desarrollo, y **Maven** como sistema de gestión de dependencias y construcción. La arquitectura sigue el patrón de **Arquitectura Limpia** (Clean Architecture) mediante un modelo **hexagonal**, lo cual facilita la mantenibilidad y escalabilidad de la aplicación.

## Arquitectura

La aplicación está estructurada bajo el enfoque hexagonal, separando las capas de dominio y aplicación de los detalles de infraestructura. Esto permite que el núcleo de la lógica de negocio se mantenga independiente de frameworks y herramientas, favoreciendo un diseño modular y orientado a la reutilización.

### Componentes principales

- **Dominio**: Define las entidades y la lógica de negocio, manteniéndose libre de dependencias de infraestructura o frameworks.
- **Aplicación (Casos de uso)**: Implementa la lógica de los casos de uso de la aplicación, interactuando con el dominio y los puertos.
- **Adaptadores de entrada y salida**: Gestionan la interacción entre el núcleo de la aplicación y el exterior. Los adaptadores de entrada exponen los servicios mediante API REST, y los adaptadores de salida se encargan de la comunicación con la base de datos y otros servicios externos.

## Requisitos

- **Java 17** o superior
- **Maven** 3.8.x o superior
- **Spring Boot 3**

## Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/alirocorrea/unicauca-asae-session21-cleanarchitecture.git
```
2. Ingresa al directorio del proyecto:
```bash
cd unicauca-asae-session21-cleanarchitecture
```
3. Compila el proyecto y descarga las dependencias:
```bash
mvn clean install
```
## Ejecución
Para ejecutar el proyecto, usa el siguiente comando en la raíz del proyecto:
```bash
mvn spring-boot:run
```
