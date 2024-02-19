package com.example.post_parser.ui.page.author

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.example.post_parser.R
import com.example.post_parser.data.DataState
import com.example.post_parser.data.model.Author
import com.example.post_parser.ui.module.BasicIconButton
import com.example.post_parser.ui.module.BasicVerifiedText
import com.example.post_parser.ui.theme.ItimTypography
import com.example.post_parser.ui.theme.Lilac
import com.example.post_parser.ui.theme.Pink
import kotlinx.coroutines.launch

@Composable
fun AuthorPageUI(component: AuthorPage) {
  val coroutineScope = rememberCoroutineScope()
  val model by component.model.subscribeAsState()

  fun updateAuthorInfo() =
    coroutineScope.launch {
      component::getAuthor.invoke()
    }

  LaunchedEffect(Unit) {
    updateAuthorInfo()
  }

  when (val state = model.author) {
    is DataState.Success<Author> -> {
      val author: Author = state.data
      Column(
        modifier =
          Modifier
            .fillMaxSize()
            .background(color = Pink)
            .padding(12.dp),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          BasicIconButton(Icons.Default.ArrowBack, component::onBackButtonClick)
        }
        Text(
          modifier =
            Modifier
              .padding(top = 12.dp, start = 12.dp, end = 12.dp)
              .fillMaxWidth(),
          text = author.username,
          style = ItimTypography.titleLarge,
          textAlign = TextAlign.Center,
        )
        Column(
          modifier = Modifier.padding(vertical = 12.dp),
        ) {
          Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(R.string.AuthorScreenPersonalInfo),
            style = ItimTypography.titleSmall,
          )
          ElevatedCard(
            shape = RoundedCornerShape(size = 24.dp),
            colors =
              CardDefaults.cardColors(
                containerColor = Color.White,
              ),
            elevation =
              CardDefaults.cardElevation(
                defaultElevation = 12.dp,
              ),
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
            ) {
              BasicVerifiedText(key = "name", value = author.name)
              BasicVerifiedText(key = "email", value = author.email)
              BasicVerifiedText(key = "phone", value = author.phone)
              BasicVerifiedText(key = "website", value = author.website)
            }
          }
        }

        Column(
          modifier = Modifier.padding(vertical = 12.dp),
        ) {
          Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(R.string.AuthorScreenAddressInfo),
            style = ItimTypography.titleSmall,
          )
          ElevatedCard(
            shape = RoundedCornerShape(size = 24.dp),
            colors =
              CardDefaults.cardColors(
                containerColor = Color.White,
              ),
            elevation =
              CardDefaults.cardElevation(
                defaultElevation = 12.dp,
              ),
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
            ) {
              BasicVerifiedText(key = "street", value = author.address.street)
              BasicVerifiedText(key = "suite", value = author.address.suite)
              BasicVerifiedText(key = "city", value = author.address.city)
              BasicVerifiedText(key = "zipcode", value = author.address.zipcode)
              Text(
                modifier = Modifier.fillMaxWidth(),
                text =
                  "geo: { " +
                    "lat: ${author.address.geo.lat}, " +
                    "lng: ${author.address.geo.lng} " +
                    "}",
                style = ItimTypography.bodyMedium,
                color = Lilac,
              )
            }
          }
        }

        Column(
          modifier = Modifier.padding(vertical = 12.dp),
        ) {
          Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(R.string.AuthorScreenCompanyInfo),
            style = ItimTypography.titleSmall,
          )
          ElevatedCard(
            shape = RoundedCornerShape(size = 24.dp),
            colors =
              CardDefaults.cardColors(
                containerColor = Color.White,
              ),
            elevation =
              CardDefaults.cardElevation(
                defaultElevation = 12.dp,
              ),
          ) {
            Column(
              modifier = Modifier.padding(12.dp),
            ) {
              BasicVerifiedText(key = "name", value = author.company.name)
              BasicVerifiedText(key = "catchPhrase", value = author.company.catchPhrase)
              BasicVerifiedText(key = "bs", value = author.company.bs)
            }
          }
        }
      }
    }

    is DataState.Loading -> {
      Column(
        modifier =
          Modifier
            .fillMaxSize()
            .background(color = Pink)
            .padding(12.dp),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          BasicIconButton(Icons.Default.ArrowBack, component::onBackButtonClick)
        }
      }
    }

    is DataState.Error -> {
      val snackBarHostState = remember { mutableStateOf(SnackbarHostState()) }
      LaunchedEffect(Unit) {
        state.exception.message?.let {
          coroutineScope.launch {
            snackBarHostState.value.showSnackbar(it)
          }
        }
      }

      Column(
        modifier =
          Modifier
            .fillMaxSize()
            .background(color = Pink)
            .padding(12.dp),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          BasicIconButton(Icons.Default.ArrowBack, component::onBackButtonClick)
        }
        SnackbarHost(snackBarHostState.value, modifier = Modifier)
      }
    }
  }
}
