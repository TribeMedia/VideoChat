var stompClient = null;
var webRtcPeer = null;
var videoInput;
var videoOutput;

window.onload = function () {
    videoInput = document.getElementById('videoInput');
    videoOutput = document.getElementById('videoOutput');

    var path = $("meta[name='path']").attr("content");
    var socket = new SockJS(path + 'hello');
    stompClient = Stomp.over(socket);

    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeaderName = $("meta[name='_csrf_header']").attr("content");
    var headers = {};
    headers[csrfHeaderName] = csrfToken;
    stompClient.connect(headers, function (frame) {
        stompClient.subscribe('/user/topic/message', function (answer) {
            var o = JSON.parse(answer.body);
            if (o.messageType == "SDPOFFER_MESSAGE") {
                webRtcPeer.processSdpAnswer(o.content);
            }
            else if (o.messageType == "ERROR") {
                alert(o.content);
            }
            else if (o.messageType == "INVITE_TO_PIPELINE_MESSAGE") {

            }
            else if (o.messageType == "RELEASE_PIPELINE_MESSAGE") {
                if (webRtcPeer) {
                    webRtcPeer.dispose();
                    webRtcPeer = null;
                }
            }
        });
    });
}

function CREATE_PIPELINE_MESSAGE(type) {
    if (type == 'One_To_Many') {
        webRtcPeer = kurentoUtils.WebRtcPeer.startSendOnly(videoInput, function (sdpOffer) {
                var message = JSON.stringify({
                    'messageType': "CREATE_PIPELINE_MESSAGE",
                    'content': sdpOffer,
                    'mediaPipelineType': type
                });
                stompClient.send("/app/message", {},
                    message
                )
                ;
            }
            , function (error) {
            }
        );


    } else if (type == 'One_To_One') {
        webRtcPeer = kurentoUtils.WebRtcPeer.startSendRecv(videoOutput, videoInput, function (sdpOffer) {
                var message = JSON.stringify({
                    'messageType': "CREATE_PIPELINE_MESSAGE",
                    'content': sdpOffer,
                    'mediaPipelineType': type
                });
                stompClient.send("/app/message", {}, message);
            }
            , function (error) {
            }
        );


    }

}

function INVITE_TO_PIPELINE_MESSAGE(to) {

    var message = JSON.stringify({
        'messageType': "INVITE_TO_PIPELINE_MESSAGE",
        'to': to
    });

    stompClient.send("/app/message", {}, message);
}


function RELEASE_PIPELINE_MESSAGE() {

    if (webRtcPeer) {
        webRtcPeer.dispose();
        webRtcPeer = null;
        var message = JSON.stringify({
            'messageType': "RELEASE_PIPELINE_MESSAGE"
        });

        stompClient.send("/app/message", {}, message);
    }
}

function JOIN_PIPELINE_MESSAGE(to, type) {
    if (type == 'One_To_Many') {
        webRtcPeer = kurentoUtils.WebRtcPeer.startRecvOnly(videoInput, function (sdpOffer) {
            var message = JSON.stringify({
                'messageType': "JOIN_PIPELINE_MESSAGE",
                'content': sdpOffer,
                'to': to
            });
            stompClient.send("/app/message", {}, message);
        }, function (error) {
        });
    }
    else if (type == 'One_To_One') {
        webRtcPeer = kurentoUtils.WebRtcPeer.startSendRecv(videoOutput, videoInput, function (sdpOffer) {
            var message = JSON.stringify({
                'messageType': "JOIN_PIPELINE_MESSAGE",
                'content': sdpOffer,
                'to': to
            });
            stompClient.send("/app/message", {}, message);
        }, function (error) {
        });
    }
}

