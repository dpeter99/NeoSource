package Math

class Rotator
{
    var x: Float
    var y: Float
    var z: Float
    
    var rotOrder: Math.RotatorOrder
        private set
    
    fun changeRotOrder(newRotOrder: Math.RotatorOrder)
    {
    
    }
}

class RotatorOrder
{
    var r0: Math.RotationAxis
    var r1: Math.RotationAxis
    var r2: Math.RotationAxis
}

enum class RotationAxis
{
    x,
    y,
    z
}