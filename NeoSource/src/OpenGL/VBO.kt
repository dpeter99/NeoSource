package OpenGL

import org.lwjgl.opengl.GL15

class VBO (val index: Int, val size: Int, val varType: Int)
{
    val id: Int
    
    init
    {
        id = GL15.glGenBuffers()
    }
    
    //glBind
    fun bind()
    {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id)
    }
    
    //glBufferData
    fun bufferData(data: Array<Float>)
    {
        bind()
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toFloatArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Double>)
    {
        bind()
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toDoubleArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Short>)
    {
        bind()
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toShortArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Int>)
    {
        bind()
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toIntArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Long>)
    {
        bind()
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toLongArray(), GL15.GL_STATIC_DRAW)
    }
}