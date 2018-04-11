import {Injectable, OnInit} from "@angular/core";
import {RestService} from "./rest.service";
import {WebsocketService} from "./websocket.service";

@Injectable()
export class ApplicationService {

  constructor(private _rest: RestService, private _wsService: WebsocketService) {
  }

  get getRestTemplate(): RestService {
    return this._rest;
  }

  get getWebsocketService(): WebsocketService {
    return this._wsService;
  }
}
