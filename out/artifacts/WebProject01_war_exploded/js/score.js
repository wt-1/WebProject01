var vue = new Vue({
    el: "#app",
    data: {
        sorces: [{date: "2022-3-26 11:03:00", grade: "90"},
            {date: "2022-3-26 11:02:00", grade: "95"},
            {date: "2022-3-26 11:01:00", grade: "90"},
            {date: "2022-3-26 11:03:00", grade: "90"},
            {date: "2022-3-26 11:02:00", grade: "95"},
            {date: "2022-3-26 11:01:00", grade: "90"},
            {date: "2022-3-26 11:03:00", grade: "90"},
            {date: "2022-3-26 11:02:00", grade: "95"},
            {date: "2022-3-26 11:01:00", grade: "90"}]
    },
    methods: {
        getScore: function () {
            var _this = this;
            _this.type = 1;
            axios.get("/scoreServlet?method=find").then(function (response) {
                _this.sorces = response.data.sorces;
                console.log(response.data);
                console.log(_this.sorces);
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    created() {
        this.getScore();
    }, mounted() {
    }
});