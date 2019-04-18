# Ahorcado

* Runnable es una interfaz que es necesaria para instanciar un Thread (Hilo). El Thread ya tiene la capacidad de generar un hilo pero si deseamos que una clase sea ejecutada en un Thread debemos implementar esta interface. El thread por otra parte es un flujo simple de ejecución dentro de un programa.



El Thread tiene 4 estados diferentes:
* New: El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start(). Se producirá un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread distinto de start().

* Start: Cuando se invoca el método start() del hilo, se dice que está en estado listo. El método se arranca con la siguiente instrucción.

* Runnable: El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

* Blocked or Not Runnable: El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

* Dead: La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.




Metodos a explicar

* start(): usado para iniciar el cuerpo de la thread definido por el método run().

* sleep(): pone a dormir una thread por un  tiempo mínimo especificado.

* yield(): hace que un thread que se está ejecutando vuelva de regreso al estado en “listo para ejecutar” para permitir que otros
  hilos de la misma prioridad puedan ejecutarse.
  
* join(): se utliza cuando un Thread necesita esperar a que otro termine (por ejemplo el Thread padre espera a que termine el hijo)
