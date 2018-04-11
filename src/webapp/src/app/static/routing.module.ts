import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AppComponent} from "../components/firstpage/app.component";

const appRoutes: Routes = [
    {path: '', redirectTo: 'main', pathMatch: 'full'},
    {
        path: 'main',
        component: AppComponent
    }
];

@NgModule({
    imports: [
        RouterModule.forRoot(
            appRoutes,
            {
                enableTracing: true, // <-- debugging purposes only
            }
        )
    ],
    exports: [
        RouterModule
    ]
})
export class RoutingModule {
}
