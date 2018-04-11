import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {AbstractDataComponent} from "../abstract-data.component";
import {ApplicationService} from "../../services/application.service";
import {SubscribedMessage} from "../../dto/subscribed.dto";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent extends AbstractDataComponent implements OnInit, OnDestroy {
  title = 'app works!';
  messages: Array<string> = [];
  messageSub: Subscription;

  constructor(applicationService: ApplicationService) {
    super(applicationService);
  }

  ngOnInit(): void {
    this.messageSub = this.applicationService.getWebsocketService.messageReceived$.subscribe( message => this.messages.push(message));
  }

  ngOnDestroy(): void {
    if ( this.messageSub ) {
      this.messageSub.unsubscribe();
    }
  }

  onClickMe(): void {
    this.applicationService.getWebsocketService.stompClient.send("/app/hello", {}, "{\"name\":\"hello\"}" )
  }

  onClickMe2(): void {
    let message: SubscribedMessage = new SubscribedMessage("private");
    this.applicationService.getWebsocketService.send("/app/private", message)
  }
}
