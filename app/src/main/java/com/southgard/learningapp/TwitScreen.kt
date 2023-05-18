package com.southgard.learningapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TwitterScreen() {
    var chat by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF161D26))) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color(color = 0xFF161026))
                .padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.steel),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                Row(Modifier.fillMaxWidth()) {
                    UserName(title = "Guillem", Modifier.padding(8.dp))
                    DefaultText(title = "@arycar_wow", Modifier.padding(8.dp))
                    DefaultText(title = "4h", Modifier.padding(8.dp))
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                BodyText(
                    text = "This is my long long text" +
                            "This is my long long text" +
                            "This is my long long text" +
                            "This is my long long text" +
                            "This is my long long text" +
                            "This is my long long text",
                    Modifier.padding(bottom = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.twit_image),
                    contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10)),
                    contentScale = ContentScale.Crop
                )
                Row(Modifier.padding(top = 16.dp)) {
                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unselectedIcon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "",
                                tint = Color(0xFF7E8B98)
                            )
                        },
                        selectedIcon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "",
                                tint = Color.Red
                            )
                        },
                        isSelected = chat
                    ) {
                        chat = !chat
                    }
                }
            }
        }
        TwitDivider()
    }
}

@Composable
fun UserName(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}


@Composable
fun BodyText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun SocialIcon(modifier: Modifier, unselectedIcon: @Composable () -> Unit, selectedIcon: @Composable () -> Unit, isSelected: Boolean, onItemSelected: () -> Unit) {
    val defaultValue = 1

    Row(modifier = Modifier.clickable { onItemSelected() }, verticalAlignment = Alignment.CenterVertically){
        if(isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

    }
}

@Composable
fun TwitDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 4.dp), color = Color.Gray)
}



