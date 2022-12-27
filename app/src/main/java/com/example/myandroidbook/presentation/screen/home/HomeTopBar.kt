package com.example.myandroidbook.presentation.screen.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myandroidbook.R
import com.example.myandroidbook.ui.theme.homeTopBar
import com.example.myandroidbook.ui.theme.homeTopBarTxt
import com.example.myandroidbook.ui.theme.homeTopIcon

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Search your topic", color = MaterialTheme.colors.homeTopBarTxt) },
        backgroundColor = MaterialTheme.colors.homeTopBar,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = MaterialTheme.colors.homeTopIcon ,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )


}

@Preview
@Composable
fun Preview() {
    HomeTopBar {

    }
}