# mask-cpf-jetpack-compose
How to use:

```
val visualTransformationCpf: VisualTransformation = remember { MaskCpf() }

TextField(
    value = state.text,
    onValueChange = { if (it.length <= 11 && it.isDigitsOnly()) state.updateText(it)  },
    placeholder = { Text(text = placeholderText) },
    shape = RoundedCornerShape(8.dp),
    leadingIcon = { Icon(imageVector = leadingIconVector, contentDescription = null) },
    visualTransformation = visualTransformationCpf
)
```
