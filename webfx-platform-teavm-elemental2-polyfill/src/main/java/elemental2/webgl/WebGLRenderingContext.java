package elemental2.webgl;

import elemental2.core.*;
import elemental2.dom.*;
import jsinterop.base.Js;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class WebGLRenderingContext implements JSObject {
    public static int ACTIVE_ATTRIBUTES;
    public static int ACTIVE_TEXTURE;
    public static int ACTIVE_UNIFORMS;
    public static int ALIASED_LINE_WIDTH_RANGE;
    public static int ALIASED_POINT_SIZE_RANGE;
    public static int ALPHA;
    public static int ALPHA_BITS;
    public static int ALWAYS;
    public static int ARRAY_BUFFER;
    public static int ARRAY_BUFFER_BINDING;
    public static int ATTACHED_SHADERS;
    public static int BACK;
    public static int BLEND;
    public static int BLEND_COLOR;
    public static int BLEND_DST_ALPHA;
    public static int BLEND_DST_RGB;
    public static int BLEND_EQUATION;
    public static int BLEND_EQUATION_ALPHA;
    public static int BLEND_EQUATION_RGB;
    public static int BLEND_SRC_ALPHA;
    public static int BLEND_SRC_RGB;
    public static int BLUE_BITS;
    public static int BOOL;
    public static int BOOL_VEC2;
    public static int BOOL_VEC3;
    public static int BOOL_VEC4;
    public static int BROWSER_DEFAULT_WEBGL;
    public static int BUFFER_SIZE;
    public static int BUFFER_USAGE;
    public static int BYTE;
    public static int CCW;
    public static int CLAMP_TO_EDGE;
    public static int COLOR_ATTACHMENT0;
    public static int COLOR_BUFFER_BIT;
    public static int COLOR_CLEAR_VALUE;
    public static int COLOR_WRITEMASK;
    public static int COMPILE_STATUS;
    public static int COMPRESSED_TEXTURE_FORMATS;
    public static int CONSTANT_ALPHA;
    public static int CONSTANT_COLOR;
    public static int CONTEXT_LOST_WEBGL;
    public static int CULL_FACE;
    public static int CULL_FACE_MODE;
    public static int CURRENT_PROGRAM;
    public static int CURRENT_VERTEX_ATTRIB;
    public static int CW;
    public static int DECR;
    public static int DECR_WRAP;
    public static int DELETE_STATUS;
    public static int DEPTH_ATTACHMENT;
    public static int DEPTH_BITS;
    public static int DEPTH_BUFFER_BIT;
    public static int DEPTH_CLEAR_VALUE;
    public static int DEPTH_COMPONENT;
    public static int DEPTH_COMPONENT16;
    public static int DEPTH_FUNC;
    public static int DEPTH_RANGE;
    public static int DEPTH_STENCIL;
    public static int DEPTH_STENCIL_ATTACHMENT;
    public static int DEPTH_TEST;
    public static int DEPTH_WRITEMASK;
    public static int DITHER;
    public static int DONT_CARE;
    public static int DST_ALPHA;
    public static int DST_COLOR;
    public static int DYNAMIC_DRAW;
    public static int ELEMENT_ARRAY_BUFFER;
    public static int ELEMENT_ARRAY_BUFFER_BINDING;
    public static int EQUAL;
    public static int FASTEST;
    public static int FLOAT;
    public static int FLOAT_MAT2;
    public static int FLOAT_MAT3;
    public static int FLOAT_MAT4;
    public static int FLOAT_VEC2;
    public static int FLOAT_VEC3;
    public static int FLOAT_VEC4;
    public static int FRAGMENT_SHADER;
    public static int FRAMEBUFFER;
    public static int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
    public static int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
    public static int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
    public static int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
    public static int FRAMEBUFFER_BINDING;
    public static int FRAMEBUFFER_COMPLETE;
    public static int FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
    public static int FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
    public static int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
    public static int FRAMEBUFFER_UNSUPPORTED;
    public static int FRONT;
    public static int FRONT_AND_BACK;
    public static int FRONT_FACE;
    public static int FUNC_ADD;
    public static int FUNC_REVERSE_SUBTRACT;
    public static int FUNC_SUBTRACT;
    public static int GENERATE_MIPMAP_HINT;
    public static int GEQUAL;
    public static int GREATER;
    public static int GREEN_BITS;
    public static int HIGH_FLOAT;
    public static int HIGH_INT;
    public static int IMPLEMENTATION_COLOR_READ_FORMAT;
    public static int IMPLEMENTATION_COLOR_READ_TYPE;
    public static int INCR;
    public static int INCR_WRAP;
    public static int INT;
    public static int INT_VEC2;
    public static int INT_VEC3;
    public static int INT_VEC4;
    public static int INVALID_ENUM;
    public static int INVALID_FRAMEBUFFER_OPERATION;
    public static int INVALID_OPERATION;
    public static int INVALID_VALUE;
    public static int INVERT;
    public static int KEEP;
    public static int LEQUAL;
    public static int LESS;
    public static int LINEAR;
    public static int LINEAR_MIPMAP_LINEAR;
    public static int LINEAR_MIPMAP_NEAREST;
    public static int LINES;
    public static int LINE_LOOP;
    public static int LINE_STRIP;
    public static int LINE_WIDTH;
    public static int LINK_STATUS;
    public static int LOW_FLOAT;
    public static int LOW_INT;
    public static int LUMINANCE;
    public static int LUMINANCE_ALPHA;
    public static int MAX_COMBINED_TEXTURE_IMAGE_UNITS;
    public static int MAX_CUBE_MAP_TEXTURE_SIZE;
    public static int MAX_FRAGMENT_UNIFORM_VECTORS;
    public static int MAX_RENDERBUFFER_SIZE;
    public static int MAX_TEXTURE_IMAGE_UNITS;
    public static int MAX_TEXTURE_SIZE;
    public static int MAX_VARYING_VECTORS;
    public static int MAX_VERTEX_ATTRIBS;
    public static int MAX_VERTEX_TEXTURE_IMAGE_UNITS;
    public static int MAX_VERTEX_UNIFORM_VECTORS;
    public static int MAX_VIEWPORT_DIMS;
    public static int MEDIUM_FLOAT;
    public static int MEDIUM_INT;
    public static int MIRRORED_REPEAT;
    public static int NEAREST;
    public static int NEAREST_MIPMAP_LINEAR;
    public static int NEAREST_MIPMAP_NEAREST;
    public static int NEVER;
    public static int NICEST;
    public static int NONE;
    public static int NOTEQUAL;
    public static int NO_ERROR;
    public static int ONE;
    public static int ONE_MINUS_CONSTANT_ALPHA;
    public static int ONE_MINUS_CONSTANT_COLOR;
    public static int ONE_MINUS_DST_ALPHA;
    public static int ONE_MINUS_DST_COLOR;
    public static int ONE_MINUS_SRC_ALPHA;
    public static int ONE_MINUS_SRC_COLOR;
    public static int OUT_OF_MEMORY;
    public static int PACK_ALIGNMENT;
    public static int POINTS;
    public static int POLYGON_OFFSET_FACTOR;
    public static int POLYGON_OFFSET_FILL;
    public static int POLYGON_OFFSET_UNITS;
    public static int RED_BITS;
    public static int RENDERBUFFER;
    public static int RENDERBUFFER_ALPHA_SIZE;
    public static int RENDERBUFFER_BINDING;
    public static int RENDERBUFFER_BLUE_SIZE;
    public static int RENDERBUFFER_DEPTH_SIZE;
    public static int RENDERBUFFER_GREEN_SIZE;
    public static int RENDERBUFFER_HEIGHT;
    public static int RENDERBUFFER_INTERNAL_FORMAT;
    public static int RENDERBUFFER_RED_SIZE;
    public static int RENDERBUFFER_STENCIL_SIZE;
    public static int RENDERBUFFER_WIDTH;
    public static int RENDERER;
    public static int REPEAT;
    public static int REPLACE;
    public static int RGB;
    public static int RGB565;
    public static int RGB5_A1;
    public static int RGBA;
    public static int RGBA4;
    public static int SAMPLER_2D;
    public static int SAMPLER_CUBE;
    public static int SAMPLES;
    public static int SAMPLE_ALPHA_TO_COVERAGE;
    public static int SAMPLE_BUFFERS;
    public static int SAMPLE_COVERAGE;
    public static int SAMPLE_COVERAGE_INVERT;
    public static int SAMPLE_COVERAGE_VALUE;
    public static int SCISSOR_BOX;
    public static int SCISSOR_TEST;
    public static int SHADER_TYPE;
    public static int SHADING_LANGUAGE_VERSION;
    public static int SHORT;
    public static int SRC_ALPHA;
    public static int SRC_ALPHA_SATURATE;
    public static int SRC_COLOR;
    public static int STATIC_DRAW;
    public static int STENCIL_ATTACHMENT;
    public static int STENCIL_BACK_FAIL;
    public static int STENCIL_BACK_FUNC;
    public static int STENCIL_BACK_PASS_DEPTH_FAIL;
    public static int STENCIL_BACK_PASS_DEPTH_PASS;
    public static int STENCIL_BACK_REF;
    public static int STENCIL_BACK_VALUE_MASK;
    public static int STENCIL_BACK_WRITEMASK;
    public static int STENCIL_BITS;
    public static int STENCIL_BUFFER_BIT;
    public static int STENCIL_CLEAR_VALUE;
    public static int STENCIL_FAIL;
    public static int STENCIL_FUNC;
    public static double STENCIL_INDEX;
    public static int STENCIL_INDEX8;
    public static int STENCIL_PASS_DEPTH_FAIL;
    public static int STENCIL_PASS_DEPTH_PASS;
    public static int STENCIL_REF;
    public static int STENCIL_TEST;
    public static int STENCIL_VALUE_MASK;
    public static int STENCIL_WRITEMASK;
    public static int STREAM_DRAW;
    public static int SUBPIXEL_BITS;
    public static int TEXTURE;
    public static int TEXTURE0;
    public static int TEXTURE1;
    public static int TEXTURE10;
    public static int TEXTURE11;
    public static int TEXTURE12;
    public static int TEXTURE13;
    public static int TEXTURE14;
    public static int TEXTURE15;
    public static int TEXTURE16;
    public static int TEXTURE17;
    public static int TEXTURE18;
    public static int TEXTURE19;
    public static int TEXTURE2;
    public static int TEXTURE20;
    public static int TEXTURE21;
    public static int TEXTURE22;
    public static int TEXTURE23;
    public static int TEXTURE24;
    public static int TEXTURE25;
    public static int TEXTURE26;
    public static int TEXTURE27;
    public static int TEXTURE28;
    public static int TEXTURE29;
    public static int TEXTURE3;
    public static int TEXTURE30;
    public static int TEXTURE31;
    public static int TEXTURE4;
    public static int TEXTURE5;
    public static int TEXTURE6;
    public static int TEXTURE7;
    public static int TEXTURE8;
    public static int TEXTURE9;
    public static int TEXTURE_2D;
    public static int TEXTURE_BINDING_2D;
    public static int TEXTURE_BINDING_CUBE_MAP;
    public static int TEXTURE_CUBE_MAP;
    public static int TEXTURE_CUBE_MAP_NEGATIVE_X;
    public static int TEXTURE_CUBE_MAP_NEGATIVE_Y;
    public static int TEXTURE_CUBE_MAP_NEGATIVE_Z;
    public static int TEXTURE_CUBE_MAP_POSITIVE_X;
    public static int TEXTURE_CUBE_MAP_POSITIVE_Y;
    public static int TEXTURE_CUBE_MAP_POSITIVE_Z;
    public static int TEXTURE_MAG_FILTER;
    public static int TEXTURE_MIN_FILTER;
    public static int TEXTURE_WRAP_S;
    public static int TEXTURE_WRAP_T;
    public static int TRIANGLES;
    public static int TRIANGLE_FAN;
    public static int TRIANGLE_STRIP;
    public static int UNPACK_ALIGNMENT;
    public static int UNPACK_COLORSPACE_CONVERSION_WEBGL;
    public static int UNPACK_FLIP_Y_WEBGL;
    public static int UNPACK_PREMULTIPLY_ALPHA_WEBGL;
    public static int UNSIGNED_BYTE;
    public static int UNSIGNED_INT;
    public static int UNSIGNED_SHORT;
    public static int UNSIGNED_SHORT_4_4_4_4;
    public static int UNSIGNED_SHORT_5_5_5_1;
    public static int UNSIGNED_SHORT_5_6_5;
    public static int VALIDATE_STATUS;
    public static int VENDOR;
    public static int VERSION;
    public static int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
    public static int VERTEX_ATTRIB_ARRAY_ENABLED;
    public static int VERTEX_ATTRIB_ARRAY_NORMALIZED;
    public static int VERTEX_ATTRIB_ARRAY_POINTER;
    public static int VERTEX_ATTRIB_ARRAY_SIZE;
    public static int VERTEX_ATTRIB_ARRAY_STRIDE;
    public static int VERTEX_ATTRIB_ARRAY_TYPE;
    public static int VERTEX_SHADER;
    public static int VIEWPORT;
    public static int ZERO;

    public HTMLCanvasElement canvas;
    public int drawingBufferHeight;
    public int drawingBufferWidth;

    public native void activeTexture(int texture);

    public native void attachShader(WebGLProgram program, WebGLShader shader);

    public native void bindAttribLocation(WebGLProgram program, int index, String name);

    public native void bindBuffer(int target, WebGLBuffer buffer);

    public native void bindFramebuffer(int target, WebGLFramebuffer buffer);

    public native void bindRenderbuffer(int target, WebGLRenderbuffer buffer);

    public native void bindTexture(int target, WebGLTexture texture);

    public native void blendColor(double red, double green, double blue, double alpha);

    public native void blendEquation(int mode);

    public native void blendEquationSeparate(int modeRGB, int modeAlpha);

    public native void blendFunc(int sfactor, int dfactor);

    public native void blendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

    public final void bufferData(int target, ArrayBuffer data, int usage) {
        this.bufferData(target, (BufferDataDataUnionType) Js.uncheckedCast(data), usage);
    }

    public final void bufferData(int target, ArrayBufferView data, int usage) {
        this.bufferData(target, (BufferDataDataUnionType)Js.uncheckedCast(data), usage);
    }

    public native void bufferData(int target, BufferDataDataUnionType data, int usage);

    public final void bufferData(int target, double data, int usage) {
        this.bufferData(target, (BufferDataDataUnionType)Js.uncheckedCast(data), usage);
    }

    public final void bufferSubData(int target, double offset, ArrayBuffer data) {
        this.bufferSubData(target, offset, (BufferSubDataDataUnionType)Js.uncheckedCast(data));
    }

    public final void bufferSubData(int target, double offset, ArrayBufferView data) {
        this.bufferSubData(target, offset, (BufferSubDataDataUnionType)Js.uncheckedCast(data));
    }

    public native void bufferSubData(int target, double offset, BufferSubDataDataUnionType data);

    public native int checkFramebufferStatus(int target);

    public native void clear(int mask);

    public native void clearColor(double red, double green, double blue, double alpha);

    public native void clearDepth(double depth);

    public native void clearStencil(int s);

    public native void colorMask(boolean red, boolean green, boolean blue, boolean alpha);

    public native void compileShader(WebGLShader shader);

    public native void compressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, ArrayBufferView data);

    public native void compressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, ArrayBufferView data);

    public native void copyTexImage2D(int target, int level, int format, int x, int y, int width, int height, int border);

    public native void copyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);

    public native WebGLBuffer createBuffer();

    public native WebGLFramebuffer createFramebuffer();

    public native WebGLProgram createProgram();

    public native WebGLRenderbuffer createRenderbuffer();

    public native WebGLShader createShader(int type);

    public native WebGLTexture createTexture();

    public native void cullFace(int mode);

    public native void deleteBuffer(WebGLBuffer buffer);

    public native void deleteFramebuffer(WebGLFramebuffer buffer);

    public native void deleteProgram(WebGLProgram program);

    public native void deleteRenderbuffer(WebGLRenderbuffer buffer);

    public native void deleteShader(WebGLShader shader);

    public native void deleteTexture(WebGLTexture texture);

    public native void depthFunc(int func);

    public native void depthMask(boolean flag);

    public native void depthRange(double nearVal, double farVal);

    public native void detachShader(WebGLProgram program, WebGLShader shader);

    public native void disable(int flags);

    public native void disableVertexAttribArray(int index);

    public native void drawArrays(int mode, int first, int count);

    public native void drawElements(int mode, int count, int type, double offset);

    public native void enable(int cap);

    public native void enableVertexAttribArray(int index);

    public native Object finish();

    public native Object flush();

    public native void framebufferRenderbuffer(int target, int attachment, int renderbuffertarget, WebGLRenderbuffer renderbuffer);

    public native void framebufferTexture2D(int target, int attachment, int textarget, WebGLTexture texture, int level);

    public native void frontFace(int mode);

    public native void generateMipmap(int target);

    public native WebGLActiveInfo getActiveAttrib(WebGLProgram program, int index);

    public native WebGLActiveInfo getActiveUniform(WebGLProgram program, int index);

    public native JsArray<WebGLShader> getAttachedShaders(WebGLProgram program);

    public native int getAttribLocation(WebGLProgram program, String name);

    public native Object getBufferParameter(int target, int pname);

    //public native WebGLContextAttributes getContextAttributes();

    public native int getError();

    public native JsObject getExtension(String name);

    public native Object getFramebufferAttachmentParameter(int target, int attachment, int pname);

    public native Object getParameter(int pname);

    public native String getProgramInfoLog(WebGLProgram program);

    public native Object getProgramParameter(WebGLProgram program, int pname);

    public native Object getRenderbufferParameter(int target, int pname);

    public native String getShaderInfoLog(WebGLShader shader);

    public native Object getShaderParameter(WebGLShader shader, int pname);

    //public native WebGLShaderPrecisionFormat getShaderPrecisionFormat(int shadertype, int precisiontype);

    public native String getShaderSource(WebGLShader shader);

    public native JsArray<String> getSupportedExtensions();

    public native Object getTexParameter(int target, int pname);

    public native Object getUniform(WebGLProgram program, WebGLUniformLocation location);

    public native WebGLUniformLocation getUniformLocation(WebGLProgram program, String name);

    public native Object getVertexAttrib(int index, int pname);

    public native double getVertexAttribOffset(int index, int pname);

    public native void hint(int target, int mode);

    public native boolean isBuffer(WebGLObject buffer);

    public native boolean isContextLost();

    public native boolean isEnabled(int cap);

    public native boolean isFramebuffer(WebGLObject framebuffer);

    public native boolean isProgram(WebGLObject program);

    public native boolean isRenderbuffer(WebGLObject renderbuffer);

    public native boolean isShader(WebGLObject shader);

    public native boolean isTexture(WebGLObject texture);

    public native void lineWidth(double width);

    public native void linkProgram(WebGLProgram program);

    public native void pixelStorei(int pname, PixelStoreiParamUnionType param);

    public final void pixelStorei(int pname, boolean param) {
        this.pixelStorei(pname, (PixelStoreiParamUnionType)Js.uncheckedCast(param));
    }

    public final void pixelStorei(int pname, int param) {
        this.pixelStorei(pname, (PixelStoreiParamUnionType)Js.uncheckedCast(param));
    }

    public native void polygonOffset(double factor, double units);

    public native void readPixels(int x, int y, int width, int height, int format, int type, ArrayBufferView pixels);

    public native void renderbufferStorage(int target, int internalformat, int width, int height);

    public native void sampleCoverage(double coverage, boolean invert);

    public native void scissor(int x, int y, int width, int height);

    public native void shaderSource(WebGLShader shader, String source);

    public native void stencilFunc(int func, int ref, int mask);

    public native void stencilFuncSeparate(int face, int func, int ref, int mask);

    public native void stencilMask(int mask);

    public native void stencilMaskSeparate(int face, int mask);

    public native void stencilOp(int fail, int zfail, int zpass);

    public native void stencilOpSeparate(int face, int fail, int zfail, int zpass);

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLCanvasElement img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLCanvasElement img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLCanvasElement img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLCanvasElement img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLImageElement img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLImageElement img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLImageElement img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLImageElement img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLVideoElement img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLVideoElement img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLVideoElement img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, HTMLVideoElement img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageBitmap img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageBitmap img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageBitmap img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageBitmap img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageData img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageData img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageData img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, ImageData img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, OffscreenCanvas img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, OffscreenCanvas img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, OffscreenCanvas img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, OffscreenCanvas img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public native void texImage2D(int target, int level, int internalformat, int format, int type, TexImage2DImgUnionType img, int format0, int type0, ArrayBufferView pixels);

    public native void texImage2D(int target, int level, int internalformat, int format, int type, TexImage2DImgUnionType img, int format0, int type0);

    public native void texImage2D(int target, int level, int internalformat, int format, int type, TexImage2DImgUnionType img, int format0);

    public native void texImage2D(int target, int level, int internalformat, int format, int type, TexImage2DImgUnionType img);

    public final void texImage2D(int target, int level, int internalformat, int format, int type, int img, int format0, int type0, ArrayBufferView pixels) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0, pixels);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, int img, int format0, int type0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0, type0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, int img, int format0) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img), format0);
    }

    public final void texImage2D(int target, int level, int internalformat, int format, int type, int img) {
        this.texImage2D(target, level, internalformat, format, type, (TexImage2DImgUnionType)Js.uncheckedCast(img));
    }

    public native void texParameterf(int target, int pname, double param);

    public native void texParameteri(int target, int pname, int param);

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLCanvasElement data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLCanvasElement data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLCanvasElement data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLImageElement data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLImageElement data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLImageElement data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLVideoElement data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLVideoElement data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, HTMLVideoElement data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageBitmap data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageBitmap data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageBitmap data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageData data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageData data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, ImageData data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, OffscreenCanvas data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, OffscreenCanvas data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, OffscreenCanvas data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public native void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, TexSubImage2DDataUnionType data, int type0, ArrayBufferView pixels);

    public native void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, TexSubImage2DDataUnionType data, int type0);

    public native void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, TexSubImage2DDataUnionType data);

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, double data, int type0, ArrayBufferView pixels) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0, pixels);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, double data, int type0) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data), type0);
    }

    public final void texSubImage2D(int target, int level, int xoffset, int yoffset, int format, int type, double data) {
        this.texSubImage2D(target, level, xoffset, yoffset, format, type, (TexSubImage2DDataUnionType)Js.uncheckedCast(data));
    }

    public native void uniform1f(WebGLUniformLocation location, double value);

    public final void uniform1fv(WebGLUniformLocation location, Float32Array value) {
        this.uniform1fv(location, (Uniform1fvValueUnionType)Js.uncheckedCast(value));
    }

    //@JsOverlay
    public final void uniform1fv(WebGLUniformLocation location, JsArray<Double> value) {
        this.uniform1fv(location, (Uniform1fvValueUnionType)Js.uncheckedCast(value));
    }

    public native void uniform1fv(WebGLUniformLocation location, Uniform1fvValueUnionType value);

    public final void uniform1fv(WebGLUniformLocation location, double[] value) {
        this.uniform1fv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform1i(WebGLUniformLocation location, Uniform1iValueUnionType value);

    public final void uniform1i(WebGLUniformLocation location, boolean value) {
        this.uniform1i(location, (Uniform1iValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform1i(WebGLUniformLocation location, int value) {
        this.uniform1i(location, (Uniform1iValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform1iv(WebGLUniformLocation location, Int32Array value) {
        this.uniform1iv(location, (Uniform1ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform1iv(WebGLUniformLocation location, JsArray<Object> value) {
        this.uniform1iv(location, (Uniform1ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform1iv(WebGLUniformLocation location, Object[] value) {
        this.uniform1iv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform1iv(WebGLUniformLocation location, Uniform1ivValueUnionType value);

    public native void uniform2f(WebGLUniformLocation location, double value1, double value2);

    public final void uniform2fv(WebGLUniformLocation location, Float32Array value) {
        this.uniform2fv(location, (Uniform2fvValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform2fv(WebGLUniformLocation location, JsArray<Double> value) {
        this.uniform2fv(location, (Uniform2fvValueUnionType)Js.uncheckedCast(value));
    }

    public native void uniform2fv(WebGLUniformLocation location, Uniform2fvValueUnionType value);

    public final void uniform2fv(WebGLUniformLocation location, double[] value) {
        this.uniform2fv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform2i(WebGLUniformLocation location, Uniform2iValue1UnionType value1, Uniform2iValue2UnionType value2);

    public final void uniform2i(WebGLUniformLocation location, Uniform2iValue1UnionType value1, boolean value2) {
        this.uniform2i(location, value1, (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2i(WebGLUniformLocation location, Uniform2iValue1UnionType value1, int value2) {
        this.uniform2i(location, value1, (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2i(WebGLUniformLocation location, boolean value1, Uniform2iValue2UnionType value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), value2);
    }

    public final void uniform2i(WebGLUniformLocation location, boolean value1, boolean value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2i(WebGLUniformLocation location, boolean value1, int value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2i(WebGLUniformLocation location, int value1, Uniform2iValue2UnionType value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), value2);
    }

    public final void uniform2i(WebGLUniformLocation location, int value1, boolean value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2i(WebGLUniformLocation location, int value1, int value2) {
        this.uniform2i(location, (Uniform2iValue1UnionType)Js.uncheckedCast(value1), (Uniform2iValue2UnionType)Js.uncheckedCast(value2));
    }

    public final void uniform2iv(WebGLUniformLocation location, Int32Array value) {
        this.uniform2iv(location, (Uniform2ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform2iv(WebGLUniformLocation location, JsArray<Object> value) {
        this.uniform2iv(location, (Uniform2ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform2iv(WebGLUniformLocation location, Object[] value) {
        this.uniform2iv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform2iv(WebGLUniformLocation location, Uniform2ivValueUnionType value);

    public native void uniform3f(WebGLUniformLocation location, double value1, double value2, double value3);

    public final void uniform3fv(WebGLUniformLocation location, Float32Array value) {
        this.uniform3fv(location, (Uniform3fvValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform3fv(WebGLUniformLocation location, JsArray<Double> value) {
        this.uniform3fv(location, (Uniform3fvValueUnionType)Js.uncheckedCast(value));
    }

    public native void uniform3fv(WebGLUniformLocation location, Uniform3fvValueUnionType value);

    public final void uniform3fv(WebGLUniformLocation location, double[] value) {
        this.uniform3fv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, Uniform3iValue2UnionType value2, Uniform3iValue3UnionType value3);

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, Uniform3iValue2UnionType value2, boolean value3) {
        this.uniform3i(location, value1, value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, Uniform3iValue2UnionType value2, int value3) {
        this.uniform3i(location, value1, value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, boolean value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, boolean value2, boolean value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, boolean value2, int value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, int value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, int value2, boolean value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, Uniform3iValue1UnionType value1, int value2, int value3) {
        this.uniform3i(location, value1, (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, Uniform3iValue2UnionType value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, value3);
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, Uniform3iValue2UnionType value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, Uniform3iValue2UnionType value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, boolean value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, boolean value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, boolean value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, int value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, int value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, boolean value1, int value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, Uniform3iValue2UnionType value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, value3);
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, Uniform3iValue2UnionType value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, Uniform3iValue2UnionType value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, boolean value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, boolean value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, boolean value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, int value2, Uniform3iValue3UnionType value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), value3);
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, int value2, boolean value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3i(WebGLUniformLocation location, int value1, int value2, int value3) {
        this.uniform3i(location, (Uniform3iValue1UnionType)Js.uncheckedCast(value1), (Uniform3iValue2UnionType)Js.uncheckedCast(value2), (Uniform3iValue3UnionType)Js.uncheckedCast(value3));
    }

    public final void uniform3iv(WebGLUniformLocation location, Int32Array value) {
        this.uniform3iv(location, (Uniform3ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform3iv(WebGLUniformLocation location, JsArray<Object> value) {
        this.uniform3iv(location, (Uniform3ivValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform3iv(WebGLUniformLocation location, Object[] value) {
        this.uniform3iv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform3iv(WebGLUniformLocation location, Uniform3ivValueUnionType value);

    public native void uniform4f(WebGLUniformLocation location, double value1, double value2, double value3, double value4);

    public final void uniform4fv(WebGLUniformLocation location, Float32Array value) {
        this.uniform4fv(location, (Uniform4fvValueUnionType)Js.uncheckedCast(value));
    }

    public final void uniform4fv(WebGLUniformLocation location, JsArray<Double> value) {
        this.uniform4fv(location, (Uniform4fvValueUnionType)Js.uncheckedCast(value));
    }

    public native void uniform4fv(WebGLUniformLocation location, Uniform4fvValueUnionType value);

    public final void uniform4fv(WebGLUniformLocation location, double[] value) {
        this.uniform4fv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4);

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, value1, value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, value1, value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, boolean value3, boolean value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, boolean value3, int value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, int value3, boolean value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, Uniform4iValue2UnionType value2, int value3, int value4) {
        this.uniform4i(location, value1, value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, boolean value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, boolean value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, int value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, boolean value2, int value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, boolean value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, boolean value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, int value3, boolean value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, Uniform4iValue1UnionType value1, int value2, int value3, int value4) {
        this.uniform4i(location, value1, (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, value4);
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, Uniform4iValue2UnionType value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, boolean value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, boolean value1, int value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, Uniform4iValue2UnionType value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), value2, (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, boolean value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, Uniform4iValue3UnionType value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, Uniform4iValue3UnionType value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, Uniform4iValue3UnionType value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), value3, (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, boolean value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, boolean value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, boolean value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, int value3, Uniform4iValue4UnionType value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), value4);
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, int value3, boolean value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4i(WebGLUniformLocation location, int value1, int value2, int value3, int value4) {
        this.uniform4i(location, (Uniform4iValue1UnionType)Js.uncheckedCast(value1), (Uniform4iValue2UnionType)Js.uncheckedCast(value2), (Uniform4iValue3UnionType)Js.uncheckedCast(value3), (Uniform4iValue4UnionType)Js.uncheckedCast(value4));
    }

    //@JsOverlay
    public final void uniform4iv(WebGLUniformLocation location, Int32Array value) {
        this.uniform4iv(location, (Uniform4ivValueUnionType)Js.uncheckedCast(value));
    }

    //@JsOverlay
    public final void uniform4iv(WebGLUniformLocation location, JsArray<Object> value) {
        this.uniform4iv(location, (Uniform4ivValueUnionType)Js.uncheckedCast(value));
    }

    //@JsOverlay
    public final void uniform4iv(WebGLUniformLocation location, Object[] value) {
        this.uniform4iv(location, (JsArray)Js.uncheckedCast(value));
    }

    public native void uniform4iv(WebGLUniformLocation location, Uniform4ivValueUnionType value);

    //@JsOverlay
    public final void uniformMatrix2fv(WebGLUniformLocation location, boolean transpose, Float32Array data) {
        this.uniformMatrix2fv(location, transpose, (UniformMatrix2fvDataUnionType)Js.uncheckedCast(data));
    }

    //@JsOverlay
    public final void uniformMatrix2fv(WebGLUniformLocation location, boolean transpose, JsArray<Double> data) {
        this.uniformMatrix2fv(location, transpose, (UniformMatrix2fvDataUnionType)Js.uncheckedCast(data));
    }

    public native void uniformMatrix2fv(WebGLUniformLocation location, boolean transpose, UniformMatrix2fvDataUnionType data);

    //@JsOverlay
    public native void uniformMatrix2fv(WebGLUniformLocation location, boolean transpose, double[] data);/* {
        this.uniformMatrix2fv(location, transpose, (JsArray)Js.uncheckedCast(data));
    }*/

    //@JsOverlay
    public final void uniformMatrix3fv(WebGLUniformLocation location, boolean transpose, Float32Array data) {
        this.uniformMatrix3fv(location, transpose, (UniformMatrix3fvDataUnionType)Js.uncheckedCast(data));
    }

    //@JsOverlay
    public final void uniformMatrix3fv(WebGLUniformLocation location, boolean transpose, JsArray<Double> data) {
        this.uniformMatrix3fv(location, transpose, (UniformMatrix3fvDataUnionType)Js.uncheckedCast(data));
    }

    public native void uniformMatrix3fv(WebGLUniformLocation location, boolean transpose, UniformMatrix3fvDataUnionType data);

    //@JsOverlay
    public final void uniformMatrix3fv(WebGLUniformLocation location, boolean transpose, double[] data) {
        this.uniformMatrix3fv(location, transpose, (JsArray)Js.uncheckedCast(data));
    }

    //@JsOverlay
    public final void uniformMatrix4fv(WebGLUniformLocation location, boolean transpose, Float32Array data) {
        this.uniformMatrix4fv(location, transpose, (UniformMatrix4fvDataUnionType)Js.uncheckedCast(data));
    }

    //@JsOverlay
    public final void uniformMatrix4fv(WebGLUniformLocation location, boolean transpose, JsArray<Double> data) {
        this.uniformMatrix4fv(location, transpose, (UniformMatrix4fvDataUnionType)Js.uncheckedCast(data));
    }

    public native void uniformMatrix4fv(WebGLUniformLocation location, boolean transpose, UniformMatrix4fvDataUnionType data);

    //@JsOverlay
    public native void uniformMatrix4fv(WebGLUniformLocation location, boolean transpose, double[] data);/* {
        this.uniformMatrix4fv(location, transpose, (JsArray)Js.uncheckedCast(data));
    }*/

    public native void useProgram(WebGLProgram program);

    public native void validateProgram(WebGLProgram program);

    public native void vertexAttrib1f(int indx, double x);

    //@JsOverlay
    public final void vertexAttrib1fv(int indx, Float32Array values) {
        this.vertexAttrib1fv(indx, (VertexAttrib1fvValuesUnionType)Js.uncheckedCast(values));
    }

    //@JsOverlay
    public final void vertexAttrib1fv(int indx, JsArray<Double> values) {
        this.vertexAttrib1fv(indx, (VertexAttrib1fvValuesUnionType)Js.uncheckedCast(values));
    }

    public native void vertexAttrib1fv(int indx, VertexAttrib1fvValuesUnionType values);

    //@JsOverlay
    public final void vertexAttrib1fv(int indx, double[] values) {
        this.vertexAttrib1fv(indx, (JsArray)Js.uncheckedCast(values));
    }

    public native void vertexAttrib2f(int indx, double x, double y);

    //@JsOverlay
    public final void vertexAttrib2fv(int indx, Float32Array values) {
        this.vertexAttrib2fv(indx, (VertexAttrib2fvValuesUnionType)Js.uncheckedCast(values));
    }

    //@JsOverlay
    public final void vertexAttrib2fv(int indx, JsArray<Double> values) {
        this.vertexAttrib2fv(indx, (VertexAttrib2fvValuesUnionType)Js.uncheckedCast(values));
    }

    public native void vertexAttrib2fv(int indx, VertexAttrib2fvValuesUnionType values);

    //@JsOverlay
    public final void vertexAttrib2fv(int indx, double[] values) {
        this.vertexAttrib2fv(indx, (JsArray)Js.uncheckedCast(values));
    }

    public native void vertexAttrib3f(int indx, double x, double y, double z);

    //@JsOverlay
    public final void vertexAttrib3fv(int indx, Float32Array values) {
        this.vertexAttrib3fv(indx, (VertexAttrib3fvValuesUnionType)Js.uncheckedCast(values));
    }

    //@JsOverlay
    public final void vertexAttrib3fv(int indx, JsArray<Double> values) {
        this.vertexAttrib3fv(indx, (VertexAttrib3fvValuesUnionType)Js.uncheckedCast(values));
    }

    public native void vertexAttrib3fv(int indx, VertexAttrib3fvValuesUnionType values);

    //@JsOverlay
    public final void vertexAttrib3fv(int indx, double[] values) {
        this.vertexAttrib3fv(indx, (JsArray)Js.uncheckedCast(values));
    }

    public native void vertexAttrib4f(int indx, double x, double y, double z, double w);

    //@JsOverlay
    public final void vertexAttrib4fv(int indx, Float32Array values) {
        this.vertexAttrib4fv(indx, (VertexAttrib4fvValuesUnionType)Js.uncheckedCast(values));
    }

    //@JsOverlay
    public final void vertexAttrib4fv(int indx, JsArray<Double> values) {
        this.vertexAttrib4fv(indx, (VertexAttrib4fvValuesUnionType)Js.uncheckedCast(values));
    }

    public native void vertexAttrib4fv(int indx, VertexAttrib4fvValuesUnionType values);

    //@JsOverlay
    public final void vertexAttrib4fv(int indx, double[] values) {
        this.vertexAttrib4fv(indx, (JsArray)Js.uncheckedCast(values));
    }

    public native void vertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, double offset);

    public native void viewport(int x, int y, int width, int height);

    /*static {
        ACTIVE_ATTRIBUTES = WebGLRenderingContext__Constants.ACTIVE_ATTRIBUTES;
        ACTIVE_TEXTURE = WebGLRenderingContext__Constants.ACTIVE_TEXTURE;
        ACTIVE_UNIFORMS = WebGLRenderingContext__Constants.ACTIVE_UNIFORMS;
        ALIASED_LINE_WIDTH_RANGE = WebGLRenderingContext__Constants.ALIASED_LINE_WIDTH_RANGE;
        ALIASED_POINT_SIZE_RANGE = WebGLRenderingContext__Constants.ALIASED_POINT_SIZE_RANGE;
        ALPHA = WebGLRenderingContext__Constants.ALPHA;
        ALPHA_BITS = WebGLRenderingContext__Constants.ALPHA_BITS;
        ALWAYS = WebGLRenderingContext__Constants.ALWAYS;
        ARRAY_BUFFER = WebGLRenderingContext__Constants.ARRAY_BUFFER;
        ARRAY_BUFFER_BINDING = WebGLRenderingContext__Constants.ARRAY_BUFFER_BINDING;
        ATTACHED_SHADERS = WebGLRenderingContext__Constants.ATTACHED_SHADERS;
        BACK = WebGLRenderingContext__Constants.BACK;
        BLEND = WebGLRenderingContext__Constants.BLEND;
        BLEND_COLOR = WebGLRenderingContext__Constants.BLEND_COLOR;
        BLEND_DST_ALPHA = WebGLRenderingContext__Constants.BLEND_DST_ALPHA;
        BLEND_DST_RGB = WebGLRenderingContext__Constants.BLEND_DST_RGB;
        BLEND_EQUATION = WebGLRenderingContext__Constants.BLEND_EQUATION;
        BLEND_EQUATION_ALPHA = WebGLRenderingContext__Constants.BLEND_EQUATION_ALPHA;
        BLEND_EQUATION_RGB = WebGLRenderingContext__Constants.BLEND_EQUATION_RGB;
        BLEND_SRC_ALPHA = WebGLRenderingContext__Constants.BLEND_SRC_ALPHA;
        BLEND_SRC_RGB = WebGLRenderingContext__Constants.BLEND_SRC_RGB;
        BLUE_BITS = WebGLRenderingContext__Constants.BLUE_BITS;
        BOOL = WebGLRenderingContext__Constants.BOOL;
        BOOL_VEC2 = WebGLRenderingContext__Constants.BOOL_VEC2;
        BOOL_VEC3 = WebGLRenderingContext__Constants.BOOL_VEC3;
        BOOL_VEC4 = WebGLRenderingContext__Constants.BOOL_VEC4;
        BROWSER_DEFAULT_WEBGL = WebGLRenderingContext__Constants.BROWSER_DEFAULT_WEBGL;
        BUFFER_SIZE = WebGLRenderingContext__Constants.BUFFER_SIZE;
        BUFFER_USAGE = WebGLRenderingContext__Constants.BUFFER_USAGE;
        BYTE = WebGLRenderingContext__Constants.BYTE;
        CCW = WebGLRenderingContext__Constants.CCW;
        CLAMP_TO_EDGE = WebGLRenderingContext__Constants.CLAMP_TO_EDGE;
        COLOR_ATTACHMENT0 = WebGLRenderingContext__Constants.COLOR_ATTACHMENT0;
        COLOR_BUFFER_BIT = WebGLRenderingContext__Constants.COLOR_BUFFER_BIT;
        COLOR_CLEAR_VALUE = WebGLRenderingContext__Constants.COLOR_CLEAR_VALUE;
        COLOR_WRITEMASK = WebGLRenderingContext__Constants.COLOR_WRITEMASK;
        COMPILE_STATUS = WebGLRenderingContext__Constants.COMPILE_STATUS;
        COMPRESSED_TEXTURE_FORMATS = WebGLRenderingContext__Constants.COMPRESSED_TEXTURE_FORMATS;
        CONSTANT_ALPHA = WebGLRenderingContext__Constants.CONSTANT_ALPHA;
        CONSTANT_COLOR = WebGLRenderingContext__Constants.CONSTANT_COLOR;
        CONTEXT_LOST_WEBGL = WebGLRenderingContext__Constants.CONTEXT_LOST_WEBGL;
        CULL_FACE = WebGLRenderingContext__Constants.CULL_FACE;
        CULL_FACE_MODE = WebGLRenderingContext__Constants.CULL_FACE_MODE;
        CURRENT_PROGRAM = WebGLRenderingContext__Constants.CURRENT_PROGRAM;
        CURRENT_VERTEX_ATTRIB = WebGLRenderingContext__Constants.CURRENT_VERTEX_ATTRIB;
        CW = WebGLRenderingContext__Constants.CW;
        DECR = WebGLRenderingContext__Constants.DECR;
        DECR_WRAP = WebGLRenderingContext__Constants.DECR_WRAP;
        DELETE_STATUS = WebGLRenderingContext__Constants.DELETE_STATUS;
        DEPTH_ATTACHMENT = WebGLRenderingContext__Constants.DEPTH_ATTACHMENT;
        DEPTH_BITS = WebGLRenderingContext__Constants.DEPTH_BITS;
        DEPTH_BUFFER_BIT = WebGLRenderingContext__Constants.DEPTH_BUFFER_BIT;
        DEPTH_CLEAR_VALUE = WebGLRenderingContext__Constants.DEPTH_CLEAR_VALUE;
        DEPTH_COMPONENT = WebGLRenderingContext__Constants.DEPTH_COMPONENT;
        DEPTH_COMPONENT16 = WebGLRenderingContext__Constants.DEPTH_COMPONENT16;
        DEPTH_FUNC = WebGLRenderingContext__Constants.DEPTH_FUNC;
        DEPTH_RANGE = WebGLRenderingContext__Constants.DEPTH_RANGE;
        DEPTH_STENCIL = WebGLRenderingContext__Constants.DEPTH_STENCIL;
        DEPTH_STENCIL_ATTACHMENT = WebGLRenderingContext__Constants.DEPTH_STENCIL_ATTACHMENT;
        DEPTH_TEST = WebGLRenderingContext__Constants.DEPTH_TEST;
        DEPTH_WRITEMASK = WebGLRenderingContext__Constants.DEPTH_WRITEMASK;
        DITHER = WebGLRenderingContext__Constants.DITHER;
        DONT_CARE = WebGLRenderingContext__Constants.DONT_CARE;
        DST_ALPHA = WebGLRenderingContext__Constants.DST_ALPHA;
        DST_COLOR = WebGLRenderingContext__Constants.DST_COLOR;
        DYNAMIC_DRAW = WebGLRenderingContext__Constants.DYNAMIC_DRAW;
        ELEMENT_ARRAY_BUFFER = WebGLRenderingContext__Constants.ELEMENT_ARRAY_BUFFER;
        ELEMENT_ARRAY_BUFFER_BINDING = WebGLRenderingContext__Constants.ELEMENT_ARRAY_BUFFER_BINDING;
        EQUAL = WebGLRenderingContext__Constants.EQUAL;
        FASTEST = WebGLRenderingContext__Constants.FASTEST;
        FLOAT = WebGLRenderingContext__Constants.FLOAT;
        FLOAT_MAT2 = WebGLRenderingContext__Constants.FLOAT_MAT2;
        FLOAT_MAT3 = WebGLRenderingContext__Constants.FLOAT_MAT3;
        FLOAT_MAT4 = WebGLRenderingContext__Constants.FLOAT_MAT4;
        FLOAT_VEC2 = WebGLRenderingContext__Constants.FLOAT_VEC2;
        FLOAT_VEC3 = WebGLRenderingContext__Constants.FLOAT_VEC3;
        FLOAT_VEC4 = WebGLRenderingContext__Constants.FLOAT_VEC4;
        FRAGMENT_SHADER = WebGLRenderingContext__Constants.FRAGMENT_SHADER;
        FRAMEBUFFER = WebGLRenderingContext__Constants.FRAMEBUFFER;
        FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = WebGLRenderingContext__Constants.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
        FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = WebGLRenderingContext__Constants.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
        FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = WebGLRenderingContext__Constants.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
        FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = WebGLRenderingContext__Constants.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
        FRAMEBUFFER_BINDING = WebGLRenderingContext__Constants.FRAMEBUFFER_BINDING;
        FRAMEBUFFER_COMPLETE = WebGLRenderingContext__Constants.FRAMEBUFFER_COMPLETE;
        FRAMEBUFFER_INCOMPLETE_ATTACHMENT = WebGLRenderingContext__Constants.FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
        FRAMEBUFFER_INCOMPLETE_DIMENSIONS = WebGLRenderingContext__Constants.FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
        FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = WebGLRenderingContext__Constants.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
        FRAMEBUFFER_UNSUPPORTED = WebGLRenderingContext__Constants.FRAMEBUFFER_UNSUPPORTED;
        FRONT = WebGLRenderingContext__Constants.FRONT;
        FRONT_AND_BACK = WebGLRenderingContext__Constants.FRONT_AND_BACK;
        FRONT_FACE = WebGLRenderingContext__Constants.FRONT_FACE;
        FUNC_ADD = WebGLRenderingContext__Constants.FUNC_ADD;
        FUNC_REVERSE_SUBTRACT = WebGLRenderingContext__Constants.FUNC_REVERSE_SUBTRACT;
        FUNC_SUBTRACT = WebGLRenderingContext__Constants.FUNC_SUBTRACT;
        GENERATE_MIPMAP_HINT = WebGLRenderingContext__Constants.GENERATE_MIPMAP_HINT;
        GEQUAL = WebGLRenderingContext__Constants.GEQUAL;
        GREATER = WebGLRenderingContext__Constants.GREATER;
        GREEN_BITS = WebGLRenderingContext__Constants.GREEN_BITS;
        HIGH_FLOAT = WebGLRenderingContext__Constants.HIGH_FLOAT;
        HIGH_INT = WebGLRenderingContext__Constants.HIGH_INT;
        IMPLEMENTATION_COLOR_READ_FORMAT = WebGLRenderingContext__Constants.IMPLEMENTATION_COLOR_READ_FORMAT;
        IMPLEMENTATION_COLOR_READ_TYPE = WebGLRenderingContext__Constants.IMPLEMENTATION_COLOR_READ_TYPE;
        INCR = WebGLRenderingContext__Constants.INCR;
        INCR_WRAP = WebGLRenderingContext__Constants.INCR_WRAP;
        INT = WebGLRenderingContext__Constants.INT;
        INT_VEC2 = WebGLRenderingContext__Constants.INT_VEC2;
        INT_VEC3 = WebGLRenderingContext__Constants.INT_VEC3;
        INT_VEC4 = WebGLRenderingContext__Constants.INT_VEC4;
        INVALID_ENUM = WebGLRenderingContext__Constants.INVALID_ENUM;
        INVALID_FRAMEBUFFER_OPERATION = WebGLRenderingContext__Constants.INVALID_FRAMEBUFFER_OPERATION;
        INVALID_OPERATION = WebGLRenderingContext__Constants.INVALID_OPERATION;
        INVALID_VALUE = WebGLRenderingContext__Constants.INVALID_VALUE;
        INVERT = WebGLRenderingContext__Constants.INVERT;
        KEEP = WebGLRenderingContext__Constants.KEEP;
        LEQUAL = WebGLRenderingContext__Constants.LEQUAL;
        LESS = WebGLRenderingContext__Constants.LESS;
        LINEAR = WebGLRenderingContext__Constants.LINEAR;
        LINEAR_MIPMAP_LINEAR = WebGLRenderingContext__Constants.LINEAR_MIPMAP_LINEAR;
        LINEAR_MIPMAP_NEAREST = WebGLRenderingContext__Constants.LINEAR_MIPMAP_NEAREST;
        LINES = WebGLRenderingContext__Constants.LINES;
        LINE_LOOP = WebGLRenderingContext__Constants.LINE_LOOP;
        LINE_STRIP = WebGLRenderingContext__Constants.LINE_STRIP;
        LINE_WIDTH = WebGLRenderingContext__Constants.LINE_WIDTH;
        LINK_STATUS = WebGLRenderingContext__Constants.LINK_STATUS;
        LOW_FLOAT = WebGLRenderingContext__Constants.LOW_FLOAT;
        LOW_INT = WebGLRenderingContext__Constants.LOW_INT;
        LUMINANCE = WebGLRenderingContext__Constants.LUMINANCE;
        LUMINANCE_ALPHA = WebGLRenderingContext__Constants.LUMINANCE_ALPHA;
        MAX_COMBINED_TEXTURE_IMAGE_UNITS = WebGLRenderingContext__Constants.MAX_COMBINED_TEXTURE_IMAGE_UNITS;
        MAX_CUBE_MAP_TEXTURE_SIZE = WebGLRenderingContext__Constants.MAX_CUBE_MAP_TEXTURE_SIZE;
        MAX_FRAGMENT_UNIFORM_VECTORS = WebGLRenderingContext__Constants.MAX_FRAGMENT_UNIFORM_VECTORS;
        MAX_RENDERBUFFER_SIZE = WebGLRenderingContext__Constants.MAX_RENDERBUFFER_SIZE;
        MAX_TEXTURE_IMAGE_UNITS = WebGLRenderingContext__Constants.MAX_TEXTURE_IMAGE_UNITS;
        MAX_TEXTURE_SIZE = WebGLRenderingContext__Constants.MAX_TEXTURE_SIZE;
        MAX_VARYING_VECTORS = WebGLRenderingContext__Constants.MAX_VARYING_VECTORS;
        MAX_VERTEX_ATTRIBS = WebGLRenderingContext__Constants.MAX_VERTEX_ATTRIBS;
        MAX_VERTEX_TEXTURE_IMAGE_UNITS = WebGLRenderingContext__Constants.MAX_VERTEX_TEXTURE_IMAGE_UNITS;
        MAX_VERTEX_UNIFORM_VECTORS = WebGLRenderingContext__Constants.MAX_VERTEX_UNIFORM_VECTORS;
        MAX_VIEWPORT_DIMS = WebGLRenderingContext__Constants.MAX_VIEWPORT_DIMS;
        MEDIUM_FLOAT = WebGLRenderingContext__Constants.MEDIUM_FLOAT;
        MEDIUM_INT = WebGLRenderingContext__Constants.MEDIUM_INT;
        MIRRORED_REPEAT = WebGLRenderingContext__Constants.MIRRORED_REPEAT;
        NEAREST = WebGLRenderingContext__Constants.NEAREST;
        NEAREST_MIPMAP_LINEAR = WebGLRenderingContext__Constants.NEAREST_MIPMAP_LINEAR;
        NEAREST_MIPMAP_NEAREST = WebGLRenderingContext__Constants.NEAREST_MIPMAP_NEAREST;
        NEVER = WebGLRenderingContext__Constants.NEVER;
        NICEST = WebGLRenderingContext__Constants.NICEST;
        NONE = WebGLRenderingContext__Constants.NONE;
        NOTEQUAL = WebGLRenderingContext__Constants.NOTEQUAL;
        NO_ERROR = WebGLRenderingContext__Constants.NO_ERROR;
        ONE = WebGLRenderingContext__Constants.ONE;
        ONE_MINUS_CONSTANT_ALPHA = WebGLRenderingContext__Constants.ONE_MINUS_CONSTANT_ALPHA;
        ONE_MINUS_CONSTANT_COLOR = WebGLRenderingContext__Constants.ONE_MINUS_CONSTANT_COLOR;
        ONE_MINUS_DST_ALPHA = WebGLRenderingContext__Constants.ONE_MINUS_DST_ALPHA;
        ONE_MINUS_DST_COLOR = WebGLRenderingContext__Constants.ONE_MINUS_DST_COLOR;
        ONE_MINUS_SRC_ALPHA = WebGLRenderingContext__Constants.ONE_MINUS_SRC_ALPHA;
        ONE_MINUS_SRC_COLOR = WebGLRenderingContext__Constants.ONE_MINUS_SRC_COLOR;
        OUT_OF_MEMORY = WebGLRenderingContext__Constants.OUT_OF_MEMORY;
        PACK_ALIGNMENT = WebGLRenderingContext__Constants.PACK_ALIGNMENT;
        POINTS = WebGLRenderingContext__Constants.POINTS;
        POLYGON_OFFSET_FACTOR = WebGLRenderingContext__Constants.POLYGON_OFFSET_FACTOR;
        POLYGON_OFFSET_FILL = WebGLRenderingContext__Constants.POLYGON_OFFSET_FILL;
        POLYGON_OFFSET_UNITS = WebGLRenderingContext__Constants.POLYGON_OFFSET_UNITS;
        RED_BITS = WebGLRenderingContext__Constants.RED_BITS;
        RENDERBUFFER = WebGLRenderingContext__Constants.RENDERBUFFER;
        RENDERBUFFER_ALPHA_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_ALPHA_SIZE;
        RENDERBUFFER_BINDING = WebGLRenderingContext__Constants.RENDERBUFFER_BINDING;
        RENDERBUFFER_BLUE_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_BLUE_SIZE;
        RENDERBUFFER_DEPTH_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_DEPTH_SIZE;
        RENDERBUFFER_GREEN_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_GREEN_SIZE;
        RENDERBUFFER_HEIGHT = WebGLRenderingContext__Constants.RENDERBUFFER_HEIGHT;
        RENDERBUFFER_INTERNAL_FORMAT = WebGLRenderingContext__Constants.RENDERBUFFER_INTERNAL_FORMAT;
        RENDERBUFFER_RED_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_RED_SIZE;
        RENDERBUFFER_STENCIL_SIZE = WebGLRenderingContext__Constants.RENDERBUFFER_STENCIL_SIZE;
        RENDERBUFFER_WIDTH = WebGLRenderingContext__Constants.RENDERBUFFER_WIDTH;
        RENDERER = WebGLRenderingContext__Constants.RENDERER;
        REPEAT = WebGLRenderingContext__Constants.REPEAT;
        REPLACE = WebGLRenderingContext__Constants.REPLACE;
        RGB = WebGLRenderingContext__Constants.RGB;
        RGB565 = WebGLRenderingContext__Constants.RGB565;
        RGB5_A1 = WebGLRenderingContext__Constants.RGB5_A1;
        RGBA = WebGLRenderingContext__Constants.RGBA;
        RGBA4 = WebGLRenderingContext__Constants.RGBA4;
        SAMPLER_2D = WebGLRenderingContext__Constants.SAMPLER_2D;
        SAMPLER_CUBE = WebGLRenderingContext__Constants.SAMPLER_CUBE;
        SAMPLES = WebGLRenderingContext__Constants.SAMPLES;
        SAMPLE_ALPHA_TO_COVERAGE = WebGLRenderingContext__Constants.SAMPLE_ALPHA_TO_COVERAGE;
        SAMPLE_BUFFERS = WebGLRenderingContext__Constants.SAMPLE_BUFFERS;
        SAMPLE_COVERAGE = WebGLRenderingContext__Constants.SAMPLE_COVERAGE;
        SAMPLE_COVERAGE_INVERT = WebGLRenderingContext__Constants.SAMPLE_COVERAGE_INVERT;
        SAMPLE_COVERAGE_VALUE = WebGLRenderingContext__Constants.SAMPLE_COVERAGE_VALUE;
        SCISSOR_BOX = WebGLRenderingContext__Constants.SCISSOR_BOX;
        SCISSOR_TEST = WebGLRenderingContext__Constants.SCISSOR_TEST;
        SHADER_TYPE = WebGLRenderingContext__Constants.SHADER_TYPE;
        SHADING_LANGUAGE_VERSION = WebGLRenderingContext__Constants.SHADING_LANGUAGE_VERSION;
        SHORT = WebGLRenderingContext__Constants.SHORT;
        SRC_ALPHA = WebGLRenderingContext__Constants.SRC_ALPHA;
        SRC_ALPHA_SATURATE = WebGLRenderingContext__Constants.SRC_ALPHA_SATURATE;
        SRC_COLOR = WebGLRenderingContext__Constants.SRC_COLOR;
        STATIC_DRAW = WebGLRenderingContext__Constants.STATIC_DRAW;
        STENCIL_ATTACHMENT = WebGLRenderingContext__Constants.STENCIL_ATTACHMENT;
        STENCIL_BACK_FAIL = WebGLRenderingContext__Constants.STENCIL_BACK_FAIL;
        STENCIL_BACK_FUNC = WebGLRenderingContext__Constants.STENCIL_BACK_FUNC;
        STENCIL_BACK_PASS_DEPTH_FAIL = WebGLRenderingContext__Constants.STENCIL_BACK_PASS_DEPTH_FAIL;
        STENCIL_BACK_PASS_DEPTH_PASS = WebGLRenderingContext__Constants.STENCIL_BACK_PASS_DEPTH_PASS;
        STENCIL_BACK_REF = WebGLRenderingContext__Constants.STENCIL_BACK_REF;
        STENCIL_BACK_VALUE_MASK = WebGLRenderingContext__Constants.STENCIL_BACK_VALUE_MASK;
        STENCIL_BACK_WRITEMASK = WebGLRenderingContext__Constants.STENCIL_BACK_WRITEMASK;
        STENCIL_BITS = WebGLRenderingContext__Constants.STENCIL_BITS;
        STENCIL_BUFFER_BIT = WebGLRenderingContext__Constants.STENCIL_BUFFER_BIT;
        STENCIL_CLEAR_VALUE = WebGLRenderingContext__Constants.STENCIL_CLEAR_VALUE;
        STENCIL_FAIL = WebGLRenderingContext__Constants.STENCIL_FAIL;
        STENCIL_FUNC = WebGLRenderingContext__Constants.STENCIL_FUNC;
        STENCIL_INDEX = WebGLRenderingContext__Constants.STENCIL_INDEX;
        STENCIL_INDEX8 = WebGLRenderingContext__Constants.STENCIL_INDEX8;
        STENCIL_PASS_DEPTH_FAIL = WebGLRenderingContext__Constants.STENCIL_PASS_DEPTH_FAIL;
        STENCIL_PASS_DEPTH_PASS = WebGLRenderingContext__Constants.STENCIL_PASS_DEPTH_PASS;
        STENCIL_REF = WebGLRenderingContext__Constants.STENCIL_REF;
        STENCIL_TEST = WebGLRenderingContext__Constants.STENCIL_TEST;
        STENCIL_VALUE_MASK = WebGLRenderingContext__Constants.STENCIL_VALUE_MASK;
        STENCIL_WRITEMASK = WebGLRenderingContext__Constants.STENCIL_WRITEMASK;
        STREAM_DRAW = WebGLRenderingContext__Constants.STREAM_DRAW;
        SUBPIXEL_BITS = WebGLRenderingContext__Constants.SUBPIXEL_BITS;
        TEXTURE = WebGLRenderingContext__Constants.TEXTURE;
        TEXTURE0 = WebGLRenderingContext__Constants.TEXTURE0;
        TEXTURE1 = WebGLRenderingContext__Constants.TEXTURE1;
        TEXTURE10 = WebGLRenderingContext__Constants.TEXTURE10;
        TEXTURE11 = WebGLRenderingContext__Constants.TEXTURE11;
        TEXTURE12 = WebGLRenderingContext__Constants.TEXTURE12;
        TEXTURE13 = WebGLRenderingContext__Constants.TEXTURE13;
        TEXTURE14 = WebGLRenderingContext__Constants.TEXTURE14;
        TEXTURE15 = WebGLRenderingContext__Constants.TEXTURE15;
        TEXTURE16 = WebGLRenderingContext__Constants.TEXTURE16;
        TEXTURE17 = WebGLRenderingContext__Constants.TEXTURE17;
        TEXTURE18 = WebGLRenderingContext__Constants.TEXTURE18;
        TEXTURE19 = WebGLRenderingContext__Constants.TEXTURE19;
        TEXTURE2 = WebGLRenderingContext__Constants.TEXTURE2;
        TEXTURE20 = WebGLRenderingContext__Constants.TEXTURE20;
        TEXTURE21 = WebGLRenderingContext__Constants.TEXTURE21;
        TEXTURE22 = WebGLRenderingContext__Constants.TEXTURE22;
        TEXTURE23 = WebGLRenderingContext__Constants.TEXTURE23;
        TEXTURE24 = WebGLRenderingContext__Constants.TEXTURE24;
        TEXTURE25 = WebGLRenderingContext__Constants.TEXTURE25;
        TEXTURE26 = WebGLRenderingContext__Constants.TEXTURE26;
        TEXTURE27 = WebGLRenderingContext__Constants.TEXTURE27;
        TEXTURE28 = WebGLRenderingContext__Constants.TEXTURE28;
        TEXTURE29 = WebGLRenderingContext__Constants.TEXTURE29;
        TEXTURE3 = WebGLRenderingContext__Constants.TEXTURE3;
        TEXTURE30 = WebGLRenderingContext__Constants.TEXTURE30;
        TEXTURE31 = WebGLRenderingContext__Constants.TEXTURE31;
        TEXTURE4 = WebGLRenderingContext__Constants.TEXTURE4;
        TEXTURE5 = WebGLRenderingContext__Constants.TEXTURE5;
        TEXTURE6 = WebGLRenderingContext__Constants.TEXTURE6;
        TEXTURE7 = WebGLRenderingContext__Constants.TEXTURE7;
        TEXTURE8 = WebGLRenderingContext__Constants.TEXTURE8;
        TEXTURE9 = WebGLRenderingContext__Constants.TEXTURE9;
        TEXTURE_2D = WebGLRenderingContext__Constants.TEXTURE_2D;
        TEXTURE_BINDING_2D = WebGLRenderingContext__Constants.TEXTURE_BINDING_2D;
        TEXTURE_BINDING_CUBE_MAP = WebGLRenderingContext__Constants.TEXTURE_BINDING_CUBE_MAP;
        TEXTURE_CUBE_MAP = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP;
        TEXTURE_CUBE_MAP_NEGATIVE_X = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_NEGATIVE_X;
        TEXTURE_CUBE_MAP_NEGATIVE_Y = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_NEGATIVE_Y;
        TEXTURE_CUBE_MAP_NEGATIVE_Z = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_NEGATIVE_Z;
        TEXTURE_CUBE_MAP_POSITIVE_X = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_POSITIVE_X;
        TEXTURE_CUBE_MAP_POSITIVE_Y = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_POSITIVE_Y;
        TEXTURE_CUBE_MAP_POSITIVE_Z = WebGLRenderingContext__Constants.TEXTURE_CUBE_MAP_POSITIVE_Z;
        TEXTURE_MAG_FILTER = WebGLRenderingContext__Constants.TEXTURE_MAG_FILTER;
        TEXTURE_MIN_FILTER = WebGLRenderingContext__Constants.TEXTURE_MIN_FILTER;
        TEXTURE_WRAP_S = WebGLRenderingContext__Constants.TEXTURE_WRAP_S;
        TEXTURE_WRAP_T = WebGLRenderingContext__Constants.TEXTURE_WRAP_T;
        TRIANGLES = WebGLRenderingContext__Constants.TRIANGLES;
        TRIANGLE_FAN = WebGLRenderingContext__Constants.TRIANGLE_FAN;
        TRIANGLE_STRIP = WebGLRenderingContext__Constants.TRIANGLE_STRIP;
        UNPACK_ALIGNMENT = WebGLRenderingContext__Constants.UNPACK_ALIGNMENT;
        UNPACK_COLORSPACE_CONVERSION_WEBGL = WebGLRenderingContext__Constants.UNPACK_COLORSPACE_CONVERSION_WEBGL;
        UNPACK_FLIP_Y_WEBGL = WebGLRenderingContext__Constants.UNPACK_FLIP_Y_WEBGL;
        UNPACK_PREMULTIPLY_ALPHA_WEBGL = WebGLRenderingContext__Constants.UNPACK_PREMULTIPLY_ALPHA_WEBGL;
        UNSIGNED_BYTE = WebGLRenderingContext__Constants.UNSIGNED_BYTE;
        UNSIGNED_INT = WebGLRenderingContext__Constants.UNSIGNED_INT;
        UNSIGNED_SHORT = WebGLRenderingContext__Constants.UNSIGNED_SHORT;
        UNSIGNED_SHORT_4_4_4_4 = WebGLRenderingContext__Constants.UNSIGNED_SHORT_4_4_4_4;
        UNSIGNED_SHORT_5_5_5_1 = WebGLRenderingContext__Constants.UNSIGNED_SHORT_5_5_5_1;
        UNSIGNED_SHORT_5_6_5 = WebGLRenderingContext__Constants.UNSIGNED_SHORT_5_6_5;
        VALIDATE_STATUS = WebGLRenderingContext__Constants.VALIDATE_STATUS;
        VENDOR = WebGLRenderingContext__Constants.VENDOR;
        VERSION = WebGLRenderingContext__Constants.VERSION;
        VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
        VERTEX_ATTRIB_ARRAY_ENABLED = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_ENABLED;
        VERTEX_ATTRIB_ARRAY_NORMALIZED = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_NORMALIZED;
        VERTEX_ATTRIB_ARRAY_POINTER = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_POINTER;
        VERTEX_ATTRIB_ARRAY_SIZE = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_SIZE;
        VERTEX_ATTRIB_ARRAY_STRIDE = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_STRIDE;
        VERTEX_ATTRIB_ARRAY_TYPE = WebGLRenderingContext__Constants.VERTEX_ATTRIB_ARRAY_TYPE;
        VERTEX_SHADER = WebGLRenderingContext__Constants.VERTEX_SHADER;
        VIEWPORT = WebGLRenderingContext__Constants.VIEWPORT;
        ZERO = WebGLRenderingContext__Constants.ZERO;
    }*/

    public interface BufferDataDataUnionType extends JSObject {
        static BufferDataDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface BufferSubDataDataUnionType extends JSObject {
        static BufferSubDataDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface PixelStoreiParamUnionType extends JSObject {
        static PixelStoreiParamUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface TexImage2DImgUnionType extends JSObject {
        static TexImage2DImgUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface TexSubImage2DDataUnionType extends JSObject {
        static TexSubImage2DDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform1fvValueUnionType extends JSObject {
        static Uniform1fvValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform1iValueUnionType extends JSObject {
        static Uniform1iValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform1ivValueUnionType extends JSObject {
        static Uniform1ivValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform2fvValueUnionType extends JSObject {
        static Uniform2fvValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform2iValue1UnionType extends JSObject {
        static Uniform2iValue1UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform2iValue2UnionType extends JSObject {
        static Uniform2iValue2UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform2ivValueUnionType extends JSObject {
        static Uniform2ivValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform3fvValueUnionType extends JSObject {
        static Uniform3fvValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform3iValue1UnionType {
        static Uniform3iValue1UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform3iValue2UnionType extends JSObject {
        static Uniform3iValue2UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform3iValue3UnionType extends JSObject {
        static Uniform3iValue3UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform3ivValueUnionType extends JSObject {
        static Uniform3ivValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4fvValueUnionType extends JSObject {
        static Uniform4fvValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4iValue1UnionType extends JSObject {
        static Uniform4iValue1UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4iValue2UnionType extends JSObject {
        static Uniform4iValue2UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4iValue3UnionType extends JSObject {
        static Uniform4iValue3UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4iValue4UnionType extends JSObject {
        static Uniform4iValue4UnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface Uniform4ivValueUnionType extends JSObject {
        static Uniform4ivValueUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface UniformMatrix2fvDataUnionType extends JSObject {
        static UniformMatrix2fvDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface UniformMatrix3fvDataUnionType extends JSObject {
        static UniformMatrix3fvDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface UniformMatrix4fvDataUnionType extends JSObject {
        static UniformMatrix4fvDataUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface VertexAttrib1fvValuesUnionType extends JSObject {
        static VertexAttrib1fvValuesUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface VertexAttrib2fvValuesUnionType extends JSObject {
        static VertexAttrib2fvValuesUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface VertexAttrib3fvValuesUnionType extends JSObject {
        static VertexAttrib3fvValuesUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface VertexAttrib4fvValuesUnionType extends JSObject {
        static VertexAttrib4fvValuesUnionType of(Object o) {
            return Js.cast(o);
        }
    }
}
