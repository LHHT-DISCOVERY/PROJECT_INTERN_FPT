$.ajax({
    type: 'GET',
    url: 'http://localhost:8080/api/user/rating',
    enctype: 'application/json',
    dataType: 'json',
    processData: false,
    cache: false,
    contentType: false,
    error: function (error) {
        console.log("Thêm tin bài đã lỗi!");
    },
    success: function (response) {
        Chart.helpers.merge(Chart.defaults.global.plugins.datalabels, {
            opacity: 1,
            color: 'white',
            borderColor: '#11469e',
            borderWidth: 2,
            borderRadius: 100,
            font: {
                weight: 'bold',
                size: 14,
                lineHeight: 1 /* align v center */
            },
            padding: {
                top: 5
            },
            /* hover styling */
            backgroundColor: function (context) {
                return context.hovered ? context.dataset.borderColor : 'white';
            },
            color: function (context) {
                return context.hovered ? 'white' : context.dataset.borderColor;
            },
            listeners: {
                enter: function (context) {
                    context.hovered = true;
                    return true;
                },
                leave: function (context) {
                    context.hovered = false;
                    return true;
                }
            }
        });

        Chart.scaleService.updateScaleDefaults('radar', {
            ticks: {
                min: 0
            }
        });
        var data = {
            labels: ["SPE", "TEC", "STR", "JUM", "DEF", "OFF"],
            datasets: [{
                label: "Lê Văn Dũng",
                backgroundColor: "rgba(38,120,255,0.2)",
                borderColor: "rgba(38,120,255, 1)",
                data: [[response.speed], [response.technique], [response.strength],
                    [response.jumping], [response.defense], [response.offense]]
            }]
        };
        var options = {
            responsive: true,
            tooltips: false,
            title: {
                text: 'Thông số cầu thủ',
                display: false,
                position: `bottom`,
            },
            plugins: {
                /* ######### https://chartjs-plugin-datalabels.netlify.com/ #########*/
                datalabels: {
                    /* formatter */
                    formatter: function (value, context) {
                        return context.chart.data.labels[context.value];
                    }
                }
            },
            /* scale: https://www.chartjs.org/docs/latest/axes/radial/linear.html#axis-range-settings */
            scale: {
                gridLines: {
                    display: true
                },
                angleLines: {
                    display: true
                },
                pointLabels: {
                    /* https://www.chartjs.org/docs/latest/axes/radial/linear.html#point-label-options */
                    fontSize: 15,
                    fontColor: 'black',
                    fontStyle: 'bold',
                    callback: function (value, index, values) {
                        return value;
                    }
                },
                ticks: {
                    /* https://www.chartjs.org/docs/latest/axes/styling.html#tick-configuration */
                    /* suggestedMax and suggestedMin settings only change the data values that are used to scale the axis */
                    suggestedMin: 0,
                    suggestedMax: 100,
                    stepSize: 25, /* 25 - 50 - 75 - 100 */
                    maxTicksLimit: 11, /* Or use maximum number of ticks and gridlines to show */
                    display: false, // remove label text only,
                }
            },
            legend: {
                /* https://www.chartjs.org/docs/latest/configuration/legend.html */
                labels: {
                    padding: 10,
                    fontSize: 14,
                    lineHeight: 30,
                },
                display: false,
            },
        };

        var myChart = new Chart(document.getElementById("chart"), {
            type: 'radar',
            data: data,
            options: options,
        });
    }
});