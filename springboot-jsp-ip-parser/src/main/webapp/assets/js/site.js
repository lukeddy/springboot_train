// $(function(){
//     var chartData =
//         [{"country": "毕节", "value": 1}, {"country": "凉山", "value": 14}, {"country": "南充", "value": 35}, {
//             "country": "济南",
//             "value": 1
//         }, {"country": "昆明", "value": 1}, {"country": "眉山", "value": 7}, {"country": "临沂", "value": 2}, {
//             "country": "重庆",
//             "value": 1
//         }, {"country": "贵阳", "value": 1}, {"country": "德阳", "value": 5}, {"country": "黔南", "value": 1}, {
//             "country": "绵阳",
//             "value": 14
//         }, {"country": "黔东南", "value": 2}, {"country": "长春", "value": 1}, {"country": "天津", "value": 1}, {
//             "country": "榆林",
//             "value": 2
//         }, {"country": "成都", "value": 66}, {"country": "广安", "value": 13}, {"country": "自贡", "value": 7}, {
//             "country": "乐山",
//             "value": 12
//         }, {"country": "宜宾", "value": 27}, {"country": "曲靖", "value": 1}, {"country": "泸州", "value": 18}, {
//             "country": "阿坝",
//             "value": 3
//         }, {"country": "武汉", "value": 9}, {"country": "遂宁", "value": 6}, {"country": "广元", "value": 10}, {
//             "country": "深圳",
//             "value": 1
//         }, {"country": "内江", "value": 11}, {"country": "达州", "value": 12}, {"country": "巴中", "value": 7}, {
//             "country": "广州",
//             "value": 4
//         }, {"country": "梅州", "value": 1}, {"country": "雅安", "value": 3}, {"country": "铜仁", "value": 1}, {
//             "country": "攀枝花",
//             "value": 5
//         }, {"country": "None", "value": 1}, {"country": "资阳", "value": 15}];
//
//     createPieChart(chartData,"chartdiv1");
//     createPieChart(chartData,"chartdiv2");
//     createPieChart(chartData,"chartdiv3");
//     createPieChart(chartData,"chartdiv4");
// });


function createPieChart(chartData, containerID){
    // 饼图
    var chart = new AmCharts.AmPieChart();
    chart.dataProvider = chartData;
    chart.titleField = "label";
    chart.valueField = "value";
    chart.outlineColor = "";
    chart.outlineAlpha = 0.5;
    chart.outlineThickness = 1;
    // 3D
    chart.depth3D = 30;
    chart.angle = 10;
    chart.write(containerID);
}