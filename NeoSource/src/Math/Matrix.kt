package Math

//We have set this to float for now because Kotlin doesn't support using operators on custom type parameters.
open class Matrix<T>
{
    val data: Array<Array<T>>
    
    //Data Constructor
    constructor(data: Array<Array<T>>)
    {
        this.data = data //TODO: Check if all rows are of equal length
    }
    
    //Constant Constructor
    constructor(constant: T, rows: Int, columns: Int)
    {
        val tempData = mutableListOf<MutableList<T>>()
        
        for (x in 0..rows-1)
        {
            val tempRow = mutableListOf<T>()
            
            for (y in 0..columns-1)
                tempRow.add(constant)
            
            data.add(tempRow)
        }
    }
    
    //Operators
    operator fun unaryPlus() = this
}