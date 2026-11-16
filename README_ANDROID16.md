# Air Force Gear - adaptación inicial Android 16

Esta copia conserva el código Java, las imágenes y los sonidos originales. La configuración actual usa Android Gradle Plugin 9.3.0, Gradle 9.5.0, Java 17, `compileSdk`/`targetSdk` 36 y `minSdk` 23. Los récords se guardan en el directorio privado de la aplicación, sin permisos de almacenamiento; también se eliminó el antiguo flujo de escritura a `/mnt/sdcard/afg`. El bucle de dibujo limita la frecuencia a 60 FPS. Se corrigieron varios fallos de lógica del nivel extra, incluidos el daño al jefe, la animación del misil, la frecuencia de tormentas y la actualización de listas de objetos.

## Abrir y probar

1. Descomprime el ZIP y abre la carpeta `AndroidSquadron2-master` en Android Studio reciente.
2. Configura JDK 17 para Gradle e instala Android SDK Platform 36 y Build Tools desde SDK Manager.
3. Deja que Gradle sincronice; necesitarás conexión para descargar el plugin y Gradle.
4. Conecta tu móvil Android 16 con depuración USB, selecciona el dispositivo y pulsa Run. También puedes ejecutar `gradlew.bat assembleDebug` desde Windows para crear `app/build/outputs/apk/debug/app-debug.apk`.
5. Prueba inicio, menús, disparos, sonido, cambios de nivel, pausa y récords. Si falla, conserva el Logcat y compártelo para corregirlo.

## Limitaciones

**No se ha compilado ni ejecutado en un dispositivo:** este entorno no dispone de Android SDK ni de un Gradle instalado con dependencias descargadas. La compatibilidad real con Android 16 está pendiente de validación. Puede haber errores de compilación por APIs antiguas y problemas de escalado, entrada táctil, audio o rendimiento. La migración de récords guardados anteriormente en almacenamiento compartido no está implementada. `targetSdk 36` exige verificar el comportamiento edge-to-edge y la interfaz en un teléfono real.

## Archivos originales

El código, las imágenes, los sonidos y las pantallas de juego se han conservado. Los archivos de compilación antiguos y metadatos de IDE se excluyen del ZIP para reducir tamaño.
