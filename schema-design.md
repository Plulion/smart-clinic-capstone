# Smart Clinic - MySQL Database Design
**Diseñador:** Pedro Stephen Lulion Pasten

## 🗄️ Entidades del Sistema
El sistema utiliza una base de datos relacional orientada a objetos (JPA) con las siguientes tablas:

### 1. Doctor (doctor)
* **id** (BIGINT, PK): Identificador único correlativo.
* **name** (VARCHAR): Nombre completo del especialista.
* **specialty** (VARCHAR): Área médica de especialización.

### 2. Paciente (patient)
* **id** (BIGINT, PK): Identificador único.
* **name** (VARCHAR): Nombre del paciente.
* **email** (VARCHAR): Correo electrónico único para comunicaciones.
* **phone** (VARCHAR): Número de contacto.

### 3. Cita Médica (appointment)
* **id** (BIGINT, PK): Identificador de la cita.
* **appointment_time** (DATETIME): Fecha y hora programada.
* **doctor_id** (FK): Relación Many-to-One con la tabla Doctor.
* **patient_id** (FK): Relación Many-to-One con la tabla Patient.

## 🔗 Relaciones Relacionales
* **Doctor ↔ Appointment**: Un doctor puede tener múltiples citas (1:N).
* **Patient ↔ Appointment**: Un paciente puede agendar múltiples citas (1:N).