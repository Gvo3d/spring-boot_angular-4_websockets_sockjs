import {BrowserModule} from '@angular/platform-browser';
import {RoutingModule} from "./static/routing.module";
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './components/firstpage/app.component';
import {WebsocketService} from "./services/websocket.service";
import {RestService} from "./services/rest.service";
import {ApplicationService} from "./services/application.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RoutingModule,
  ],
  providers: [
    WebsocketService,
    RestService,
    ApplicationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
