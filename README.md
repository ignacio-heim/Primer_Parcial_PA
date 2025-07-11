# Segundo Parcial Programación Avanzada

## Profesor: Horacio Valenzuela
## Alumno: Ignacio Heim

### Funcionalidades
La funcionalidad de la aplicación consiste en un sistema de registro de adopciones de mascotas.

El usuario deberá loguearse al sistema con su correo y contraseña. En caso de error, no podrá acceder al sistema.
Si se podrá crear un nuevo usuario.

La ***funcionalidad principal*** es elegir de una lista ya prestablecida, un animal y adoptante. Luego habrá una opción de confirmar la adopción.

Finalmente, el usuario tiene la posibilida de descargar el ticket de la adopción en formato PDF.

### Estrucutra del proyecto
    /src
        /app            -> Acceso controller
        /controller     -> Manejo de eventos / lógica de la vista
        /dao            -> Acceso a datos
        /infrastructure -> Clases accesorias
        /model          -> Entidades
        /resources      -> Imágenes
        /service        -> Lógica de negocio
        /view           -> Interfaz de usuario (Swing)


### Capturas de pantalla de la adopción

1. Login

![img.png](capturas/img.png)
2. Ingreso correto

![img_1.png](capturas/img_1.png)
3. Ingreso denegado

![img_3.png](capturas/img_3.png)

![img_5.png](capturas/img_5.png)

4. Registrar adopcion

![img_2.png](capturas/img_2.png)

5. Elegir mascota y adoptante

![img_6.png](capturas/img_6.png)

6. Confirmar adopcion

![img_7.png](capturas/img_7.png)

7. Descargar ticket adopción

![img_8.png](capturas/img_8.png)

8. PDF descargado

![img_9.png](capturas/img_9.png)