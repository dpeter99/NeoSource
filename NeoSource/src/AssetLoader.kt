import OpenGL.IBO
import OpenGL.VAO
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
    
    //VBO List
    val vboList = listOf(vboPositions, vboTextureCoordinates)
    
    
    //Helper function to automatically add VBOs to stuff and things
    fun generateVAO(indices: Array<Int>): VAO
    {
        //Create VAO
        val vao = VAO()
        
        //Add all common VBOs from list
        for (vbo in vboList)
            vao.addVBO(vbo)
        
        //Generate and set IBO from indices
        val ibo = IBO()
        ibo.bufferData(indices)
        vao.setIBO(ibo)
        
        //Return VAO
        return vao
    }
    
    fun generateVAOs(data: Array<Array<Int>>): List<VAO>
    {
        val vaos = mutableListOf<VAO>()
        for (indices in data)
        {
            val vao = generateVAO(indices)
            vaos.add(vao)
        }
        
        return vaos.toList()
    }
    
    
    val meshSections = mutableListOf<MeshSection>()
    
    for (section in sections)
    {
        val vaoTriangles = generateVAO(section.triangles)
        val vaosTriangleStrips = generateVAOs(section.triangleStrips)
        val vaosTriangleFans = generateVAOs(section.triangleFans)
    
        val vaoLines = generateVAO(section.lines)
        val vaosLineStrips = generateVAOs(section.lineStrips)
        val vaosLineLoops = generateVAOs(section.lineLoops)
    
        val vaoPoints = generateVAO(section.points)
        
        //Create mesh section from data above
        meshSections.add(MeshSection(
                vaoTriangles, vaosTriangleStrips, vaosTriangleFans,
                vaoLines, vaosLineStrips, vaosLineLoops,
                vaoPoints
        ))
    }
    
    return StaticMesh(meshSections.toList())
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

class MeshData
(
        val positions: Array<Float>,
        val textureCoordinates: Array<Float>,
        
        val sections: Array<MeshIndices>
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