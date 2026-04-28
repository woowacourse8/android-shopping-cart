package woowacourse.shopping.ui.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.shopping.model.Product
import woowacourse.shopping.repository.inmemory.InMemoryProductRepository
import woowacourse.shopping.ui.productdetail.component.CartAddButton
import woowacourse.shopping.ui.productdetail.component.ProductDetailBody
import woowacourse.shopping.ui.productdetail.component.ProductDetailHeader

@Composable
fun ProductDetailScreen(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        ProductDetailHeader()

        ProductDetailBody(
            product = product
        )

        Spacer(modifier = Modifier.weight(1f))

        CartAddButton(
            onClick = onClick,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(product = InMemoryProductRepository.APPLE, onClick = {})
}
