var vue = new Vue({
    el: "#app",
    data: {
        hours: 0,
        minutes: 0,
        seconds: 0,
        grade: 0,
        isf: false,
        topics: [{topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false},
            {topic: "16*2/4+7=", ans: "4", res: '', flag: false},
            {topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
            {topic: "15/3+12-6=", ans: "3", res: '', flag: false}]
    },
    methods: {
        bracket: function () {
            var _this = this;
            _this.type = 1;
            axios.get("/ariServlet?method=bracket").then(function (response) {
                _this.topics = response.data.topics;
                // console.log(_this.topics);
                console.log(response.data);
            }).catch(function (err) {
                console.log(err);
            });
        },
        judge: function () {
            var t = this.topics;
            this.isf = true;
            window.clearInterval(time);
            for (var i = 0; i < t.length; i++) {
                if (t[i].res === t[i].ans) {
                    t[i].flag = true;
                    this.grade += 5;
                } else {
                    t[i].flag = false;
                }
            }
            this.addGrade();
            this.addQuestion();
        },
        addGrade: function () {
            var _this = this;
            let params = '&grade='+_this.grade;
            axios.post("/scoreServlet?method=add" + params
            ).then(function (response) {

            }).catch(function (err) {
            });
        },
        addQuestion:function () {
            var _this = this;
            var t=_this.topics;
            for (var i=0;i<t.length;i++){
                if (!t[i].flag){
                    let params = '&topic='+t[i].topic.toString()+'&ans='+t[i].ans;
                    axios.post("/questionServlet?method=add" + params
                    ).then(function (response) {

                    }).catch(function (err) {
                    });
                }
            }
        },
        addTime: function () {
            time = window.setInterval(() => {
                if (this.seconds === 59){
                    this.minutes += 1;
                    this.seconds = 0;
                } else if (this.minutes === 5 && this.seconds === 0) {
                    this.judge();
                } else {
                    this.seconds += 1;
                }
            }, 1000)
        }
    },
    created() {
        this.bracket();
    }, mounted() {
        this.addTime();
    },
    watch: {

    },
    computed: {

    }
});