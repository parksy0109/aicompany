var chart1Labels = [];
var chart1adopt = [];
var chart1home = [];
var chart1free = [];

var chart2Labels = [];
var chart2data1 = [];
var chart2data2 = [];
var chart2data3 = [];
var chart2tooltip1 = [];
var chart2tooltip2 = [];
var chart2tooltip3 = [];

var chart3Labels = [];
var chart3data = [];

$(document).ready(function(){
    getTimeStamp();

    jQuery.ajax({ // $.ajax 와 동일한 표현
        url : '/samsam/storereport.do',
        type : 'POST',
        dataType : 'json', //서버에서 보내줄 데이터 타입
        contentType : 'application/json;charset=utf-8',
        success : function(map) {
            console.log(map);
            if(map.storecount != null || map.standbycount != null){
                var count = "<tr><td>총 가입업체 수</td><td>" + map.storecount+"</td></tr>"
                count += "<tr><td>인증대기업체 수</td><td>" + map.standbycount+"</td></tr>"

                $('.storecount').append(count);
            }//if
            if(map.chart1 != null && map.chart1 != ""){
                console.log("chart1")
                console.log(map.chart1)
                $.each(map.chart1, function(index, item){
                    if(item.board == "분양"){
                        chart1adopt.push(item.write_count);
                        chart1Labels.push(item.write_date.substr(2,8));
                    }
                    if(item.board == "가정"){
                        chart1home.push(item.write_count);
                    }
                    if(item.board == "책임"){
                        chart1free.push(item.write_count);
                    }
                });
            }//map.chart1
            console.log("chart2")
            console.log(map.adopt)
            console.log(map.home)
            console.log(map.free)

            if(map.adopt != null && map.adopt != ""){
                chart2Labels.push("분양")
                var maxitem =0;
                var max_local=null;
                var second = 0;
                var second_local=null;
                var minitem = 0;
                var min_local=null;
                $.each(map.adopt, function(index, item){
                    console.log("인덱스 :"+index)

                    if (parseInt(item.alocal_count) > maxitem){
                        second = maxitem
                        second_local = max_local
                        maxitem = parseInt(item.alocal_count)
                        max_local = item.local
                    }else if(second < parseInt(item.alocal_count) < maxitem){
                        second = parseInt(item.alocal_count)
                        second_local = item.local
                    }else{
                        minitem = parseInt(item.alocal_count)
                        min_local = item.local
                    }
                });
                chart2data1.push(maxitem)
                chart2tooltip1.push(max_local)
                chart2data2.push(second)
                chart2tooltip2.push(second_local)
                chart2data3.push(minitem)
                chart2tooltip3.push(min_local)
            }
            if(map.home != null && map.home != ""){
                chart2Labels.push("가정")
                var maxitem =0;
                var max_local=null;
                var second = 0;
                var second_local=null;
                var minitem = 0;
                var min_local =null;
                $.each(map.home, function(index, item){
                    console.log("가정인덱스 :"+index)

                    if (parseInt(item.hlocal_count) > maxitem){
                        second = maxitem
                        second_local = max_local
                        maxitem = parseInt(item.hlocal_count)
                        max_local = item.local
                    }else if(second < parseInt(item.hlocal_count) < maxitem){
                        second = parseInt(item.hlocal_count)
                        second_local = item.local
                    }else{
                        minitem = parseInt(item.hlocal_count)
                        min_local = item.local
                    }
                });
                chart2data1.push(maxitem)
                chart2tooltip1.push(max_local)
                chart2data2.push(second)
                chart2tooltip2.push(second_local)
                chart2data3.push(minitem)
                chart2tooltip3.push(min_local)
            }
            if(map.free != null && map.free != ""){
                chart2Labels.push("책임")
                var maxitem =0;
                var max_local =null;
                var second = 0;
                var second_local=null;
                var minitem = 0;
                var min_local =null;
                $.each(map.free, function(index, item){
                    console.log("ㅊㅇ인덱스 :"+index)
                    if (parseInt(item.flocal_count) > maxitem){
                        second = maxitem
                        second_local = max_local
                        maxitem = parseInt(item.flocal_count)
                        max_local = item.local
                    }else if(second < parseInt(item.flocal_count) < maxitem){
                        second = parseInt(item.flocal_count)
                        second_local = item.local
                    }else{
                        minitem = parseInt(item.flocal_count)
                        min_local = item.local
                    }
                });
                chart2data1.push(maxitem)
                chart2tooltip1.push(max_local)
                chart2data2.push(second)
                chart2tooltip2.push(second_local)
                chart2data3.push(minitem)
                chart2tooltip3.push(min_local)
            }//map.chart2
            console.log("chart3")
            console.log(map.chart3pay)
            console.log(map.chart3repay)

            var repayCount = null;
            if(map.chart3pay != null && map.chart3pay != ""){
                $.each(map.chart3pay, function(index, item){
                    if(item.refund != null && item.refund !=""){
                        chart3Labels.push(item.refund);
                        chart3data.push(item.count)
                    }
                });
            }
            if(map.chart3repay != null && map.chart3repay != ""){
                $.each(map.chart3repay, function(index, item){
                    repayCount += item.biz_count

                    chart3Labels.push("Buy again")
                    chart3data.push(repayCount)
                });
            }
            lineChart()
            barChart();
            donutChart()
            console.log("create Chart");
        },
        error : function() {
            console.log("업체카운팅 and chart ajax실패!!!");
        }
    });

})//ready
function lineChart(){
    console.log("linechart")
    console.log(chart1adopt)
    console.log(chart1home)
    console.log(chart1free)
    console.log("툴팁")
    console.log(chart1Labels)
    var ctx = $('#linechart').get(0).getContext('2d');
    var linedata =
        {
            labels: chart1Labels,
            datasets:
                [{
                    labels: '업체',
                    borderColor: 'rgba(255, 99, 132, 1.5)',
                    fill: false,
                    data: chart1adopt
                },
                    {
                        labels: '가정',
                        borderColor: 'rgba(54, 162, 235, 1.5)',
                        fill: false,
                        data: chart1home
                    },
                    {
                        labels: '책임',
                        borderColor: 'rgba(255, 206, 86, 1.5)',
                        fill: false,
                        data: chart1free
                    }]
        };
    var lineoptions = {
        responsive: true,
        legend : {
            display: false
        },
        title: {
            display: true,
            text: '     일간분양게시현황',
            fontSize: 17,
            fontColor: 'rgba(46, 49, 49, 1)'
        },
        animation: false,
        tooltips: {
            displayColors: false, // 툴팁 바 컬러 표시 여부
            titleFontColor: '#fff', // 툴팁 폰트 관련
            titleAlign: 'center', // 툴팁 폰트 관련
            bodyAlign : 'center',
            callbacks: {
                label: function(tooltipItem, data) {
                    var item = data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
                    var label = data.datasets[tooltipItem.datasetIndex].labels;
                    return label + ' : '+item;
                }
            }
        }
    };

    var lineChart = new Chart(ctx,{
        type: 'line',
        data: linedata,
        options: lineoptions
    });
}//line chart
function barChart(){
    console.log("barchart")
    console.log(chart2data1)
    console.log(chart2data2)
    console.log(chart2data3)
    console.log("툴팁")
    console.log(chart2tooltip1)
    console.log(chart2tooltip2)
    console.log(chart2tooltip3)

    var ctx = $('#barchart').get(0).getContext('2d');
    var bardata =
        {
            labels: chart2Labels,
            datasets:
                [{
                    labels: chart2tooltip1,
                    backgroundColor: 'rgba(255, 99, 132, 1)',
                    borderColor: 'rgba(255, 99, 132, 1.5)',
                    data: chart2data1
                },
                    {
                        labels: chart2tooltip2,
                        backgroundColor: 'rgba(54, 162, 235, 1)',
                        borderColor: 'rgba(54, 162, 235, 1.5)',
                        data: chart2data2
                    },
                    {
                        labels: chart2tooltip3,
                        backgroundColor: 'rgba(255, 206, 86, 1)',
                        borderColor: 'rgba(255, 206, 86, 1.5)',
                        data: chart2data3
                    }]
        };
    var baroptions = {
        responsive: true,
        legend : {
            display: false
        },
        title: {
            display: true,
            text: '   최근 1주간 게시글 지역 탑3',
            fontSize: 17,
            fontColor: 'rgba(46, 49, 49, 1)'
        },
        animation: false,
        tooltips: {
            displayColors: false, // 툴팁 바 컬러 표시 여부
            titleFontColor: '#fff', // 툴팁 폰트 관련
            titleAlign: 'center', // 툴팁 폰트 관련
            callbacks: {
                label: function(tooltipItem, data) {
                    var item = data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
                    var label = data.datasets[tooltipItem.datasetIndex].labels[tooltipItem.index];
                    return label + ' : '+item;
                }
            }
        }
    };

    var barChart = new Chart(ctx,{
        type: 'bar',
        data: bardata,
        options: baroptions
    });
}//bar chart

function donutChart(){
    console.log("donutchart")
    console.log(chart3data)
    console.log("툴팁")
    console.log(chart3Labels)
    var ctx = $('#donutchart').get(0).getContext('2d');
    var donutdata =
        {
            labels: chart3Labels,
            datasets:
                [{
                    backgroundColor: [
                        'rgba(255, 99, 132, 1.5)',
                        'rgba(54, 162, 235, 1.5)',
                        'rgba(255, 206, 86, 1.5)'
                    ],
                    hoverBorderColor : '#fff',
                    data: chart3data
                }]
        };
    var donutoptions = {
        responsive: true,
        legend : {
            display: true,
            position : 'bottom'
        },
        title: {
            display: true,
            text: '최근 한달 구매내역',
            fontSize: 17,
            fontColor: 'rgba(46, 49, 49, 1)'
        },
        animation: false,
        tooltips: {
            displayColors: false, // 툴팁 바 컬러 표시 여부
            titleFontColor: '#fff', // 툴팁 폰트 관련
            titleAlign: 'center', // 툴팁 폰트 관련
            bodyAlign : 'center'
        }
    };

    var donutChart = new Chart(ctx,{
        type: 'doughnut',
        data: donutdata,
        options: donutoptions
    });
}//donut chart