/**
 *  Medium article -> https://medium.com/@softwaretechsolution/decorator-design-pattern-cafdf7c3f0b2
            idea :
                     Component
                         |
                 |             |
            Decorator      no. of concrete components
                |
            no. of  concrete Decorators ( بهارات / additions )
 */
// Examples
// Coffee shop
// Text
// Http request

interface Text {
    fun getTextContent(): String
}

class PlainEdittext(
    private val content: String
) : Text {
    override fun getTextContent(): String {
        return content
    }
}

abstract class DecoratedText(
   protected val decoratedText: Text
) : Text {
    override fun getTextContent(): String {
        return decoratedText.getTextContent()
    }
}

class BoldDecoratedText(
    boldDecoratedText: Text
) : DecoratedText(boldDecoratedText) {
    override fun getTextContent(): String {
        return " <b> ${decoratedText.getTextContent()} </b> "
    }
}

class ItalicDecoratedText(
    italicDecoratedText: Text
) : DecoratedText(italicDecoratedText) {
    override fun getTextContent(): String {
        return " <i> ${decoratedText.getTextContent()} </i> "
    }
}

/**
fun main() {

        // plain text
        var plainEdittext: Text = PlainEdittext("Tamer Elgayar")

        plainEdittext = BoldDecoratedText(plainEdittext)
        plainEdittext = ItalicDecoratedText(plainEdittext)

        print(plainEdittext.getTextContent())
    }

 **/





