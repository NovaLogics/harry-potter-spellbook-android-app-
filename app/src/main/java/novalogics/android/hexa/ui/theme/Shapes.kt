package novalogics.android.hexa.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(
        size = 4.dp
    ),
    medium = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 36.dp,
        bottomEnd = 36.dp
    ),
    large = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 8.dp,
        bottomStart = 8.dp,
        bottomEnd = 0.dp
    ),

)
