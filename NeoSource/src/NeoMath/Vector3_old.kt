package NeoMath

class Vector3_old
(
    var x: Float,
    var y: Float,
    var z: Float
)
{
    operator fun unaryPlus() = this
    operator fun unaryMinus() = Vector3(-x, -y, -z)
    
    operator fun plus(b: Vector3) = Vector3(x + b.x, y + b.y, z + b.z)
    operator fun minus(b: Vector3) = this + (-b)
    
    operator fun plusAssign(b: Vector3)
    {
        x += b.x
        y += b.y
        z += b.z
    }
    operator fun minusAssign(b: Vector3)
    {
        this += -b
    }
}