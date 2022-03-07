package com.codexo.nyt.ui.home

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.codexo.nyt.R
import com.codexo.nyt.data.model.Article
import com.codexo.nyt.ui.theme.NYTTheme

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) { article: Article ->
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                CardContent(article = article)
            }
        }
    }

}

@Composable
private fun CardContent(article: Article) {
    val imagerPainter = rememberImagePainter(data = article.photoUrl) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
        scale(Scale.FILL)
    }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Image(
            painter = imagerPainter,
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            val context = LocalContext.current
            Text(
                text = article.highlight ?: "highlight",
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.clickable {
//                    val browserIntent = Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse(article.url)
//                    )
//                    startActivity(context, browserIntent, null)

                    val builder = CustomTabsIntent.Builder()
                    val customTabsIntent = builder.build()
                    customTabsIntent.launchUrl(context, Uri.parse(article.url));
                },
                maxLines = 1
            )

            Text(text = article.author ?: "hellur")

            Row(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    modifier = Modifier.size(20.dp),
                    contentDescription = null
                )
                Text(
                    text = article.updated ?: "09-02-2022",
                    Modifier.padding(2.dp),
                    style = MaterialTheme.typography.subtitle2.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }

            if (expanded) {
                Text(
                    text = article.highlight ?: "highlight",
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    NYTTheme {
        CardContent(
            Article(
                id = 238974237489234,
                url = "google.com",
                source = "nyt",
                updated = "09-02-2022",
                title = "title",
                author = "joel",
                photoUrl = "https://avatars.githubusercontent.com/u/26358650?v=4",
                caption = "sdfsdf",
                highlight = "Sdfsdfsd",
                copyright = "SDfsdf"
            )
        )
    }
}