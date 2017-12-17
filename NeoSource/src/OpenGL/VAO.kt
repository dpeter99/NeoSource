package OpenGL

import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30

class VAO
{
    val id: Int
    private val vboIDs = mutableListOf<Int>()
    
    var ibo: IBO? = null
        private set
    
    init
    {
        id = GL30.glGenVertexArrays()
    }
    
    fun bind()
    {
        GL30.glBindVertexArray(id)
    }
    
    fun addVBO(vbo: VBO)
    {
        bind()
        vbo.bind()
        GL20.glVertexAttribPointer(vbo.index, vbo.size, vbo.varType, false, 0, 0)
        GL20.glEnableVertexAttribArray(vbo.index)
        
        vboIDs.add(vbo.id)
    }
    
    fun setIBO(ibo: IBO)
    {
        bind()
        ibo.bind()
        
        this.ibo = ibo
    }
    
    //Getter
    fun getVboIDs() = vboIDs.toList()
}