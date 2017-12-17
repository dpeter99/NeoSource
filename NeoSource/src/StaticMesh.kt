import OpenGL.VAO

data class StaticMesh
(
    val sections: List<MeshSection>
)

class MeshSection
(
    val triangles: VAO,
    val triangleStrips: List<VAO>,
    val triangleFans: List<VAO>,
    
    val lines: VAO,
    val lineStrips: List<VAO>,
    val lineLoops: List<VAO>,
    
    val points: VAO,
    
    var shader: Shader? = null
)