
fun main() {
    println("Factory Method Pattern Example")

    val factories = listOf(ProductAFactory(), ProductBFactory())
    factories.forEach { factory ->
        val product = factory.createProduct()
        product.use() // Calls the use method of the created product
    }
}

open class Product {
    open fun use() {
        println("Using a generic product")
    }
}

class ProductA : Product() {
    override fun use() {
        println("Using Product A")
    }
}

class ProductB : Product() {
    override fun use() {
        println("Using Product B")
    }
}

interface ProductFactory {
    fun createProduct(): Product
}

class ProductAFactory : ProductFactory {
    override fun createProduct(): Product {
        return ProductA()
    }
}

class ProductBFactory : ProductFactory {
    override fun createProduct(): Product {
        return ProductB()
    }
}
