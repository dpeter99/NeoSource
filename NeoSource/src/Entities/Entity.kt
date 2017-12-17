package Entities

open class Entity
{
    constructor()
    {
    
    }
    
    var relativeTransform: Math.Transform = ''
    
    private var parent: Entity? = null

    //Other Entyties that are below this in the world hierarchy
    private val children = mutableListOf<Entity>()

    //Other stuff that is inside this Entity in the world hierarchy and belong to a internal hierarchy
    private val components = mutableListOf<Entity>()
    
    private fun prepAttachment(newParent: Entity?)
    {
        fun recursiveParent(p: Entity?): Entity?
        {
            if (p == this || p == null) return p
            else return recursiveParent(p.parent)
        }
        
        
        if (recursiveParent(newParent) == this)
        {
            throw IllegalArgumentException("Cannot attach Entity to itself or to child Entities.")
        }
        
        //TODO: TRANSFORM
        if (newParent != null)
        {

        }
        
        parent = newParent
    }
    
    fun setAttachment(newParent: Entity?)
    {
        prepAttachment(newParent)
        newParent?.components?.add(this)
    }
    
    fun setParent(newParent: Entity?)
    {
        prepAttachment(newParent)
        newParent?.children?.add(this)
    }
}