package structuralPatterns// The Flyweight design pattern is a structural pattern that optimizes memory usage by sharing a common state among multiple objects.
// Shared vs. Unique Data: Objects are split into shared (intrinsic) data and unique (extrinsic) data.
// The shared data is stored in a central place and reused, while the unique data is kept separately.

/**
     *              /*
     *     +----------------------------------+
     *     |           <<Interface>>          |
     *     |              Icon                |
     *     +----------------------------------+
     *     | + draw(x: Int, y: Int)           |
     *     +----------------------------------+
     *                  ▲
     *                  |
     *     -------------------------------------
     *     |                                   |
     *     |                                   |
     * +---------------------+        +----------------------+
     * |      FileIcon      |        |     FolderIcon       |
     * +---------------------+        +----------------------+
     * | - image: String    |        | - image: String     |
     * | - color: String    |        | - color: String     |
     * +---------------------+        +----------------------+
     * | + draw(x: Int, y: Int) |     | + draw(x: Int, y: Int) |
     * +---------------------+        +----------------------+
     *
     *           Uses Flyweight Factory
     *                  ▲
     *                  |
     *                  |
     *     +--------------------------------------+
     *     |             IconFactory              |
     *     +--------------------------------------+
     *     | - cacheIcons: MutableMap<String, Icon>|
     *     | - imageFile: String?                 |
     *     | - color: String?                     |
     *     +--------------------------------------+
     *     | + setImage(image: String)            |
     *     | + setColor(color: String)            |
     *     | + getIcon(key: String): Icon         |
     *     | + loadImage()                        |
     *     +--------------------------------------+
     *                  |
     *     +------------+----------------------+
     *     |                                   |
     * Creates and reuses                Creates and reuses
     * FileIcon instances               FolderIcon instances
     * */
 *
 *
 * */



// example of Mobile app
// fileIcon folderIcon

interface Icon {
    fun draw(x: Int, y: Int)
}

class FileIcon(
    val image: String,
    val color: String
) : Icon {
    override fun draw(x: Int, y: Int) {
        println("Draw File Icon = $image with color: $color in ($x,$y)")
    }
}

class FolderIcon(
    val image: String,
    val color: String
) : Icon {
    override fun draw(x: Int, y: Int) {
        println("Draw folder Icon =  $image with color: $color in ($x,$y)")
    }
}

class IconFactory {
    val cacheIcons: MutableMap<String, Icon> = mutableMapOf()
    private var imageFile:String? = null
    private var color:String? = null
    fun setImage(image: String){
        this.imageFile = image
    }
    fun setColor(color: String){
        this.color = color
    }

    fun getIcon(key: String): Icon {
        if (cacheIcons.containsKey(key))
            return cacheIcons[key]!!
        return when (key) {
            "file" -> {
                val fileIcon = FileIcon(imageFile!!, color!!)
                cacheIcons[key] = fileIcon
                fileIcon
            }

            "folder" -> {
                val folderIcon = FolderIcon(imageFile!!, color!!)
                cacheIcons[key] = folderIcon
                folderIcon
            }

            else -> {
                throw IllegalArgumentException("UnSupported $key")
            }
        }
    }

    // extra method
    fun loadImage(){
        println(imageFile)
    }
}

