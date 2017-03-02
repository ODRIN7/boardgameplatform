"use strict";
/* tslint:disable:max-line-length */
var models_1 = require('./models');
var moment = require('moment');
// the person using the app us Juliet
var me = new models_1.User('Juliet', require('images/avatars/female-avatar-1.png'));
var ladycap = new models_1.User('Lady Capulet', require('images/avatars/female-avatar-2.png'));
var echo = new models_1.User('Echo Bot', require('images/avatars/male-avatar-1.png'));
var rev = new models_1.User('Reverse Bot', require('images/avatars/female-avatar-4.png'));
var wait = new models_1.User('Waiting Bot', require('images/avatars/male-avatar-2.png'));
var tLadycap = new models_1.Thread('tLadycap', ladycap.name, ladycap.avatarSrc);
var tEcho = new models_1.Thread('tEcho', echo.name, echo.avatarSrc);
var tRev = new models_1.Thread('tRev', rev.name, rev.avatarSrc);
var tWait = new models_1.Thread('tWait', wait.name, wait.avatarSrc);
var initialMessages = [
    new models_1.Message({
        author: me,
        sentAt: moment().subtract(45, 'minutes').toDate(),
        text: 'Yet let me weep for such a feeling loss.',
        thread: tLadycap
    }),
    new models_1.Message({
        author: ladycap,
        sentAt: moment().subtract(20, 'minutes').toDate(),
        text: 'So shall you feel the loss, but not the friend which you weep for.',
        thread: tLadycap
    }),
    new models_1.Message({
        author: echo,
        sentAt: moment().subtract(1, 'minutes').toDate(),
        text: "I'll echo whatever you send me",
        thread: tEcho
    }),
    new models_1.Message({
        author: rev,
        sentAt: moment().subtract(3, 'minutes').toDate(),
        text: "I'll reverse whatever you send me",
        thread: tRev
    }),
    new models_1.Message({
        author: wait,
        sentAt: moment().subtract(4, 'minutes').toDate(),
        text: "I'll wait however many seconds you send to me before responding. Try sending '3'",
        thread: tWait
    }),
];
var ChatExampleData = (function () {
    function ChatExampleData() {
    }
    ChatExampleData.init = function (messagesService, threadsService, userService) {
        // TODO make `messages` hot
        messagesService.messages.subscribe(function () { return ({}); });
        // set "Juliet" as the current user
        userService.setCurrentUser(me);
        // create the initial messages
        initialMessages.map(function (message) { return messagesService.addMessage(message); });
        threadsService.setCurrentThread(tEcho);
        this.setupBots(messagesService);
    };
    ChatExampleData.setupBots = function (messagesService) {
        // echo bot
        messagesService.messagesForThreadUser(tEcho, echo)
            .forEach(function (message) {
            messagesService.addMessage(new models_1.Message({
                author: echo,
                text: message.text,
                thread: tEcho
            }));
        }, null);
        // reverse bot
        messagesService.messagesForThreadUser(tRev, rev)
            .forEach(function (message) {
            messagesService.addMessage(new models_1.Message({
                author: rev,
                text: message.text.split('').reverse().join(''),
                thread: tRev
            }));
        }, null);
        // waiting bot
        messagesService.messagesForThreadUser(tWait, wait)
            .forEach(function (message) {
            var waitTime = parseInt(message.text, 10);
            var reply;
            if (isNaN(waitTime)) {
                waitTime = 0;
                reply = "I didn't understand " + message.text + ". Try sending me a number";
            }
            else {
                reply = "I waited " + waitTime + " seconds to send you this.";
            }
            setTimeout(function () {
                messagesService.addMessage(new models_1.Message({
                    author: wait,
                    text: reply,
                    thread: tWait
                }));
            }, waitTime * 1000);
        }, null);
    };
    return ChatExampleData;
}());
exports.ChatExampleData = ChatExampleData;
