package NeoMath

class Transform
(
        var position: NeoMath.Vector3,
        var rotation:,
        var scale: NeoMath.Vector3
)
{
    constructor(position: NeoMath.Vector3, rotation:, scale: Float): this(position, rotation, NeoMath.Vector3(scale, scale, scale))
    constructor(position: NeoMath.Vector3, rotation: ): this(position, rotation, 1f)
    
    
}