import {Injectable} from '@angular/core';
import {Client, Frame, Message} from "stompjs";

import * as stompjs from 'stompjs';
import * as SockJS from "sockjs-client";
import {Subject} from "rxjs/Subject";
import {Constants} from "../static/constants";
import {RestService} from "./rest.service";
import {SubscribedMessage} from "../dto/subscribed.dto";

@Injectable()
export class WebsocketService {
  private messageSource = new Subject<string>();
  private identity:string;
  messageReceived$ = this.messageSource.asObservable();
  stompClient: Client;

  constructor(private rest: RestService) {
    this.rest.doGet(Constants.getSessionUrl()).subscribe(x => {
      this.identity = x.text();

      const socket = new SockJS(Constants.getWebSocketUrl()) as WebSocket;
      this.stompClient = stompjs.over(socket);
      this.stompClient.connect('', '', (frame: Frame) => {

        this.stompClient.subscribe(Constants.getQueueUrl(this.identity), (message: Message) => {
          this.onMessage(message);
        });

      });

    });
  }


  private onMessage(message: Message) {
    console.log('Received greeting:', message.body);
    let json = JSON.parse(message.body);
    this.messageSource.next(json['content']);
  }

  public send(destination: string, message: SubscribedMessage): void {
    message.identity = this.identity;
    console.log("SENDING: "+JSON.stringify(message))
    this.stompClient.send(destination, {}, JSON.stringify(message)  )
  }
}
