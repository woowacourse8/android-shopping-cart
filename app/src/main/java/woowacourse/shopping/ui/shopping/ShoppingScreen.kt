package woowacourse.shopping.ui.shopping

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.shopping.model.Product
import woowacourse.shopping.model.Products
import woowacourse.shopping.repository.inmemory.InMemoryProductRepository
import woowacourse.shopping.ui.shopping.component.ShoppingBody
import woowacourse.shopping.ui.shopping.component.ShoppingHeader

private const val PAGE_SIZE = 20

@Composable
fun ShoppingScreen(
    products: Products,
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit,
    onProductClick: (Product) -> Unit
) {
    val productsSize = products.count()
    var visibleCount by rememberSaveable { mutableIntStateOf(PAGE_SIZE) }
    val visibleProducts = products.getPagedProducts(0, visibleCount).toList()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShoppingHeader(onCartClick = onCartClick)

        ShoppingBody(
            products = Products(visibleProducts),
            showMoreButton = visibleProducts.size < productsSize,
            modifier = Modifier
                .padding(20.dp)
                .weight(1f),
            onProductClick = onProductClick,
            onMoreClick = {
                visibleCount = minOf(visibleCount + PAGE_SIZE, productsSize)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingScreenPreview() {
    ShoppingScreen(
        products = InMemoryProductRepository.products,
        onCartClick = {},
        onProductClick = {}
    )
}
