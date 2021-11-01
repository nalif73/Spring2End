const CartList = {
    data() {
        return {
            product: {},
        }
    },
    template: `
      <div>
            <h1>Корзина</h1>
            <div class="row row-cols-auto mt-5 mb-5">
                <div v-for="product in products" :key="product.id" class="card col px-0" style="width: 18rem;">
                         <img :src="product.imageLink" class="card-img-top" alt="product image">
                        <div class="card-body">
                            <h5 class="card-name">{{ product.name }}</h5>
                            <p class="card-text">{{ product.description }}</p>
                            <div class="justify-content"></div>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">Цена: {{ product.price }} руб.</small>
                        </div>
                    </div>
            </div>
        </div>
    `
}