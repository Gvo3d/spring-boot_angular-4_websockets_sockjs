export class Constants {

  public static get HOME_URL(): string {
    return "http://localhost:8080";
  };

  public static get SESSION(): string {
    return "/session";
  };

  public static get WEB_SOCKET(): string {
    return "/gs-guide-websocket";
  };

  public static getWebSocketUrl(): string {
    return Constants.HOME_URL + Constants.WEB_SOCKET;
  }

  public static getSessionUrl(): string {
    return Constants.HOME_URL + Constants.SESSION;
  }

  public static getQueueUrl(id:string): string {
    return '/user/'+id+'/queue/reply';
  }
}
