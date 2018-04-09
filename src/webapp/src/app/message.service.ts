import {Injectable} from '@angular/core';
import {Client, Frame, Message} from "stompjs";

import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";
import {Subject} from "rxjs/Subject";

@Injectable()
export class MessageService {

  private messageSource = new Subject<string>();
  messageReceived$ = this.messageSource.asObservable();


  stompClient: Client;

  constructor() {
    const socket = new SockJS('http://localhost:8080/gs-guide-websocket') as WebSocket;
    this.stompClient = stompjs.over(socket);
    this.stompClient.connect('', '', (frame: Frame) => {
      console.log('CONNECT CONNECT');
      console.log("Frame:"+frame);

      this.stompClient.subscribe('/topic/greetings', (message: Message) => {
        console.log(message)
        this.onMessage(message);
      });

      this.stompClient.subscribe('/queue/reply', (message: Message) => {
        console.log("/queue/reply")
        this.onMessage(message);
      });

    });
  }


  private onMessage(message: Message) {
    console.log('Received greeting:', message.body);
    let json = JSON.parse(message.body);
    this.messageSource.next(json['content']);
  }


}
