import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30

private val vaos = mutableListOf<VAO>()
private val textures = mutableListOf<Int>()


val VERTEX_POSITIONS = 0
val TEXTURE_COORDINATES = 1

val vboAttributeNumbers = listOf<Int>(VERTEX_POSITIONS, TEXTURE_COORDINATES)


fun loadModel(positions: Array<Float>, textureCoordinates: Array<Float>, sections: Array<MeshIndices>): StaticMesh
{
    //Create VBOs
    val vboPositions = GL15.glGenBuffers()
    val vboTextureCoordinates = GL15.glGenBuffers()
    
    //Fill VBOs with data
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboPositions)
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positions.toFloatArray(), GL15.GL_STATIC_DRAW)
    
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboTextureCoordinates)
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureCoordinates.toFloatArray(), GL15.GL_STATIC_DRAW)

    
    for (section in sections)
    {
        val vaoTriangles = GL30.glGenVertexArrays()
        val vaoTriangleStrips = GL30.glGenVertexArrays()
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

private fun







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
    
    //Textures
    for (texture in textures)
        GL11.glDeleteTextures(texture)
}