<snippet>
  <content><![CDATA[
# ${1:AndroidOpenGLESDemos}

Exploring and testing of OpenGL ES APIs.

## Installation & usage
TODO

## Android API Reference
http://developer.android.com/guide/topics/graphics/opengl.html
http://developer.android.com/training/graphics/opengl/index.html
http://developer.android.com/training/graphics/opengl/environment.html
Checking OpenGL ES Version: http://developer.android.com/guide/topics/graphics/opengl.html#version-check

### OpenGL packages
1. Establish a container view for OpenGL using GLSurfaceView and GLSurfaceView.Renderer
2. Start calling OpenGL APIs using following classes
2.1. android.opengl: OpenGL ES 1.0/1.1 API Packages. Better performance than javax. apis
2.2. javax.microedition.khronos.opengles: OpenGL ES 1.0/1.1
2.3 android.opengl.GLES20: OpenGL ES 2.0 API Class (since Android 2.2, API Level 8)
3. <uses-feature android:glEsVersion="0x00020000" android:required="true"> ("0x00030000" / "0x00030001")


## License
TODO

]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>
