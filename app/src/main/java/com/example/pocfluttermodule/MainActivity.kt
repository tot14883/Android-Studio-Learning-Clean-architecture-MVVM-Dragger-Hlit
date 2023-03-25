package com.example.pocfluttermodule

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocfluttermodule.presentation.authentication.viewModels.AuthenViewModel
import com.example.pocfluttermodule.ui.theme.POCFlutterModuleTheme
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AuthenViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.test()
        setContent {
            POCFlutterModuleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeScreen()
//                    routes()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    POCFlutterModuleTheme {
        TipTimeScreen()
    }
}

@Composable
fun TipTimeScreen() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField(
            label = R.string.bill_amount,
            keyboardOptions = KeyboardOptions.Default.copy(
              keyboardType = KeyboardType.Number,
              imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions (
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = amountInput,
            onValueChange = { amountInput = it }
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            value = tipInput,
            onValueChange = { tipInput = it }
        )
        RoundTheTipRow(roundUp = roundUp, onRoundUpChanged = { roundUp = it})
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    value: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.cost_of_service)) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}

private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean,
): String {
    var tip = tipPercent / 100 * amount
    if (roundUp)
        tip = kotlin.math.ceil(tip)

    return NumberFormat.getNumberInstance().format(tip)
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray
            )
        )
    }
}



//
//@Composable
//fun DiceRollerApp() {
//    DiceWithButtonAndImage(modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.Center))
//}
//
//@Composable
//fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
//    var result by remember { mutableStateOf( 1) }
//    val imageResource = when(result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//
//    Column(
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = imageResource),
//            contentDescription = result.toString()
//        )
//        Spacer(
//            modifier = Modifier.height(16.dp)
//        )
//        Button(
//            onClick = { result = (1..6).random() }
//        ) {
//            Text(stringResource(R.string.roll))
//        }
//    }
//}
//
//@Composable
//fun LemonApp() {
//
//    // Current step the app is displaying (remember allows the state to be retained
//    // across recompositions).
//    var currentStep by remember { mutableStateOf(1) }
//
//    // Number of times the lemon needs to be squeezed to turn into a glass of lemonade
//    var squeezeCount by remember { mutableStateOf(0) }
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colors.background
//    ) {
//        when (currentStep) {
//            1 -> {
//                // Display lemon tree image and ask user to pick a lemon from the tree
//                LemonTextAndImage(
//                    textLabelResourceId = R.string.lemon_select,
//                    drawableResourceId = R.drawable.lemon_tree,
//                    contentDescriptionResourceId = R.string.lemon_tree_content_description,
//                    onImageClick = {
//                        // Update to next step
//                        currentStep = 2
//                        // Each time a lemon is picked from the tree, get a new random number
//                        // between 2 and 4 (inclusive) for the number of times the lemon needs
//                        // to be squeezed to turn into lemonade
//                        squeezeCount = (2..4).random()
//                    }
//                )
//            }
//            2 -> {
//                // Display lemon image and ask user to squeeze the lemon
//                LemonTextAndImage(
//                    textLabelResourceId = R.string.lemon_squeeze,
//                    drawableResourceId = R.drawable.lemon_squeeze,
//                    contentDescriptionResourceId = R.string.lemon_content_description,
//                    onImageClick = {
//                        // Decrease the squeeze count by 1 for each click the user performs
//                        squeezeCount--
//                        // When we're done squeezing the lemon, move to the next step
//                        if (squeezeCount == 0) {
//                            currentStep = 3
//                        }
//                    }
//                )
//            }
//            3 -> {
//                // Display glass of lemonade image and ask user to drink the lemonade
//                LemonTextAndImage(
//                    textLabelResourceId = R.string.lemon_drink,
//                    drawableResourceId = R.drawable.lemon_drink,
//                    contentDescriptionResourceId = R.string.lemonade_content_description,
//                    onImageClick = {
//                        // Update to next step
//                        currentStep = 4
//                    }
//                )
//            }
//            4 -> {
//                // Display empty glass image and ask user to start again
//                LemonTextAndImage(
//                    textLabelResourceId = R.string.lemon_empty_glass,
//                    drawableResourceId = R.drawable.lemon_restart,
//                    contentDescriptionResourceId = R.string.empty_glass_content_description,
//                    onImageClick = {
//                        // Back to starting step
//                        currentStep = 1
//                    }
//                )
//            }
//        }
//    }
//}
//
///**
// * Composable that displays a text label above an image that is clickable.
// *
// * @param textLabelResourceId is the resource ID for the text string to display
// * @param drawableResourceId is the resource ID for the image drawable to display below the text
// * @param contentDescriptionResourceId is the resource ID for the string to use as the content
// * description for the image
// * @param onImageClick will be called when the user clicks the image
// * @param modifier modifiers to set to this composable
// */
//@Composable
//fun LemonTextAndImage(
//    textLabelResourceId: Int,
//    drawableResourceId: Int,
//    contentDescriptionResourceId: Int,
//    onImageClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = modifier.fillMaxSize()
//    ) {
//        Text(
//            text = stringResource(textLabelResourceId),
//            fontSize = 18.sp
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Image(
//            painter = painterResource(drawableResourceId),
//            contentDescription = stringResource(contentDescriptionResourceId),
//            modifier = Modifier
//                .wrapContentSize()
//                .clickable(
//                    onClick = onImageClick
//                )
//                .border(
//                    BorderStroke(2.dp, Color(105, 205, 216)),
//                    shape = RoundedCornerShape(4.dp)
//                )
//                .padding(16.dp)
//        )
//    }
//}