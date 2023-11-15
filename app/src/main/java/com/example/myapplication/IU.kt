package com.example.laprimera

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.Check
import androidx.compose.material3.icons.filled.Error
import androidx.compose.material3.icons.filled.Info
import androidx.compose.material3.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.MyViewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun IU(miViewModel: MyViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Imagen con offset
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "icono",
                modifier = Modifier
                    .size(210.dp)
                    .offset(y = 120.dp, x = 70.dp)
            )

            // Texto que muestra la lista de números aleatorios
            Text(
                text = "Números: ${miViewModel.getListaRandom()}",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .offset(y = 300.dp, x = 30.dp)
            )

            // Botón para generar números aleatorios
            Button(
                onClick = { miViewModel.crearRandom() },
                modifier = Modifier
                    .offset(y = 330.dp, x = 40.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Icono del botón
                    Image(
                        painter = painterResource(id = R.drawable.f35wev_w8aatfzh),
                        contentDescription = "Generar números",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(20.dp)
                    )
                    // Texto del botón
                    Text(text = "Click para generar números")
                }
            }

            // Componente de login
            Login(miViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Texto simulando un botón (Clicks)
        TextButton(
            onClick = { miViewModel.contador() },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryVariant)
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Text("CLICKS: ${miViewModel.getContador()}")
        }

        // Caja de texto para escribir
        OutlinedTextField(
            value = miViewModel.getString(),
            onValueChange = { miViewModel.name.value = it },
            label = { Text(text = "Escribe:") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Ocultar el teclado al hacer clic en "Done"
                    LocalSoftwareKeyboardController.current?.hide()
                }
            )
        )

        // Condición para mostrar el contenido de la caja solo si hay más de 3 caracteres
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(R.drawable.f4kaiiyxoaarlre),
                contentDescription = "icono",
                modifier = Modifier
                    .size(200.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Hola $name",
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.saludo),
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = modifier
            )
            Button(
                onClick = { Log.d("Calcular", "Click!!!") },
                modifier = Modifier
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primaryVariant)
            ) {
                Text(text = "Click me!", color = Color.DarkGray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        IU(miViewModel = MyViewModel())
    }
}
