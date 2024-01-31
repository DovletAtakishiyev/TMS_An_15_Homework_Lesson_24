package com.tshahakurov.noteapplication.view.fragment.main.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tshahakurov.noteapplication.R
import com.tshahakurov.noteapplication.model.User

@Composable
fun ProfileScreen(
    user: User,
    onLogout: ()->Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

//        Image(
//            painter = painterResource(id = R.drawable.background),
//            contentDescription = "bg",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "User Profile",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .requiredSize(300.dp, 400.dp)
                    .border(2.dp, Color(0xA37E21A5), RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0x3E7458DB))
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Column {
                    ProfileElement(
                        title = "User Name",
                        value = "${user.firstName} ${user.lastName}"
                    )
                    ProfileElement(
                        title = "User Email",
                        value = user.email ?: "n/a"
                    )
                }

                Column {
                    Button(
                        modifier = Modifier.width(150.dp),
                        onClick = {
                            Toast.makeText(context, "Edit Profile", Toast.LENGTH_SHORT).show() }
                    ) {
                        Text(text = "Edit")
                    }
                    Button(
                        modifier = Modifier.width(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFF8F7F8),
                            contentColor = Color(0xFF220F91)
                        ),
                        onClick = {
                            onLogout()
                        }) {
                        Text(text = "Logout")
                    }
                }

            }
        }
    }
}

@Composable
fun ProfileElement(
    title: String,
    value: String
) {
    val fontSize = 14.sp

    Row(
        modifier = Modifier
            .border(2.dp, Color(0xA37E21A5), RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0x1EE6DEE2))
            .fillMaxWidth()
            .padding(20.dp)
            .requiredHeight(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title : ",
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = value,
            fontSize = fontSize
        )
    }

}

//@Preview(showBackground = true, widthDp = 450)
//@Composable
//fun ProfilePreview() {
////    ProfileScreen()
//}