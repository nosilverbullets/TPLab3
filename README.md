# TPLab3
 
Un importante centro de salud, los ha contratado para diseñar y desarrollar un ambicioso
proyecto. Se trata de un Sistema de control y seguimiento a distancia de pacientes.
El cliente busca contar con una herramienta que permita llevar registro de diferentes
parámetros de control sobre los Pacientes adheridos al mismo. Estos parámetros serán
definidos por los Médicos en los Planes de Control que cada Enfermedad requiera, a
grandes rasgos estos podrían ser, tomar la temperatura, tomar determinada medicación,
tomar agua, medirse la presión, etc.

El plan de salud a aplicarse a cada paciente, como se dijo, estará determinado por el motivo
por el cual el paciente está siendo atendido, y tiene un tiempo de duración, el paciente
deberá completar el plan indicado por el profesional cada día mientras dure el plan.

Cuando un paciente es agregado al sistema, se debe indicar el motivo por el cual va a ser
tratado (Enfermedad), será asignado a un profesional existente en el sistema, y quedará a
la espera de que el profesional le asigne el plan que deberá seguir, y la fecha de finalización
del mismo.

Se requieren tres tipos de Usuarios, Administradores, Profesionales y Pacientes. Cuando un
usuario ingresa al sistema, éste verá las opciones que a él, por su perfil le correspondan, a
saber.

● Administrador
○ Ingreso de Pacientes
○ Ingreso de Profesionales
○ Administracion de Enfermedades
○ Administración de Tareas de Control

● Profesionales
○ Asignación de Planes de Control
○ Control de los registros de los Pacientes
○ Finalización de Planes de Control

● Pacientes
○ Ingreso de Datos de Control

En el caso de los Profesionales, cuando éstos ingresan al Sistema, con su nombre de
usuario y clave, se le deberá informar si tiene nuevos pacientes asignados, para que el
Profesional pueda asignarle el plan que considere. Esta tarea consiste en definir un periodo
de tiempo para el tratamiento y asignar las diferentes tareas que el Paciente debe realizar
diariamente. El Profesional tiene que poder ver los datos ingresados por cada Paciente. Se
debe mostrar el Profesional, tambíen, un mensaje indicando que pacientes no han cumplido
con el plan el día anterior.

Para el caso de los Pacientes, al ingresar los mismos, estos deben recibir un mensaje si el
día anterior no ha cumplido con el plan, para el día en curso, se le deben mostrar las
acciones que el paciente debe seguir, mostrando los datos ya ingresados, permitiendo
modificar alguno de ellos e ingresar los que todavía no ha completado.
