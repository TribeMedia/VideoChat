# VideoChat
application built on spring boot and kurento (one-to-one) and (one-to-many) in server side and clint side using javascripte consol

#open the image link to see video  how to use
[![ScreenShot](http://i.imgur.com/MDtdHT9.png)](https://www.youtube.com/watch?v=TZhbCTqBXMw)





open localhost:8080/revo/videochat


using this function write them in the consol it saved in static/js/index.js

CREATE_PIPELINE_MESSAGE(type);
-->     type may be One_To_Many  or One_To_One


INVITE_TO_PIPELINE_MESSAGE(name)
-->     name is the user that you want him to access you mediapipeliee


JOIN_PIPELINE_MESSAGE(to, type)
-->     to is the user who invite you type is the type may be One_To_Many  or One_To_One


