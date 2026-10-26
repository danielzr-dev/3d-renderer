# 3D Renderer

Renderizador 3D por software escrito en Java, sin librerías gráficas 3D. Proyecta modelos sencillos en pantalla usando matrices, cuaterniones y un rasterizador propio sobre Java Swing/AWT.

## Qué hace

- Proyección en perspectiva con matrices 4x4 (modelo, vista y proyección)
- Rasterizado de triángulos con z-buffer (buffer de profundidad) y coordenadas baricéntricas
- Descarte de caras traseras (backface culling)
- Modo wireframe y modo relleno
- Rotación de cámara con cuaterniones, con teclado y ratón
- Cuatro modelos: cubo, pirámide, tetraedro y octaedro

## Controles

| Tecla / ratón | Acción |
|---|---|
| W / S | Rotar la cámara arriba / abajo |
| A / D | Rotar la cámara izquierda / derecha |
| Flechas | Mover la cámara |
| Ratón | Rotar la cámara |
| Q / E | Rotar el modelo en un eje |
| R / F | Rotar el modelo en otro eje |
| C / P / T / O | Cambiar a cubo / pirámide / tetraedro / octaedro |
| V | Alternar wireframe |

## Cómo ejecutarlo

Requiere Java 21 o superior.

1. Clona el repositorio: `git clone https://github.com/danielzr-dev/3d-renderer.git`
2. Crea un proyecto Java en tu IDE y añade la carpeta `src` como carpeta de código fuente.
3. Ejecuta la clase `Main`.

Los parámetros (resolución, velocidades, color del wireframe, sensibilidad del ratón) están en `src/config/AppConfig.java`.

## Estructura

- `math`: vectores, matrices 4x4, cuaterniones y transformaciones
- `model`: triángulos y modelos 3D
- `rendering`: pipeline de transformación y rasterizadores
- `graphs`: ventana, bucle de render, cámara y entrada de usuario

## Estado del proyecto

Proyecto en desarrollo, hecho como práctica personal para aprender cómo funciona un motor 3D por dentro.

Próximos pasos: sombreado plano (flat shading) con una luz direccional.
