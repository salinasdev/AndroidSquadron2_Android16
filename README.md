[![CircleCI](https://dl.circleci.com/status-badge/img/gh/salinasdev/AndroidSquadron2/tree/master.svg?style=svg&circle-token=a9aeab2ee346446d72f599d8364b76d5b7b3b23d)](https://dl.circleci.com/status-badge/redirect/gh/salinasdev/AndroidSquadron2/tree/master)

# <img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/AFG-NewTitle_100.png">
<p align="justify">
Air Force Gear surgio en 2012, cuando cursaba el segundo curso de Desarrollo de Aplicaciones Multiplataforma. En ese momento yo jugaba bastante a U.N. Squadron de Super Nintendo, y como proyecto para el curso comencé a desarrollar un shooter vertical muy rudimentario, con graficos cogidos de Internet y musica, como no podia ser de otra manera, de U.N. Squadron. De hecho, el proyecto en Android se llama AndroidSquadron2.

</p>



## Versión actual del repositorio

El proyecto está preparado como **Air Force Gear 1.1-android16** (`versionCode` 2). Esta versión actualiza la configuración de Android y pule varios aspectos del juego, conservando los gráficos, sonidos y niveles originales.

- Android Gradle Plugin 9.3.0 y Gradle 9.5.0.
- Java 17, `compileSdk` 36 y `targetSdk` 36; `minSdk` 23.
- Los récords se guardan en el almacenamiento privado de la aplicación, sin requerir permisos de almacenamiento.
- El bucle de dibujo limita la frecuencia a 60 fotogramas por segundo para evitar que el juego se acelere en pantallas de alta frecuencia.
- Se corrigieron errores del nivel extra y del jefe final: daño independiente del ajuste de sonido, animación del misil, aparición de tormentas y eliminación de objetos durante las actualizaciones.
- El guardado del récord al completar el nivel se realiza una sola vez.

**Estado:** la adaptación está en desarrollo y todavía requiere compilación y pruebas en un dispositivo Android 16. Para ver los pasos de configuración y las limitaciones conocidas, consulta [README_ANDROID16.md](README_ANDROID16.md).

## Change Log
### [1.1-android16] - En desarrollo
#### Changed
- Actualizada la configuración de compilación y compatibilidad para Android 16.
- Los récords pasan a guardarse en el almacenamiento privado de la aplicación.
- El renderizado se limita a 60 FPS.
#### Fixed
- Corregidos el daño y la derrota del jefe del nivel extra, independientemente de si el sonido está activado.
- Corregidas la animación del misil, la frecuencia de aparición de tormentas y la actualización de listas de objetos.
- Evitadas escrituras repetidas del récord durante la pantalla de fin de nivel.

### [1.0.0] - 2017-12-23
#### Added
- Primera versión publicada en Google Play.

## Controles: 

- Toca una opción para seleccionar. Toca de nuevo para seleccionar esa opción.
- Desplaza el avión pulsandolo y arrastrando el dedo de derecha a izquierda.
- Toca en el avión para disparar la artillería.
- El juego tiene botones para pausar el juego, quitar la música o volver al menú de inicio.

## Niveles de dificultad:

- Fácil.
- Normal.
- Dificil.

Al completar estos niveles podrás desbloquear dos niveles extra más.

## Armamento:
<table border="0" cellpadding="0" cellspacing="0" width="100">
<tr>
  <td>Nombre</td>
  <td>Icono</td>
  <td>Descripción</td>
</tr>

<tr>
  <td>Normal</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/bnormal.png"></td>
  <td>El más basico. Hace un punto de daño</td>
</tr>

<tr>
  <td>Maverick</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/bmave.png"></td>
  <td>Hace dos puntos de daño</td>
</tr>

<tr>
  <td>Harrington</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/bharry.png"></td>
  <td>Hace tres punto de daño</td>
</tr>
</table>

## Objetos:

<table border="0" cellpadding="0" cellspacing="0" width="100">
<tr>
  <td>Nombre</td>
  <td>Icono</td>
  <td>Descripción</td>
</tr>
<tr>
  <td>Fuel</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/iFuel.png"></td>
  <td>Incrementa el fuel</td>
</tr>
<tr>
  <td>Reparar</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/irepa.png"></td>
  <td>Aumenta nuestra barra de vida</td>
</tr>
<tr>
  <td>Fuel podrido</td>
  <td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/app/src/main/assets/lficon.png"></td>
  <td>Pierdes una gran cantidad de fuel, ¡Evítalo!</td>
</tr>
</table>


## Imágenes:
<table border="0" cellpadding="0" cellspacing="0" width="100">
<tr>
<td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/images/1.png" width="200" height="356"></td>
<td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/images/2.png" width="200" height="356"></td>
<td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/images/3.png" width="200" height="356"></td>
<td><img src="https://github.com/salinasdev/AndroidSquadron2/blob/master/images/4.png" width="200" height="356"></td>
</tr>
</table>

## Vídeo:

[![Click para reproducir en Youtube](https://img.youtube.com/vi/CeMnl1f1M4U/0.jpg)](https://www.youtube.com/watch?v=CeMnl1f1M4U)

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
