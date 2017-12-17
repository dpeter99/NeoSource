import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL20

abstract class Shader
{
    private val shaderId: Int
    private val vertexShaderId: Int
    private val fragmentShaderId: Int
    
    
    constructor(vertexShaderCode: String, fragmentShaderCode: String)
    {
        vertexShaderId = compileShader(vertexShaderCode, GL20.GL_VERTEX_SHADER)
        fragmentShaderId = compileShader(fragmentShaderCode, GL20.GL_FRAGMENT_SHADER)
        shaderId = GL20.glCreateProgram()
        GL20.glAttachShader(shaderId, vertexShaderId)
        GL20.glAttachShader(shaderId, fragmentShaderId)
        bindAttributes()
        GL20.glLinkProgram(shaderId)
        GL20.glValidateProgram(shaderId)
        getUniformLocations()
    }
    
    
    fun start() = GL20.glUseProgram(shaderId)
    fun stop() = GL20.glUseProgram(0)
    
    fun cleanUp()
    {
        stop()
        GL20.glDetachShader(shaderId, vertexShaderId)
        GL20.glDetachShader(shaderId, fragmentShaderId)
        GL20.glDeleteShader(vertexShaderId)
        GL20.glDeleteShader(fragmentShaderId)
        GL20.glDeleteProgram(shaderId)
    }
    
    
    //Uniforms
    protected fun loadUniformFloat(location: Int, value: Float) = GL20.glUniform1f(location, value)
    protected fun loadUniformVector3(location: Int, value: NeoMath.Vector3) = GL20.glUniform3f(location, value.x, value.y, value.z)
    protected fun loadUniformBoolean(location: Int, value: Boolean) = loadUniformInteger(location, if (value) 1 else 0)
    protected fun loadUniformInteger(location: Int, value: Int) = GL20.glUniform1i(location, value)
    //TODO: Matrix4
    
    protected fun bindAttribute(attribute: Int, variableName: String) = GL20.glBindAttribLocation(shaderId, attribute, variableName)
    
    abstract fun bindAttributes()
    abstract fun getUniformLocations()
}

private fun compileShader(source: String, type: Int): Int
{
    val newShaderId = GL20.glCreateShader(type)
    GL20.glShaderSource(newShaderId, source)
    GL20.glCompileShader(newShaderId)
    
    if (GL20.glGetShaderi(newShaderId, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE)
        throw IllegalStateException(GL20.glGetShaderInfoLog(newShaderId))
    
    return newShaderId
}