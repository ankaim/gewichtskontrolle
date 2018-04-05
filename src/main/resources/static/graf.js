google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var jsonData = $.ajax({
        url: "text.json",
        dataType: "json",
        async: false
    }).responseText;

    var data = new google.visualization.DataTable(jsonData);
    console.log(data);
    console.log(jsonData);


    var options = {
        title: 'All data for the period',
        curveType: 'function',
        legend: {position: 'bottom'}
    };

    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

    chart.draw(data, options);
}