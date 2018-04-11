import {ApplicationService} from "../services/application.service";

export abstract class AbstractDataComponent {
    constructor(public applicationService: ApplicationService) {
    }
}
