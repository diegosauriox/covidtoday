//Chart.defaults.global.elements.point.radius = 2
var chartColors = [
    'rgb(255, 99, 132)',
    'rgb(255, 159, 64)',
    'rgb(255, 205, 86)',
    'rgb(75, 192, 192)',
    'rgb(54, 162, 235)',
    'rgb(153, 102, 255)',
    'rgb(231,233,237)',
    'rgb(255, 99, 132)',
    'rgb(255, 159, 64)',
    'rgb(255, 205, 86)',
    'rgb(75, 192, 192)',
    'rgb(54, 162, 235)',
    'rgb(153, 102, 255)',
    'rgb(231,233,237)',
    'rgb(255, 99, 132)',
    'rgb(255, 159, 64)',
];

var config = {
    type: 'line',
    data: {
        labels: [],
        datasets: []
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        title: {
            display: true,
            text: 'Casos confirmados diarios por región'
        },
        tooltips: {
            mode: 'label',
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Día'
                },
                ticks: {
                    autoSkip: true,
                    maxTicksLimit: 15
                }
            }],
            yAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Casos confirmados'
                },
            }]
        }
    }
};



fetch('https://chile-coronapi.herokuapp.com/api/v3/historical/regions')
    .then(response => response.json())
    .then((data) => {
        for (let i = 1; i < 16; i++) {
            if (i != 13) {
                var labels = [];
                var datasets = [];
                const element = data[i.toString()];
                var nombre = element.region;
                const entries = Object.entries(element.regionData);
                for (let j = 0; j < entries.length-1; j+=5) {
                    let label = entries[j][0];
                    let dataset = entries[j][1].confirmed
                    labels.push(label);
                    datasets.push(dataset);
                }
                let label = entries[entries.length-1][0];
                let dataset = entries[entries.length-1][1].confirmed
                labels.push(label);
                datasets.push(dataset);
                var json = {
                    label: nombre,
                    backgroundColor: chartColors[i - 1],
                    borderColor: chartColors[i - 1],
                    data: datasets,
                    fill: false,
                }
                config.data.datasets.push(json);
            }
        }
        config.data.labels = labels;
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myLine = new Chart(ctx, config);
    })
    .catch(function (err) {
        console.error(err);
    });
