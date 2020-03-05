var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1
    },
    mounted() {
        this.searchProduct();
    },
    methods: {
        searchProduct(){
            axios.get('/product/search',{
                pageNum : this.pageNum
            })
            .then(res => {
                this.pageInfo = res.data;
            })
            .catch(res => {
                console.log(res);
            })

        },
        handlePageChange(val){
            console.log('page change');
            this.pageNum = val;
            this.searchProduct();
        },
        handleGoCreateClick(){
            location.href='product-create.html';
        },
        handleGoUpdateClick(index,row){
            console.log('to submit click', row);
            location.href='product-update.html?productId='+row.productId;
        }
    }   
})