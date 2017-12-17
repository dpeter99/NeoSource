data class StaticMesh
{
    val sections: List<MeshSection>
    val vboIDs: List<Int>
}

class MeshSection
{
    val triangles: VAO
    val triangleStrips: List<VAO>
    val triangleFans: List<VAO>
    
    val lines: VAO
    val lineStrips: List<VAO>
    val lineLoops: List<VAO>
    
    val points: VAO
    
    var shader: Shader
}

class VAO
(
    val vaoID: Int,
    val vertexCount: Int,
    val vboIDs: List<Int>
)