import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MaskCpf: VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return maskCpf(text)
    }
}


fun maskCpf(text: AnnotatedString): TransformedText {

    //327.674.748-07
    val trimmed = if (text.text.length >= 11) text.text.substring(0..10) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i==2 || i==5) out += "."
        if (i==8) out += "-"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset+1
            if (offset <= 8) return offset+2
            if (offset <= 11) return offset+3
            return 14

        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <=14) return offset -2
            return 11
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}
