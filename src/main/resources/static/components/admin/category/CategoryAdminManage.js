const CategoryAdminManage = {
    data() {
        return {
            category: {},
            file: null,
            categories: []
        }
    },
    methods: {
        getCategoryById(categoryId) {
            axios.get('/api/v1/category/' + categoryId).then(response => {
                this.category = response.data;
            })
        },
        getCategories() {
            axios.get('/api/v1/category/').then(response => {
                this.categories = response.data;
            })
        },
        saveCategory() {
            axios.post("/api/v1/category/",  this.category )
                .then(result => {
                    this.$router.push({name: 'adminCategory'});
                }).catch(error =>  {
                    console.log(error);
                });
        }
    },
    mounted() {
        const categoryId = this.$route.params.id;
        if (categoryId) {
            this.getCategoryById(categoryId);
        }

        this.getCategories();
    },
    template: `
        <div class="container">
            <div class="form-group mb-3">
                <label for="categoryName" class="form-label">Наименование категории</label>
                <input v-model="category.name" id="categoryName" type="text" class="form-control" placeholder="Укажите наименование">
            </div>
            
            <div class="form-group mb-3">
              <label for="categoryAlias">Алиас категории</label>
              <input v-model="category.alias" class="form-control" placeholder="Введите алиас" id="categoryAlias">
            </div>

          <button type="submit" @click="saveCategory"  class="btn btn-primary">Сохранить</button>
        </div>
    `,
}