package NeoMath

class Transform
(
        var position: Math.Vector3,
        var rotation:,
        var scale: Math.Vector3
)
{
    constructor(position: Math.Vector3, rotation:, scale: Float): this(position, rotation, Math.Vector3(scale, scale, scale))
    constructor(position: Math.Vector3, rotation: ): this(position, rotation, 1f)
    
    
}