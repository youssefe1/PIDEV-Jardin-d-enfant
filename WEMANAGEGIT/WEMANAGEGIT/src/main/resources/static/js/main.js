'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var usersList = "";

var user={
	    "id": "0",
	    "userName": "haitham",
	    "password": "123",
	    "roles": "user",
	    "email": "haitham@gmail.com",
	    "telephone": "54043829",
	    "adresse": "isma3iliya",
	    "firstName": "haitham",
	    "lastName": "kossentini"};



var userid="";
userid=user.id;
var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];



function connect(event) {
 
	  username=user.firstName+user.lastName;
	    userid=user.id;
	    console.log("aaaaaaaaaaaa"+username);
    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
   // stompClient.subscribe('/topic/public', onMessageReceived);
    stompClient.subscribe('/topic/public', onDisplay);
    // Tell your username to the server
   /* stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({user: username, type: 'JOIN'})
    )*/
    stompClient.send("/app/chat.getHistory",
        {},
        JSON.stringify({sender: user, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textbody = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    var messagebody = messageInput.value.trim();
    if(messagebody && stompClient) {
        var chatMessage = {
            sender: user,
            body: messageInput.value,
            type: 'CHAT',
           
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function onDisplay(payload) {
    var mes = JSON.parse(payload.body);
    if( mes.length>1 && usersList!=username){
    	for (const message of mes) {
    		console.log(message);
    		var messageElement = document.createElement('li');

    	    if(message.type==='JOIN') {
    	        messageElement.classList.add('event-message');
    	        message.body = username + ' joined!';
    	    } else if (message.type === 'LEAVE') {
    	        messageElement.classList.add('event-message');
    	        message.body = username + ' left!';
    	    } else {
    	        messageElement.classList.add('chat-message');

    	        var avatarElement = document.createElement('i');
    	        var avatarText = document.createTextNode(username[0]);
    	        avatarElement.appendChild(avatarText);
    	        avatarElement.style['background-color'] = getAvatarColor(username);

    	        messageElement.appendChild(avatarElement);

    	        var usernameElement = document.createElement('span');
    	        var usernameText = document.createTextNode(username);
    	        
    	        usernameElement.appendChild(usernameText);
    	        messageElement.appendChild(usernameElement);
    	        var dateTest=convert(message.date);
    	        var date =document.createTextNode(dateTest);
    	        messageElement.appendChild(date);
    	    }

    	    var textElement = document.createElement('p');
    	    var messageText = document.createTextNode(message.body);
    	    textElement.appendChild(messageText);
    	   
    	    messageElement.appendChild(textElement);
    
    	    messageArea.appendChild(messageElement);
    	    messageArea.scrollTop = messageArea.scrollHeight;
    	    
    		}
    	usersList=username;

    }
    else {
    	var message = mes;
    	 var messageElement = document.createElement('li');

    	    if(message.type === 'JOIN') {
    	        messageElement.classList.add('event-message');
    	        message.body = username + ' joined!';
    	    } else if (message.type === 'LEAVE') {
    	        messageElement.classList.add('event-message');
    	        message.body = username + ' left!';
    	    } else {
    	        messageElement.classList.add('chat-message');

    	        var avatarElement = document.createElement('i');
    	        var avatarText = document.createTextNode(username[0]);
    	        avatarElement.appendChild(avatarText);
    	        avatarElement.style['background-color'] = getAvatarColor(username);

    	        messageElement.appendChild(avatarElement);

    	        var usernameElement = document.createElement('span');
    	        var usernameText = document.createTextNode(username);
    	        usernameElement.appendChild(usernameText);
    	        messageElement.appendChild(usernameElement);
    	        var dateTest=convert(message.date);
    	        var date =document.createTextNode(dateTest);
    	        messageElement.appendChild(date);
    	    }

    	    var textElement = document.createElement('p');
    	    var messageText = document.createTextNode(message.body);
    	    textElement.appendChild(messageText);
    	   
    	   
    	    messageElement.appendChild(textElement);
    
    
    	    messageArea.appendChild(messageElement);
    	    messageArea.scrollTop = messageArea.scrollHeight;
    }   
}



function onMessageReceived(payload) {
    var mes= JSON.parse(payload.body);
    console.log(message);
    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.body = username + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.body = username + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(username[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(username);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(username);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
        var dateTest="   "+message.date.toString();
        var date =document.createTextNode(dateTest);
        messageElement.appendChild(date);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.body);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}


function convert(date){
	  var datearray = date.split("T");
	  var dateres= datearray[0].split("-")
	  var timearray= datearray[1].split(".");
	  var newdate="   "+dateres[2]+"/"+dateres[1]+"/"+dateres[0]+"  "+timearray[0]; 
	  return newdate;
	}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)