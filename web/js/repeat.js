var vue = new Vue({
    el: "#app",
    data: {
        hours: 0,
        minutes: 0,
        seconds: 0,
        isf: false,
        questions: [{topic: "15-20+(21*16)=", ans: "2", res: '', flag: false},
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
        getRepeat: function () {
            var _this = this;
            _this.type = 1;
            axios.get("/questionServlet?method=find").then(function (response) {
                _this.questions = response.data.questions;
                console.log(response.data);
                console.log(_this.questions);
            }).catch(function (err) {
                console.log(err);
            });
        },
        judge: function () {
            var t = this.questions;
            this.isf = true;
            for (var i = 0; i < t.length; i++) {
                if (t[i].res === t[i].ans) {
                    t[i].flag = true;
                } else {
                    t[i].flag = false;
                }
            }
            this.removeQuestion()
        },
        removeQuestion:function () {
            var _this = this;
            var t=_this.questions;
            for (var i=0;i<t.length;i++){
                if (t[i].flag){
                    let params = '&topic='+t[i].topic;
                    axios.post("/questionServlet?method=remove" + params
                    ).then(function (response) {

                    }).catch(function (err) {
                    });
                }
            }
        }
    },
    created() {
        this.getRepeat();
    }, mounted() {

    }
});