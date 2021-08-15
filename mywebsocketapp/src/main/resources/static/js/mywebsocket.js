var stompClient = null;

$(function () {

    // 页面初始化
    connectToWebSocketServer();

});

// 连接websocketserver服务端
function connectToWebSocketServer() {

    // 1.创建客户端连接通道
    var socket = new SockJS("http://localhost:8085/fbSocket");
    stompClient = Stomp.over(socket);

    // 2.连接服务端
    stompClient.connect({}, function (frame) {
        // 1.设置连接标志位
        setConnected(true);

        // console.log('Connected: ' + frame);

        // 2.根据当前用户信息,订阅感兴趣的数据
        stompClient.subscribe('/myorder/userId/10010', function (frame) {

            // showResponseResult(JSON.parse(frame.body).content);
            console.info(frame);
            showResponseResult(frame.body);
        });
    });
}


// 设置连接标志位
function setConnected(connected) {
    $("#connect").attr("disabled", connected);
    $("#disconnect").attr("disabled", !connected);

    if (connected) {
        $("#conversationDiv").show();
    } else {
        $("#conversationDiv").hide();
    }
    $("#response").html("");
}

function csendToClient() {
    var msgBody = $("#name").val();
    var headers = {};
    stompClient.send("/csendToClient", headers, msgBody);
}

function disconnectWebSocketServer() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showResponseResult(message) {
    $("#response").append("<tr><td>" + message + "</td></tr>");
}