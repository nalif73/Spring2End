const SingIn = {
    data() {
        return {
            auth: {
                username: "",
                password: ""
            },
            isErrorLogin: true
        }
    },
    methods: {
        login() {
            console.log(this.auth)
            axios.post("/api/v1/auth", this.auth)
                .then(result => {
                    localStorage.setItem('token', result.data.token)
                    this.$router.push({ name: 'productList' })
                    this.isErrorLogin = false;
                }, function (error) {
                    this.isErrorLogin = true;
                });
        }
    },
    template: `
        <div class="container" style="width: 50%">
            <h1 class="h3 mb-3 fw-normal">Пожалуйста, войдите</h1>
        
            <div class="form-floating mb-2">
              <input v-model="auth.username" type="text" class="form-control" id="floatingInput" placeholder="name@example.com" autocomplete="off" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAPhJREFUOBHlU70KgzAQPlMhEvoQTg6OPoOjT+JWOnRqkUKHgqWP4OQbOPokTk6OTkVULNSLVc62oJmbIdzd95NcuGjX2/3YVI/Ts+t0WLE2ut5xsQ0O+90F6UxFjAI8qNcEGONia08e6MNONYwCS7EQAizLmtGUDEzTBNd1fxsYhjEBnHPQNG3KKTYV34F8ec/zwHEciOMYyrIE3/ehKAqIoggo9inGXKmFXwbyBkmSQJqmUNe15IRhCG3byphitm1/eUzDM4qR0TTNjEixGdAnSi3keS5vSk2UDKqqgizLqB4YzvassiKhGtZ/jDMtLOnHz7TE+yf8BaDZXA509yeBAAAAAElFTkSuQmCC&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%;">
              <label for="floatingInput">Логин</label>
            </div>
            <div class="form-floating mb-2">
              <input v-model="auth.password" type="password" class="form-control" id="floatingPassword" placeholder="Пароль" autocomplete="off" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAPhJREFUOBHlU70KgzAQPlMhEvoQTg6OPoOjT+JWOnRqkUKHgqWP4OQbOPokTk6OTkVULNSLVc62oJmbIdzd95NcuGjX2/3YVI/Ts+t0WLE2ut5xsQ0O+90F6UxFjAI8qNcEGONia08e6MNONYwCS7EQAizLmtGUDEzTBNd1fxsYhjEBnHPQNG3KKTYV34F8ec/zwHEciOMYyrIE3/ehKAqIoggo9inGXKmFXwbyBkmSQJqmUNe15IRhCG3byphitm1/eUzDM4qR0TTNjEixGdAnSi3keS5vSk2UDKqqgizLqB4YzvassiKhGtZ/jDMtLOnHz7TE+yf8BaDZXA509yeBAAAAAElFTkSuQmCC&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%;">
              <label for="floatingPassword">Пароль</label>
            </div>
            <div class="invalid-feedback mb-2" v-if="isErrorLogin">
                Не верно введен логин или пароль!
            </div>
            <button class="w-100 btn btn-lg btn-primary mb-2" type="button" @click="login">Войти</button>
            <p class="mt-5 mb-3 text-muted">©Магазин 2021</p>
        </div>
    `
}