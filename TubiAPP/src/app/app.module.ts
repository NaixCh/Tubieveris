import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AppComponent } from './app.component';
import { GameComponent } from './Modules/game/game.component';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './Modules/header/header.component';
import { FooterComponent } from './Modules/footer/footer.component';
import { InicioComponent } from './Modules/inicio/inicio.component';
import { WikiComponent } from './Modules/wiki/wiki.component';
import { DownloadComponent } from './Modules/download/download.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NuestroProyectoComponent } from './Modules/nuestro-proyecto/nuestro-proyecto.component';


@NgModule({
  declarations: [
    AppComponent,
    GameComponent,
    HeaderComponent,
    FooterComponent,
    InicioComponent,
    WikiComponent,
    DownloadComponent,
    NuestroProyectoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [
    
    { provide: 'externalUrlRedirectResolver',
      useValue: (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
          window.location.href = (route.data as any).externalUrl;
      }
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
