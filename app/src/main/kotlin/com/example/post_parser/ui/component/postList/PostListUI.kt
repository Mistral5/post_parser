import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.post_parser.R
import com.example.post_parser.data.model.Post
import com.example.post_parser.ui.component.postList.PostList
import com.example.post_parser.ui.theme.Gray
import com.example.post_parser.ui.theme.ItimTypography
import com.example.post_parser.ui.theme.Lilac

@Composable
fun PostListUI(
  component: PostList,
  posts: List<Post>? = null,
) {
  LazyColumn(
    contentPadding = PaddingValues(vertical = 12.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
    horizontalAlignment = Alignment.Start,
  ) {
    item {
      Text(
        modifier =
          Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        text = stringResource(R.string.HomeScreenTitle),
        style = ItimTypography.titleLarge,
      )
    }
    if (posts != null) {
      items(posts) { post ->
        PostCard(component, post)
      }
    } else {
      items(5) {
        PostCard()
      }
    }
  }
}

@Composable
fun PostCard(
  component: PostList,
  post: Post,
) {
  ElevatedCard(
    shape = RoundedCornerShape(size = 24.dp),
    colors =
      CardDefaults.cardColors(
        containerColor = Lilac,
      ),
    elevation =
      CardDefaults.cardElevation(
        defaultElevation = 12.dp,
      ),
  ) {
    Column(
      modifier = Modifier.padding(12.dp),
    ) {
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = post.title,
        style = ItimTypography.bodyLarge,
      )
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = post.body,
        style = ItimTypography.bodySmall,
      )
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
      ) {
        TextButton(
          onClick = { (component::onAuthorClick)(post.userId) },
        ) {
          Text(
            text = "Author",
            style = ItimTypography.bodySmall,
            textAlign = TextAlign.Right,
            textDecoration = TextDecoration.Underline,
          )
        }
      }
    }
  }
}

@Composable
fun PostCard() {
  ElevatedCard(
    shape = RoundedCornerShape(size = 24.dp),
    colors =
      CardDefaults.cardColors(
        containerColor = Lilac,
      ),
    elevation =
      CardDefaults.cardElevation(
        defaultElevation = 12.dp,
      ),
  ) {
    Column(
      modifier = Modifier.padding(12.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
    ) {
      Box(
        modifier =
          Modifier
            .size(width = 144.dp, height = 24.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .background(color = Gray),
      )
      Box(
        modifier =
          Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .background(color = Gray),
      )
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
      ) {
        Box(
          modifier =
            Modifier
              .size(width = 96.dp, height = 24.dp)
              .clip(shape = RoundedCornerShape(size = 12.dp))
              .background(color = Gray),
        )
      }
    }
  }
}
