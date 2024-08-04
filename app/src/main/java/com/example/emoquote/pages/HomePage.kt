package com.example.emoquote.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.emoquote.AuthState
import com.example.emoquote.AuthViewModel
import com.example.emoquote.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier,
             navController: NavController, authViewModel: AuthViewModel,) {
    val authState = authViewModel.authState.observeAsState()

    val firestore = remember { FirebaseFirestore.getInstance() }
    var text by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        try {
            val document = firestore.collection("texts")
                .document("myText").get().await()
            text = document.getString("happyquote") ?: "No content found"
        } catch (e: Exception) {
            text = "Failed to fetch text"
        }
    }

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }
    val scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.White)
        .verticalScroll(scrollState),){
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 5.dp, end = 12.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "EmoQuote", color = Color.Red, fontWeight = FontWeight.ExtraLight,
                fontFamily = FontFamily.Serif, fontSize = 40.sp)

                    TextButton(onClick = { authViewModel.signout() }) {
                        Text(text = "Logout>", color = Color.Black, fontSize = 18.sp)
                    }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Quote of the Day:", color = Color.Black,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,modifier=Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(7.dp))

        Card(modifier = Modifier
            .width(415.dp)
            .height(150.dp)
            .padding(10.dp)
            .shadow(elevation = 16.dp, shape = RoundedCornerShape(8.dp))


        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.light),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .scale(7f)
                )
                Column (modifier = Modifier
                    .align(Alignment.Center)
                    .padding(15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = text, color = Color.Black, fontFamily = FontFamily.Serif)
                }

            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        Column (modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = "How are you feeling today!" ,
                color = Color.Black, fontWeight = FontWeight.ExtraLight,
                fontFamily = FontFamily.Serif, fontSize = 25.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                    Card(
                        modifier = Modifier
                            .size(150.dp)
                            .background(color = Color.White)
                            .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(5.dp)
                        , onClick = { navController.navigate("happy")},

                        )


                    {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .padding(15.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.happiness),
                                contentDescription = "Happy",
                                modifier = Modifier.size(90.dp)
                            )
                            Text(
                                text = "Happy",
                                color = Color.Black,
                                fontWeight = FontWeight.ExtraLight,
                                fontFamily = FontFamily.Serif,
                                fontSize = 25.sp
                            )
                        }

                    }

                Spacer(modifier = Modifier.width(15.dp))
                Card(
                    modifier = Modifier
                        .size(150.dp)
                        .background(color = Color.White)
                        .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { navController.navigate("sad")}
                )
                                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sadness),
                            contentDescription = "Sad",
                            modifier = Modifier.size(90.dp)
                        )
                        Text(
                            text = "Sad",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraLight,
                            fontFamily = FontFamily.Serif,
                            fontSize = 25.sp
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                Card(
                    modifier = Modifier
                        .size(150.dp)
                        .background(color = Color.White)
                        .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { navController.navigate("anger")}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.anger),
                            contentDescription = "Anger",
                            modifier = Modifier.size(90.dp)
                        )
                        Text(
                            text = "Anger",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraLight,
                            fontFamily = FontFamily.Serif,
                            fontSize = 25.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.width(15.dp))
                Card(
                    modifier = Modifier
                        .size(150.dp)
                        .background(color = Color.White)
                        .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { navController.navigate("love")},

                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "Love",
                            modifier = Modifier.size(90.dp)
                        )
                        Text(
                            text = "Love",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraLight,
                            fontFamily = FontFamily.Serif,
                            fontSize = 25.sp
                        )
                    }

                }
            }


        }
        Spacer(modifier = Modifier.height(18.dp))
    }


}