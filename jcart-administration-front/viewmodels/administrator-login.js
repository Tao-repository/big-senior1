var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: '',
    },
    mounted() {
      
    },
    methods: {
        handleLoginClick(){
            this.administratorLogin();
        },
        administratorLogin(){
            axios.get("/administrator/login",
            {
                params:{
                    username : this.username,
                    password : this.password
                }
            })
            .then(res => {
                alert('登录成功');
                localStorage['jcartToken'] = res.data.token;
                localStorage['expireTimestamp'] = res.data.expireTimestamp;
                location.href="product-search.html";         
            })
            .catch(function (error) {
                console.log(error);
                alert('登录失败');
            });
        }
    }   
})