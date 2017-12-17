package OpenGL

import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL30

class IBO
{
    val id: Int
    var size: Int = 0
    
    init
    {
        id = GL15.glGenBuffers()
    }
    
    //Not doing this before binding binds it to the currently bound VAO, which we don't want to do when setting data.
    fun unbindVAO()
    {
        GL30.glBindVertexArray(0)
    }
    
    //glBind
    fun bind()
    {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id)
    }
    
    fun prepareSetData(size: Int)
    {
        unbindVAO()
        bind()
        this.size += size
    }
    
    //glBufferData
    fun bufferData(data: Array<Short>)
    {
        prepareSetData(data.size)
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toShortArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Int>)
    {
        prepareSetData(data.size)
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toIntArray(), GL15.GL_STATIC_DRAW)
    }
    
    fun bufferData(data: Array<Long>)
    {
        prepareSetData(data.size)
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data.toLongArray(), GL15.GL_STATIC_DRAW)
    }
}