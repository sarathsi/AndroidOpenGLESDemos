# AndroidOpenGLESDemos
Exploring and testing of OpenGL ES apis

##Android API guide:
http://developer.android.com/guide/topics/graphics/opengl.html
http://developer.android.com/training/graphics/opengl/index.html
http://developer.android.com/training/graphics/opengl/environment.html

##Checking OpenGL ES Version:
http://developer.android.com/guide/topics/graphics/opengl.html#version-check

##Declaring OpenGL Requirements:
/*
<uses-feature android:glEsVersion="0x00020000" android:required="true" />
"0x00030000" / "0x00030001"
*/

##OpenGL packages
- Establish a container view for OpenGL using GLSurfaceView and GLSurfaceView.Renderer
- Start calling OpenGL APIs using following classes
-- android.opengl: OpenGL ES 1.0/1.1 API Packages. Better performance than javax. apis
-- javax.microedition.khronos.opengles: OpenGL ES 1.0/1.1
-- android.opengl.GLES20: OpenGL ES 2.0 API Class (since Android 2.2, API Level 8)

