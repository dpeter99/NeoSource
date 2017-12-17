import OpenGL.VBO
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30


private val vaos = mutableListOf<Int>()
private val vbos = mutableListOf<Int>()
private val textures = mutableListOf<Int>()


val VAO_POSITIONS = 0
val VAO_TEXTURE_COORDINATES = 1


fun loadModel(positions: Array<Float>, textureCoordinates: Array<Float>, sections: Array<MeshIndices>): StaticMesh
{
    //Create VBOs
    val vboPositions = VBO(VAO_POSITIONS, 3, GL11.GL_FLOAT)
    val vboTextureCoordinates = VBO(VAO_TEXTURE_COORDINATES, 2, GL11.GL_FLOAT)
    
    //Fill VBOs with data
    vboPositions.bufferData(positions)
    vboTextureCoordinates.bufferData(textureCoordinates)
    
    
    for (section in sections)
    {
        val vaoTriangles = fillVAO(section.triangles)
        
        for (indices in section.triangleStrips)
        {
            val vaoTriangleStrips = GL30.glGenVertexArrays()
            fillVAO()
        }
        val vaoTriangleFans = GL30.glGenVertexArrays()
    
        val vaoLines = GL30.glGenVertexArrays()
        val vaoLineStips = GL30.glGenVertexArrays()
        val vaoLoops = GL30.glGenVertexArrays()
    
        val vaoPoints = GL30.glGenVertexArrays()
    }
    
    //For each section create a VAO for every item
    // Create VBO for indices and Bind
    // Bind VBOs
    // Add VAO object to list
    
    //Create StaticMesh
    //Return
}


class MeshIndices
(
    val triangles: Array<Int>,
    val triangleStrips: Array<Array<Int>>,
    val triangleFans: Array<Array<Int>>,

    val lines: Array<Int>,
    val lineStrips: Array<Array<Int>>,
    val lineLoops: Array<Array<Int>>,

    val points: Array<Int>
)


fun cleanUp()
{
    //VAOs
    for (vao in vaos)
        GL30.glDeleteVertexArrays(vao)
    
    //VBOs
    for (vbo in vbos)
        GL15.glDeleteBuffers(vbo)
    
    //Textures
    for (texture in textures)
        GL11.glDeleteTextures(texture)
}