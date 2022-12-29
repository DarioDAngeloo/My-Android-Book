package com.example.myandroidbook.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myandroidbook.R
import com.example.myandroidbook.domain.model.KotlinModel
import com.example.myandroidbook.navigation.Screen
import com.example.myandroidbook.presentation.components.RankingDifficultyWidget
import com.example.myandroidbook.ui.theme.Shapes
import com.example.myandroidbook.ui.theme.homeTopBarTxt
import com.example.myandroidbook.ui.theme.large_radius_corner
import com.example.myandroidbook.util.Constants.BASE_URL

@Composable
fun ListContent(
    kotlinInfo: LazyPagingItems<KotlinModel>,
    navHostController: NavHostController
) {
}

@Composable
fun KotlinItem(
    kotlinModel: KotlinModel,
    navHostController: NavHostController
) {


    Box(modifier = Modifier
        .height(400.dp)
        .clickable {
            navHostController.navigate(Screen.Details.passKotlinId(kotlinId = kotlinModel.id))
        },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = Shapes.large) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = "$BASE_URL${kotlinModel.image}")
                    .placeholder(drawableResId = R.drawable.placeholder)
                    .error(drawableResId = R.drawable.placeholder)
                    .build(), contentDescription = stringResource(R.string.kotlin_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomEnd = large_radius_corner,
                bottomStart = large_radius_corner
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp)) {
                Text(
                    text = kotlinModel.title,
                    color = MaterialTheme.colors.homeTopBarTxt,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = kotlinModel.about,
                    color = MaterialTheme.colors.homeTopBarTxt,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis

                )
                Row(
                    modifier = Modifier.padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RankingDifficultyWidget(
                        modifier = Modifier.padding(end = 15.dp),
                        ranking = kotlinModel.ranking
                    )
                    Text(text = "(${kotlinModel.ranking})", textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    KotlinItem(kotlinModel = KotlinModel(
        id = 1,
        title = "Japan",
        image = "sad",
        about = "we are gonna get outta here in febraruary 2023",
        tags = listOf(),
        ranking = 3.0,
        yearRelease = 2023,
        difficulty = "easy"
    ), navHostController = rememberNavController())
}