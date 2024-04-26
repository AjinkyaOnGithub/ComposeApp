package com.android.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.composeapp.navigation.AppNavHost
import com.android.composeapp.ui.theme.ComposeAppTheme

class LoginUI() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                loginUIDemo(AppNavHost(navController = rememberNavController()))
                }
            }
        }
    }
}

@Composable
fun loginUIDemo(appNavHost: Unit) {
    ImageResourceDemo()
    var isValid by remember {
        mutableStateOf(true)
    }
    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val textState = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter your text here") })
        Text("Username: " + textState.value.text)

        val textState1 = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textState1.value, onValueChange = {
            textState1.value = it
        }, modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter your text here") })
        Text("Password: " + textState1.value.text)
        if (!isValid) {
            Text(
                text = "Invalid username or password",
                color = Color.Red,
                modifier = Modifier.padding(8. dp)
            )
        }
        Button(onClick = {
            isValid = isValidCredentials(
                email = textState.value.toString(),
                password = textState1.value.toString()
            )
            if (isValid) {
                // Handle successful login

            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
    }

}

@Composable
fun ImageResourceDemo() {
    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(150.dp), // you can set this to whatever size you want your image to be
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
    }
}


private fun isValidCredentials(email: String, password: String): Boolean {
    val emailPattern = Regex("[a-zA-Z0–9._-]+@[a-z]+\\.+[a-z]+")
    val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    return emailPattern.matches(email) && passwordPattern.matches(password)
}
