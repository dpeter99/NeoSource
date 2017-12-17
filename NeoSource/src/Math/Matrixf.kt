package Math

open class Matrixf: Matrix<Float>
{
    //Constructors
    constructor(data: Array<Array<Float>>): super(data)
    constructor(constant: Float, rows: Int, columns: Int): super(constant, rows, columns)
    
    //Operators
    operator fun unaryMinus() = this * -1f
    
    operator fun plus(b: Matrixf): Matrixf
    {

    }
    operator fun minus(b: Matrixf) = this + (-b)
}